import java.util.Arrays;

/**
 *
 * @authors Yannick Jussub 66308 - Bernardo Fernandes 75122
 */
public class CrystalCastle {
    static final int MOD = 1_000_000_007;

    private final char[][] grid;
    private final int maxConsecJumps;
    private final int maxTotalJumps;

    public CrystalCastle(char[][] grid, int M, int N) {
    this.grid = grid;
    this.maxConsecJumps = M;
    this.maxTotalJumps = N;
    }

    public long solve() {
        int R = grid.length;
        int C = grid[0].length;

        // dp[row%3][col][consecutiveJumps][totalJumps]
        int[][][][] dp = new int[3][C][maxConsecJumps + 1][maxTotalJumps + 1];

        for (int s = 0; s < 3; s++)
            for (int c = 0; c < C; c++)
                for (int m = 0; m <= maxConsecJumps; m++)
                    Arrays.fill(dp[s][c][m], 0);

        dp[0][0][0][0] = 1;

        for (int r = 0; r < R; r++) {
            int clearSlot = (r + 2) % 3;
            for (int c = 0; c < C; c++)
                for (int m = 0; m <= maxConsecJumps; m++)
                    Arrays.fill(dp[clearSlot][c][m], 0);

            int rSlot = r % 3;

            for (int c = 0; c < C; c++) {
                if (grid[r][c] == '#') continue;
                char tile = grid[r][c];

                for (int consec = 0; consec <= maxConsecJumps; consec++) {
                    for (int total = 0; total <= maxTotalJumps; total++) {
                        int val = dp[rSlot][c][consec][total];
                        if (val == 0) continue;

                        // Step R: (r, c+1)
                        if (c + 1 < C && grid[r][c + 1] != '#') {
                            dp[rSlot][c + 1][0][total] =
                                (int) ((dp[rSlot][c + 1][0][total] + (long) val) % MOD);
                        }

                        // Step D: (r+1, c)
                        if (r + 1 < R && grid[r + 1][c] != '#') {
                            int nSlot = (r + 1) % 3;
                            dp[nSlot][c][0][total] =
                                (int) ((dp[nSlot][c][0][total] + (long) val) % MOD);
                        }

                        // Jumps: need consec < M and total < N
                        if (consec < maxConsecJumps && total < maxTotalJumps) {
                            // LD: (r+1, c-1) — diagonal, forbidden from X and J
                            if (tile != 'X' && tile != 'J') {
                                if (r + 1 < R && c - 1 >= 0 && grid[r + 1][c - 1] != '#') {
                                    int nSlot = (r + 1) % 3;
                                    dp[nSlot][c - 1][consec + 1][total + 1] =
                                        (int) ((dp[nSlot][c - 1][consec + 1][total + 1] + (long) val) % MOD);
                                }
                            }

                            // DD: (r+2, c) — straight jump, forbidden from J only
                            if (tile != 'J') {
                                if (r + 2 < R && grid[r + 2][c] != '#') {
                                    int nSlot = (r + 2) % 3;
                                    dp[nSlot][c][consec + 1][total + 1] =
                                        (int) ((dp[nSlot][c][consec + 1][total + 1] + (long) val) % MOD);
                                }
                            }

                            // RD: (r+1, c+1) — diagonal, forbidden from X and J
                            if (tile != 'X' && tile != 'J') {
                                if (r + 1 < R && c + 1 < C && grid[r + 1][c + 1] != '#') {
                                    int nSlot = (r + 1) % 3;
                                    dp[nSlot][c + 1][consec + 1][total + 1] =
                                        (int) ((dp[nSlot][c + 1][consec + 1][total + 1] + (long) val) % MOD);
                                }
                            }
                        }
                    }
                }
            }
        }

        long ans = 0;
        int lastSlot = (R - 1) % 3;
        for (int consec = 0; consec <= maxConsecJumps; consec++) {
            for (int total = 0; total <= maxTotalJumps; total++) {
                ans = (ans + dp[lastSlot][C - 1][consec][total]) % MOD;
            }
        }

        return ans;
    }
}
