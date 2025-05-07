package com.nateshao.distributed.raft_demo;

import java.util.ArrayList;
import java.util.List;

public class RaftNode {
    private int id;
    private int currentTerm = 0;
    private int votedFor = -1;
    private Role role = Role.FOLLOWER;
    private List<LogEntry> log = new ArrayList<>();
    private List<RaftNode> peers;

    public RaftNode(int id) {
        this.id = id;
    }

    public void setPeers(List<RaftNode> peers) {
        this.peers = peers;
    }

    // 选举超时，变为候选人发起股票
    public void startElection() {
        currentTerm++;
        votedFor = id;
        role = Role.CANDIDATE;
        int voteCount = 1; // 给自己投票

        for (RaftNode peer : peers) {
            if (peer != this && peer.requestVote(currentTerm, id)) {
                voteCount++;
            }
        }

        if (voteCount > peers.size() / 2) {
            role = Role.LEADER;
            System.out.println("Node " + id + " becomes LEADER in term " + currentTerm);
            sendHeartbeats();
        }
    }

    // 接收投票请求
    public boolean requestVote(int term, int candidateId) {
        if (term > currentTerm) {
            currentTerm = term;
            votedFor = candidateId;
            role = Role.FOLLOWER;
            return true;
        }
        return false;
    }

    // 向其他节点发送心跳包（模拟 AppendEntries RPC）
    public void sendHeartbeats() {
        for (RaftNode peer : peers) {
            if (peer != this) {
                peer.receiveHeartbeat(currentTerm, id);
            }
        }
    }

    public void receiveHeartbeat(int term, int leaderId) {
        if (term >= currentTerm) {
            currentTerm = term;
            role = Role.FOLLOWER;
            votedFor = leaderId;
            System.out.println("Node " + id + " accepts heartbeat from LEADER " + leaderId);
        }
    }

    public Role getRole() {
        return role;
    }

    public int getId() {
        return id;
    }

}
