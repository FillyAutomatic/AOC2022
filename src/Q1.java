import java.io.*;
import java.util.*;
import java.math.*;

public class Q1 {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/q.in"))));

        String s = sc.nextLine();
        int ans = 0;
        int curr = 0;
        boolean[][] grid = new boolean[5000][11];
        for (int i = 0; i < 5000; ++i) {
            grid[i][7] = true;
            grid[i][8] = true;
            grid[i][9] = true;
            grid[i][10] = true;
        }
        boolean[][][] rocks = new boolean[5][4][4];
        rocks[0][0][0] = true;
        rocks[0][0][1] = true;
        rocks[0][0][2] = true;
        rocks[0][0][3] = true;
        rocks[1][0][1] = true;
        rocks[1][1][0] = true;
        rocks[1][1][1] = true;
        rocks[1][1][2] = true;
        rocks[1][2][1] = true;
        rocks[2][0][0] = true;
        rocks[2][0][1] = true;
        rocks[2][0][2] = true;
        rocks[2][1][2] = true;
        rocks[2][2][2] = true;
        rocks[3][0][0] = true;
        rocks[3][1][0] = true;
        rocks[3][2][0] = true;
        rocks[3][3][0] = true;
        rocks[4][0][0] = true;
        rocks[4][0][1] = true;
        rocks[4][1][0] = true;
        rocks[4][1][1] = true;
        for (int i = 0; i < 2022; ++i) {
            int x = 2;
            int y = ans + 3;
            while (true) {
                int move = s.charAt(curr) == '<' ? -1 : 1;
                ++curr;
                curr %= s.length();
                if (x + move < 0)
                    move = 0;
                for (int a = 0; a < 4; ++a) {
                    for (int b = 0; b < 4; ++b) {
                        if (rocks[i % 5][a][b] && grid[y + a][x + b + move])
                            move = 0;
                    }
                }
                x += move;
                move = -1;
                if (y + move < 0)
                    move = 0;
                for (int a = 0; a < 4; ++a) {
                    for (int b = 0; b < 4; ++b) {
                        if (rocks[i % 5][a][b] && grid[y + a + move][x + b])
                            move = 0;
                    }
                }
                if (move == 0) {
                    for (int a = 0; a < 4; ++a) {
                        for (int b = 0; b < 4; ++b) {
                            if (rocks[i % 5][a][b]) {
                                grid[y + a][x + b] = true;
                                ans = Math.max(ans, y + a + 1);
                            }
                        }
                    }
                    break;
                }
                y += move;
            }
        }
        System.out.println(ans);
    }
}