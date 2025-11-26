package smwu.network.dto.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class HeartRateRequest {
    private String deviceId;
    private int heartRate;
    private String timestamp; // YYYY-MM-DD HH:MM:SS
}
