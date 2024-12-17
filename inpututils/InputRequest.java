/**
 * File Name: InputRequest.java
 * Purpose: This class provides methods to request various user inputs, with built-in range checks and valid input checks. 
 * Date Created: Dec 16 2024
 * Dependencies:
 * -java.util.Scanner: Required as the method for retrieving user input. Passes the responsibility of closing the scanner
 *                     to the user to avoid prematurely closing System.in.
 * 
 * @author Charles J. Walker
 * @version 1.0
 * @since 22.0.2
 */
package inpututils;

import java.util.NoSuchElementException;


public class InputRequest{

    @SuppressWarnings("UnnecessaryBoxing")
    public static int requestNumber(String request, int min, int max, java.util.Scanner scan) {
        return (int) genericRequestNumber(request, Integer.valueOf(min), Integer.valueOf(max), scan);
    }
    @SuppressWarnings("UnnecessaryBoxing")
    public static float requestNumber(String request, float min, float max, java.util.Scanner scan) {
        return (float) genericRequestNumber(request, Float.valueOf(min), Float.valueOf(max), scan);
    }
    @SuppressWarnings("UnnecessaryBoxing")
    public static double requestNumber(String request, double min, double max, java.util.Scanner scan) {
        return (double) genericRequestNumber(request, Double.valueOf(min), Double.valueOf(max), scan);
    }
    @SuppressWarnings("UnnecessaryBoxing")
    public static long requestNumber(String request, long min, long max, java.util.Scanner scan) {
        return (long) genericRequestNumber(request, Long.valueOf(min), Long.valueOf(max), scan);
    }
    @SuppressWarnings("UnnecessaryBoxing")
    public static byte requestNumber(String request, byte min, byte max, java.util.Scanner scan) {
        return (byte) genericRequestNumber(request, Byte.valueOf(min), Byte.valueOf(max), scan);
    }
    @SuppressWarnings("UnnecessaryBoxing")
    public static short requestNumber(String request, short min, short max, java.util.Scanner scan) {
        return (short) genericRequestNumber(request, Short.valueOf(min), Short.valueOf(max), scan);
    }
    /**
     * This method prompts the program user with a message given by the implementor and repeatedly requests a valid value until one is provided. 
     * @param The data type of <E> must not be larger than a double.
     * @param <E>
     * @param request
     * @param min
     * @param max
     * @param scan - An open instance of scanner not closed by this method.
     * @return Returns a user-given value with the inclusive range specified by min and max.
     */
    @SuppressWarnings("unchecked")
    private static <E extends Number & Comparable<E>> E genericRequestNumber(String request, E min, E max, java.util.Scanner scan) {

        boolean validValue = false;
    
        E returnValue = null;

        double originalValue;

        while(!validValue){ // Loop until a valid input is entered.
            
            System.out.println(request);

            if (scan.hasNextDouble()) {

                originalValue = scan.nextDouble();

                switch (min.getClass().getSimpleName()){
                    case "Integer" -> {
                        returnValue = (E) Integer.valueOf((int) originalValue);
                    }
                    case "Float" -> {
                        returnValue = (E) Float.valueOf((float) originalValue);
                    }
                    case "Long" -> {
                        returnValue = (E) Long.valueOf((long) originalValue);
                    }
                    case "Double" -> {
                        returnValue = (E) Double.valueOf(originalValue);
                    }
                    case "Byte" -> {
                        returnValue = (E) Byte.valueOf((byte) originalValue);
                    }
                    case "Short" -> {
                        returnValue = (E) Short.valueOf((short) originalValue);
                    }
                }

                if(returnValue != null && returnValue.compareTo(min) != -1 && returnValue.compareTo(max) != 1){

                    validValue = true;
                }
            }

            if (!validValue){

                System.out.println("Please enter a valid "+ min.getClass().getSimpleName() +" in the inclusive range of " + min + " to " + max + ".");
                try {//Used to handle to handle the rare case the user manages to cause a NoSuchElementException with no line found or otherwise.
                    
                    scan.nextLine(); // Consume the invalid token to avoid an infinite loop

                } catch (NoSuchElementException e) {

                }
                
            }

        }
        return returnValue;
    } 
}

