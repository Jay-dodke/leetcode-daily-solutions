---
comments: true
difficulty: Medium
edit_url: 
rating: 1699
source: Weekly Contest 441 Q2
tags:
    - Array
    - Hash Table
    - Binary Search
---

<!-- problem:start -->

# [3488. Closest Equal Element Queries](https://leetcode.com/problems/closest-equal-element-queries)



## Description

<!-- description:start -->

<p>You are given a <strong>circular</strong> array <code>nums</code> and an array <code>queries</code>.</p>

<p>For each query <code>i</code>, you have to find the following:</p>

<ul>
	<li>The <strong>minimum</strong> distance between the element at index <code>queries[i]</code> and <strong>any</strong> other index <code>j</code> in the <strong>circular</strong> array, where <code>nums[j] == nums[queries[i]]</code>. If no such index exists, the answer for that query should be -1.</li>
</ul>

<p>Return an array <code>answer</code> of the <strong>same</strong> size as <code>queries</code>, where <code>answer[i]</code> represents the result for query <code>i</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [1,3,1,4,1,3,2], queries = [0,3,5]</span></p>

<p><strong>Output:</strong> <span class="example-io">[2,-1,3]</span></p>

<p><strong>Explanation:</strong></p>

<ul>
	<li>Query 0: The element at <code>queries[0] = 0</code> is <code>nums[0] = 1</code>. The nearest index with the same value is 2, and the distance between them is 2.</li>
	<li>Query 1: The element at <code>queries[1] = 3</code> is <code>nums[3] = 4</code>. No other index contains 4, so the result is -1.</li>
	<li>Query 2: The element at <code>queries[2] = 5</code> is <code>nums[5] = 3</code>. The nearest index with the same value is 1, and the distance between them is 3 (following the circular path: <code>5 -&gt; 6 -&gt; 0 -&gt; 1</code>).</li>
</ul>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [1,2,3,4], queries = [0,1,2,3]</span></p>

<p><strong>Output:</strong> <span class="example-io">[-1,-1,-1,-1]</span></p>

<p><strong>Explanation:</strong></p>

<p>Each value in <code>nums</code> is unique, so no index shares the same value as the queried element. This results in -1 for all queries.</p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= queries.length &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= nums[i] &lt;= 10<sup>6</sup></code></li>
	<li><code>0 &lt;= queries[i] &lt; nums.length</code></li>
</ul>

<!-- description:end -->

## Solutions

<!-- solution:start -->

#### Java

```java
class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;
        int m = n * 2;
        int[] d = new int[m];
        Arrays.fill(d, m);

        Map<Integer, Integer> left = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int x = nums[i % n];
            if (left.containsKey(x)) {
                d[i] = Math.min(d[i], i - left.get(x));
            }
            left.put(x, i);
        }

        Map<Integer, Integer> right = new HashMap<>();
        for (int i = m - 1; i >= 0; i--) {
            int x = nums[i % n];
            if (right.containsKey(x)) {
                d[i] = Math.min(d[i], right.get(x) - i);
            }
            right.put(x, i);
        }

        for (int i = 0; i < n; i++) {
            d[i] = Math.min(d[i], d[i + n]);
        }

        List<Integer> ans = new ArrayList<>();
        for (int query : queries) {
            ans.add(d[query] >= n ? -1 : d[query]);
        }
        return ans;
    }
}
```

<!-- tabs:end -->

<!-- solution:end -->

<!-- problem:end -->