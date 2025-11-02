package Nov2;

public class GandW_Better {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];

        for (int[] wall : walls) {
            grid[wall[0]][wall[1]] = 3;
        }
        for (int[] guard : guards) {
            grid[guard[0]][guard[1]] = 2;
        }
        int[] dr = { 0, 0, 1, -1 };
        int[] dc = { 1, -1, 0, 0 };

        for (int[] guard : guards) {
            int r0 = guard[0];
            int c0 = guard[1];

            for (int i = 0; i < 4; i++) {
                int r = r0;
                int c = c0;

                while (true) {
                    r += dr[i];
                    c += dc[i];

                    if (r >= m || r < 0 || c < 0 || c >= n) {
                        break;
                    }
                    int cellstate = grid[r][c];

                    if (cellstate == 3 || cellstate == 2) {
                        break;
                    }
                    if (cellstate == 0) {
                        grid[r][c] = 1;
                    }
                }
            }
        }
        int unguard = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    unguard++;
                }
            }
        }
        return unguard;
    }

    public static void main(String[] args) {
        GandW_Better object = new GandW_Better();
        int m = 4, n = 6;
        int[][] guards = { { 0, 0 }, { 1, 1 }, { 2, 3 } };
        int[][] walls = { { 2, 2 }, { 0, 1 }, { 1, 4 } };

        int ans = object.countUnguarded(m, n, guards, walls);
        System.out.println(ans);
    }
}
