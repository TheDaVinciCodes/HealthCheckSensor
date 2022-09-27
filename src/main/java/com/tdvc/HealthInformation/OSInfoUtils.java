package com.tdvc.HealthInformation;

/**
 * @author FAYWHNT
 * 
 * The Utils class contains the method bytesToHumanReadableValue 
 * to convert long values into human readable value 
 * 
 * --> https://github.com/luciopaiva/java-simple-system-info/blob/master/src/com/luciopaiva/Utils.java
 *
 */
public class OSInfoUtils
{

    private static String[] BYTE_UNITS = {"B", "kB", "MB", "GB", "TB"};

    static String bytesToHumanReadableValue(long valueInBytes) 
    {
        int unitsIndex = 0;
        double value = valueInBytes;
        while (value > 1024d && unitsIndex < BYTE_UNITS.length - 1) 
        {
            value /= 1024d;
            unitsIndex++;
        }
        return String.format("%.2f %s", value, BYTE_UNITS[unitsIndex]);
    }
    
    
}