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

        int N = Integer.parseInt(br.readLine());
        ArrayList<Point> points = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            points.add(new Point(x, y));
        }

        bw.write(grahamScan(points) + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    static Point root = new Point(Long.MAX_VALUE, Long.MAX_VALUE);

    static int grahamScan(ArrayList<Point> input) {
        // 기준점 찾기
        for (int i = 0; i < input.size(); i++) {
            if (input.get(i).y < root.y) {
                root = input.get(i);
            } else if (input.get(i).y == root.y) {
                if (input.get(i).x < root.x) {
                    root = input.get(i);
                }
            }
        }

        // 모든 점들을 반시계 방향으로 정렬하기
        input.sort(new Comparator<Point>() {
            @Override
            public int compare(Point p1, Point p2) {    // return 1이면 자리를 바꾼다
                int result = ccw(root, p1, p2);

                if (result > 0) {
                    return -1;
                } else if (result < 0) {
                    return 1;
                } else {
                    long distance1 = dist(root, p1);
                    long distance2 = dist(root, p2);

                    if (distance1 > distance2) {    // 거리가 더 가까운 순으로 정렬
                        return 1;
                    }
                }
                return -1;
            }
        });

        Stack<Point> stack = new Stack<>();
        stack.add(root);

        for (int i = 1; i < input.size(); i++) {
            while (stack.size() > 1 && (ccw(stack.get(stack.size() - 2), stack.get(stack.size() - 1), input.get(i)) <= 0)) {    // first, second, next
                stack.pop();    // second 빼기
            }
            stack.add(input.get(i));    // next 넣기
        }

        return stack.size();
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

    static long dist(Point p1, Point p2) {
        return (p2.x - p1.x) * (p2.x - p1.x) + (p2.y - p1.y) * (p2.y - p1.y);
    }
}