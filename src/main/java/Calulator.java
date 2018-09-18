import java.util.Arrays;

public class Calulator {

    private static String NEGATIVE_NUMBERS_EXCEPTION_MESSAGE = "Negative numbers are not supported";
    private static String EMPTY_STRING_EXCEPTION_MESSAGE = "Empty string are not supported";

    protected int add(String addNumbers){

        if(addNumbers.startsWith("-")) throw new IllegalArgumentException(NEGATIVE_NUMBERS_EXCEPTION_MESSAGE);
        if(addNumbers.length() > 1){
            String [] numbers = addNumbers.trim().replaceAll("\\D","").split("");
            int sum = 0;
            for(String number:numbers)
                sum = sum + Integer.parseInt(number);
            return sum;
        }else
            return Integer.parseInt(addNumbers);

    }


}
