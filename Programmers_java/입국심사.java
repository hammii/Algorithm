import java.util.Arrays;

class Solution {
    public long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;

        Arrays.sort(times);
        long min = 0;
        long max = Long.MAX_VALUE;
        long mid; // 가장 오래 걸리는 시간
        long sum;

        while (min <= max) {
            mid = (min + max) / 2;
            sum = 0;
            for (int i = 0; i < times.length; i++) {    // 각 심사관이 심사하는 사람의 수
                sum += mid / times[i];

                if (sum >= n) {
                    break;
                }
            }

            if (n > sum) {
                min = mid + 1;
            } else {
                max = mid - 1;
                answer = Math.min(answer, mid);
            }
        }

        return answer;
    }
}