package com.websecurity.websecurity.security;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.zaproxy.clientapi.core.ApiResponse;
import org.zaproxy.clientapi.core.ApiResponseElement;
import org.zaproxy.clientapi.core.ClientApi;
import org.zaproxy.clientapi.core.ClientApiException;

import java.nio.charset.StandardCharsets;

@Data
@RequiredArgsConstructor
@Slf4j
public class ActiveScan {

    public String scanApi(String zapTarget){
        ClientApi clientApi = new ClientApi("localhost", 8080, "eaq02is6gakrccol0ofbhvnbvc");
        try {
            ApiResponse response = clientApi.ascan.scan(zapTarget,"True", "False", null, null,null);
            String scanId;
            int progress;

            scanId = ((ApiResponseElement) response).getValue();
            do {
                Thread.sleep(5000);
                progress = Integer.parseInt(((ApiResponseElement) clientApi.ascan.status(scanId)).getValue());
                log.info("Active Scan in progress : {}%", progress);
            } while (progress < 100);
            log.info("Active Scan Complete");
            return new String(clientApi.core.xmlreport(), StandardCharsets.UTF_8);
        } catch (ClientApiException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
