package com.example.medical_platform.util;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class GetNewLocalDateTime {
    public static LocalDateTime GetNewLocalDateTime(){
        Date date=new Date();
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();

        return instant.atZone(zoneId).toLocalDateTime();
    }
}
