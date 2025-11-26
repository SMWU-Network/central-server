package smwu.network.dto.response;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HeartRateResponse {
    private int heartRate;
    private String timestamp;
}
