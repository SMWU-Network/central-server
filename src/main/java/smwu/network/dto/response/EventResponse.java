package smwu.network.dto.response;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EventResponse {
    private String event; // FALL, RISK
    private String timestamp;
}