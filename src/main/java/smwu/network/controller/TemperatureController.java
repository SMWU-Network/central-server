package smwu.network.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import smwu.network.dto.TemperatureRequest;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/iot")
public class TemperatureController {

    @PostMapping("/temperature")
    public String receiveTemperature(@RequestBody TemperatureRequest request) {
        log.info("Received Temperature: {}", request);
        return "OK";
    }
}
