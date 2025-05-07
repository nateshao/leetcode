package com.nateshao.distributed.raft_demo;

/**
 * Leader	接收客户端请求，负责日志复制，系统中只能有一个
 * Follower	被动响应请求，接受 Leader 的日志同步
 * Candidate	发起选举，尝试成为 Leader
 */
public enum Role {
    LEADER,
    FOLLOWER,
    CANDIDATE,
}
