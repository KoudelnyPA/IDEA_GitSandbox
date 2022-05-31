import org.example.IntegerFactory;
import org.example.Statistics;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Iterator;
import java.util.Random;

enum TestArrayType {MAX_FIRST, MAX_END};

public class StatisticsTest {

    @Test
    void testGetMaxFirst(){
        // {23, 4, 7}
        Iterable<Integer> data = createTestIntegerArray(TestArrayType.MAX_FIRST);
        int expected = 23;
        int actual = Statistics.getMax(data);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testGetMaxLast(){
        // {4, 7, 89}
        Iterable<Integer> data = createTestIntegerArray(TestArrayType.MAX_END);
        int expected = 89;
        int actual = Statistics.getMax(data);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testGetMaxMockFirst(){
        // {23, 4, 7}
        IntegerFactory factory = Mockito.mock(IntegerFactory.class);//createTestIntegerArray(TestArrayType.MAX_FIRST);
        Iterable<Integer> data = createTestIntegerArray(TestArrayType.MAX_FIRST);
        Mockito.doReturn(data).when(factory).createIntegerArray(3);
        int expected = 23;
        int actual = Statistics.getMax(data/*factory.createIntegerArray(3)*/);
        Assertions.assertEquals(expected, actual);
    }

    public static Iterable<Integer> createTestIntegerArray(final TestArrayType arrayType){
        return new Iterable<Integer>() {
            @Override
            public Iterator<Integer> iterator() {
                return new Iterator<Integer>() {
                    int[] arr;
                    {
                        switch(arrayType){
                            case MAX_FIRST : arr = new int[]{23, 4, 7}; break;
                            case MAX_END :  arr = new int[]{4, 7, 89}; break;
                        }
                    }
                    int current = 0;
                    @Override
                    public boolean hasNext() {
                        return current < arr.length;
                    }
                    @Override
                    public Integer next() {
                        if(hasNext()){
                            return arr[current++];
                        }
                        else{
                            throw new ArrayIndexOutOfBoundsException();
                        }
                    }
                };
            }
        };
    }
}
