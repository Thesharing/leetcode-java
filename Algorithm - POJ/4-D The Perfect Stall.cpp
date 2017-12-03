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
