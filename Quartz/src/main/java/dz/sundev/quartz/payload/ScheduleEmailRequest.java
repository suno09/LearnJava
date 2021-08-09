package dz.sundev.quartz.payload;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Getter
@Setter
public class ScheduleEmailRequest {
    private String email;

    private String subject;

    private String body;

    private LocalDateTime dateTime;

    private ZoneId timeZone;

    @Override
    public String toString() {
        return "ScheduleEmailRequest{" +
                "email='" + email + '\'' +
                ", subject='" + subject + '\'' +
                ", body='" + body + '\'' +
                ", dateTime=" + dateTime +
                ", timeZone=" + timeZone +
                '}';
    }
}