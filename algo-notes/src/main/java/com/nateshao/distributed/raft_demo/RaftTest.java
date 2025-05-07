package com.nateshao.distributed.raft_demo;

import java.util.ArrayList;
import java.util.List;

public class RaftTest {
    public static void main(String[] args) {
        List<RaftNode> cluster = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            cluster.add(new RaftNode(5));
        }
        for (RaftNode node : cluster) {
            node.setPeers(cluster);
        }
        // 模拟某个节点发起选举
        cluster.get(2).startElection();// 假设节点 2 触发超时
        for (RaftNode node : cluster) {
            System.out.println("Node " + node.getId() + " is in state: " + node.getRole());
        }
    }
}
