public class Date
{
    private static final int MIN_YEAR     = 1800;
    private static final int CURRENT_YEAR = 2025;

    private static final int SATURDAY     = 0;
    private static final int SUNDAY       = 1;
    private static final int MONDAY       = 2;
    private static final int TUESDAY      = 3;
    private static final int WEDNESDAY    = 4;
    private static final int THURSDAY     = 5;
    private static final int FRIDAY       = 6;

    private static final int JANUARY      = 1;
    private static final int FEBRUARY     = 2;
    private static final int MARCH        = 3;
    private static final int APRIL        = 4;
    private static final int MAY          = 5;
    private static final int JUNE         = 6;
    private static final int JULY         = 7;
    private static final int AUGUST       = 8;
    private static final int SEPTEMBER    = 9;
    private static final int OCTOBER      = 10;
    private static final int NOVEMBER     = 11;
    private static final int DECEMBER     = 12;

    private static final int[] MONTH_CODES = {1, 4, 4, 0, 2, 5, 0, 3, 6, 1, 4, 6};


    private final int year;
    private final int month;
    private final int day;

    Date(final int year,
         final int month,
         final int day)
    {
        if (year < MIN_YEAR || year > CURRENT_YEAR)
        {
            throw new IllegalArgumentException("Invalid year: " + year);
        }

        this.year = year;
        this.month = month;
        this.day = day;
    }

    private int getDaysInMonth(int month, int year)
    {
        if (month == APRIL || month == JUNE || month == SEPTEMBER || month == NOVEMBER)
        {
            return 30;
        }
        else if (month == FEBRUARY)
        {
            return isLeapYear(year) ? 29 : 28;
        }
        return 31;
    }

    private boolean isLeapYear(int year)
    {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    int getYear()
    {
        return year;
    }

    int getMonth()
    {
        return month;
    }

    int getDay()
    {
        return day;
    }

    public String getYyyyMmDd()
    {
        return year + "-" +  month + "-" + day;
    }

    private String getDayName(int dayIndex)
    {
        if (dayIndex == SUNDAY)
        {
            return "Sunday";
        }
        else if (dayIndex == MONDAY)
        {
            return "Monday";
        }
        else if (dayIndex == TUESDAY)
        {
            return "Tuesday";
        }
        else if (dayIndex == WEDNESDAY)
        {
            return "Wednesday";
        }
        else if (dayIndex == THURSDAY)
        {
            return "Thursday";
        }
        else if (dayIndex == FRIDAY)
        {
            return "Friday";
        }
        else if (dayIndex == SATURDAY)
        {
            return "Saturday";
        }
        else
        {
            return "Invalid day";
        }
    }

    public String getDayOfWeek()
    {
        int lastTwoDigitsInYear;
        int monthCode;
        int step1;
        int step2;
        int step3;
        int step4;
        int step5;
        int step6;
        int step7;

        lastTwoDigitsInYear = year % 100;
        step1 = lastTwoDigitsInYear / 12;
        step2 = lastTwoDigitsInYear - 12 * step1;
        step3 = step2 / 4;
        step4 = day + step1 + step2 + step3;
        monthCode = MONTH_CODES[month - 1];
        step5 = step4 + monthCode;

        if (year >= 2000)
        {
            step5 += 6;
        }
        else if (year < 1900)
        {
            step5 += 2;
        }

        if(isLeapYear(year) && (month == JANUARY || month == FEBRUARY))
        {
            step5 += 6;
        }

        step6 = step5 % 7;
        step7 = step6;

        return getDayName(step7);

    }

    public static void main(final String[] args)
    {
        final Date d;
        d = new Date(1977,10,31);
        System.out.println(d.getDayOfWeek());

    }

}
