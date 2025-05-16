import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Islands {
    private int[] parent;
    private int[] rank;
    private int count;    
    public List<Integer> find(int m,int n,int[][] positions){
        parent = new int[m * n];
        rank = new int[m * n];
        Arrays.fill(parent, -1);
        count = 0;

        List<Integer> result = new ArrayList<>();
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        for (int[] pos : positions) {
            int r = pos[0], c = pos[1];
            int idx = r * n + c;

            if (parent[idx] != -1) {
                result.add(count);  // already land
                continue;
            }

            parent[idx] = idx;
            count++;

            for (int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                int nIdx = nr * n + nc;

                if (nr < 0 || nr >= m || nc < 0 || nc >= n || parent[nIdx] == -1) continue;

                union(idx, nIdx);
            }

            result.add(count);
        }

        return result;
    }
    private int find(int i) {
        if (parent[i] != i) {
            parent[i] = find(parent[i]);  // path compression
        }
        return parent[i];
    }

    private void union(int x, int y) {
        int rootx = find(x);
        int rooty = find(y);

        if (rootx != rooty) {
            if (rank[rootx] > rank[rooty]) {
                parent[rooty] = rootx;
            } else if (rank[rootx] < rank[rooty]) {
                parent[rootx] = rooty;
            } else {
                parent[rooty] = rootx;
                rank[rootx]++;
            }
            count--;
        }
    }
}
          