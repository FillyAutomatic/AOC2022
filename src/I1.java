import java.io.*;
import java.util.*;
import java.math.*;

public class I1 {
	public static void main(String[] args) throws IOException {

		/*/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		/*/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/i.in"))));
		/**/
		
		int ans = 0;
		int hy = 0;
		int hx = 0;
		int ty = 0;
		int tx = 0;
		HashMap<Integer, HashSet<Integer>> hm = new HashMap<>();
		hm.put(0, new HashSet<>());
		hm.get(0).add(0);
		while (sc.hasNextLine()) {
			String s = sc.nextLine();
			char c = s.charAt(0);
			int n = Integer.parseInt(s.substring(2));
			int dy = 0;
			int dx = 0;
			if (c=='U')
				--dy;
			if (c=='D')
				++dy;
			if (c=='L')
				--dx;
			if (c=='R')
				++dx;
			for (int i = 0; i < n; ++i) {
				hy += dy;
				hx += dx;
				if (ty-hy==2) {
					--ty;
					tx = hx;
				}
				if (hy-ty==2) {
					++ty;
					tx = hx;
				}
				if (tx-hx==2) {
					--tx;
					ty = hy;
				}
				if (hx-tx==2) {
					++tx;
					ty = hy;
				}
				if (!hm.containsKey(ty))
					hm.put(ty, new HashSet<>());
				hm.get(ty).add(tx);
			}
		}
		for (int k : hm.keySet()) {
			ans += hm.get(k).size();
		}
		System.out.println(ans);
	}
}