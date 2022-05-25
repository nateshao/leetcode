package com.nateshao.test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

/**
 * @date Created by 邵桐杰 on 2022/5/24 10:04
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
public class App {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            System.out.println("usage: todo <init|list|add|edit|remove|mark|unmark> [args]");
        }
        String homePath = System.getProperty("user.home");
//        Path filePath = Path.of(homePath + File.separator + ".todo");
//        String fileNameWithPath = filePath + File.separator + "tasks";
//        if ("init".equals(args[0])) {
//            if (!Files.exists(filePath)) {
//                Files.createDirectory(filePath);
//            }
//            File file = new File(fileNameWithPath);
//            if (!file.exists()) {
//                file.createNewFile();
//            }
//            System.out.println("Initialized successfully.");
//            return;
//        }
//        if ("add".equals(args[0])) {
//            String taskName = Joiner.on(" ").join(Arrays.stream(args).skip(1).toArray(String[]::new));
//            Files.write(Paths.get(fileNameWithPath), taskName.concat("\n").getBytes(), StandardOpenOption.APPEND);
//            return;
//        }

    }
}


//上述完成了任务初始化，接下来需要在gradle里面执行
