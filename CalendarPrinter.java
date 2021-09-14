//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: Calendar Printer
// Files: CalendarPrinter.java, CalendarTester.java
// Course: CS300, Term 1, 2019
//
// Author: Erin Crews
// Email: eecrews@wisc.edu
// Lecturer's Name: Gary Dahl
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:
// Partner Email:
// Partner Lecturer's Name:
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// ___ Write-up states that pair programming is allowed for this assignment.
// ___ We have both read and understand the course Pair Programming Policy.
// ___ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully
// acknowledge and credit those sources of help here. Instructors and TAs do
// not need to be credited here, but tutors, friends, relatives, room mates,
// strangers, and others do. If you received no outside help from either type
// of source, then please explicitly indicate NONE.
//
// Persons: NONE
// Online Sources: https://www.developer.com/java/data/understanding-the-java-labeled-statement.html
// This online source helped me learn how to break out of a nested for loop in one statement using
//////////////////// labels.
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

import java.util.Scanner;

public class CalendarPrinter {

  private final static String[] DAYS_OF_WEEK = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
  private final static String[] MONTHS_OF_YEAR =
      {"JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"};

  /**
   * Calculates the number of centuries (rounded down) that is represented by the specified year
   * (ie. the integer part of year/100).
   * 
   * @param year to compute the century of (based on the Gregorian Calendar AD) String must contain
   *             the digits of a single non-negative int for year.
   * @return number of centuries in the specified year
   */
  public static int getCentury(String year) {
    int numCentury = Integer.parseInt(year);
    return numCentury / 100;
  }

  /**
   * Calculates the number of years between the specified year, and the first year in the specified
   * year's century. This number is always between 0 - 99.
   * 
   * @param year to compute the year within century of (Gregorian Calendar AD) String must contain
   *             the digits of a single non-negative int for year.
   * @return number of years since first year in the current century
   */
  public static int getYearWithinCentury(String year) {
    int numYear = Integer.parseInt(year);
    return numYear % 100;
  }


  /**
   * This method computes whether the specified year is a leap year or not.
   * 
   * @param yearString is the year that is being checked for leap-year-ness String must contain the
   *                   digits of a single non-negative int for year.
   * @return true when the specified year is a leap year, and false otherwise
   */
  public static boolean getIsLeapYear(String yearString) {
    int numLeapYear = Integer.parseInt(yearString);
    if (numLeapYear % 4 != 0)
      return false;
    else if (numLeapYear % 100 != 0)
      return true;
    else if (numLeapYear % 400 != 0)
      return false;
    else
      return true;

  }

  /**
   * Converts the name or abbreviation for any month into the index of that month's abbreviation
   * within MONTHS_OF_YEAR. Matches the specified month based only on the first three characters,
   * and is case in-sensitive.
   * 
   * @param month which may or may not be abbreviated to 3 or more characters
   * @return the index within MONTHS_OF_YEAR that a match is found at and returns -1, when no match
   *         is found
   */
  public static int getMonthIndex(String month) {
    int index = -1;
    String firstThree = month.substring(0, 3);

    for (int i = 0; i < MONTHS_OF_YEAR.length; i++) {
      if (firstThree.equalsIgnoreCase(MONTHS_OF_YEAR[i]))
        index = i;
    }

    return index;

  }

  /**
   * Calculates the number of days in the specified month, while taking into consideration whether
   * or not the specified year is a leap year.
   * 
   * @param month which may or may not be abbreviated to 3 or more characters
   * @param year  of month that days are being counted for (Gregorian Calendar AD) String must
   *              contain the digits of a single non-negative int for year.
   * @return the number of days in the specified month (between 28-31)
   */
  public static int getNumberOfDaysInMonth(String month, String year) {
    int days = -1;
    switch (getMonthIndex(month)) {
      case 0:
      case 2:
      case 4:
      case 6:
      case 7:
      case 9:
      case 11:
        days = 31;
        break;
      case 3:
      case 5:
      case 8:
      case 10:
        days = 30;
        break;
      case 1:
        if (getIsLeapYear(year)) {
          days = 29;
          break;
        } else
          days = 28;
    }

    return days;

  }

