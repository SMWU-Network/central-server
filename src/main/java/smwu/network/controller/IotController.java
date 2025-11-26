package smwu.network.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import smwu.network.dto.*;
import smwu.network.service.DashboardService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/iot")
@Slf4j
public class IotController {

    private final DashboardService dashboardService;

    @PostMapping("/event")
    public ResponseEntity<String> receiveEvent(@RequestBody EventRequest request) {
        log.info("Received Event: {}", request);
        dashboardService.saveEvent(request);
        return ResponseEntity.ok("OK");
    }

    @PostMapping("/heart-rate")
    public ResponseEntity<String> receiveHeartRate(@RequestBody HeartRateRequest request) {
        log.info("Received Heart Rate: {}", request);
        dashboardService.saveHeartRate(request);
        return ResponseEntity.ok("OK");
    }

    @PostMapping("/location")
    public ResponseEntity<String> receiveLocation(@RequestBody LocationRequest request) {
        log.info("Received Location: {}", request);
        dashboardService.saveLocation(request);
        return ResponseEntity.ok("OK");
    }

    @PostMapping("/temperature")
    public ResponseEntity<String> receiveTemperature(@RequestBody TemperatureRequest request) {
        log.info("Received Temperature: {}", request);
        dashboardService.saveTemperature(request);
        return ResponseEntity.ok("OK");
    }

    @GetMapping("/dashboard")
    public DashboardResponse getDashboard() {
        return dashboardService.getDashboardSnapshot();
    }
}

