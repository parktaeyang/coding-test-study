package com.leet_code;

import java.util.HashMap;
import java.util.Map;

public class P1_Two_Sum {

    Solution solution = new Solution();

    int[] testExample(){
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        return  solution.twoSum(nums, target);
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