package com.example.weatheroptimizer.util;

import java.time.LocalDateTime;

public class ClientHelper {
    public static boolean checkTimeInRange(LocalDateTime inputTime){
        LocalDateTime currentTime = LocalDateTime.now();
        LocalDateTime wantedTime = currentTime.plusHours(24);
        LocalDateTime lowerRange = wantedTime.minusMinutes(30);
        LocalDateTime upperRange = wantedTime.plusMinutes(30);

        if((inputTime.isBefore(upperRange) || inputTime.isEqual(upperRange)) && (inputTime.isAfter(lowerRange) || inputTime.isEqual(lowerRange)) ){
            return true;
        }
        return false;
    }
}
