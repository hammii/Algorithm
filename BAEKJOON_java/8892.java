import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int test = 0; test < T; test++) {
            int k = Integer.parseInt(br.readLine());
            String[] words = new String[k];
            boolean possible = false;

            for (int i = 0; i < k; i++) {
                words[i] = br.readLine();
            }

            loop:
            for (int i = 0; i < k; i++) {
                for (int j = 0; j < k; j++) {
                    if (i == j) {
                        continue;
                    }
                    String new_word = words[i].concat(words[j]);

                    if (isPalindrome(new_word)) {
                        bw.write(new_word + "\n");
                        possible = true;
                        break loop;
                    }
                }
            }

            if (!possible) {
                bw.write(0 + "\n");
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }

    static boolean isPalindrome(String word) {
        int n = word.length();
        for (int i = 0; i < (n / 2); i++) {
            if (word.charAt(i) != word.charAt(n - i - 1)) {
                return false;
            }
        }
        return true;
    }
}