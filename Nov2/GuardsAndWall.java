package Nov2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class GuardsAndWall {
    private static void dfs(int r, int c, String dir, int[][] visited, Map<String, Integer> map) {

        int n = visited.length;
        int m = visited[0].length;

        if (r >= m || r < 0 || c < 0 || c >= n) {
            return;
        }
        if (map.containsKey(r + "," + "c")) {
            return;
        }
        visited[r][c] = 1;
        if (dir.equals("r"))
            dfs(r, c + 1, "r", visited, map);

        if (dir.equals("l"))
            dfs(r, c - 1, "l", visited, map);

        if (dir.equals("d"))
            dfs(r + 1, c, "d", visited, map);

        if (dir.equals("u"))
            dfs(r - 1, c, "u", visited, map);
    }

    public static int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int cnt = 0;
        int[][] visited = new int[n][n];
        Map<String, Integer> map = new HashMap<>();
        Queue<int[]> queue = new LinkedList<>();

        for (int[] g : guards) {
            queue.add(g);
            map.put(g[0] + "," + g[1], 1);
            visited[g[0]][g[1]] = 3;
        }

        for (int[] w : walls) {
            map.put(w[0] + "," + w[1], 1);
            visited[w[0]][w[1]] = 1;
        }

        for (int[] g : guards) {
            int r = g[0], c = g[1];
            dfs(r, c + 1, "r", visited, map);
            dfs(r, c - 1, "l", visited, map);
            dfs(r + 1, c, "d", visited, map);
            dfs(r - 1, c, "u", visited, map);

            for (int i = 0; i < m; i++)
                for (int j = 0; j < n; j++)
                    if (visited[i][j] == 0)
                        cnt++;
        }
        return cnt;
    }
}
