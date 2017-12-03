#include <cstring>
#include <iostream>
#include <queue>

using namespace std;

int MAX_VALUE = 10000;
int n, f, d;
int dist;
// n -> cow; m -> stall;
int capacity[410][410];
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
    cin >> n >> f >> d;
    int fi, di, food, drink;
    dist = 1 + f + n * 2 + d + 1;
    memset(capacity, 0, sizeof(capacity));
    for (int cow = 1; cow <= n; cow++) {
        cin >> fi >> di;
        for (int i = 0; i < fi; i++) {
            cin >> food;
            capacity[1 + food][1 + f + cow] = 1;
        }
        for (int i = 0; i < di; i++) {
            cin >> drink;
            capacity[1 + f + n + cow][1 + f + n * 2 + drink] = 1;
        }
        capacity[1 + f + cow][1 + f + n + cow] = 1;
    }
    for (int i = 1; i <= f; i++) {
        capacity[1][1 + i] = 1;
    }
    for (int i = 1; i <= d; i++) {
        capacity[1 + f + n * 2 + i][dist] = 1;
    }
    // cout << "  S 1 2 3 1 2 3 4 1 2 3 4 1 2 3 E" << endl;
    // char ch[] = {' ', 'S', '1', '2', '3', '1', '2', '3', '4', '1', '2', '3', '4', '1', '2', '3', 'E'};
    // for (int i = 1; i <= dist; i++) {
    //     cout << ch[i] << ' ';
    //     for (int j = 1; j <= dist; j++) {
    //         cout << capacity[i][j] << ' ';
    //     }
    //     cout << endl;
    // }
    int max_flow = 0;
    while (bfs()) {
        // for (int i = dist; i > 1; i = former[i]) {
        //     cout << i << ' ';
        // }
        // cout << endl;
        int bottleneck = 2 * MAX_VALUE;
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
    return 0;
}
