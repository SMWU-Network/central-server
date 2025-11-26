package smwu.network.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import smwu.network.dto.response.*;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Component
@RequiredArgsConstructor
public class DashboardStore {

    // deviceId별 최신값 저장
    private final Map<String, EventResponse> events = new ConcurrentHashMap<>();
    private final Map<String, HeartRateResponse> heartRates = new ConcurrentHashMap<>();
    private final Map<String, LocationResponse> locations = new ConcurrentHashMap<>();
    private final Map<String, TemperatureResponse> temperatures = new ConcurrentHashMap<>();

    // 각 항목에 대해 업데이트
    public void updateEvent(String deviceId, EventResponse response) {
        events.put(deviceId, response);
    }

    public void updateHeartRate(String deviceId, HeartRateResponse response) {
        heartRates.put(deviceId, response);
    }

    public void updateLocation(String deviceId, LocationResponse response) {
        locations.put(deviceId, response);
    }

    public void updateTemperature(String deviceId, TemperatureResponse response) {
        temperatures.put(deviceId, response);
    }

    // 대시보드 응답값 생성
    public List<DashboardResponse> getDashboardSnapshot() {
        // 모든 deviceId와 deviceId에 해당하는 각 데이터 추출
        Set<String> deviceIds = new HashSet<>();
        deviceIds.addAll(events.keySet());
        deviceIds.addAll(heartRates.keySet());
        deviceIds.addAll(locations.keySet());
        deviceIds.addAll(temperatures.keySet());

        List<DashboardResponse> result = new ArrayList<>();

        for (String deviceId : deviceIds) {
            result.add(
                    DashboardResponse.builder()
                            .deviceId(deviceId)
                            .event(events.get(deviceId))
                            .heartRate(heartRates.get(deviceId))
                            .location(locations.get(deviceId))
                            .temperature(temperatures.get(deviceId))
                            .build()
            );
        }

        return result;
    }
}
