import java.util.Arrays;
import java.util.List;

public class Calulator {

    private static String NEGATIVE_NUMBERS_EXCEPTION_MESSAGE = "Negative numbers are not supported";
    private static String EMPTY_STRING_EXCEPTION_MESSAGE = "Empty string are not supported";

    protected int add(String addNumbers){

        if(addNumbers.startsWith("-")) throw new IllegalArgumentException(NEGATIVE_NUMBERS_EXCEPTION_MESSAGE);
        if(addNumbers.length() > 1){
            String nums = removeNumberMore1000(addNumbers);
            String [] numbers = nums.trim().replaceAll("\\D","").split("");
            int sum = 0;
            for(String number:numbers)
                if(Integer.parseInt(number) < 1000) {
                    sum = sum + Integer.parseInt(number);
                }
            return sum;
        }else
            return Integer.parseInt(addNumbers);
    }

    private String removeNumberMore1000(String addNumbers) {
        StringBuilder sb = new StringBuilder();
        for(char c : addNumbers.toCharArray()){
            if(Character.isDigit(c)){
                sb.append(c);
            }else{
                sb.append(" ");
            }
        }
        String[] numbers = sb.toString().replaceAll(" +", " ").split(" ");

        for(String num:numbers){
            if(!num.equals("")){
                if(Integer.parseInt(num)> 1000){
                    addNumbers = addNumbers.replace(num,"");
                }
            }
        }
        return addNumbers;
    }
}
