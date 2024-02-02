import java.io.*;
import java.util.*;
import java.math.*;

public class H2 {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/h.in"))));

        long ans = 0;
        ArrayList<String> grid = new ArrayList<>();
        while (sc.hasNextLine()) {
            grid.add(sc.nextLine());
        }
        int n = grid.size();
        int m = grid.get(0).length();
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                long w = 0;
                long x = 0;
                long y = 0;
                long z = 0;
                for (int a = i - 1; a >= 0; --a) {
                    ++w;
                    if (grid.get(a).charAt(j) >= grid.get(i).charAt(j))
                        break;
                }
                for (int a = i + 1; a < n; ++a) {
                    ++x;
                    if (grid.get(a).charAt(j) >= grid.get(i).charAt(j))
                        break;
                }
                for (int a = j - 1; a >= 0; --a) {
                    ++y;
                    if (grid.get(i).charAt(a) >= grid.get(i).charAt(j))
                        break;
                }
                for (int a = j + 1; a < m; ++a) {
                    ++z;
                    if (grid.get(i).charAt(a) >= grid.get(i).charAt(j))
                        break;
                }
                ans = Math.max(ans, w * x * y * z);
            }
        }
        System.out.println(ans);
    }
}