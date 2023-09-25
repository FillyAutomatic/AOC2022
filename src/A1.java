import java.io.*;
import java.util.*;
import java.math.*;

public class A1 {
	public static void main(String[] args) throws IOException {

		/*/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		/*/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/a.in"))));
		/**/
		
		int ans = 0;
		int curr = 0;
		while (sc.hasNextLine()) {
			String s = sc.nextLine();
			if (s.isEmpty()) {
				curr = 0;
			} else {
				curr += Integer.parseInt(s);
				ans = Math.max(ans, curr);
			}
		}
		System.out.println(ans);
	}
}