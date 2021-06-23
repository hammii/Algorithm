import java.util.*;

class Solution {
    public long solution(long n) {
        ArrayList<Integer> list = new ArrayList<>();
        long answer = 0;

        while (n > 0) {
            list.add((int) (n % 10));
            n /= 10;
        }
        list.sort((o1, o2) -> o1 - o2);
        int ten = 1;
        for (Integer digit : list) {
            answer += (long) digit * ten;
            ten *= 10;
        }

        return answer;
    }
}