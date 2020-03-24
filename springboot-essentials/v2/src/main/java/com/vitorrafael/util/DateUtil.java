package com.vitorrafael.util;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// @Component Transform the class into a Spring Component -> @ComponentScan will scan it
// The following are specializations of the @Component
// @Repository  Used when working with Data Access Objects
// @Service Used in service classes
@Component
public class DateUtil {
    public String formatLocalDateTimeToDatabaseStyle(LocalDateTime localDateTime) {
        return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(localDateTime);
    }
}
