import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class CalculateTest {


    @Test
    public void emptyStringRetureZeroTest(){

        Calulator calculator = new Calulator();

        int result = calculator.add("0");

        assertThat(result,equalTo(0));


    }

    @Test
    public void singleNumberReturnsValueTest(){
        Calulator calculator = new Calulator();

        int result = calculator.add("1");

        assertThat(result,equalTo(1));

    }

    @Test
    public void twoNumbersWithCommaDelimitedReturnsTheSumTest(){

        Calulator calculator = new Calulator();

        int result = calculator.add("1,1");

        assertThat(result,equalTo(2));
    }

    @Test
    public void twoNumbersWithNewLineDelimitedReturnsTheSumTest(){

        Calulator calculator = new Calulator();

        int result = calculator.add("1\n1");

        assertThat(result,equalTo(2));
    }

    @Test
    public void threeNumbersWithDelimitedEitherSideReturnsTheSumTest(){

        Calulator calculator = new Calulator();

        int result = calculator.add("1\n1,1");

        assertThat(result,equalTo(3));
    }

    @Test
    public void negativeNumbersThrowAnExecption(){

        Calulator calculator = new Calulator();
        try {
            calculator.add("-1,-1,-1");
        } catch (IllegalArgumentException ex) {
            Assert.assertThat(ex.getMessage(), equalTo("Negative numbers are not supported"));
        }

    }

    @Test
    public void numbersBiggerThanThousandShouldBeIgnored(){

        Calulator calculator = new Calulator();

        int result = calculator.add("1001,2");

        assertThat(result,equalTo(2));

    }

    @Test
    public void delimitersCanBeOfAnyLengthWithTheFollowingFormat(){

        Calulator calculator = new Calulator();

        int result = calculator.add("//[***]\\n1***2***3");

        assertThat(result,equalTo(6));

    }

    @Test
    public void allowMultipleDelimiters(){

        Calulator calculator = new Calulator();

        int result = calculator.add("//[*][%]\\n1*2%3");

        assertThat(result,equalTo(6));


    }

}

