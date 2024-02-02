import java.io.*;
import java.util.*;
import java.math.*;

public class V1 {
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

                if (d == 0 && (nx >= al.get(ny).length() || al.get(ny).charAt(nx) == ' ')) {
                    nx = 0;
                    while (al.get(ny).charAt(nx) == ' ')
                        ++nx;
                }
                if (d == 1 && (ny >= al.size() || nx >= al.get(ny).length() || al.get(ny).charAt(nx) == ' ')) {
                    ny = 0;
                    while (nx >= al.get(ny).length() || al.get(ny).charAt(nx) == ' ')
                        ++ny;
                }
                if (d == 2 && (nx < 0 || al.get(ny).charAt(nx) == ' ')) {
                    nx = al.get(ny).length() - 1;
                    while (al.get(ny).charAt(nx) == ' ')
                        --nx;
                }
                if (d == 3 && (ny < 0 || nx >= al.get(ny).length() || al.get(ny).charAt(nx) == ' ')) {
                    ny = al.size() - 1;
                    while (nx >= al.get(ny).length() || al.get(ny).charAt(nx) == ' ')
                        --ny;
                }

                if (al.get(ny).charAt(nx) == '#')
                    break;

                y = ny;
                x = nx;
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