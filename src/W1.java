import java.io.*;
import java.util.*;
import java.math.*;

public class W1 {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/w.in"))));

        int ans = 0;
        ArrayList<String> grid = new ArrayList<>();
        int elves = 0;
        while (sc.hasNextLine()) {
            grid.add(sc.nextLine());
            for (int i = 0; i < grid.get(grid.size() - 1).length(); ++i) {
                if (grid.get(grid.size() - 1).charAt(i) == '#')
                    ++elves;
            }
        }
        int[] ys = new int[elves];
        int[] xs = new int[elves];
        int elf = 0;
        for (int i = 0; i < grid.size(); ++i) {
            for (int j = 0; j < grid.get(i).length(); ++j) {
                if (grid.get(i).charAt(j) == '#') {
                    ys[elf] = i;
                    xs[elf] = j;
                    ++elf;
                }
            }
        }
        for (int round = 0; round < 10; ++round) {
            int[] py = new int[elves];
            int[] px = new int[elves];
            HashMap<Integer, HashMap<Integer, Integer>> props = new HashMap<>();
            for (int i = 0; i < elves; ++i) {
                int dy = 0;
                int dx = 0;
                for (int zp = 0; zp < 4; ++zp) {
                    int z = (round % 4 + zp) % 4;
                    switch (z) {
                    case 0:
                        dy = -1;
                        for (int j = 0; j < elves; ++j) {
                            if (ys[j] == ys[i] - 1 && Math.abs(xs[j] - xs[i]) <= 1)
                                dy = 0;
                        }
                        break;
                    case 1:
                        dy = 1;
                        for (int j = 0; j < elves; ++j) {
                            if (ys[j] == ys[i] + 1 && Math.abs(xs[j] - xs[i]) <= 1)
                                dy = 0;
                        }
                        break;
                    case 2:
                        dx = -1;
                        for (int j = 0; j < elves; ++j) {
                            if (Math.abs(ys[j] - ys[i]) <= 1 && xs[j] == xs[i] - 1)
                                dx = 0;
                        }
                        break;
                    case 3:
                        dx = 1;
                        for (int j = 0; j < elves; ++j) {
                            if (Math.abs(ys[j] - ys[i]) <= 1 && xs[j] == xs[i] + 1)
                                dx = 0;
                        }
                        break;
                    default:
                        break;
                    }
                    if (dy != 0 || dx != 0)
                        break;
                }
                int ct = 0;
                for (int j = 0; j < elves; ++j) {
                    if (i != j && Math.abs(ys[j] - ys[i]) <= 1 && Math.abs(xs[j] - xs[i]) <= 1)
                        ++ct;
                }
                if (ct == 0) {
                    dy = 0;
                    dx = 0;
                }
                int y = ys[i] + dy;
                int x = xs[i] + dx;
                py[i] = y;
                px[i] = x;
                if (!props.containsKey(y))
                    props.put(y, new HashMap<>());
                props.get(y).put(x, props.get(y).getOrDefault(x, 0) + 1);
            }
            for (int i = 0; i < elves; ++i) {
                if (props.get(py[i]).get(px[i]) > 1)
                    continue;
                ys[i] = py[i];
                xs[i] = px[i];
            }
        }
        int miny = 10000;
        int maxy = -10000;
        int minx = 10000;
        int maxx = -10000;
        for (int i = 0; i < elves; ++i) {
            miny = Math.min(miny, ys[i]);
            maxy = Math.max(maxy, ys[i]);
            minx = Math.min(minx, xs[i]);
            maxx = Math.max(maxx, xs[i]);
        }
        ans = (maxy - miny + 1) * (maxx - minx + 1) - elves;

        System.out.println(ans);
    }
}