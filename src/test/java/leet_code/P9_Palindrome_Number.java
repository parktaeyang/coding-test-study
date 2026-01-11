package leet_code;

import org.junit.jupiter.api.Test;

public class P9_Palindrome_Number {

    @Test
    void testExample1(){
        isPalindrome(121);
        System.out.println("\n\ntestExample1 : "+123456+"\n\n");
    }

    @Test
    void testExample2(){
        isPalindrome(-121);
        System.out.println("\n\ntestExample2 : "+123456+"\n\n");
    }

    @Test
    void testExample3(){
        isPalindrome(10);
        System.out.println("\n\ntestExample3 : "+123456+"\n\n");
    }

    public boolean isPalindrome(int x) {
        boolean result = false;

        if((x < 0) || (x % 10 == 0)){
            return false;
        }

        return result;
    }
}
