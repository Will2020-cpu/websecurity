package com.websecurity.websecurity.security;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.zaproxy.clientapi.core.ApiResponseElement;
import org.zaproxy.clientapi.core.ClientApi;
import org.zaproxy.clientapi.core.ClientApiException;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Data
@RequiredArgsConstructor
@Slf4j
public class ActiveScan {

    private static  List<String> allUrls = new ArrayList<>();

   static public String scanApi(String zapTarget){
        if (!allUrls.contains(zapTarget)){
            ajaxSpider(zapTarget);
        }
        ClientApi clientApi = new ClientApi("ec2-18-188-29-71.us-east-2.compute.amazonaws.com", 8090, "eaq02is6gakrccol0ofbhvnbvc");
        try {
            clientApi.pscan.recordsToScan();
            int numberOfRecords;

            while (true) {
                Thread.sleep(2000);
                clientApi.pscan.recordsToScan();
                numberOfRecords = Integer.parseInt(((ApiResponseElement) clientApi.pscan.recordsToScan()).getValue());
                System.out.println("Number of records left for scanning : " + numberOfRecords);
                if (numberOfRecords == 0) {
                    break;
                }
            }
            log.info("Active Scan Complete");
            return new String(clientApi.core.jsonreport(), StandardCharsets.UTF_8);
        } catch (ClientApiException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    public static void ajaxSpider(String target){
        ClientApi clientApi = new ClientApi("ec2-18-188-29-71.us-east-2.compute.amazonaws.com", 8090, "eaq02is6gakrccol0ofbhvnbvc");
        try {
            clientApi.ajaxSpider.scan(target,null,null,null);
            String status;

            long startTime = System.currentTimeMillis();
            log.info("Startime {}", startTime);
            long timeout = TimeUnit.MINUTES.toMillis(2);

            do {
                Thread.sleep(2000);
                status = (((ApiResponseElement) clientApi.ajaxSpider.status()).getValue());
                System.out.println("Spider status : " + status);
            } while (!("stopped".equals(status)) && ((System.currentTimeMillis() - startTime) < timeout));

            log.info("Spider completed");
            allUrls.add(target);

        } catch (ClientApiException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
