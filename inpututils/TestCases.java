import java.util.Scanner;
import inpututils.InputRequest;

public class TestCases {

    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        
        int intValue = InputRequest.requestNumber("Enter int value.", 0, 10, scan);
    }


  
        public void testMethod(){

            double doubleValue = InputRequest.requestNumber("Enter double value.", 0.0, 4.0, scan);
        }
}



