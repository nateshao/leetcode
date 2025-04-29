package com.nateshao.threadPool;

// 模拟三个接口的调用类
public class ApiService {
    // 接口A：快速查询接口
    public String callApiA() throws InterruptedException {
        Thread.sleep(5);
        return "Result from API-A";
    }

    // 接口B：耗时处理接口
    public String callApiB() throws InterruptedException {
        Thread.sleep(5);
        return "Result from API-B";
    }

    // 接口C：依赖B的支付接口
    public String callApiC() throws InterruptedException {
        Thread.sleep(5);
        return "Result from API-C";
    }

}
