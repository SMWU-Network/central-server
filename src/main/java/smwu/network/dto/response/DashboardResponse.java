package smwu.network.dto.response;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DashboardResponse {
    private String deviceId;
    private EventResponse event;
    private HeartRateResponse heartRate;
    private LocationResponse location;
    private TemperatureResponse temperature;
}
