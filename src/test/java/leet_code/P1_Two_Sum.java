package leet_code;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

public class P1_Two_Sum {

    Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    void testExample1() {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = solution.twoSum(nums, target);
        
        assertEquals(2, result.length);
        assertTrue((result[0] == 0 && result[1] == 1) || (result[0] == 1 && result[1] == 0));
        assertEquals(target, nums[result[0]] + nums[result[1]]);
    }

    @Test
    void testExample2() {
        int[] nums = {3, 2, 4};
        int target = 6;
        int[] result = solution.twoSum(nums, target);
        
        assertEquals(2, result.length);
        assertTrue((result[0] == 1 && result[1] == 2) || (result[0] == 2 && result[1] == 1));
        assertEquals(target, nums[result[0]] + nums[result[1]]);
    }

    @Test
    void testExample3() {
        int[] nums = {3, 3};
        int target = 6;
        int[] result = solution.twoSum(nums, target);
        
        assertEquals(2, result.length);
        assertTrue((result[0] == 0 && result[1] == 1) || (result[0] == 1 && result[1] == 0));
        assertEquals(target, nums[result[0]] + nums[result[1]]);
    }
}

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // HashMap을 사용하여 숫자와 인덱스를 저장
        Map<Integer, Integer> map = new HashMap<>();
        
        // 배열을 한 번만 순회 (O(n) 시간 복잡도)
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            
            // complement가 이미 HashMap에 있으면 두 인덱스 반환
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            
            // 현재 숫자와 인덱스를 HashMap에 저장
            map.put(nums[i], i);
        }
        
        // 문제 조건상 항상 해답이 존재하지만, 컴파일 오류 방지를 위한 반환
        return new int[]{};
    }
}