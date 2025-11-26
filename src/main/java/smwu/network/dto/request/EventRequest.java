package smwu.network.dto.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EventRequest {
    private String deviceId;
    private String event; // FALL, RISK
    private String timestamp;
}