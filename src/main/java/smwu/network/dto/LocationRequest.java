package smwu.network.dto;

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
