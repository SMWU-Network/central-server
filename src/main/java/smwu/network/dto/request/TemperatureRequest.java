package smwu.network.dto.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TemperatureRequest {
    private String deviceId;
    private double temperature;
    private String timestamp; // YYYY-MM-DD HH:MM:SS
}
