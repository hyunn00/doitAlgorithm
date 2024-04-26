package chap06;

import java.util.Arrays;
import java.util.GregorianCalendar;

import static java.util.Calendar.*;

public class SortCalendar {
    public static void main(String[] args) {
        GregorianCalendar[] x = {
                new GregorianCalendar(2022, NOVEMBER, 1),
                new GregorianCalendar(1963, OCTOBER, 18),
                new GregorianCalendar(1985, APRIL, 5),
        };

        Arrays.sort(x);

        for(GregorianCalendar c : x) {
            System.out.printf("%04d년 %02d월 %02d일\n",
                    c.get(YEAR),
                    c.get(MONTH) + 1,
                    c.get(DATE)
            );
        }
    }
}
