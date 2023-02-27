import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class StringCheckTest {

    private static final List<Integer> SECOND_WORD_EXPECTED_RESULT = new ArrayList<>(Arrays.asList(0,1));
    private static final List<Integer> FOURTH_WORD_EXPECTED_RESULT = new ArrayList<>(Arrays.asList(3,4));
    private static final String[] TEST_DATA = {"qwe","wqe","qwee","a","a"};
    private static final String SECOND_WORD_FOR_CHECK = "eqw";
    private static final String FOURTH_WORD_FOR_CHECK = "a";

    @Test
    public void duplicateElementsSeekerTest() {
        Map<String, List<Integer>> actualResult = StringCheck.duplicateElementSeeker(TEST_DATA);

        Assert.assertEquals(actualResult.get(SECOND_WORD_FOR_CHECK), SECOND_WORD_EXPECTED_RESULT,
                "Индексы не соответствуют");
        Assert.assertEquals(actualResult.get(FOURTH_WORD_FOR_CHECK), FOURTH_WORD_EXPECTED_RESULT,
                "Индексы не соответствуют");
    }
}
