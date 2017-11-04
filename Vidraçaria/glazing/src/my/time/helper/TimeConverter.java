/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.time.helper;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.swing.text.DateFormatter;

/**
 *
 * @author andre
 */
public class TimeConverter {

    /**
     * Gives how many minutes there are in the given amount of hours
     * @param hours
     * @return 
     */
    static public int hoursToMinutes(int hours) {
        return hours / 60;
    }

    /**
     * Gives how many minutes there are in the given amount of days
     * @param days
     * @return 
     */
    static public int daysToMinutes(int days) {
        return days / 24 / 60;
    }

    /**
     * Sums minutes
     * @param minuteElem
     * @return 
     */
    static public int minutesSum(Integer... minuteElem) {
        int sum = 0;
        for (Integer elem : minuteElem) {
            sum += elem;
        }
        return sum;
    }

    /**
     * Convenience method to add a specified number of minutes to a LocalDateTime object
     * Based on: http://stackoverflow.com/questions/9043981/how-to-add-minutes-to-my-date
     * @param minutes minutes to add
     * @param beforeTime the original date
     * @return 
     */
    public static LocalDateTime add(int minutes, LocalDateTime beforeTime) {
        final long ONE_MINUTE_IN_MILLIS = 60000;//millisecs
        Date beforeTimeDate = asDate(beforeTime);
        long curTimeInMs = beforeTimeDate.getTime();
        Date afterAddingMins = new Date(curTimeInMs + (minutes * ONE_MINUTE_IN_MILLIS));
        return asLocalDateTime(afterAddingMins);
    }

    /**
     * Converts a LocalDate object to a Date object
     * @param localDate
     * @return
     */
    public static Date asDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * Converts a LocalDateTime object to an Date object
     * @param localDateTime
     * @return
     */
    public static Date asDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * Converts a Date object to an LocalDate object
     * @param date
     * @return
     */
    public static LocalDate asLocalDate(Date date) {
        return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
    }

    
    public enum dateTypes{
        complete, date, time;
    }
    
    public static String getFormat(dateTypes dt){
            switch(dt){
                case complete:
                    return "dd/MM/yyyy HH:mm";
                case date:
                    return "dd/MM/yyyy";
                case time:
                    return "HH:mm";
                default:
                    return null;
            }
        }
    
    /**
     * Converts a Date object to an LocalDateTime object
     * @param date
     * @return
     */
    public static LocalDateTime asLocalDateTime(Date date) {
        return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDateTime();
    }
    
    public static String toCompleteString(LocalDateTime dt){        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return dt.format(formatter);
    }
    
    public static String toDateString(LocalDateTime dt){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return dt.format(formatter);
    }
    
    public static String toTimeString(LocalDateTime dt){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        return dt.format(formatter);
    }
    
    public static String toString(LocalDate dt){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return dt.format(formatter);
    }
    
    public static LocalDateTime fromString(String dateStr){
        /*DateTimeFormatter formatter = DateTimeFormatter.ofPattern(getFormat(type));
        return LocalDateTime.parse(dateStr, formatter);*/
        
        System.out.println(dateStr);
        System.out.println(getFormat(type));
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(getFormat(type));
        LocalDateTime formatDateTime = LocalDateTime.parse(dateStr, formatter);

        System.out.println("Before : " + dateStr);
        System.out.println("After : " + formatDateTime);

        return formatDateTime;
        //System.out.println("After : " + formatDateTime.format(formatter));
    }
    public static LocalDateTime fromString(String dateStr){
        /*DateTimeFormatter formatter = DateTimeFormatter.ofPattern(getFormat(type));
        return LocalDateTime.parse(dateStr, formatter);*/
        
        System.out.println(dateStr);
        System.out.println(getFormat(type));
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(getFormat(type));
        LocalDateTime formatDateTime = LocalDateTime.parse(dateStr, formatter);

        System.out.println("Before : " + dateStr);
        System.out.println("After : " + formatDateTime);

        return formatDateTime;
        //System.out.println("After : " + formatDateTime.format(formatter));
    }
    

}
