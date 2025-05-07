package com.nateshao.distributed;

import java.util.*;

public class ConsistentHashAlg<T> {
    /**
     * 一致性hash算法
     */
    private final TreeMap<Integer, T> circle = new TreeMap<Integer, T>();
    private final int virtualNodes;

    public ConsistentHashAlg(int virtualNodes, Collection<T> nodes) {
        this.virtualNodes = virtualNodes;
        for (T node : nodes) {
            add(node);
        }
    }

    private int hash(String key) {
        // 可替换为 MurmurHash、FNV 等更好算法
        return key.hashCode() & 0x7fffffff;
    }

    public void add(T node) {
        for (int i = 0; i < virtualNodes; i++) {
            String vnodeKey = node.toString() + "##VN" + i;
            circle.put(hash(vnodeKey), node);
        }
    }

    public void remove(T node) {
        for (int i = 0; i < virtualNodes; i++) {
            String vnodeKey = node.toString() + "##VN" + i;
            circle.remove(hash(vnodeKey));
        }
    }

    public T get(String key) {
        if (circle.isEmpty()) return null;
        int hash = hash(key);
        // 寻找最小 >= hash 的节点
        Map.Entry<Integer, T> entry = circle.ceilingEntry(hash);
        if (entry == null) {
            return circle.firstEntry().getValue(); // 转回头部
        }
        return entry.getValue();
    }

    // 查看当前哈希环
    public void printCircle() {
        for (Map.Entry<Integer, T> entry : circle.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }
    }


    public static void main(String[] args) {
        List<String> nodes = Arrays.asList("Node-A", "Node-B", "Node-C");
        ConsistentHashAlg ch = new ConsistentHashAlg(100, nodes);
        for (int i = 0; i < 10; i++) {
            String key = "user" + i;
            System.out.println(key + " is mapped to " + ch.get(key));
        }

        System.out.println("\nRemoving Node-B...");
        ch.remove("Node-B");

        for (int i = 0; i < 10; i++) {
            String key = "user" + i;
            System.out.println(key + " is mapped to " + ch.get(key));
        }
    }

}
