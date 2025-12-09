package smwu.network.websocket;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class WebSocketPublisher {

    private final SimpMessagingTemplate messagingTemplate;

    public void publish(String deviceId, Object payload) {
        messagingTemplate.convertAndSend("/topic/iot/" + deviceId, payload);
    }
}
