import java.io.*;
import java.util.*;
import java.math.*;

public class N1 {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/n.in"))));

        int ans = 0;
        boolean[][] rock = new boolean[1000][1000];
        while (sc.hasNextLine()) {
            String[] s = sc.nextLine().replace("-", "").replace(">", "").replace("  ", " ").split(" ");
            int ux = Integer.parseInt(s[0].split(",")[0]);
            int uy = Integer.parseInt(s[0].split(",")[1]);
            for (int i = 1; i < s.length; ++i) {
                int vx = Integer.parseInt(s[i].split(",")[0]);
                int vy = Integer.parseInt(s[i].split(",")[1]);
                for (int y = Math.min(uy, vy); y <= Math.max(uy, vy); ++y) {
                    for (int x = Math.min(ux, vx); x <= Math.max(ux, vx); ++x) {
                        rock[y][x] = true;
                    }
                }
                ux = vx;
                uy = vy;
            }
        }
        while (true) {
            int y = 0;
            int x = 500;
            while (y < 500) {
                if (!rock[y + 1][x])
                    ++y;
                else if (!rock[y + 1][x - 1]) {
                    ++y;
                    --x;
                } else if (!rock[y + 1][x + 1]) {
                    ++y;
                    ++x;
                } else {
                    break;
                }
            }
            if (y == 500)
                break;
            ++ans;
            rock[y][x] = true;
        }
        System.out.println(ans);
    }
}