package smwu.network.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import smwu.network.dto.response.ChatMessageResponse;

import java.time.LocalDateTime;

@Controller
@RequiredArgsConstructor
public class ChatController {

    private final SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/chat/{deviceId}")
    public void handleChat(
            @DestinationVariable String deviceId,
            ChatMessageResponse message
    ) {
        message.setTimestamp(LocalDateTime.now().toString());

        messagingTemplate.convertAndSend(
                "/topic/chat/" + deviceId,
                message
        );
    }
}
