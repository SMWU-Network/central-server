package smwu.network.service;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;
import smwu.network.dto.response.ChatMessageResponse;

@Component
@RequiredArgsConstructor
public class AlertPublisher {

    private final SimpMessagingTemplate messagingTemplate;

    public void publish(String role, String deviceId, String type, Object payload) {
        messagingTemplate.convertAndSend(
                String.format("/topic/%s/%s/%s", role, deviceId, type),
                payload
        );
    }

    public void publishToAllRoles(String deviceId, String type, Object payload) {
        publish("center", deviceId, type, payload);
        publish("children", deviceId, type, payload);
    }

    public void sendChatMessage(String deviceId, ChatMessageResponse msg) {
        messagingTemplate.convertAndSend("/topic/chat/" + deviceId, msg);
    }
}
