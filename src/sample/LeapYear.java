package sample;

public class LeapYear {
    /**
     * @field year to be used for checking if leap year
     */
    private int year;


    /**
     * @param currYear to be initialized for leap year class
     */
    LeapYear(final int currYear) {
        this.year = currYear;
    }
    /**
     *
     * @return year
     */
    public int getYear() {
        return this.year;
    }
    /**
     *
     * @return boolean
     */
    public boolean isLeapYear() {
        int currentYear = this.getYear();
        final int divisibleBy4 = 4;
        final int divisibleBy100 = 100;
        final int divisibleBy400 = 400;

        if (currentYear % divisibleBy4 == 0 && currentYear % divisibleBy100 != 0
                || currentYear % divisibleBy400 == 0) {
           System.out.println(year + " is a leap year");
           return true;
        }

        System.out.println(year + " is not a leap year");
        return false;
    }
}
