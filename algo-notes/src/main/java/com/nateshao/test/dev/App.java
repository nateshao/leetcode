//package com.nateshao.test.dev;
//
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileReader;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.nio.file.StandardOpenOption;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.stream.Collectors;
//
//
///**
// * @date Created by 邵桐杰 on 2022/5/25 20:44
// * @微信公众号 程序员千羽
// * @个人网站 www.nateshao.cn
// * @博客 https://nateshao.gitlab.io
// * @GitHub https://github.com/nateshao
// * @Gitee https://gitee.com/nateshao
// * Description:
// */
//public class App {
//    public static void main(String[] args) throws IOException {
//        if (args.length == 0) {
//            System.out.println("usage: todo <init|list|add|edit|remove|mark|unmark> [args]");
//        }
//        var cmd = args[0];
//        switch (cmd) {
//            case "init":
//                initTask();
//                break;
//            case "list":
//                listTask();
//                break;
//
//            case "add":
//                String tasksName = Arrays.stream(args).skip(1).collect(Collectors.joining(" "));
//                addTask(tasksName);
//                break;
//            case "mark":
//                int markedTaskId = tasksName.indexOf(String.valueOf(args)) + 1;
//                markTask(markedTaskId);
//                break;
//            case "remove":
//                int removedTaskId = tasksName.indexOf(String.valueOf(args)) + 1;
//                removeTask(removedTaskId);
//                break;
//            default:
//                break;
//        }
//    }
//
//    private static void listTask() throws IOException {
//        List<Task> taskList = new ArrayList<>();
//
//        BufferedReader in = new BufferedReader(new FileReader("C:/Users/Sheren Castle/.todo/tasks"));
//        String line = null;
//        List<String> todoCompeletedList = new ArrayList<>();
//        while ((line = in.readLine()) != null) {
//            //System.out.println(line);
//            taskList.add(new Task(line));
//        }
//
//        for (int i = 0; i < todoCompeletedList.size(); i++) {
//            System.out.println("# To be done");
//            System.out.println(i + 1 + " " + todoCompeletedList.get(i).split(" ", 2));
//            System.out.println("# Completed");
//            System.out.println(i + 1 + " " + todoCompeletedList.get(i).split("/*", 1));
//        }
//
//
//    }
//
//    private static void initTask() throws IOException {
//        if (!Files.exists(FileTool.filePath)) {
//            Files.createDirectory(FileTool.filePath);
//        }
//        File file = new File(FileTool.fileNameWithPath);
//        if (!file.exists()) {
//            file.createNewFile();
//
//        }
//        System.out.println("Initialized successfully.");
//        return;
//
//    }
//
//    private static void markTask(int markedTaskId) throws IOException {
//        BufferedReader mark = new BufferedReader(new FileReader("C:/Users/Sheren Castle/.todo/tasks"));
//        StringBuilder stringBuildermark = new StringBuilder();
//        String markedline = null;
//        while ((markedline = mark.readLine()) != null) {
//            var markedTasksName = "*" + mark + "\n";
//            stringBuildermark.replace(markedTaskId - 1, markedTaskId - 1, markedTasksName);
//        }
//
//
//    }
//
//    private static void addTask(String tasksName) throws IOException {
//
//        Files.write(Paths.get(FileTool.fileNameWithPath), tasksName.getBytes(), StandardOpenOption.APPEND);
//    }
//
//    private static void removeTask(int removedTaskId) throws IOException {
//
//        BufferedReader bufferedReader = new BufferedReader(new FileReader("C:/Users/Sheren Castle/.todo/tasks"));
//        StringBuilder stringBuilder = new StringBuilder();
//        String text = null;
//        while ((text = bufferedReader.readLine()) != null) {
//            stringBuilder.deleteCharAt(removedTaskId - 1);
//
//        }
//    }
//}
