import java.util.*;
import java.util.stream.IntStream;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        boolean[] people = new boolean[n + 1];
        boolean[] able = new boolean[n + 1];

        Arrays.fill(people, true);
        for (int k : lost) {    // 잃어버린 사람
            people[k] = false;
        }
        for (int k : reserve) { // 빌려줄 수 있는 사람
            able[k] = true;
        }

        for (int i = 1; i <= n; i++) {  // 자신이 체육복을 잃어버린 경우
            int finalI = i;
            if (IntStream.of(lost).anyMatch(x -> x == finalI) && IntStream.of(reserve).anyMatch(x -> x == finalI)) {
                people[i] = true;
                able[i] = false;
            }
        }

        for (int k : reserve) { // 앞뒤로 빌려줄 수 있는 경우
            if (able[k] && !people[k - 1]) {
                people[k - 1] = true;
            } else if (k + 1 <= n) {
                if (able[k] && !people[k + 1]) {
                    people[k + 1] = true;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (people[i]) {
                answer++;
            }
        }

        return answer;
    }
}