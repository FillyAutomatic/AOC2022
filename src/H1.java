import java.io.*;
import java.util.*;
import java.math.*;

public class H1 {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/h.in"))));

        int ans = 0;
        ArrayList<String> grid = new ArrayList<>();
        while (sc.hasNextLine()) {
            grid.add(sc.nextLine());
        }
        int n = grid.size();
        int m = grid.get(0).length();
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                int va = 0;
                int vb = 1;
                for (int a = 0; a < i; ++a) {
                    if (grid.get(a).charAt(j) >= grid.get(i).charAt(j))
                        vb = 0;
                }
                va = Math.max(va, vb);
                vb = 1;
                for (int a = i + 1; a < n; ++a) {
                    if (grid.get(a).charAt(j) >= grid.get(i).charAt(j))
                        vb = 0;
                }
                va = Math.max(va, vb);
                vb = 1;
                for (int a = 0; a < j; ++a) {
                    if (grid.get(i).charAt(a) >= grid.get(i).charAt(j))
                        vb = 0;
                }
                va = Math.max(va, vb);
                vb = 1;
                for (int a = j + 1; a < m; ++a) {
                    if (grid.get(i).charAt(a) >= grid.get(i).charAt(j))
                        vb = 0;
                }
                va = Math.max(va, vb);
                ans += va;
            }
        }
        System.out.println(ans);
    }
}