  /**
   * Calculates the index of the first day of the week in a specified month. The index returned
   * corresponds to position of this first day of the week within the DAYS_OF_WEEK class field.
   * 
   * @param month which may or may not be abbreviated to 3 or more characters
   * @param year  of month to determine the first day from (Gregorian Calendar AD) String must
   *              contain the digits of a single non-negative int for year.
   * @return index within DAYS_OF_WEEK of specified month's first day
   */
  public static int getFirstDayOfWeekInMonth(String month, String year) {
    int m; // month
    int K; // year of the century
    int J; // zero-based century
    int yearNum = Integer.parseInt(year);

    if (getMonthIndex(month) == 0 || getMonthIndex(month) == 1) {
      m = getMonthIndex(month) + 13;
      K = (yearNum - 1) % 100;
      J = (yearNum - 1) / 100;
    } else {
      m = getMonthIndex(month) + 1;
      K = getYearWithinCentury(year);
      J = getCentury(year);
    }

    int h = (int) ((1 + Math.floor((13 * (m + 1)) / 5) + K + Math.floor(K / 4) + Math.floor(J / 4)
        + 5 * J) % 7);

    if (h - 2 < 0)
      return h + 5;
    else
      return h - 2;
  }

  /**
   * Creates and initializes a 2D String array to reflect the specified month. The first row of this
   * array [0] should contain labels representing the days of the week, starting with Monday, as
   * abbreviated in DAYS_OF_WEEK. Every later row should contain dates under the corresponding days
   * of week. Entries with no corresponding date in the current month should be filled with a single
   * period. There should not be any extra rows that are either blank, unused, or completely filled
   * with periods. For example, the contents for September of 2019 should look as follows, where
   * each horizontal row is stored in different array within the 2d result:
   *
   * MON TUE WED THU FRI SAT SUN . . . . . . 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21
   * 22 23 24 25 26 27 28 29 30 . . . . . .
   *
   * @param month which may or may not be abbreviated to 3 or more characters
   * @param year  of month generate calendar for (Gregorian Calendar AD) String must contain the
   *              digits of a single non-negative int for year.
   * @return 2d array of strings depicting the contents of a calendar
   */
  public static String[][] generateCalendar(String month, String year) {
    String[][] calendarArray;
    if (getFirstDayOfWeekInMonth(month, year) >= 5 && getMonthIndex(month) != 1)
      calendarArray = new String[7][7];
    else if (getIsLeapYear(year))
      calendarArray = new String[6][7];
    else
      calendarArray = new String[5][7];

    for (int col = 0; col < 7; col++) {
      calendarArray[0][col] = DAYS_OF_WEEK[col];
    }

    Integer counter = 1;

    outerLoop: for (int row = 1; row < calendarArray.length; row++) {
      for (int col = 0; col < calendarArray[row].length; col++) {
        if (row == 1 && col < getFirstDayOfWeekInMonth(month, year)) {
          calendarArray[row][col] = null;
          continue;
        }
        calendarArray[row][col] = counter.toString();
        if (counter < getNumberOfDaysInMonth(month, year))
          counter++;
        else
          break outerLoop;
      }

    }
    insertDots(calendarArray);
    return calendarArray;
  }

  /**
   * Replaces all instances of null in the calendar with the "." character.
   * 
   * @param a 2D array containing the data of an already-created calendar
   */
  private static void insertDots(String[][] generatedCalendar) {
    for (int row = 0; row < generatedCalendar.length; row++) {
      for (int col = 0; col < generatedCalendar[row].length; col++) {
        if (generatedCalendar[row][col] == null)
          generatedCalendar[row][col] = ".";
      }
    }
  }

  /**
   * Creates line dividers in the calendar output.
   * 
   * @return 32 instances of the "=" character to create a dashed line
   */
  private static String outputLines() {
    return "\n================================\n";
  }

  /**
   * Displays each calendar date of a specific row number in an organized, easy-to-read fashion.
   * Used to make outputting the calendar simpler in the main method.
   * 
   * @param a   2D array containing the data of an already-created calendar
   * @param the index value of the row to output
   */
  private static void outputRow(String[][] generatedCalendar, int rowNumber) {
    System.out.println("");
    for (int col = 0; col < generatedCalendar[0].length; col++)
      System.out.printf("%-4s", generatedCalendar[rowNumber][col]);
  }

  /**
   * Contains the Scanner which gathers user input of which month and year are being printed.
   * Creates a 2D array containing the data of a calendar for the specified month and year. Outputs
   * the 2D array.
   * 
   * @param command line arguments are unused in this program
   */
  public static void main(String[] args) {
    System.out.print("Welcome to the Calendar Printer." + outputLines());

    Scanner userInput = new Scanner(System.in);
    System.out.println("Enter the month to print:");
    String month = userInput.nextLine();

    System.out.println("Enter the year to print:");
    String year = userInput.nextLine();

    String[][] cal = generateCalendar(month, year);

    for (int rowNumber = 0; rowNumber < cal.length; rowNumber++) {
      outputRow(cal, rowNumber);
    }

    System.out.print(outputLines() + "Thanks, and have a great day!");


  }

}
