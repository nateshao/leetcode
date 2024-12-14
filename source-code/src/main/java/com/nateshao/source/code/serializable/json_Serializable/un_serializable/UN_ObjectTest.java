package com.nateshao.source.code.serializable.json_Serializable.un_serializable;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @date Created by 邵桐杰 on 2023/2/25 17:16
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * Description:
 */
public class UN_ObjectTest {
    @DisplayName("反序列化对象")
    @Test
    public void testJsonToObject() {
        String text = "{\"age\":18,\"name\":\"千羽\"}";
        User user = JSON.parseObject(text, User.class);
        System.out.println(user);  // User{name='千羽', age=18}
    }

    @DisplayName("反序列化数组")
    @Test
    public void testJsonToArray() {
        String text = "[{\"age\":18,\"name\":\"千羽\"}, {\"age\":19,\"name\":\"千寻\"}]";
        User[] users = JSON.parseObject(text, User[].class);
        System.out.println(Arrays.toString(users));  // [User{name='千羽', age=18}, User{name='千寻', age=19}]
    }

    @DisplayName("反序列化集合")
    @Test
    public void testJsonToCollection() {
        String text = "[{\"age\":18,\"name\":\"千羽\"}, {\"age\":19,\"name\":\"千寻\"}]";
        // List 集合
        List<User> userList = JSON.parseArray(text, User.class);
        System.out.println(Arrays.toString(userList.toArray()));  // [User{name='千羽', age=18}, User{name='千寻', age=19}]
        // Set 集合
        Set<User> userSet = JSON.parseObject(text, new TypeReference<Set<User>>() {
        });
        System.out.println(Arrays.toString(userSet.toArray()));  // [User{name='千寻', age=19}, User{name='千羽', age=18}]
    }

    @DisplayName("反序列化映射")
    @Test
    public void testJsonToMap() {
        String text = "{1:{\"age\":18,\"name\":\"千羽\"}, 2:{\"age\":19,\"name\":\"千寻\"}}";
        Map<Integer, User> userList = JSON.parseObject(text, new TypeReference<Map<Integer, User>>() {
        });
        for (Integer i : userList.keySet()) {
            System.out.println(userList.get(i));
        }
        /*
            User{name='千羽', age=18}
            User{name='千寻', age=19}
         */
    }
}
