package smwu.network.websocket;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class WebSocketPublisher {

    private final SimpMessagingTemplate messagingTemplate;

    public void publish(String role, String deviceId, String dataType, Object payload) {
        String destination = String.format("/topic/%s/%s/%s", role, deviceId, dataType);
        messagingTemplate.convertAndSend(destination, payload);
    }

    public void publishAllRoles(String deviceId, String dataType, Object payload) {
        publish("child", deviceId, dataType, payload);
        publish("counselor", deviceId, dataType, payload);
        publish("center", deviceId, dataType, payload);
    }
}
