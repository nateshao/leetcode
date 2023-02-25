package com.nateshao.source.code.serializable.json_Serializable.serializable;

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @date Created by 邵桐杰 on 2023/2/25 17:12
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
public class ObjectTest {
    private static List<User> userList = new ArrayList<User>();

    @BeforeAll
    public static void setUp() {
        userList.add(new User("千羽", 18));
        userList.add(new User("千寻", 19));
    }

    @DisplayName("序列化对象")
    @Test
    public void testObjectToJson() {
        String userJson = JSON.toJSONString(userList.get(0));
        System.out.println(userJson);  // {"AGE":18,"NAME":"千羽"}
    }

    @DisplayName("序列化集合")
    @Test
    public void testListToJson() {
        String userListJson = JSON.toJSONString(userList);
        System.out.println(userListJson);  // [{"AGE":18,"NAME":"千羽"},{"AGE":19,"NAME":"千寻"}]
    }

    @DisplayName("序列化数组")
    @Test
    public void testArrayToJson() {
        User[] userArray = new User[5];
        userArray[0] = new User("zhangsan", 20);
        userArray[1] = new User("lisi", 21);
        String userArrayJson = JSON.toJSONString(userArray);
        System.out.println(userArrayJson);  // [{"AGE":20,"NAME":"zhangsan"},{"AGE":21,"NAME":"lisi"},null,null,null]
    }

    @DisplayName("序列化映射")
    @Test
    public void testMapToJson() {
        Map<Integer, User> userMap = new HashMap<Integer, User>();
        userMap.put(1, new User("xiaotie", 10));
        userMap.put(2, new User("xiaoliu", 11));
        String userMapJson = JSON.toJSONString(userMap);
        System.out.println(userMapJson);  // {1:{"AGE":10,"NAME":"xiaotie"},2:{"AGE":11,"NAME":"xiaoliu"}}
    }
}
