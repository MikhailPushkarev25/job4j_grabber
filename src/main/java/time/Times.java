package time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Times {
    public static void main(String[] args) {
    LocalTime time = LocalTime.now();
    LocalDate data = LocalDate.now();
    LocalDateTime dt = LocalDateTime.of(data, time);
    System.out.println(dt);
    LocalTime time1 = LocalTime.now().plusHours(1);
    LocalDate date2 = LocalDate.now().minusDays(1);
    LocalDateTime ldt = LocalDateTime.of(date2, time1);
    System.out.println(ldt);

    }
}
