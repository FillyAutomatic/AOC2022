import java.io.*;
import java.util.*;
import java.math.*;

public class R2 {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/r.in"))));

        int ans = 0;
        boolean[][][] cubes = new boolean[100][100][100];
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            int a = Integer.parseInt(s.split(",")[0]) + 2;
            int b = Integer.parseInt(s.split(",")[1]) + 2;
            int c = Integer.parseInt(s.split(",")[2]) + 2;
            cubes[a][b][c] = true;
        }
        boolean[][][] access = new boolean[100][100][100];
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(0);
        while (!q.isEmpty()) {
            int u = q.removeFirst();
            int ua = u / 10000;
            int ub = (u / 100) % 100;
            int uc = u % 100;
            for (int i = -1; i <= 1; ++i) {
                for (int j = -1; j <= 1; ++j) {
                    for (int k = -1; k <= 1; ++k) {
                        if (Math.abs(i) + Math.abs(j) + Math.abs(k) != 1)
                            continue;
                        int va = ua + i;
                        int vb = ub + j;
                        int vc = uc + k;
                        if (va < 0 || vb < 0 || vc < 0 || va >= 100 || vb >= 100 || vc >= 100 || cubes[va][vb][vc]
                                || access[va][vb][vc])
                            continue;
                        access[va][vb][vc] = true;
                        q.add(va * 10000 + vb * 100 + vc);
                    }
                }
            }
        }
        for (int i = 1; i < 99; ++i) {
            for (int j = 1; j < 99; ++j) {
                for (int k = 1; k < 99; ++k) {
                    if (access[i][j][k]) {
                        if (cubes[i - 1][j][k])
                            ans++;
                        if (cubes[i + 1][j][k])
                            ans++;
                        if (cubes[i][j - 1][k])
                            ans++;
                        if (cubes[i][j + 1][k])
                            ans++;
                        if (cubes[i][j][k - 1])
                            ans++;
                        if (cubes[i][j][k + 1])
                            ans++;
                    }
                }
            }
        }
        System.out.println(ans);
    }
}