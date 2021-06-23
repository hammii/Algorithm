import java.io.*;
import java.util.*;

class Point {
    long x;
    long y;

    Point(long x, long y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        ArrayList<Point> points = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            String belong = st.nextToken();

            if (belong.equals("Y")) {   // Y인 것만 볼록 껍질
                points.add(new Point(x, y));
            }
        }

        Stack<Point> result = grahamScan(points);
        bw.write(result.size() + "\n");

        for (int i = 0; i < result.size(); i++) {
            bw.write(result.get(i).x + " " + result.get(i).y + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    static Stack<Point> grahamScan(ArrayList<Point> input) throws IOException {

        // 모든 점들을 x 오름차순으로 정렬하기
        input.sort(new Comparator<Point>() {
            @Override
            public int compare(Point p1, Point p2) {    // return 1이면 자리를 바꾼다
                if (p1.x > p2.x) {
                    return 1;
                } else if (p1.x == p2.x) {
                    if (p1.y > p2.y) {
                        return 1;
                    }
                }
                return -1;
            }
        });

        Stack<Point> lower = new Stack<>();     // 아래 껍질
        Stack<Point> upper = new Stack<>();     // 위 껍질

        // 아래 껍질 계산
        for (int i = 0; i < input.size(); i++) {
            while (lower.size() > 1 && (ccw(lower.get(lower.size() - 2), lower.get(lower.size() - 1), input.get(i)) < 0)) {    // first, second, next
                lower.pop();
            }
            lower.add(input.get(i));
        }

        // 위 껍질 계산
        for (int i = input.size() - 1; i >= 0; i--) {
            while (upper.size() > 1 && (ccw(upper.get(upper.size() - 2), upper.get(upper.size() - 1), input.get(i)) < 0)) {    // first, second, next
                upper.pop();
            }
            upper.add(input.get(i));
        }

        lower.pop();    // 중복 제거
        upper.pop();

        lower.addAll(upper);

        return lower;
    }

    static int ccw(Point p1, Point p2, Point p3) {
        long result = (p1.x * p2.y + p2.x * p3.y + p3.x * p1.y) - (p2.x * p1.y + p3.x * p2.y + p1.x * p3.y);

        if (result > 0) {   // 반시계 방향
            return 1;
        } else if (result < 0) {    // 시계 방향
            return -1;
        } else {
            return 0;
        }
    }
}