package com.websecurity.websecurity.api;


import com.websecurity.websecurity.entities.DataWeb;
import com.websecurity.websecurity.security.ActiveScan;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api/scan")
@RequiredArgsConstructor
@Slf4j
public class EndpointResource {

    @PostMapping(path = "/web/" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> scanWeb(@RequestParam(name = "web") String web){
//        log.info("Active scan result {} ",activeScan.scanApi("https://example.com/"));
        return ResponseEntity.accepted().body(ActiveScan.scanApi(web));
    }
}
