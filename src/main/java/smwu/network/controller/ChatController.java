package smwu.network.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import smwu.network.dto.response.ChatMessageResponse;

import java.time.LocalDateTime;

@Controller
@RequiredArgsConstructor
@Slf4j
public class ChatController {

    private final SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/chat/{deviceId}")
    public void handleChat(
            @DestinationVariable String deviceId,
            ChatMessageResponse message
    ) {
        log.info("[CHAT-RECEIVED] deviceId={}, sender={}, message={}",
                deviceId, message.getSender(), message.getMessage());

        message.setTimestamp(LocalDateTime.now().toString());

        log.info("[CHAT-PUBLISH]  → /topic/chat/{}, payload={}", deviceId, message);

        messagingTemplate.convertAndSend(
                "/topic/chat/" + deviceId,
                message
        );
    }
}
