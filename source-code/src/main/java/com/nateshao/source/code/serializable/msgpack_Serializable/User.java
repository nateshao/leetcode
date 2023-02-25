package com.nateshao.source.code.serializable.msgpack_Serializable;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @date Created by 邵桐杰 on 2023/2/25 23:19
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private static final long serialVersionUID = 4719921525393585541L;
    protected String id;
    private String userID;
    private String type;
    private BigDecimal rate;
    private Date createTime;
    private Date UpdateTime;
}
