package sample;
import java.util.Scanner;
import java.util.Arrays;

public final class TestJava {

    private TestJava() {
        super();
    }

    /**
	*
	* @param args
	*/
	public static void main(final String[] args) {
		Scanner takeInp = new Scanner(System.in);
		boolean flag = true;

		do {
		    System.out.print("Input the year: ");
	        int year = takeInp.nextInt();
	        LeapYear leapyr = new LeapYear(year);
	        flag = leapyr.isLeapYear();
	        System.out.println(flag);
		} while (flag);
		System.out.println("Exiting Loop");

		takeInp.close();
	}
	/**
	 *
	 * @param takeInp this is the scanner object to take the user input
	 * @return returns an integer array to manipulate or print
	 */
	public static int[] takeInput(final Scanner takeInp) {
		System.out.print("Enter Array Size: ");
		int arraySize = takeInp.nextInt();
		int[] numArray = new int[arraySize];
		System.out.println("");

		for (int i = 0; i < arraySize; i++) {
		    System.out.print("Enter Array Numbers: ");
		    numArray[i] = takeInp.nextInt();
		}

		return numArray;
	}

	/**
	 *
	 * @param x will be our number array
	 * @return returns the smallest number found within the array
	 */
	public static int findSmallestNumber(final int[] x) {
		int z = x[0];

		for (int i = 1; i < x.length; i++) {
			if (x[i] < z) {
				z = x[i];
			}
		}

		return z;
	}

	/**
	 *
	 * @param x will be our integer array
	 * @return returns the largest integer found in the array
	 */
	public static int findLargestNumber(final int[] x) {
		int z = x[0];

		for (int i = 1; i < x.length; i++) {
			if (x[i] > z) {
				z = x[i];
			}
		}

		return z;
	}

}



class LeapYear {
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

    public int getYear() {
        return this.year;
    }

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


