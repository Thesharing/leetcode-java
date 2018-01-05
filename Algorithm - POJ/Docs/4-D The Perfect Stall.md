# The Perfect Stall

### 描述
Farmer John completed his new barn just last week, complete with all the latest milking technology. Unfortunately, due to engineering problems, all the stalls in the new barn are different. For the first week, Farmer John randomly assigned cows to stalls, but it quickly became clear that any given cow was only willing to produce milk in certain stalls. For the last week, Farmer John has been collecting data on which cows are willing to produce milk in which stalls. A stall may be only assigned to one cow, and, of course, a cow may be only assigned to one stall. 
Given the preferences of the cows, compute the maximum number of milk-producing assignments of cows to stalls that is possible. 

### 输入
The input includes several cases. For each case, the first line contains two integers, N (0 <= N <= 200) and M (0 <= M <= 200). N is the number of cows that Farmer John has and M is the number of stalls in the new barn. Each of the following N lines corresponds to a single cow. The first integer (Si) on the line is the number of stalls that the cow is willing to produce milk in (0 <= Si <= M). The subsequent Si integers on that line are the stalls in which that cow is willing to produce milk. The stall numbers will be integers in the range (1..M), and no stall will be listed twice for a given cow.

### 输出
For each case, output a single line with a single integer, the maximum number of milk-producing stall assignments that can be made.

### 样例输入
```
5 5
2 2 5
3 2 3 4
2 1 5
3 1 2 5
1 2 
```

### 样例输出
```
4
```

### 代码

```cpp
#include <cstring>
#include <iostream>
#include <queue>

using namespace std;

int MAX_VALUE = 10000;
int m, n;
int dist;
// n -> cow; m -> stall;
int capacity[410][410];
int road_count[210];
int former[410];
int inqueue[410];
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
        if (cur == dist) {
            return true;
        }
        for (int i = 1; i <= dist; i++) {
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
        dist = 1 + n + m + 1;
        int max_flow = 0;
        memset(capacity, 0, sizeof(capacity));
        int stall;
        for (int i = 2; i <= n + 1; i++) {
            cin >> road_count[i];
            for(int j = 0; j < road_count[i]; j++){
                cin >> stall;
                capacity[i][1 + n + stall] = MAX_VALUE;
            }
            capacity[1][i] = 1;
        }
        for (int i = 1; i <= m; i++){
            capacity[1 + n + i][dist] = 1;
        }
        while (bfs()) {
            int bottleneck = 2 * MAX_VALUE ;
            for (int i = dist; i > 1; i = former[i]) {
                if (bottleneck > capacity[former[i]][i]) {
                    bottleneck = capacity[former[i]][i];
                }
            }
            for (int i = dist; i > 1; i = former[i]) {
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
