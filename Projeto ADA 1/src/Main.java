import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int numtests = Integer.parseInt(in.readLine());
        int[] output = new int[numtests];


        for (int i = 0; i < numtests; i++) {
            String[] line = in.readLine().split(" ");
            int R = Integer.parseInt(line[0]);
            int C = Integer.parseInt(line[1]);
            int M = Integer.parseInt(line[2]);
            int N = Integer.parseInt(line[3]);

            char[][] gridIn = new char[R][C];
            for (int j = 0; j < R; j++) {
                gridIn[j] = in.readLine().toCharArray();

                Grid grid = new Grid(gridIn);
                CrystalCastle castle = new CrystalCastle(grid, M, N);
                output[i] = castle.solver();
            }
        }

        for (int i = 0; i < numtests; i++) {
            System.out.println(output[i]);
        }
    }
}
