package smwu.network.dto.response;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TemperatureResponse {
    private double temperature;
    private String timestamp;
}
