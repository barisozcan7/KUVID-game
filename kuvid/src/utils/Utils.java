package utils;

import domain.enums.SaveMode;
import domain.models.options.SaveOptions;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;
import java.util.stream.IntStream;

public class Utils {

    public static String secondsToMMSS(int seconds) {
        int mins = seconds / 60;
        int secs = seconds - mins * 60;
        return String.format("%02d:%02d", mins, secs);
    }

    public static int generateRandomInteger(int min, int max) {
        Random rand = new Random();
        int randInt = rand.nextInt(max - min + 1) + min;
        return randInt;
    }

    public static int selectRandomInteger(int a, int b, int c) {
        Random rand = new Random();
        int randInt = rand.nextInt(3);
        switch (randInt) {
            case 0 -> {
                return a;
            }
            case 1 -> {
                return b;
            }
            case 2 -> {
                return c;
            }
        }
        return c;
    }

    public static int selectRandomInteger(int a, int b, int c, int d, int e) {
        Random rand = new Random();
        int randInt = rand.nextInt(5);
        switch (randInt) {
            case 0 -> {
                return a;
            }
            case 1 -> {
                return b;
            }
            case 2 -> {
                return c;
            }
            case 3 -> {
                return d;
            }
            case 4 -> {
                return e;
            }
        }
        return e;
    }

    public static String fileNameGenerator(String username) {
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SS");
        String strDate = dateFormat.format(date);
        long timestamp = DateStringToTimestampConverter(strDate);
        return username + "_" + timestamp;
    }

    public static SaveOptions fileNameToSaveOptionsConverter(String fileName, SaveMode saveMode) {
        StringBuilder builder = new StringBuilder();
        String[] fileNamePartsList = fileName.split("_");
        IntStream.range(0, fileNamePartsList.length -1)
                .forEach( i -> builder.append(fileNamePartsList[i] + "_"));
        String finalString = builder.substring(0, builder.toString().length()-1);
        return new SaveOptions(finalString, fileNamePartsList[fileNamePartsList.length - 1], saveMode);
    }

    public static String timestampToDateConverter(String timestamp) {

        Timestamp stamp = new Timestamp(Long.parseLong(timestamp));
        Date date = new Date(stamp.getTime());
        return dateFormatter(date);
    }

    public static long DateStringToTimestampConverter(String dateString) {
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SS").parse(dateString);
            long timestamp = date.getTime();
            return timestamp;
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    public static String dateFormatter(Date date) {
        DateFormat f = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SS");
        return f.format(date);
    }
}
