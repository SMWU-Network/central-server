package smwu.network.dto.response;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LocationResponse {
    private String location;
    private String timestamp;
}