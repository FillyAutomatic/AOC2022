import java.io.*;
import java.util.*;
import java.math.*;

public class X2 {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/x.in"))));

        int ans = 1234567;
        ArrayList<String> grid = new ArrayList<>();
        while (sc.hasNextLine()) {
            grid.add(sc.nextLine());
        }
        int n = grid.size();
        int m = grid.get(0).length();
        boolean[][] up = new boolean[n][m];
        boolean[][] down = new boolean[n][m];
        boolean[][] left = new boolean[n][m];
        boolean[][] right = new boolean[n][m];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (grid.get(i).charAt(j) == '^')
                    up[i][j] = true;
                if (grid.get(i).charAt(j) == 'v')
                    down[i][j] = true;
                if (grid.get(i).charAt(j) == '<')
                    left[i][j] = true;
                if (grid.get(i).charAt(j) == '>')
                    right[i][j] = true;
            }
        }
        boolean[][][] avail = new boolean[10000][n][m];
        for (int i = 0; i < 10000; ++i) {
            for (int j = 0; j < n; ++j) {
                for (int k = 0; k < m; ++k) {
                    if (grid.get(j).charAt(k) != '#' && !up[j][k] && !down[j][k] && !left[j][k] && !right[j][k])
                        avail[i][j][k] = true;
                }
            }
            boolean[][] nup = new boolean[n][m];
            boolean[][] ndown = new boolean[n][m];
            boolean[][] nleft = new boolean[n][m];
            boolean[][] nright = new boolean[n][m];
            for (int j = 1; j < n - 1; ++j) {
                for (int k = 1; k < m - 1; ++k) {
                    int uj = ((j - 1) + n - 3) % (n - 2) + 1;
                    int dj = ((j + 1) + n - 3) % (n - 2) + 1;
                    int lk = ((k - 1) + m - 3) % (m - 2) + 1;
                    int rk = ((k + 1) + m - 3) % (m - 2) + 1;
                    nup[uj][k] = up[j][k];
                    ndown[dj][k] = down[j][k];
                    nleft[j][lk] = left[j][k];
                    nright[j][rk] = right[j][k];
                }
            }
            up = nup;
            down = ndown;
            left = nleft;
            right = nright;
        }
        boolean[][][] dp = new boolean[10000][n][m];
        dp[0][0][1] = true;
        for (int i = 1; i < 10000; ++i) {
            for (int j = 0; j < n; ++j) {
                for (int k = 0; k < m; ++k) {
                    if (!avail[i][j][k])
                        continue;
                    dp[i][j][k] |= dp[i - 1][j][k];
                    if (j > 0)
                        dp[i][j][k] |= dp[i - 1][j - 1][k];
                    if (j < n - 1)
                        dp[i][j][k] |= dp[i - 1][j + 1][k];
                    if (k > 0)
                        dp[i][j][k] |= dp[i - 1][j][k - 1];
                    if (k < m - 1)
                        dp[i][j][k] |= dp[i - 1][j][k + 1];
                    if (dp[i][j][k] && j == n - 1) {
                        ans = i;
                        break;
                    }
                }
                if (ans == i)
                    break;
            }
            if (ans == i)
                break;
        }
        for (int i = 0; i < n - 1; ++i) {
            for (int j = 0; j < m; ++j) {
                dp[ans][i][j] = false;
            }
        }
        for (int i = ans + 1; i < 10000; ++i) {
            for (int j = 0; j < n; ++j) {
                for (int k = 0; k < m; ++k) {
                    if (!avail[i][j][k])
                        continue;
                    dp[i][j][k] |= dp[i - 1][j][k];
                    if (j > 0)
                        dp[i][j][k] |= dp[i - 1][j - 1][k];
                    if (j < n - 1)
                        dp[i][j][k] |= dp[i - 1][j + 1][k];
                    if (k > 0)
                        dp[i][j][k] |= dp[i - 1][j][k - 1];
                    if (k < m - 1)
                        dp[i][j][k] |= dp[i - 1][j][k + 1];
                    if (dp[i][j][k] && j == 0) {
                        ans = i;
                        break;
                    }
                }
                if (ans == i)
                    break;
            }
            if (ans == i)
                break;
        }
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                dp[ans][i][j] = false;
            }
        }
        for (int i = ans + 1; i < 10000; ++i) {
            for (int j = 0; j < n; ++j) {
                for (int k = 0; k < m; ++k) {
                    if (!avail[i][j][k])
                        continue;
                    dp[i][j][k] |= dp[i - 1][j][k];
                    if (j > 0)
                        dp[i][j][k] |= dp[i - 1][j - 1][k];
                    if (j < n - 1)
                        dp[i][j][k] |= dp[i - 1][j + 1][k];
                    if (k > 0)
                        dp[i][j][k] |= dp[i - 1][j][k - 1];
                    if (k < m - 1)
                        dp[i][j][k] |= dp[i - 1][j][k + 1];
                    if (dp[i][j][k] && j == n - 1) {
                        ans = i;
                        break;
                    }
                }
                if (ans == i)
                    break;
            }
            if (ans == i)
                break;
        }
        System.out.println(ans);
    }
}