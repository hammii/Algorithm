import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println(solution(new int[]{6, 5, 4, 1, 0}));
    }

    public static int solution(int[] citations) {
        int answer = 0;

        Arrays.sort(citations);
        int max = citations[citations.length - 1];
        int idx = citations.length - 1;

        for (int h = max; h >= 0; h--) {
            if (h >= citations[idx] && citations.length - idx <= h) {
                answer = h;
                break;
            }
            if (Arrays.asList(citations).contains(h)) idx--;
        }

        return answer;
    }
}