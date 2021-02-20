import java.util.*;

class Solution {
    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        List<Integer> arr_list = new ArrayList<>();

        for (int a : array) {
            arr_list.add(a);
        }

        for (int i = 0; i < commands.length; i++) {
            List<Integer> new_list = new ArrayList<>(arr_list);
            new_list = new_list.subList(commands[i][0] - 1, commands[i][1]);

            Collections.sort(new_list);
            answer[i] = new_list.get(commands[i][2] - 1);
        }

        return answer;
    }
}