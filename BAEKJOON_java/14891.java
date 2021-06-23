import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static int[][] gear = new int[5][9];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int sum = 0;

        for (int i = 1; i <= 4; i++) {
            String str = br.readLine();
            String[] array_str = str.split("");
            for (int j = 1; j <= 8; j++) {
                gear[i][j] = Integer.parseInt(array_str[j - 1]);
            }
        }

        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int cw = Integer.parseInt(st.nextToken());

            rotate(num, cw);
        }

        if (gear[1][1] == 1) sum += 1;
        if (gear[2][1] == 1) sum += 2;
        if (gear[3][1] == 1) sum += 4;
        if (gear[4][1] == 1) sum += 8;
        bw.write(sum + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    public static boolean isCW(int cw) {
        return cw == 1;
    }

    public static void rotate(int num, int cw) {
        boolean direction = isCW(cw);
        switch (num) {
            case 1:
                if (gear[1][3] != gear[2][7]) {
                    if (gear[2][3] != gear[3][7]) {
                        if (gear[3][3] != gear[4][7]) {
                            rotation(1, direction);
                            rotation(2, !direction);
                            rotation(3, direction);
                            rotation(4, !direction);
                        } else {
                            rotation(1, direction);
                            rotation(2, !direction);
                            rotation(3, direction);
                        }
                    } else {
                        rotation(1, direction);
                        rotation(2, !direction);
                    }
                } else {
                    rotation(1, direction);
                }
                break;
            case 2:
                if (gear[1][3] != gear[2][7]) rotation(1, !direction);
                if (gear[2][3] != gear[3][7]) {
                    if (gear[3][3] != gear[4][7]) {
                        rotation(2, direction);
                        rotation(3, !direction);
                        rotation(4, direction);
                    } else {
                        rotation(2, direction);
                        rotation(3, !direction);
                    }
                } else {
                    rotation(2, direction);
                }
                break;
            case 3:
                if (gear[3][3] != gear[4][7]) rotation(4, !direction);
                if (gear[2][3] != gear[3][7]) {
                    if (gear[1][3] != gear[2][7]) {
                        rotation(3, direction);
                        rotation(1, direction);
                        rotation(2, !direction);
                    } else {
                        rotation(3, direction);
                        rotation(2, !direction);
                    }
                } else {
                    rotation(3, direction);
                }
                break;
            case 4:
                if (gear[3][3] != gear[4][7]) {
                    if (gear[2][3] != gear[3][7]) {
                        if (gear[1][3] != gear[2][7]) {
                            rotation(4, direction);
                            rotation(3, !direction);
                            rotation(2, direction);
                            rotation(1, !direction);
                        } else {
                            rotation(4, direction);
                            rotation(3, !direction);
                            rotation(2, direction);
                        }
                    } else {
                        rotation(4, direction);
                        rotation(3, !direction);
                    }
                } else {
                    rotation(4, direction);
                }
                break;
        }
    }

    public static void rotation(int num, boolean cw) {
        if (cw) {
            int temp = gear[num][8];
            System.arraycopy(gear[num], 1, gear[num], 2, 7);
            gear[num][1] = temp;
        } else {
            int temp = gear[num][1];
            System.arraycopy(gear[num], 2, gear[num], 1, 7);
            gear[num][8] = temp;
        }
    }
}