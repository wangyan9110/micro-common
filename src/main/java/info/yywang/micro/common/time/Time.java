package info.yywang.micro.common.time;

import info.yywang.micro.common.exceptions.BizException;

import java.util.Calendar;
import java.util.Date;

/**
 * @author yanyan.wang
 * @date 2016-09-07 14:55
 */
public class Time implements Comparable {

    private int hour;

    private int minute;

    private int second;

    public Time(String time) {
        String[] times = time.split(":");
        if (times.length != 3) {
            throw new BizException("time format error HH:mm:ss");
        }
        this.hour = Integer.parseInt(times[0]);
        this.minute = Integer.parseInt(times[1]);
        this.second = Integer.parseInt(times[2]);
    }

    public Time(int seconds) {
        this.hour = seconds / 3600;
        this.minute = seconds % 3600 / 60;
        this.second = (seconds % 3600) % 60;
    }

    public Time(Date date) {
        Calendar calendar = DateUtils.toCalendar(date);
        this.hour = calendar.get(Calendar.HOUR);
        this.minute = calendar.get(Calendar.MINUTE);
        this.second = calendar.get(Calendar.SECOND);
    }

    public int toSeconds() {
        return hour * 3600 + minute * 60 + second;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Time time = (Time) o;

        if (hour != time.hour) return false;
        if (minute != time.minute) return false;
        return second == time.second;

    }

    @Override
    public int hashCode() {
        int result = hour;
        result = 31 * result + minute;
        result = 31 * result + second;
        return result;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(String.format("%02d", hour))
                .append(":")
                .append(String.format("%02d", minute))
                .append(":")
                .append(String.format("%02d", second));
        return result.toString();
    }

    public int compareTo(Object o) {
        if (o == null) {
            return -1;
        }
        if (!(o instanceof Time)) {
            return -1;
        }
        if (this.toSeconds() < ((Time) o).toSeconds()) {
            return -1;
        }
        return 1;
    }
}
