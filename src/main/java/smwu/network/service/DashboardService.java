package smwu.network.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import smwu.network.dto.request.EventRequest;
import smwu.network.dto.request.HeartRateRequest;
import smwu.network.dto.request.LocationRequest;
import smwu.network.dto.request.TemperatureRequest;
import smwu.network.dto.response.*;
import smwu.network.entity.*;
import smwu.network.repository.*;
import smwu.network.websocket.WebSocketPublisher;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class DashboardService {

    private final DeviceRepository deviceRepository;
    private final EventRepository eventRepository;
    private final HeartRateRepository heartRateRepository;
    private final LocationRepository locationRepository;
    private final TemperatureRepository temperatureRepository;
    private final DashboardStore dashboardStore;
    private final WebSocketPublisher webSocketPublisher;

    private Device getOrCreateDevice(String deviceId) {
        return deviceRepository.findByDeviceId(deviceId)
                .orElseGet(() -> deviceRepository.save(
                        Device.builder().deviceId(deviceId).build()
                ));
    }

    public java.util.List<DashboardResponse> getDashboardSnapshot() {
        return dashboardStore.getDashboardSnapshot();
    }

    public void saveEvent(EventRequest dto) {
        Device device = getOrCreateDevice(dto.getDeviceId());

        Event event = Event.builder()
                .device(device)
                .event(dto.getEvent())
                .timestamp(LocalDateTime.parse(dto.getTimestamp()))
                .build();

        eventRepository.save(event);

        EventResponse response = EventResponse.builder()
                .event(event.getEvent())
                .timestamp(event.getTimestamp().toString())
                .build();

        dashboardStore.updateEvent(device.getDeviceId(), response);

        webSocketPublisher.publish(device.getDeviceId(), response);
    }

    public void saveHeartRate(HeartRateRequest dto) {
        Device device = getOrCreateDevice(dto.getDeviceId());

        HeartRate hr = HeartRate.builder()
                .device(device)
                .heartRate(dto.getHeartRate())
                .timestamp(LocalDateTime.parse(dto.getTimestamp()))
                .build();

        heartRateRepository.save(hr);

        HeartRateResponse response = HeartRateResponse.builder()
                .heartRate(hr.getHeartRate())
                .timestamp(hr.getTimestamp().toString())
                .build();

        dashboardStore.updateHeartRate(device.getDeviceId(), response);

        webSocketPublisher.publish(device.getDeviceId(), response);
    }

    public void saveLocation(LocationRequest dto) {
        Device device = getOrCreateDevice(dto.getDeviceId());

        Location loc = Location.builder()
                .device(device)
                .location(dto.getLocation())
                .timestamp(LocalDateTime.parse(dto.getTimestamp()))
                .build();

        locationRepository.save(loc);

        LocationResponse response = LocationResponse.builder()
                .location(loc.getLocation())
                .timestamp(loc.getTimestamp().toString())
                .build();

        dashboardStore.updateLocation(device.getDeviceId(), response);

        webSocketPublisher.publish(device.getDeviceId(), response);
    }

    public void saveTemperature(TemperatureRequest dto) {
        Device device = getOrCreateDevice(dto.getDeviceId());

        Temperature temp = Temperature.builder()
                .device(device)
                .temperature(dto.getTemperature())
                .timestamp(LocalDateTime.parse(dto.getTimestamp()))
                .build();

        temperatureRepository.save(temp);

        TemperatureResponse response = TemperatureResponse.builder()
                .temperature(temp.getTemperature())
                .timestamp(temp.getTimestamp().toString())
                .build();

        dashboardStore.updateTemperature(device.getDeviceId(), response);

        webSocketPublisher.publish(device.getDeviceId(), response);
    }

}
