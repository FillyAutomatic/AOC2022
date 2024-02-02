import java.io.*;
import java.util.*;
import java.math.*;

public class I2 {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/i.in"))));

        int ans = 0;
        int[] ys = new int[10];
        int[] xs = new int[10];
        HashMap<Integer, HashSet<Integer>> hm = new HashMap<>();
        hm.put(0, new HashSet<>());
        hm.get(0).add(0);
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            char c = s.charAt(0);
            int n = Integer.parseInt(s.substring(2));
            int dy = 0;
            int dx = 0;
            if (c == 'U')
                --dy;
            if (c == 'D')
                ++dy;
            if (c == 'L')
                --dx;
            if (c == 'R')
                ++dx;
            for (int i = 0; i < n; ++i) {
                ys[0] += dy;
                xs[0] += dx;
                for (int j = 1; j < 10; ++j) {
                    if (Math.abs(ys[j] - ys[j - 1]) == 2 && Math.abs(xs[j] - xs[j - 1]) == 2) {
                        ys[j] += -(ys[j] - ys[j - 1]) / 2;
                        xs[j] += -(xs[j] - xs[j - 1]) / 2;
                    }
                    if (ys[j] - ys[j - 1] == 2) {
                        --ys[j];
                        xs[j] = xs[j - 1];
                    }
                    if (ys[j - 1] - ys[j] == 2) {
                        ++ys[j];
                        xs[j] = xs[j - 1];
                    }
                    if (xs[j] - xs[j - 1] == 2) {
                        --xs[j];
                        ys[j] = ys[j - 1];
                    }
                    if (xs[j - 1] - xs[j] == 2) {
                        ++xs[j];
                        ys[j] = ys[j - 1];
                    }
                }
                if (!hm.containsKey(ys[9]))
                    hm.put(ys[9], new HashSet<>());
                hm.get(ys[9]).add(xs[9]);
            }
        }
        for (int k : hm.keySet()) {
            ans += hm.get(k).size();
        }
        System.out.println(ans);
    }
}