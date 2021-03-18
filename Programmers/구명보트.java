import java.util.Arrays;

public class Main {
	public int solution(int[] people, int limit) {
        int answer = 0;
        int min_idx = 0;
        int max_idx = people.length - 1;

        Arrays.sort(people);
        while (min_idx <= max_idx) {
            if (people[min_idx] + people[max_idx] <= limit) {
                min_idx++;
            }
            max_idx--;
            answer++;
        }

        return answer;
    }
}