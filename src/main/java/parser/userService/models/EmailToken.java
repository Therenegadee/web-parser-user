package parser.userService.models;

import lombok.*;
import parser.userService.models.enums.TokenType;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmailToken {
    private Long id;
    private String token;
    private Date expirationDate;
    private User user;
    private TokenType tokenType;

    public EmailToken(User user) {
        this.user = user;
        token = UUID.randomUUID().toString();
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Timestamp(cal.getTime().getTime()));
        cal.add(Calendar.MINUTE, 2880);
        expirationDate = new Date(cal.getTime().getTime());
    }

}
