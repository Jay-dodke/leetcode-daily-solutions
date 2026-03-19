---
comments: true
difficulty: Medium
edit_url: 
rating: 1672
source: Weekly Contest 405 Q3
tags:
    - Array
    - Matrix
    - Prefix Sum
---

<!-- problem:start -->

# [3212. Count Submatrices With Equal Frequency of X and Y](https://leetcode.com/problems/count-submatrices-with-equal-frequency-of-x-and-y)



## Description

<!-- description:start -->

<p>Given a 2D character matrix <code>grid</code>, where <code>grid[i][j]</code> is either <code>&#39;X&#39;</code>, <code>&#39;Y&#39;</code>, or <code>&#39;.&#39;</code>, return the number of <span data-keyword="submatrix">submatrices</span> that contain:</p>

<ul>
	<li><code>grid[0][0]</code></li>
	<li>an <strong>equal</strong> frequency of <code>&#39;X&#39;</code> and <code>&#39;Y&#39;</code>.</li>
	<li><strong>at least</strong> one <code>&#39;X&#39;</code>.</li>
</ul>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">grid = [[&quot;X&quot;,&quot;Y&quot;,&quot;.&quot;],[&quot;Y&quot;,&quot;.&quot;,&quot;.&quot;]]</span></p>

<p><strong>Output:</strong> <span class="example-io">3</span></p>

<p><strong>Explanation:</strong></p>

<p><strong><img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/3200-3299/3212.Count%20Submatrices%20With%20Equal%20Frequency%20of%20X%20and%20Y/images/examplems.png" style="padding: 10px; background: rgb(255, 255, 255); border-radius: 0.5rem; width: 175px; height: 350px;" /></strong></p>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">grid = [[&quot;X&quot;,&quot;X&quot;],[&quot;X&quot;,&quot;Y&quot;]]</span></p>

<p><strong>Output:</strong> <span class="example-io">0</span></p>

<p><strong>Explanation:</strong></p>

<p>No submatrix has an equal frequency of <code>&#39;X&#39;</code> and <code>&#39;Y&#39;</code>.</p>
</div>

<p><strong class="example">Example 3:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">grid = [[&quot;.&quot;,&quot;.&quot;],[&quot;.&quot;,&quot;.&quot;]]</span></p>

<p><strong>Output:</strong> <span class="example-io">0</span></p>

<p><strong>Explanation:</strong></p>

<p>No submatrix has at least one <code>&#39;X&#39;</code>.</p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= grid.length, grid[i].length &lt;= 1000</code></li>
	<li><code>grid[i][j]</code> is either <code>&#39;X&#39;</code>, <code>&#39;Y&#39;</code>, or <code>&#39;.&#39;</code>.</li>
</ul>

<!-- description:end -->

## Solutions

#### Java

```java
class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][][] s = new int[m + 1][n + 1][2];
        int ans = 0;
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                s[i][j][0] = s[i - 1][j][0] + s[i][j - 1][0] - s[i - 1][j - 1][0]
                    + (grid[i - 1][j - 1] == 'X' ? 1 : 0);
                s[i][j][1] = s[i - 1][j][1] + s[i][j - 1][1] - s[i - 1][j - 1][1]
                    + (grid[i - 1][j - 1] == 'Y' ? 1 : 0);
                if (s[i][j][0] > 0 && s[i][j][0] == s[i][j][1]) {
                    ++ans;
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