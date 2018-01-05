# Drainage Ditches

### 描述
Every time it rains on Farmer John's fields, a pond forms over Bessie's favorite clover patch. This means that the clover is covered by water for awhile and takes quite a long time to regrow. Thus, Farmer John has built a set of drainage ditches so that Bessie's clover patch is never covered in water. Instead, the water is drained to a nearby stream. Being an ace engineer, Farmer John has also installed regulators at the beginning of each ditch, so he can control at what rate water flows into that ditch. 
Farmer John knows not only how many gallons of water each ditch can transport per minute but also the exact layout of the ditches, which feed out of the pond and into each other and stream in a potentially complex network. 
Given all this information, determine the maximum rate at which water can be transported out of the pond and into the stream. For any given ditch, water flows in only one direction, but there might be a way that water can flow in a circle. 

### 输入
The input includes several cases. For each case, the first line contains two space-separated integers, N (0 <= N <= 200) and M (2 <= M <= 200). N is the number of ditches that Farmer John has dug. M is the number of intersections points for those ditches. Intersection 1 is the pond. Intersection point M is the stream. Each of the following N lines contains three integers, Si, Ei, and Ci. Si and Ei (1 <= Si, Ei <= M) designate the intersections between which this ditch flows. Water will flow through this ditch from Si to Ei. Ci (0 <= Ci <= 10,000,000) is the maximum rate at which water will flow through the ditch.

### 输出
For each case, output a single integer, the maximum rate at which water may emptied from the pond.

### 样例输入
```
5 4
1 2 40
1 4 20
2 4 20
2 3 30
3 4 10
```

### 样例输出
```
50
```

### 代码

```cpp

#include <cstring>
#include <iostream>
#include <queue>

using namespace std;

int MAX_VALUE = 10000001;
int m, n;
// m: count of points; (1 -> m)
// n: count of roads; (0 -> n-1)
int capacity[210][210];
int former[210];
int inqueue[210];
queue<int> bfs_queue;

bool bfs()
{
    memset(inqueue, 0, sizeof(inqueue));
    memset(former, 0, sizeof(former));
    while (!bfs_queue.empty()) {
        bfs_queue.pop();
    }
    bfs_queue.push(1);
    inqueue[1] = 1;
    while (!bfs_queue.empty()) {
        int cur = bfs_queue.front();
        bfs_queue.pop();
        if (cur == m) {
            return true;
        }
        for (int i = 1; i <= m; i++) {
            if (inqueue[i] == 0 && capacity[cur][i] > 0) {
                bfs_queue.push(i);
                inqueue[i] = 1;
                former[i] = cur;
            }
        }
    }
    return false;
}

int main(void)
{
    while (cin >> n >> m) {
        int max_flow = 0;
        memset(capacity, 0, sizeof(capacity));
        int a, b, c;
        for (int i = 0; i < n; i++) {
            cin >> a >> b >> c;
            capacity[a][b] += c;
        }
        while (bfs()) {
            int bottleneck = MAX_VALUE;
            for (int i = m; i > 1; i = former[i]) {
                if (bottleneck > capacity[former[i]][i]) {
                    bottleneck = capacity[former[i]][i];
                }
            }
            for (int i = m; i > 1; i = former[i]) {
                capacity[former[i]][i] -= bottleneck;
                capacity[i][former[i]] += bottleneck;
            }
            max_flow += bottleneck;
        }
        cout << max_flow << endl;
    }
    return 0;
}
```
