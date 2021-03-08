import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;

        while(n > 0){
            int mod = n % 10;
            answer += mod;
            n /= mod;
        }

        return answer;
    }
}