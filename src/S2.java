import java.io.*;
import java.util.*;
import java.math.*;

public class S2 {
	public static void main(String[] args) throws IOException {

		/*/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		/*/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/s.in"))));
		/**/
		
		int ans = 1;
		int id = 0;
		while (sc.hasNextLine()) {
			String s = sc.nextLine();
			++id;
			int orec = Integer.parseInt(s.split(" ")[6]);
			int clayc = Integer.parseInt(s.split(" ")[12]);
			int oboc = Integer.parseInt(s.split(" ")[18]);
			int obcc = Integer.parseInt(s.split(" ")[21]);
			int georc = Integer.parseInt(s.split(" ")[27]);
			int geobc = Integer.parseInt(s.split(" ")[30]);
			
			HashMap<Long, Integer> hm = new HashMap<>();
			hm.put(1L, 0);
			int max = 0;
			System.out.println(id);
			if (id>3)
				continue;
			for (int i = 0; i < 32; ++i) {
				System.out.println(id+" " + i + " " + hm.size());
				HashMap<Long, Integer> hmn = new HashMap<>();
				for (long x : hm.keySet()) {
					int orebots = (int)(x<<55>>>55);
					int claybots = (int)(x<<46>>>55);
					int obbybots = (int)(x<<37>>>55);
					int geodebots = (int)(x<<28>>>55);
					int ore = (int)(x<<19>>>55);
					int clay = (int)(x<<10>>>55);
					int obby = (int)(x<<1>>>55);
					int geodes = hm.get(x);
					for (int a = 0; a <= 1; ++a) {
						if (a==1&&orebots>=3)
							continue;
						for (int b = 0; b <= 1; ++b) {
							if (a+b>1)
								continue;
							for (int c = 0; c <= 1; ++c) {
								if (a+b+c>1)
									continue;
								for (int d = 0; d <= 1; ++d) {
									if (a+b+c+d>1)
										continue;
									if (a+b+c+d==0&&orebots>=clayc&&clay>=clayc)
										continue;
									if (a*orec+b*clayc+c*oboc+d*georc>ore)
										continue;
									if (c*obcc>clay)
										continue;
									if (d*geobc>obby)
										continue;
									int nore = Math.min(ore-(a*orec+b*clayc+c*oboc+d*georc)+orebots, 511);
									int nclay = Math.min(clay-c*obcc+claybots, 511);
									int nobby =  obby-d*geobc+obbybots;
									int ngeodes = geodes+geodebots;
									int norebots = orebots+a;
									int nclaybots = claybots+b;
									int nobbybots = obbybots+c;
									int ngeodebots = geodebots+d;
									// System.out.println(i+" "+(norebots+nclaybots+nobbybots+ngeodebots));
									long key = nobby;
									key<<=9;
									key += nclay;
									key<<=9;
									key += nore;
									key<<=9;
									key += ngeodebots;
									key<<=9;
									key += nobbybots;
									key<<=9;
									key += nclaybots;
									key<<=9;
									key += norebots;
									hmn.put(key, Math.max(hmn.getOrDefault(key, 0), ngeodes));
									max = Math.max(max, ngeodes);
								}
							}
						}
					}
				}
				hm = hmn;
			}
			System.out.println(max);
			ans *= max;
		}
		System.out.println(ans);
	}
}