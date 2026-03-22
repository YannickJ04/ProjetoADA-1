/**
 *
 * @authors Yannick Jussub 66308 - Bernardo Fernandes 75122
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int numtests = Integer.parseInt(in.readLine());
        StringBuilder sb = new StringBuilder();


        for (int i = 0; i < numtests; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            char[][] grid = new char[R][C];
            for (int j = 0; j < R; j++) {
                grid[j] = in.readLine().toCharArray();
            }
                CrystalCastle castle = new CrystalCastle(grid, M, N);
                if (i > 0) sb.append('\n');
                sb.append(castle.solve());

        }

        System.out.println(sb);
    }
}
