package smwu.network.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import smwu.network.dto.response.ChatMessageResponse;
import smwu.network.dto.response.HeartRateResponse;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class AlertEngine {

    private final AlertPublisher alertPublisher;

    public void checkHeartRate(String deviceId, HeartRateResponse hr) {
        int value = hr.getHeartRate();

        if (value >= 120) {
            alertPublisher.sendChatMessage(deviceId,
                    new ChatMessageResponse("system",
                            "⚠ 심박수 이상 감지! (" + value + ")",
                            LocalDateTime.now().toString())
            );

            alertPublisher.publishToAllRoles(deviceId, "event", hr);
        }

        if (value <= 50) {
            alertPublisher.sendChatMessage(deviceId,
                    new ChatMessageResponse("system",
                            "⚠ 심박수 낮음 감지! (" + value + ")",
                            LocalDateTime.now().toString())
            );

            alertPublisher.publishToAllRoles(deviceId, "event", hr);
        }
    }

    public void checkEvent(String deviceId, String event) {

        if (event.equalsIgnoreCase("FALL") ||
                event.equalsIgnoreCase("FALL_DETECTED")) {

            ChatMessageResponse alert = new ChatMessageResponse(
                    "system",
                    "⚠ 낙상 감지! 즉시 확인이 필요합니다!",
                    LocalDateTime.now().toString()
            );

            // 채팅으로 전송
            alertPublisher.sendChatMessage(deviceId, alert);

            // 이벤트 채널로도 전송
            alertPublisher.publishToAllRoles(deviceId, "event", alert);
        }
    }
}
