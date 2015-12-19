package com.self.learn.JDK8;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.text.DateFormatter;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class DateTimeDemo {
    private static final Logger LOG = LoggerFactory.getLogger(DateTimeDemo.class);

    @Test
    public void LocalDateDemo() {
        LocalDate today = LocalDate.now();
        LOG.info("Today's Local date : {}", today); //2015-10-21
        new Date(); //Wed Oct 21 22:29:33 CST 2015

        int year = today.getYear(); //2015
        int month = today.getMonthValue(); //10
        int day = today.getDayOfMonth(); //21
        LOG.info("Year: {}, Month: {}, day: {}", year, month, day);

        LocalDate customDate = LocalDate.of(2010, 01, 12);
        LOG.info("date value is: {}", customDate);//2010-01-12

        LOG.info("Today {} and customDate {} are same date? {}", today, customDate, today.equals(customDate));

        LocalDate nextWeek = today.plus(1, ChronoUnit.WEEKS);
        LOG.info("Date after 1 week : {}", nextWeek);
    }

    @Test
    public void MonthDayDemo() {
        LocalDate birthDate = LocalDate.of(2010, 10, 21);
        MonthDay birthday = MonthDay.of(birthDate.getMonth(), birthDate.getDayOfMonth());
        MonthDay currentMonthDay = MonthDay.from(LocalDate.now());
        if (currentMonthDay.equals(birthday)) {
            LOG.info("Many Many happy returns of the day !!");
        } else {
            LOG.info("Sorry, today is not your birthday");
        }
    }

    @Test
    public void LocalTimeDemo() {
        LocalTime localTime = LocalTime.now(); //15:36:43.244
        LocalTime newTime = localTime.plusHours(2);
        LOG.info("Time after 2 hours is {}.", newTime); //17:36:43.244
    }

    @Test
    public void ClockDemo() {
        Clock clock = Clock.systemUTC(); //SystemClock[Z]
        Clock clock2 = Clock.systemDefaultZone(); //SystemClock[Asia/Shanghai]
        LOG.info("" + clock);
        LocalDate.now(clock);
        LOG.info("" + LocalDate.now(clock2));
    }

    @Test
    public void LocalDateTimeDemo() {
        ZoneId america = ZoneId.of("America/New_York");
        LocalDateTime localDateTime = LocalDateTime.now(); //2015-10-22T16:08:36.014
        ZonedDateTime dateAndTimeInNewYork = ZonedDateTime.of(localDateTime, america);//2015-10-22T16:22:54.825-04:00[America/New_York]
        LOG.info("Current date and time is {}", localDateTime);
        LOG.info("Current newYork date and time is {}", dateAndTimeInNewYork);
    }

    @Test
    public void YearMonthDemo() {
        YearMonth currentYearMonth = YearMonth.now();
        LOG.info("Days in month year {}: {}", currentYearMonth, currentYearMonth.lengthOfMonth());
    }

    @Test
    public void PeriodDemo() {
        LocalDate today = LocalDate.now();
        LocalDate java8Release = LocalDate.of(2014, Month.MARCH, 14);
        Period periodToNextJavaRelease =
                Period.between(today, java8Release);
        System.out.println("Months left between today and Java 8 release : " + periodToNextJavaRelease.getMonths());
    }

    @Test
    public void instantDemo() {
        Instant timestamp = Instant.now(); //2015-10-22T08:21:31.713Z
        System.out.println("What is value of this instant " + timestamp);
    }

    @Test
    public void formatDemo() {
        String dayAfterTommorrow = "20151024";
        LocalDate formatDate = LocalDate.parse(dayAfterTommorrow, DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println(formatDate); //2015-10-24

        String goodFriday = "Apr 18 2014";
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd yyyy");
            LocalDate holiday = LocalDate.parse(goodFriday, formatter);
            System.out.printf("Successfully parsed String %s, date is %s%n", goodFriday, holiday); //2014-04-18
        } catch (DateTimeParseException ex) {
            System.out.printf("%s is not parsable!%n", goodFriday);
            ex.printStackTrace();
        }

        LocalDateTime arrivalDate = LocalDateTime.now();
        try {
            DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-mm-dd hh:mm a");
            String landing = arrivalDate.format(format);
            System.out.printf("Arriving at : %s %n", landing);
        } catch (DateTimeException ex) {
            System.out.printf("%s can't be formatted!%n", arrivalDate);
            ex.printStackTrace();
        }


        /*String todayString = "2014-06-12";
        try {
            DateFormatter formatter = DateFormatter..ofPattern("yyyy-mm-dd");
//            formatter.parse(todayString);
            LocalDate holiday = LocalDate.parse(todayString, formatter);
            System.out.printf("todayString" + holiday); //2014-04-18
        } catch (DateTimeParseException ex) {
            System.out.printf("%s is not parsable!%n", goodFriday);
            ex.printStackTrace();
        }*/
    }

}
