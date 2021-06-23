class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();

        int left = 0;
        int comp;
        for (int i = 0; i < number.length() - k; i++) {
            comp = 0;
            for (int j = left; j <= i + k; j++) {
                if (comp < number.charAt(j) - '0') {
                    comp = number.charAt(j) - '0';
                    left = j + 1;
                }
            }
            answer.append(comp);
        }
        return answer.toString();
    }
}