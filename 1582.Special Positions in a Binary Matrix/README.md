---
comments: true
difficulty: Easy
edit_url: https://github.com/Jay-dodke/leetcode-daily-solutions
rating: 1321
source: Weekly Contest 206 Q1
tags:
    - Array
    - Matrix
---

<!-- problem:start -->

# [1582. Special Positions in a Binary Matrix](https://leetcode.com/problems/special-positions-in-a-binary-matrix)



## Description

<!-- description:start -->

<p>Given an <code>m x n</code> binary matrix <code>mat</code>, return <em>the number of special positions in </em><code>mat</code><em>.</em></p>

<p>A position <code>(i, j)</code> is called <strong>special</strong> if <code>mat[i][j] == 1</code> and all other elements in row <code>i</code> and column <code>j</code> are <code>0</code> (rows and columns are <strong>0-indexed</strong>).</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/1500-1599/1582.Special%20Positions%20in%20a%20Binary%20Matrix/images/special1.jpg" style="width: 244px; height: 245px;" />
<pre>
<strong>Input:</strong> mat = [[1,0,0],[0,0,1],[1,0,0]]
<strong>Output:</strong> 1
<strong>Explanation:</strong> (1, 2) is a special position because mat[1][2] == 1 and all other elements in row 1 and column 2 are 0.
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/1500-1599/1582.Special%20Positions%20in%20a%20Binary%20Matrix/images/special-grid.jpg" style="width: 244px; height: 245px;" />
<pre>
<strong>Input:</strong> mat = [[1,0,0],[0,1,0],[0,0,1]]
<strong>Output:</strong> 3
<strong>Explanation:</strong> (0, 0), (1, 1) and (2, 2) are special positions.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>m == mat.length</code></li>
	<li><code>n == mat[i].length</code></li>
	<li><code>1 &lt;= m, n &lt;= 100</code></li>
	<li><code>mat[i][j]</code> is either <code>0</code> or <code>1</code>.</li>
</ul>

<!-- description:end -->

## Solutions

#### Java

```java
class Solution {
    public int numSpecial(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] rows = new int[m];
        int[] cols = new int[n];

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                rows[i] += mat[i][j];
                cols[j] += mat[i][j];
            }
        }

        int ans = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (mat[i][j] == 1 && rows[i] == 1 && cols[j] == 1) {
                    ans++;
                }
            }
        }

        return ans;
    }
}
```


<!-- tabs:end -->

<!-- solution:end -->

<!-- problem:end -->