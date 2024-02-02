import java.io.*;
import java.util.*;
import java.math.*;

public class E2 {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/e.in"))));

        String ans = "";
        ArrayList<ArrayDeque<Character>> al = new ArrayList<>();
        for (int i = 0; i < 10; ++i)
            al.add(new ArrayDeque<>());
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            if (s.charAt(1) == '1') {
                sc.nextLine();
                break;
            }
            for (int i = 1; i < 10; ++i) {
                int j = i * 4 - 3;
                if (s.length() < j)
                    break;
                if (s.charAt(j) != ' ')
                    al.get(i).addFirst(s.charAt(j));
            }
        }
        int nc = 9;

        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            String[] ws = s.split(" ");
            String tm = "";
            for (int i = 0; i < Integer.parseInt(ws[1]); ++i) {
                int u = Integer.parseInt(ws[3]);
                int v = Integer.parseInt(ws[5]);
                tm += al.get(u).removeLast();
            }
            for (int i = 0; i < Integer.parseInt(ws[1]); ++i) {
                int u = Integer.parseInt(ws[3]);
                int v = Integer.parseInt(ws[5]);
                al.get(v).add(tm.charAt(tm.length() - i - 1));
            }
        }
        for (int i = 1; i <= nc; ++i)
            ans += al.get(i).removeLast();
        System.out.println(ans);
    }
}