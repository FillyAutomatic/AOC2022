import java.io.*;
import java.util.*;
import java.math.*;

public class U1 {
	public static void main(String[] args) throws IOException {

		/*/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		/*/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/u.in"))));
		/**/
		
		long ans = 0;
		HashMap<String, String> monkeys = new HashMap<>();
		while (sc.hasNextLine()) {
			String s = sc.nextLine();
			monkeys.put(s.substring(0,4), s.substring(6));
		}
		while (true) {
			try {
				ans = Long.parseLong(monkeys.get("root"));
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
		System.out.println(ans);
	}
}