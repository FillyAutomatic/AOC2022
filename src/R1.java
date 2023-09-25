import java.io.*;
import java.util.*;
import java.math.*;

public class R1 {
	public static void main(String[] args) throws IOException {

		/*/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		/*/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/r.in"))));
		/**/
		
		int ans = 0;
		boolean[][][] cubes = new boolean[100][100][100]; 
		while (sc.hasNextLine()) {
			String s = sc.nextLine();
			int a = Integer.parseInt(s.split(",")[0])+1;
			int b = Integer.parseInt(s.split(",")[1])+1;
			int c = Integer.parseInt(s.split(",")[2])+1;
			cubes[a][b][c] = true;
		}
		for (int i = 1; i < 99; ++i) {
			for (int j = 1; j < 99; ++j) {
				for (int k = 1; k < 99; ++k) {
					if (cubes[i][j][k]) {
						ans += 6;
						if (cubes[i-1][j][k])
							ans--;
						if (cubes[i+1][j][k])
							ans--;
						if (cubes[i][j-1][k])
							ans--;
						if (cubes[i][j+1][k])
							ans--;
						if (cubes[i][j][k-1])
							ans--;
						if (cubes[i][j][k+1])
							ans--;
					}
				}
			}
		}
		System.out.println(ans);
	}
}