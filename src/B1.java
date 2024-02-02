import java.io.*;
import java.util.*;
import java.math.*;

public class B1 {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/b.in"))));

        int ans = 0;
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            int a = s.split(" ")[0].charAt(0) - 'A';
            int b = s.split(" ")[1].charAt(0) - 'X';
            ans += 3 + b + 1;
            if ((b - a + 3) % 3 == 2)
                ans -= 3;
            if ((b - a + 3) % 3 == 1)
                ans += 3;
        }
        System.out.println(ans);
    }
}