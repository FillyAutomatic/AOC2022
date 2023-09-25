import java.io.*;
import java.util.*;
import java.math.*;

public class F2 {
	public static void main(String[] args) throws IOException {

		/*/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		/*/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/f.in"))));
		/**/
		
		int ans = 0;
		String s = sc.next();
		for (int i = 13; i < s.length(); ++i) {
			HashSet<Character> cs = new HashSet<>();
			cs.add(s.charAt(i));
			cs.add(s.charAt(i-1));
			cs.add(s.charAt(i-2));
			cs.add(s.charAt(i-3));
			cs.add(s.charAt(i-4));
			cs.add(s.charAt(i-5));
			cs.add(s.charAt(i-6));
			cs.add(s.charAt(i-7));
			cs.add(s.charAt(i-8));
			cs.add(s.charAt(i-9));
			cs.add(s.charAt(i-10));
			cs.add(s.charAt(i-11));
			cs.add(s.charAt(i-12));
			cs.add(s.charAt(i-13));
			if (cs.size()==14) {
				System.out.println(i+1);
				return;
			}
		}
	}
}