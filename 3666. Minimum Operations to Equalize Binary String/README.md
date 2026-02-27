---
comments: true
difficulty: Hard
edit_url: https://github.com/Jay-dodke/leetcode-daily-solutions
edit_url: 
rating: 2476
source: Biweekly Contest 164 Q4
tags:
    - Breadth-First Search
    - Union Find
    - Math
    - String
    - Ordered Set
---

<!-- problem:start -->

# [3666. Minimum Operations to Equalize Binary String](https://leetcode.com/problems/minimum-operations-to-equalize-binary-string)



## Description

<!-- description:start -->

<p>You are given a binary string <code>s</code>, and an integer <code>k</code>.</p>

<p>In one operation, you must choose <strong>exactly</strong> <code>k</code> <strong>different</strong> indices and <strong>flip</strong> each <code>&#39;0&#39;</code> to <code>&#39;1&#39;</code> and each <code>&#39;1&#39;</code> to <code>&#39;0&#39;</code>.</p>

<p>Return the <strong>minimum</strong> number of operations required to make all characters in the string equal to <code>&#39;1&#39;</code>. If it is not possible, return -1.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = &quot;110&quot;, k = 1</span></p>

<p><strong>Output:</strong> <span class="example-io">1</span></p>

<p><strong>Explanation:</strong></p>

<ul>
	<li>There is one <code>&#39;0&#39;</code> in <code>s</code>.</li>
	<li>Since <code>k = 1</code>, we can flip it directly in one operation.</li>
</ul>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = &quot;0101&quot;, k = 3</span></p>

<p><strong>Output:</strong> <span class="example-io">2</span></p>

<p><strong>Explanation:</strong></p>

<p>One optimal set of operations choosing <code>k = 3</code> indices in each operation is:</p>

<ul>
	<li><strong>Operation 1</strong>: Flip indices <code>[0, 1, 3]</code>. <code>s</code> changes from <code>&quot;0101&quot;</code> to <code>&quot;1000&quot;</code>.</li>
	<li><strong>Operation 2</strong>: Flip indices <code>[1, 2, 3]</code>. <code>s</code> changes from <code>&quot;1000&quot;</code> to <code>&quot;1111&quot;</code>.</li>
</ul>

<p>Thus, the minimum number of operations is 2.</p>
</div>

<p><strong class="example">Example 3:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = &quot;101&quot;, k = 2</span></p>

<p><strong>Output:</strong> <span class="example-io">-1</span></p>

<p><strong>Explanation:</strong></p>

<p>Since <code>k = 2</code> and <code>s</code> has only one <code>&#39;0&#39;</code>, it is impossible to flip exactly <code>k</code> indices to make all <code>&#39;1&#39;</code>. Hence, the answer is -1.</p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 10<sup>​​​​​​​5</sup></code></li>
	<li><code>s[i]</code> is either <code>&#39;0&#39;</code> or <code>&#39;1&#39;</code>.</li>
	<li><code>1 &lt;= k &lt;= s.length</code></li>
</ul>

<!-- description:end -->

## Solutions

<!-- solution:start -->

#### Java

```java
class Solution {
    public int minOperations(String s, int k) {
        int n = s.length();

        TreeSet<Integer>[] ts = new TreeSet[2];
        Arrays.setAll(ts, i -> new TreeSet<>());

        for (int i = 0; i <= n; i++) {
            ts[i % 2].add(i);
        }

        int cnt0 = 0;
        for (char c : s.toCharArray()) {
            if (c == '0') {
                cnt0++;
            }
        }

        ts[cnt0 % 2].remove(cnt0);

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

                TreeSet<Integer> t = ts[l % 2];

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
```
