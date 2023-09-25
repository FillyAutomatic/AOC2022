import java.io.*;
import java.util.*;
import java.math.*;

public class U2 {
	public static void main(String[] args) throws IOException {

		/*/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		/*/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/u.in"))));
		/**/
		
		long ans = 1234567890123456L;
		HashMap<String, String> om = new HashMap<>();
		while (sc.hasNextLine()) {
			String s = sc.nextLine();
			om.put(s.substring(0,4), s.substring(6));
		}
		long min = 0;
		long max = 1234567890123456L;
		while (min<max) {
			long i = (min+max)/2;
			HashMap<String, String> monkeys = (HashMap<String, String>)om.clone();
			monkeys.put("humn", ""+i);
			while (true) {
				try {
					Long.parseLong(monkeys.get("root"));
					break;
				} catch (Exception e) {
					HashMap<String, String> nm = new HashMap<>();
					for (String m : monkeys.keySet()) {
						try {
							Long.parseLong(monkeys.get(m));
							nm.put(m, monkeys.get(m));
						} catch (Exception ee) {
							String first = monkeys.get(m).substring(0,4);
							char op = monkeys.get(m).charAt(5);
							String second = monkeys.get(m).substring(7,11);
							try {
								long a = Long.parseLong(monkeys.get(first));
								long b = Long.parseLong(monkeys.get(second));
								long ta = 0;
								if (m.equals("root")) {
									if (a==b) {
										ans = Math.min(ans, i);
										min = i;
										max = i;
									} else if (a>b)
										min = i+1;
									else
										max = i-1;
								}
								if (op=='+')
									ta = a+b;
								if (op=='-')
									ta = a-b;
								if (op=='*')
									ta = a*b;
								if (op=='/')
									ta = a/b;
								nm.put(m, ""+ta);
							} catch (Exception eee) {
								nm.put(m, monkeys.get(m));
							}
						}
					}
					monkeys = nm;
				}
			}
		}
		for (long i = 1000000000000L; i < 1000000000001L; ++i) {
			
		}
		System.out.println(ans);
	}
}