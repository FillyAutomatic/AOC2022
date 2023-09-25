import java.io.*;
import java.util.*;
import java.math.*;

public class C2 {
	public static void main(String[] args) throws IOException {

		/*/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		/*/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/c.in"))));
		/**/
		
		int ans = 0;
		while (sc.hasNextLine()) {
			String s1 = sc.nextLine();
			String s2 = sc.nextLine();
			String s3 = sc.nextLine();
			boolean[] a = new boolean[256];
			boolean[] b = new boolean[256];
			boolean[] bb = new boolean[256];
			for (char c : s1.toCharArray())
				a[c] = true;
			for (char c : s2.toCharArray())
				b[c] = true;
			for (char c : s3.toCharArray())
				bb[c] = true;
			for (char c = 'a'; c <= 'z'; ++c) {
				if (a[c]&&b[c]&&bb[c]) {
					ans += c-'a';
					ans++;
				}
			}
			for (char c = 'A'; c <= 'Z'; ++c) {
				if (a[c]&&b[c]&&bb[c]) {
					ans += c-'A';
					ans+=27;
				}
			}
		}
		System.out.println(ans);
	}
}