//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: Calendar Tester
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
public class CalendarTester {

  /**
   * Tests the getCentury method of the CalendarPrinter class. Passing in "2" should return 0.
   * Passing in "2019" should return 20. Passing in "44444" should return 444.
   * 
   * @return true if all instances pass, false if at least one fails
   */
  public static boolean testGetCentury() {
    if (CalendarPrinter.getCentury("2") != 0)
      return false;
    if (CalendarPrinter.getCentury("2019") != 20)
      return false;
    if (CalendarPrinter.getCentury("44444") != 444)
      return false;
    return true;
  }

  /**
   * Tests the getYearWithinCentury method of the CalendarPrinter class. Passing in "2001" should
   * return 1. Passing in "2072" should return 72. Passing in "3000" should return 0.
   * 
   * @return true if all instances pass, false if at least one fails
   */
  public static boolean testGetYearWithinCentury() {
    if (CalendarPrinter.getYearWithinCentury("2001") != 1)
      return false;
    if (CalendarPrinter.getYearWithinCentury("2072") != 72)
      return false;
    if (CalendarPrinter.getYearWithinCentury("3000") != 0)
      return false;
    return true;
  }

  /**
   * Tests the getIsLeapYear method of the CalendarPrinter class. Passing in "2004" should return
   * true. Passing in "2011" should return false. Passing in "1" should return false.
   * 
   * @return true if all instances pass, false if at least one fails
   */
  public static boolean testGetIsLeapYear() {
    if (!CalendarPrinter.getIsLeapYear("2004"))
      return false;
    if (CalendarPrinter.getIsLeapYear("2011"))
      return false;
    if (CalendarPrinter.getIsLeapYear("1"))
      return false;
    return true;
  }

  /**
   * Tests the getMonthIndex method of the CalendarPrinter class. Passing in "April" should return
   * 3. Passing in "Jannnnnn" should return 0. Passing in "Hello" should return -1.
   * 
   * @return true if all instances pass, false if at least one fails
   */
  public static boolean testGetMonthIndex() {
    if (CalendarPrinter.getMonthIndex("April") != 3)
      return false;
    if (CalendarPrinter.getMonthIndex("Jannnnnn") != 0)
      return false;
    if (CalendarPrinter.getMonthIndex("Hello") != -1)
      return false;
    return true;
  }

  /**
   * Tests the getNumberOfDaysInMonth method of the CalendarPrinter class. Passing in "March",
   * "2019" should return 31. Passing in "Febbbbb", "2016" should return 29. Passing in "Feb",
   * "2019", should return 28.
   * 
   * @return true if all instances pass, false if at least one fails
   */
  public static boolean testGetNumberOfDaysInMonth() {
    if (CalendarPrinter.getNumberOfDaysInMonth("March", "2019") != 31)
      return false;
    if (CalendarPrinter.getNumberOfDaysInMonth("Febbbbb", "2016") != 29)
      return false;
    if (CalendarPrinter.getNumberOfDaysInMonth("Feb", "2019") != 28)
      return false;
    return true;
  }

  /**
   * Tests the getFirstDayOfWeekInMonth method of the CalendarPrinter class. Passing in "January",
   * "1800" should return 2. Passing in "aUg", "3014" should return 0. Passing in "mayyyyy", "2016"
   * should return 6.
   * 
   * @return true if all instances pass, false if at least one fails
   */
  public static boolean testGetFirstDayOfWeekInMonth() {
    if (CalendarPrinter.getFirstDayOfWeekInMonth("January", "1800") != 2)
      return false;
    if (CalendarPrinter.getFirstDayOfWeekInMonth("aUg", "3014") != 0)
      return false;
    if (CalendarPrinter.getFirstDayOfWeekInMonth("mayyyyy", "2016") != 6)
      return false;
    return true;
  }

  /**
   * Tests the generateCalendar method of the CalendarPrinter class. Row 1 column 6 of the 2D array
   * generated by generateCalendar("Sept", "2019") should equal "1". Row 0 column 0 of the 2D array
   * generated by generateCalendar("jannn", "1580") should equal "MON". The length of the 2D array
   * generated by generateCalendar("Sept", "2019") should equal 7.
   * 
   * @return true if all instances pass, false if at least one fails
   */
  public static boolean testGenerateCalendar() {
    if (!CalendarPrinter.generateCalendar("Sept", "2019")[1][6].equals("1"))
      return false;
    if (!CalendarPrinter.generateCalendar("jannn", "1580")[0][0].equals("MON"))
      return false;
    if (CalendarPrinter.generateCalendar("Sept", "2019").length != 7)
      return false;
    return true;
  }

  /**
   * Runs each tester method and outputs a String containing the method(s) that fail, if any.
   * 
   * @param command line arguments are unused in this program
   */
  public static void main(String[] args) {
    if (!testGetCentury())
      System.out.println("getCentury failed.");
    if (!testGetYearWithinCentury())
      System.out.println("getYearWithinCentury failed.");
    if (!testGetIsLeapYear())
      System.out.println("getIsLeapYear failed.");
    if (!testGetMonthIndex())
      System.out.println("getMonthIndex failed.");
    if (!testGetNumberOfDaysInMonth())
      System.out.println("getNumberOfDaysInMonth failed.");
    if (!testGetFirstDayOfWeekInMonth())
      System.out.println("getFirstDayOfWeekInMonth failed.");
    if (!testGenerateCalendar())
      System.out.println("generateCalendar failed.");

    System.out.println("All tests executed.");
  }

}