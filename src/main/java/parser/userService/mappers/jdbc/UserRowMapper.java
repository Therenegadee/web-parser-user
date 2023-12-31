package parser.userService.mappers.jdbc;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import parser.userService.models.User;
import parser.userService.models.enums.ActivationStatus;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class UserRowMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        return User
                .builder()
                .id(rs.getLong("id"))
                .username(rs.getString("username"))
                .email(rs.getString("email"))
                .password(rs.getString("password"))
                .activationStatus(ActivationStatus.fromValue(rs.getString("activation_status")))
                .telegramUserId(rs.getString("telegram_id"))
                .build();
    }
}
