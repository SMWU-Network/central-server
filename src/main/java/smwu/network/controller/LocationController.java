package smwu.network.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import smwu.network.dto.LocationRequest;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/iot")
public class LocationController {

    @PostMapping("/location")
    public String receiveLocation(@RequestBody LocationRequest request) {
        log.info("Received Location: {}", request);
        return "OK";
    }
}
