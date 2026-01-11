package leet_code;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

/*
Given a string s, find the length of the longest substring without duplicate characters.

Example 1:
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3. Note that "bca" and "cab" are also correct answers.

Example 2:
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:
Input: s = "pwwkew"
Output: 3

Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

중복없이 제일 긴 문자열의 길이
 */
public class P3_Longest_Characters {

    @Test
    void testExample1(){
        int result = lengthOfLongestSubstring("abcabcbb");
        System.out.println("\n\ntestExample1 : "+result+"\n\n");
    }

    @Test
    void testExample2(){
        int result = lengthOfLongestSubstring("bbbbb");
        System.out.println("\n\ntestExample2 : "+result+"\n\n");
    }

    @Test
    void testExample3(){
        int result = lengthOfLongestSubstring("pwwkew");
        System.out.println("\n\ntestExample3 : "+result+"\n\n");
    }

    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();

        int l = 0;          // 윈도우(부분문자열) 시작 인덱스
        int maxLen = 0;

        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);

            // 중복이 없어질 때까지 왼쪽(l)을 줄여가며 제거
            while (set.contains(c)) {
                set.remove(s.charAt(l));
                l++;
            }

            // 이제 c를 추가해도 중복이 없음
            set.add(c);

            // 현재 윈도우 길이 갱신
            maxLen = Math.max(maxLen, r - l + 1);
        }

        return maxLen;
    }
}
