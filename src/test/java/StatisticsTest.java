import org.example.Statistics;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StatisticsTest {
    @Test
    void testMax1(){
        Statistics stat = new Statistics(new int[] {65, 7, 12, 1} );
        int expected = 65;
        int actual = stat.getMax();
        Assertions.assertEquals(expected, actual);

    }

    @Test
    void testMax2(){
        Statistics stat = new Statistics(new int[] {3, 7, 12, 19} );
        int expected = 19;
        int actual = stat.getMax();
        Assertions.assertEquals(expected, actual);

    }
}
