#include <cstdio>
#include <cstring>
#include <iostream>
#include <queue>
#include <vector>

using namespace std;

const int INF = 0x3f3f3f3f;

struct edge {
    int dest;
    int capacity;
} edge_set[100000000];
vector<int> source[200000];
int n, m;
int level[200000];
int edge_count = 0;

void addedge(int u, int v, int capacity)
{
    edge_set[edge_count].dest = v;
    edge_set[edge_count].capacity = capacity;
    source[u].push_back(edge_count++);
    edge_set[edge_count].dest = u;
    edge_set[edge_count].capacity = 0;
    source[v].push_back(edge_count++);
}

bool bfs()
{
    memset(level, 0, sizeof(level));
    queue<int> bfs_queue;
    level[0] = 1;
    bfs_queue.push(0);
    while (!bfs_queue.empty()) {
        int cur = bfs_queue.front();
        bfs_queue.pop();
        if (cur == n + 1) {
            return true;
        }
        for (int i = 0; i < source[cur].size(); i++) {
            int dest = edge_set[source[cur][i]].dest;
            if (level[dest] == 0 && edge_set[source[cur][i]].capacity > 0) {
                level[dest] = level[cur] + 1;
                bfs_queue.push(dest);
            }
        }
    }
    return false;
}

int dfs(int s, int t, int max_f)
{
    if (s == t)
        return max_f;
    int ret = 0;
    for (int i = 0; i < source[s].size(); i++) {
        int src = source[s][i];
        int v = edge_set[src].dest, f = edge_set[src].capacity;
        if (level[s] + 1 == level[v] && f > 0) {
            int min_n = min(max_f - ret, f);
            f = dfs(v, t, min_n);
            if (src % 2 == 0) {
                edge_set[src].capacity -= f;
                edge_set[src + 1].capacity += f;
            }
            else {
                edge_set[src].capacity -= f;
                edge_set[src - 1].capacity += f;
            }
            ret += f;
            if (ret == max_f)
                return ret;
        }
    }
    return ret;
}

int main(void)
{
    scanf("%d%d", &n, &m);
    int a, b, c;
    for (int i = 1; i <= n; i++) {
        scanf("%d%d", &a, &b);
        addedge(0, i, a);
        addedge(i, n + 1, b);
    }
    for (int i = 0; i < m; i++) {
        scanf("%d%d%d", &a, &b, &c);
        addedge(a, b, c);
        addedge(b, a, c);
    }
    int max_flow = 0;
    // for(int i = 1; i <= n + 2; i ++){
    //     cout << "Source: " << i << endl;
    //     for(vector<int>::iterator it = source[i].begin(); it != source[i].end(); it++){
    //         cout << edge_set[*it].dest << '\t' << edge_set[*it].capacity << endl;
    //     }
    // }
    while (bfs()) {
        max_flow += dfs(0, n + 1, INF);
    }
    printf("%d\n", max_flow);
    return 0;
}