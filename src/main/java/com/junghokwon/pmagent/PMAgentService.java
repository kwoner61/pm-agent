package com.junghokwon.pmagent;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static com.junghokwon.pmagent.PMAgentConstants.*;

@Service
public class PMAgentService {

    private final Runtime runtime = Runtime.getRuntime();

    public PMAgentMessage getPerfDetails() throws IOException, InterruptedException {
        PMAgentMessage msg = new PMAgentMessage();
        msg.setUuid(UUID.randomUUID().toString());
        msg.setTimestamp(Timestamp.from(Instant.now()));
        msg.setCpuPercent(getCpuUsage());
        msg.setMemPercent(getMemUsage());
        return msg;
    }

    String execCommandOnHost(String command) throws InterruptedException, IOException {
        Process p = runtime.exec(command);
        p.waitFor(CMD_TIMEOUT_SEC, TimeUnit.SECONDS);
        BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line;
        String response = "";
        while ((line = reader.readLine()) != null) {
            response = response.concat(line);
        }
        return response;
    }

    int getCpuUsage() throws IOException, InterruptedException {
        String cmdResult = execCommandOnHost(GET_CPU_LOAD);
        return Integer.parseInt(cmdResult.replaceAll(NON_DIGITS,""));
    }

    int getMemUsage() throws IOException, InterruptedException {
        String cmdResult = execCommandOnHost(GET_MAX_MEM);
        String cleanResult = cmdResult.replaceAll(NON_DIGITS, "");
        long totalMem = Long.parseLong(cleanResult);

        cmdResult = execCommandOnHost(GET_FREE_MEM);
        cleanResult = cmdResult.replaceAll(NON_DIGITS, "");
        long freeMem = Long.parseLong(cleanResult) * 1024;

        return (int) ((totalMem - freeMem) * 100 / totalMem);
    }

}
