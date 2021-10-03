package com.junghokwon.pmagent;

import lombok.Data;

import java.sql.Timestamp;


@Data
public class PMAgentMessage {
    private String uuid;
    private Timestamp timestamp;
    private int cpuPercent;
    private int memPercent;
}
