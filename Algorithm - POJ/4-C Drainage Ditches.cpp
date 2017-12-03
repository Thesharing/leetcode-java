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
