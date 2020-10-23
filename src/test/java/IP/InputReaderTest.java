package test.java.IP;

import main.java.IP.ToDoList.InputReader;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InputReaderTest {
    /**
     * Tests the method isSpecialCharacter of InputReader class, it takes in string input from the user, checks for
     * special characters and returns true if the string contains one or more special characters s
     */
    @Test
    public void checkIsSpecialCharacterWhenTrue() {
        InputReader reader = new InputReader();
        String input = "%#€";
        assert(reader.isSpecialCharacter(input));
    }

    @Test
    public void checkIsSpecialCharacterWhenFalse() {
        InputReader reader = new InputReader();
        String input = "Hello";
        assertEquals(false,reader.isSpecialCharacter(input));

    }

    @Test
    public void checkIsSpecialCharacterOnCombination() {
        InputReader reader = new InputReader();
        String input = "%He@llo";
        assertEquals(false,reader.isSpecialCharacter(input));
    }
    /**
     * Tests the method isNumeric of InputReader class, it takes in string input from the user, parse it into double
     * and returns true if the string is parsable to double
     */
    @Test
    public void checkIsNumericWhenTrue() {
        InputReader reader = new InputReader();
        String input = "123";                   //valid numeric data
        assert(reader.isNumeric(input));
    }

    /**
     *  Negative test case to validate if the isNumeric() method will return false
     *  when a value which cannot be parsed to date is entered
     */

    @Test
    public void checkIsNumericWhenFalse() {
        InputReader reader = new InputReader();
        String input = "hello";                          //Invalid data
        assertEquals(false,reader.isNumeric(input));
    }

/**
 * This test will validate the isValidDate() method of InputReader class which returns true if the give string is parsable to
 * date format "YYYY-MM-DD" else it returns false
 */
//Returns true when the valid date format is given
    @Test
    public void checkisValidDateWithCorrectFormat() {
        InputReader reader = new InputReader();
        String dateInput = "2020-12-31";
        assertEquals(true, reader.isValidDate(dateInput));
    }
    //  isValidDate returns false when date format is not following ISO Date format: YYYY-MM-DD
    @Test
    public void checkisValidDateWithInCorrectFormat() {
        InputReader reader = new InputReader();
        String dateInput = "31-12-2020";
        assertEquals(false, reader.isValidDate(dateInput));
    }
//  isValidDate returns false when random junk characters are given
    @Test
    public void checkisValidDateWithRandomInput() {
        InputReader reader = new InputReader();
        String dateInput = "123#€%&";
        assertEquals(false, reader.isValidDate(dateInput));
    }
}
