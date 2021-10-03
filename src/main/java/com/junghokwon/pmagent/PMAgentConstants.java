package com.junghokwon.pmagent;

public class PMAgentConstants {
    PMAgentConstants() {}
    static final int CMD_TIMEOUT_SEC = 3;
    static final String NON_DIGITS = "\\D+";
    static final String GET_MAX_MEM = "cmd /c wmic ComputerSystem GET TotalPhysicalMemory";
    static final String GET_FREE_MEM = "cmd /c wmic OS GET FreePhysicalMemory";
    static final String GET_CPU_LOAD = "cmd /c wmic cpu GET loadpercentage";
}
