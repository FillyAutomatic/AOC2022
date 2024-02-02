import java.io.*;
import java.util.*;
import java.math.*;

public class C1 {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/c.in"))));

        int ans = 0;
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            boolean[] a = new boolean[256];
            boolean[] b = new boolean[256];
            for (int i = 0; i < s.length() / 2; ++i) {
                a[s.charAt(i)] = true;
                b[s.charAt(s.length() / 2 + i)] = true;
            }
            for (char c = 'a'; c <= 'z'; ++c) {
                if (a[c] && b[c]) {
                    ans += c - 'a';
                    ans++;
                }
            }
            for (char c = 'A'; c <= 'Z'; ++c) {
                if (a[c] && b[c]) {
                    ans += c - 'A';
                    ans += 27;
                }
            }
        }
        System.out.println(ans);
    }
}