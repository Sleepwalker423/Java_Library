/**
 * This class provides methods to request various user inputs, with built-in range checks and valid input checks. 
 */
package textutils.inputrequest;

class InputRequest{

    /**
     * This method prompts the program user with a message given by the implementor and repeatedly requests a valid value until one is provided. 
     * @param The data type of <E> must not be larger than a double.
     * @param <E>
     * @param request
     * @param min
     * @param max
     * @param scan
     * @return Returns a user-given value with the inclusive range specified by min and max.
     */
    public <E extends Number> E requestNumber(String request, E min, E max, java.util.Scanner scan) {

        boolean validValue = false;
    
        E givenValue;

        while(!validValue){ // Loop until a valid input is entered.
            
            System.out.print(message+ ": ");

            if (scan.hasNextDouble()) {

                givenValue = (E)scan.nextDouble();

                if(givenValue.comareTo(min) != -1 && givenValue.compareTo(max) != 1){

                    validValue = true;
                }
            }

            if (!validValue){

                System.out.println("Please enter a valid "+ min.getClass().getSimpleName() +" in the inclusive range of " + min + " to " + max + ".");

                scan.next(); // Consume the invalid token to avoid an infinite loop
            }

        }
        return givenValue;
    } 
}
