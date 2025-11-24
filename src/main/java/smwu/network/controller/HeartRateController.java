package smwu.network.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import smwu.network.dto.HeartRateRequest;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/iot")
public class HeartRateController {

    @PostMapping("/heart-rate")
    public String receiveHeartRate(@RequestBody HeartRateRequest request) {
        log.info("Received Heart Rate: {}", request);
        return "OK";
    }
}
