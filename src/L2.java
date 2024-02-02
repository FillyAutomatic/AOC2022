import java.io.*;
import java.util.*;
import java.math.*;

public class L2 {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/l.in"))));

        int ans = 0;
        ArrayList<String> grid = new ArrayList<>();
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            grid.add(s);
        }
        int n = grid.size();
        int m = grid.get(0).length();
        int[][] dist = new int[n][m];
        int ey = 0;
        int ex = 0;
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                dist[i][j] = 10000;
                if (grid.get(i).charAt(j) == 'E') {
                    ey = i;
                    ex = j;
                    grid.set(i, grid.get(i).replace('E', 'z'));
                }
                if (grid.get(i).charAt(j) == 'S') {
                    grid.set(i, grid.get(i).replace('S', 'a'));
                }
                if (grid.get(i).charAt(j) == 'a') {
                    dist[i][j] = 0;
                    q.add(i * m + j);
                }
            }
        }
        while (!q.isEmpty()) {
            int u = q.removeFirst();
            int uy = u / m;
            int ux = u % m;
            int[] dy = { -1, 0, 1, 0 };
            int[] dx = { 0, -1, 0, 1 };
            for (int z = 0; z < 4; ++z) {
                int vy = uy + dy[z];
                int vx = ux + dx[z];
                if (vy < 0 || vx < 0 || vy >= n || vx >= m || dist[vy][vx] <= dist[uy][ux] + 1
                        || grid.get(vy).charAt(vx) - grid.get(uy).charAt(ux) > 1)
                    continue;
                dist[vy][vx] = dist[uy][ux] + 1;
                q.add(vy * m + vx);
            }
        }
        System.out.println(dist[ey][ex]);
    }
}