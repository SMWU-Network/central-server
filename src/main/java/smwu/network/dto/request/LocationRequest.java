package smwu.network.dto.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LocationRequest {
    private String deviceId;
    private String location;
    private String timestamp; // YYYY-MM-DD HH:MM:SS
}
