package com.taskscheduler.TaskScheduler.constants;

import java.text.SimpleDateFormat;
import java.util.TimeZone;

public class Constants {
    public static SimpleDateFormat getDateFormatter() {
        SimpleDateFormat sd = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        sd.setTimeZone(TimeZone.getTimeZone("IST"));
        return sd;
    }

    public static SimpleDateFormat getOnlyDateFormatter() {
        SimpleDateFormat sd = new SimpleDateFormat("dd-MM-yyyy");
        sd.setTimeZone(TimeZone.getTimeZone("IST"));
        return sd;
    }
}
