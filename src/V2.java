import java.io.*;
import java.util.*;
import java.math.*;

public class V2 {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/v.in"))));

        int ans = 0;
        ArrayList<String> al = new ArrayList<>();
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            if (!s.isEmpty())
                al.add(s);
            else
                break;
        }
        String dirs = sc.nextLine();
        int y = 0;
        int x = al.get(0).indexOf('.');
        int d = 0;
        int[] dx = { 1, 0, -1, 0 };
        int[] dy = { 0, 1, 0, -1 };
        int i = 0;

        HashMap<Integer, Integer> wxs = new HashMap<>();
        HashMap<Integer, Integer> wys = new HashMap<>();
        HashMap<Integer, Integer> wds = new HashMap<>();
        for (int j = 0; j < 50; ++j) {
            // A
            int oy = 150;
            int ox = 50 + j;
            int od = 1;
            int ny = 150 + j;
            int nx = 49;
            int nd = 2;
            wys.put(oy * 1000 + ox * 4 + od, ny);
            wxs.put(oy * 1000 + ox * 4 + od, nx);
            wds.put(oy * 1000 + ox * 4 + od, nd);

            oy = 150 + j;
            ox = 50;
            od = 0;
            ny = 149;
            nx = 50 + j;
            nd = 3;
            wys.put(oy * 1000 + ox * 4 + od, ny);
            wxs.put(oy * 1000 + ox * 4 + od, nx);
            wds.put(oy * 1000 + ox * 4 + od, nd);

            // B
            oy = 99;
            ox = 0 + j;
            od = 3;
            ny = 50 + j;
            nx = 50;
            nd = 0;
            wys.put(oy * 1000 + ox * 4 + od, ny);
            wxs.put(oy * 1000 + ox * 4 + od, nx);
            wds.put(oy * 1000 + ox * 4 + od, nd);

            oy = 50 + j;
            ox = 49;
            od = 2;
            ny = 100;
            nx = 0 + j;
            nd = 1;
            wys.put(oy * 1000 + ox * 4 + od, ny);
            wxs.put(oy * 1000 + ox * 4 + od, nx);
            wds.put(oy * 1000 + ox * 4 + od, nd);

            // C
            oy = 50;
            ox = 100 + j;
            od = 1;
            ny = 50 + j;
            nx = 99;
            nd = 2;
            wys.put(oy * 1000 + ox * 4 + od, ny);
            wxs.put(oy * 1000 + ox * 4 + od, nx);
            wds.put(oy * 1000 + ox * 4 + od, nd);

            oy = 50 + j;
            ox = 100;
            od = 0;
            ny = 49;
            nx = 100 + j;
            nd = 3;
            wys.put(oy * 1000 + ox * 4 + od, ny);
            wxs.put(oy * 1000 + ox * 4 + od, nx);
            wds.put(oy * 1000 + ox * 4 + od, nd);

            // D
            oy = 0 + j;
            ox = 150;
            od = 0;
            ny = 149 - j;
            nx = 99;
            nd = 2;
            wys.put(oy * 1000 + ox * 4 + od, ny);
            wxs.put(oy * 1000 + ox * 4 + od, nx);
            wds.put(oy * 1000 + ox * 4 + od, nd);

            oy = 149 - j;
            ox = 100;
            od = 0;
            ny = 0 + j;
            nx = 149;
            nd = 2;
            wys.put(oy * 1000 + ox * 4 + od, ny);
            wxs.put(oy * 1000 + ox * 4 + od, nx);
            wds.put(oy * 1000 + ox * 4 + od, nd);

            // E
            oy = -1;
            ox = 100 + j;
            od = 3;
            ny = 199;
            nx = 0 + j;
            nd = 3;
            wys.put(oy * 1000 + ox * 4 + od, ny);
            wxs.put(oy * 1000 + ox * 4 + od, nx);
            wds.put(oy * 1000 + ox * 4 + od, nd);

            oy = 200;
            ox = 0 + j;
            od = 1;
            ny = 0;
            nx = 100 + j;
            nd = 1;
            wys.put(oy * 1000 + ox * 4 + od, ny);
            wxs.put(oy * 1000 + ox * 4 + od, nx);
            wds.put(oy * 1000 + ox * 4 + od, nd);

            // F
            oy = 0 + j;
            ox = 49;
            od = 2;
            ny = 149 - j;
            nx = 0;
            nd = 0;
            wys.put(oy * 1000 + ox * 4 + od, ny);
            wxs.put(oy * 1000 + ox * 4 + od, nx);
            wds.put(oy * 1000 + ox * 4 + od, nd);

            oy = 149 - j;
            ox = -1;
            od = 2;
            ny = 0 + j;
            nx = 50;
            nd = 0;
            wys.put(oy * 1000 + ox * 4 + od, ny);
            wxs.put(oy * 1000 + ox * 4 + od, nx);
            wds.put(oy * 1000 + ox * 4 + od, nd);

            // G
            oy = -1;
            ox = 50 + j;
            od = 3;
            ny = 150 + j;
            nx = 0;
            nd = 0;
            wys.put(oy * 1000 + ox * 4 + od, ny);
            wxs.put(oy * 1000 + ox * 4 + od, nx);
            wds.put(oy * 1000 + ox * 4 + od, nd);

            oy = 150 + j;
            ox = -1;
            od = 2;
            ny = 0;
            nx = 50 + j;
            nd = 1;
            wys.put(oy * 1000 + ox * 4 + od, ny);
            wxs.put(oy * 1000 + ox * 4 + od, nx);
            wds.put(oy * 1000 + ox * 4 + od, nd);
        }
        while (i < dirs.length()) {
            String ns = "";
            while (i < dirs.length() && dirs.charAt(i) >= '0' && dirs.charAt(i) <= '9') {
                ns += dirs.charAt(i);
                ++i;
            }
            int num = Integer.parseInt(ns);

            for (int j = 0; j < num; ++j) {
                int ny = y + dy[d];
                int nx = x + dx[d];
                int nd = d;
                int pass = 1000 * ny + 4 * nx + d;
                if (wys.containsKey(pass)) {
                    ny = wys.get(pass);
                    nx = wxs.get(pass);
                    nd = wds.get(pass);
                }

                if (al.get(ny).charAt(nx) == '#')
                    break;

                y = ny;
                x = nx;
                d = nd;
            }

            if (i == dirs.length())
                break;

            char dir = dirs.charAt(i);
            ++i;
            if (dir == 'R')
                ++d;
            else
                --d;
            d += 4;
            d %= 4;
        }
        ans = (y + 1) * 1000 + (x + 1) * 4 + d;
        System.out.println(ans);
    }
}