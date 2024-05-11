package com.websecurity.websecurity.api;


import com.websecurity.websecurity.entities.DataWeb;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/scan")
@RequiredArgsConstructor
@Slf4j
public class EndpointResource {

    @PostMapping(path = "/web" , consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DataWeb> scanWeb(@RequestBody DataWeb dataWeb, HttpServletRequest request){

        return ResponseEntity.accepted().body(dataWeb);
    }
}
