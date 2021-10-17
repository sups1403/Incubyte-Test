import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringCalculatorShould {
    @Test
    public void
    return_0_when_input_is_empty() {
        assertEquals("0", given(""));
    }

    @Test
    public void
    return_3_when_input_is_1_2() {
        assertEquals("3", given("1,2"));
    }

    @Test
    public void
    sum_floats_and_return_float() {
        assertEquals("6.6", given("2.2,4.4"));
    }

    @Test
    public void
    treat_newLine_as_a_delimiter() {
        assertEquals("6", given("1\n2,3"));
    }

    @Test
    public void
    return_error_msg_when_newLine_at_invalid_position() {
        assertEquals("Number expected but '\n' found at position 6.", given("1,2,5,\n3"));
    }

    @Test
    public void
    return_error_msg_when_delimiter_at_last_position() {
        assertEquals("Number expected but EOF found.", given("2,3,4.2,"));
    }

    @Test
    public void
    return_correct_sum_when_custom_delimiter_is_used() {
        assertEquals("3", given("//;\n1;2"));
        assertEquals("3", given("//|\n1|2"));
        assertEquals("8", given("//@@\n1@@2@@5"));
        assertEquals("5", given("//sep\n2sep3"));
    }

    @Test
    public void
    return_string_of_negative_numbers_when_negative_numbers_are_used_as_input() {
        assertEquals("Negative not allowed: -1", given("-1,2"));
        assertEquals("Negative not allowed: -4,-5", given("2,-4,-5"));
    }

    private String given(String number) {
        StringCalculator stringCalculator = new StringCalculator();
        return stringCalculator.sum(number);
    }
}