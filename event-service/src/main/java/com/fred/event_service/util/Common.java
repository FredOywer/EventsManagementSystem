package com.fred.event_service.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Common {
    public static String getTimestamp(){
        SimpleDateFormat dateFormat = new SimpleDateFormat(Constants.TIMESTAMP_FORMAT);
        return dateFormat.format(new Date());
    }
}
