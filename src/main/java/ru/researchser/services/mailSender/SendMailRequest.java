package ru.researchser.services.mailSender;

import lombok.*;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Component
public class SendMailRequest {
    private String userEmail;
    private String cryptoUserId;
}