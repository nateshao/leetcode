package com.nateshao.distributed.lsm_tree;

import java.io.*;
import java.util.*;

public class LSMTree {
    private final TreeMap<String, String> memTable = new TreeMap<>();
    private final File walFile = new File("wal.log");
    private final File sstableDir = new File("sstables");
    private int sstableCount = 0;

    public LSMTree() throws IOException {
        if (!sstableDir.exists()) sstableDir.mkdirs();
        recoverFromWAL();
    }

    // 写入：写 WAL -> 写入内存
    public void put(String key, String value) throws IOException {
        writeWAL(key, value);
        memTable.put(key, value);
        if (memTable.size() >= 5) { // 达到阈值，刷盘
            flushToSSTable();
        }
    }

    // 查询：内存 -> SSTables（模拟）
    public String get(String key) throws IOException {
        if (memTable.containsKey(key)) return memTable.get(key);

        // 查询 SSTable（新 -> 旧）
        File[] files = sstableDir.listFiles();
        if (files == null) return null;

        Arrays.sort(files, Comparator.comparing(File::getName).reversed());
        for (File file : files) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] kv = line.split(",", 2);
                    if (kv[0].equals(key)) return kv[1];
                }
            }
        }
        return null;
    }

    // 写前日志
    private void writeWAL(String key, String value) throws IOException {
        try (FileWriter writer = new FileWriter(walFile, true)) {
            writer.write(key + "," + value + "\n");
        }
    }

    // 恢复 WAL
    private void recoverFromWAL() throws IOException {
        if (!walFile.exists()) return;
        try (BufferedReader reader = new BufferedReader(new FileReader(walFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] kv = line.split(",", 2);
                memTable.put(kv[0], kv[1]);
            }
        }
    }

    // 刷盘为 SSTable
    private void flushToSSTable() throws IOException {
        File sstable = new File(sstableDir, "sstable_" + (++sstableCount) + ".txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(sstable))) {
            for (Map.Entry<String, String> entry : memTable.entrySet()) {
                writer.write(entry.getKey() + "," + entry.getValue() + "\n");
            }
        }
        memTable.clear();
        walFile.delete(); // 清除 WAL（模拟）
        walFile.createNewFile();
    }

    // 示例运行
    public static void main(String[] args) throws IOException {
        LSMTree lsm = new LSMTree();
        lsm.put("apple", "red");
        lsm.put("banana", "yellow");
        lsm.put("grape", "purple");
        lsm.put("lemon", "yellow");
        lsm.put("peach", "pink"); // 触发 flush

        System.out.println("grape = " + lsm.get("grape"));
        System.out.println("apple = " + lsm.get("apple"));
    }
}
