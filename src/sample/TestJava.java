package sample;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.*;

public class TestJava {
    /**
     * @field sensitiveStuff
     */
    private int sensitiveStuff;
    /**
     * @field id
     */
    private String id = "buh";

    /**
     * default constructor.
     */
    public TestJava() {
    }

    /**
     * @param stuff
     */
    public TestJava(final int stuff) {
        this.sensitiveStuff = stuff;
    }

    /**
     * @return returns private field
     */
    public int getSensitiveStuff() {
        return sensitiveStuff;
    }

    /**
     * @param sensitiveStuff takes in int to modify value
     */
    public void setSensitiveStuff(final int sensitiveStuff) {
        this.sensitiveStuff = sensitiveStuff;
    }

    /**
    *@param args
	*/
	public static void main(final String[] args) {
		Scanner takeInp = new Scanner(System.in);
		boolean flag = true;
		
//		do {
//		    System.out.print("Input the year: ");
//	        int year = takeInp.nextInt();
//	        LeapYear leapyr = new LeapYear(year);
//	        flag = leapyr.isLeapYear();
//	        System.out.println(flag);
//		} while (flag);
//		System.out.println("Exiting Loop");

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






