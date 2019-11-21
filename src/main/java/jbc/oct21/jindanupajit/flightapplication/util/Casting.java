package jbc.oct21.jindanupajit.flightapplication.util;

import java.sql.Timestamp;

public abstract class Casting {



    public static class Long {
        public static long from(String s) {
            try {
                return java.lang.Long.parseLong(s);
            } catch (NumberFormatException e) {
                return 0;
            }
        }
    }

    public static class Double {
        public static double from(String s) {
            try {
                return java.lang.Double.parseDouble(s);
            } catch (NumberFormatException e) {
                return 0;
            }
        }
    }

    public static class Timestamp {
        public static java.sql.Timestamp from(String s) {
            return java.sql.Timestamp.valueOf(s);
        }

        public static java.sql.Timestamp from(int yyyy, int MM, int dd) {
            return java.sql.Timestamp.valueOf(String.format("%04d-%02d-%02d 12:00:00.000000", yyyy, MM, dd));
        }

        public static java.sql.Timestamp from(int yyyy, int MM, int dd, int hh, int mm) {
            return java.sql.Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:00.000000", yyyy, MM, dd, hh, mm));
        }

        public static java.sql.Timestamp now() {
            return new java.sql.Timestamp(System.currentTimeMillis());
        }
    }

}
