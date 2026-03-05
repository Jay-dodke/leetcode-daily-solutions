import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.TreeSet;

class Solution {
    public int minOperations(String s, int k) {
        int n = s.length();

        List<TreeSet<Integer>> ts = Arrays.asList(new TreeSet<>(), new TreeSet<>());

        for (int i = 0; i <= n; i++) {
            ts.get(i % 2).add(i);
        }

        int cnt0 = 0;
        for (char c : s.toCharArray()) {
            if (c == '0') {
                cnt0++;
            }
        }

        ts.get(cnt0 % 2).remove(cnt0);

        Deque<Integer> q = new ArrayDeque<>();
        q.offer(cnt0);

        int ans = 0;
        while (!q.isEmpty()) {
            for (int size = q.size(); size > 0; --size) {
                int cur = q.poll();
                if (cur == 0) {
                    return ans;
                }

                int l = cur + k - 2 * Math.min(cur, k);
                int r = cur + k - 2 * Math.max(k - n + cur, 0);

                TreeSet<Integer> t = ts.get(l % 2);

                Integer next = t.ceiling(l);
                while (next != null && next <= r) {
                    q.offer(next);
                    t.remove(next);
                    next = t.ceiling(l);
                }
            }
            ans++;
        }

        return -1;
    }
}
