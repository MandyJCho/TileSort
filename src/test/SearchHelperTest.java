package test;

import Search.SearchHelper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Mandy Cho :) on 1/26/18.
 */
class SearchHelperTest {
    @Test
    public void testIsGoalState() throws Exception {
        String[] arrangements = {"WWxBB", "xBBWW", "xWWBB"};
        Arrays.stream(arrangements)
                .forEach((arrangement) -> {
                        // Assertions.assertFalse(SearchHelper.isGoalState(arrangement));
                    }
                );

        // Assertions.assertTrue(SearchHelper.isGoalState("BBxWW"));
    }
}