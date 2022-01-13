package com.android.foodorderapp.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.logging.SimpleFormatter;

// đối tượng hours trong json
public class Hours {

    String Sunday;
    String Monday;
    String Tuesday;
    String Wednesday;
    String Thursday;
    String Friday;
    String Saturday;

    public String getSunday() {
        return Sunday;
    }

    public void setSunday(String sunday) {
        Sunday = sunday;
    }

    public String getMonday() {
        return Monday;
    }

    public void setMonday(String monday) {
        Monday = monday;
    }

    public String getTuesday() {
        return Tuesday;
    }

    public void setTuesday(String tuesday) {
        Tuesday = tuesday;
    }

    public String getWednesday() {
        return Wednesday;
    }

    public void setWednesday(String wednesday) {
        Wednesday = wednesday;
    }

    public String getThursday() {
        return Thursday;
    }

    public void setThursday(String thursday) {
        Thursday = thursday;
    }

    public String getFriday() {
        return Friday;
    }

    public void setFriday(String friday) {
        Friday = friday;
    }

    public String getSaturday() {
        return Saturday;
    }

    public void setSaturday(String saturday) {
        Saturday = saturday;
    }



    // Lấy ngày giờ
    // cố định ngày giờ
    //https://qastack.vn/programming/1661325/simpledateformat-and-locale-based-format-string
    public String getTodaysHours() {
        // khai bao biến lịch
        Calendar calendar = Calendar.getInstance();
        // thấy thời gian trong ngày
        Date date  = calendar.getTime();
        // lầy ngày
        //SimpleDateFormat is a concrete class for formatting and parsing dates in a locale-sensitive manner
        // . It allows for formatting (date → text), parsing (text → date), and normalization.
        // Shows  "Monday, October 8, 2012"
        //E - Tên ngày trong tuần (Thứ ba; Thứ ba)
        String day = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(date.getTime());
        // dữ liệu trên đt ngày nào thì hiển thị ngày giờ hoạt động cửa hàng ngày đó
        switch (day) {
            case "Sunday":
                return this.Sunday;
            case "Monday":
                return this.Monday;
            case "Tuesday":
                return this.Tuesday;
            case "Wednesday":
                return this.Wednesday;
            case "Thursday":
                return this.Thursday;
            case "Friday":
                return this.Friday;
            case "Saturday":
                return this.Saturday;
            default:
                return this.Sunday;

        }
    }
}
