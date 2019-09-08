package artemser;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class TwoSumTest {
    int[][] expectedResult;

    @Before
    public void setUp(){
        expectedResult = new int[][]{
                {0,1},
                null,
                {2,3},
                {1,2}
        };
    }

    @Test
    public void twoSum() {
        Assert.assertArrayEquals(expectedResult[0], TwoSum.twoSum(new int[]{2,7,11,15}, 9));
        Assert.assertArrayEquals(expectedResult[1], TwoSum.twoSum(new int[]{2,7,11,15}, 100));
        Assert.assertArrayEquals(expectedResult[2], TwoSum.twoSum(new int[]{7,7,11,15}, 26));
        Assert.assertArrayEquals(expectedResult[3], TwoSum.twoSum(new int[]{2,7,33,34}, 40));
    }

}
