package com.nateshao.source.code.serializable.msgpack_Serializable;

import org.msgpack.packer.Packer;
import org.msgpack.unpacker.Unpacker;

import java.io.IOException;

/**
 * @date Created by 邵桐杰 on 2023/2/25 23:21
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description: 字段要保持一致
 * protected String id;
 * private String userID;
 * private String type;
 * private BigDecimal rate;
 * private Date createTime;
 * private Date UpdateTime;
 */
public class UserTemplate extends MsgPackTemplate<User> {
    public void write(Packer packer, User user, boolean b) throws IOException {
        if (user == null) {
            packer.write(user);
            return;
        }
        // 字段保持一致
        writeString(packer, user.id);
        writeString(packer, user.getUserID());
        writeString(packer, user.getType());
        writeBigDecimal(packer, user.getRate());
        writeDate(packer, user.getCreateTime());
        writeDate(packer, user.getUpdateTime());

    }

    public User read(Unpacker unpacker, User user, boolean req) throws IOException {
        if (!req && unpacker.trySkipNil()) {
            return null;
        }
        if (unpacker == null) return new User();
        user.setId(readString(unpacker));
        user.setUserID(readString(unpacker));
        user.setType(readString(unpacker));
        user.setRate(readBigDecimal(unpacker));
        user.setCreateTime(readDate(unpacker));
        user.setUpdateTime(readDate(unpacker));
        return user;
    }
}
