import java.io.*;
import java.util.*;

class Point {
    long x, y;

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
        ArrayList<Point> lines = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());


            lines.add(new Point(x, y));
        }

        // 오름차순으로 정렬
        lines.sort(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if (o1.x > o2.x) {
                    return 1;
                } else if (o1.x == o2.x) {
                    if (o1.y > o2.y) {
                        return 1;
                    }
                }
                return -1;
            }
        });

        long s = lines.get(0).x;
        long e = lines.get(0).y;
        long sum = e - s;

        for (int i = 1; i < lines.size(); i++) {
            long ns = lines.get(i).x;
            long ne = lines.get(i).y;

            if ((s <= ns) && (ne <= e)) {   // 이전 선분에 전부 포함되는 경우
                continue;
            } else if (ns < e) {    // 이전 선분에 start 점이 있는 경우
                sum += -(e - ns) + (ne - ns);
            } else {    // 겹치지 않는 경우
                sum += ne - ns;
            }
            s = ns;
            e = ne;
        }

        bw.write(sum + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}