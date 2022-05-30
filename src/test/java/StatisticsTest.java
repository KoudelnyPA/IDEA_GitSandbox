import org.example.Statistics;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StatisticsTest {
    @Test
    void testMax1(){
        Statistics stat = new Statistics(new int[] {5, 7, 12, 1} );
        int expected = 12;
        int actual = stat.getMax();
        Assertions.assertEquals(expected, actual);

    }
}
