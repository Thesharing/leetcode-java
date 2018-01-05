# The Unique MST

### 描述
Given a connected undirected graph, tell if its minimum spanning tree is unique.

Definition 1 (Spanning Tree): Consider a connected, undirected graph G = (V, E). A spanning tree of G is a subgraph of G, say T = (V', E'), with the following properties:
1. V' = V.
2. T is connected and acyclic.

Definition 2 (Minimum Spanning Tree): Consider an edge-weighted, connected, undirected graph G = (V, E). The minimum spanning tree T = (V, E') of G is the spanning tree that has the smallest total cost. The total cost of T means the sum of the weights on all the edges in E'.

### 输入
The first line contains a single integer t (1 <= t <= 20), the number of test cases. Each case represents a graph. It begins with a line containing two integers n and m (1 <= n <= 100), the number of nodes and edges. Each of the following m lines contains a triple (xi, yi, wi), indicating that xi and yi are connected by an edge with weight = wi. For any two nodes, there is at most one edge connecting them.

### 输出
For each input, if the MST is unique, print the total cost of it, or otherwise print the string 'Not Unique!'.

### 样例输入
```
2
3 3
1 2 1
2 3 2
3 1 3
4 4
1 2 2
2 3 2
3 4 2
4 1 2
```

### 样例输出
```
3
Not Unique!
```

### 代码

```cpp
#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

struct edge {
    int x;
    int y;
    int w;
    int sign;

    edge(int x, int y, int w) : x(x), y(y), w(w), sign(0) {}

    // Implement < and > for sort
    bool operator<(const edge &e) const
    {
        return (w < e.w);
    }

    bool operator>(const edge &e) const
    {
        return (w > e.w);
    }
};

int find_parent(int x, int parent[])
{
    if (x != parent[x]) {
        parent[x] = find_parent(parent[x], parent);
    }
    return parent[x];
}

int main(void)
{
    int parent[100];

    int t;
    cin >> t;
    while (t-- > 0) {

        bool has_signed_point = false;

        int m, n;
        cin >> n >> m;

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        // Input - Kruskal
        vector<edge> edge_v;
        int x, y, w;
        for (int i = 0; i < m; i++) {
            cin >> x >> y >> w;
            edge_v.push_back(edge(x, y, w));
        }
        sort(edge_v.begin(), edge_v.end());

        // 如果 the edge has the same weight，标记为1
        int last_w = -1;
        for (vector<edge>::iterator it = edge_v.begin(); it != edge_v.end(); it++){
            if (last_w == it->w) {
                it--;
                it->sign = 1; // has the same weight
                it++;
                it->sign = 1;
            }
            last_w = it->w;
        }

        // 通过并查集来实现Kruskal
        // 如果用到的sign = 1的边，则改为sign = 2
        int sum = 0;
        for (vector<edge>::iterator it = edge_v.begin(); it != edge_v.end(); it++) {
            if (find_parent(it->x, parent) != find_parent(it->y, parent)) {
                if (it->sign == 1) {
                    has_signed_point = true;
                    it->sign = 2; // should be deleted
                }
                sum += it->w;
                parent[it->y] = it->x;
            }
        }

        if (has_signed_point) {
            // 对于每一条sign = 2的边，尝试删掉这条边，然后重新跑一遍Kruskal，如果最小生成树的总长是一样的，说明不是Unique
            for (vector<edge>::iterator it = edge_v.begin(); it != edge_v.end(); it++) {
                if (it->sign == 2) {
                    int sum_2 = 0;
                    for (int i = 1; i <= n; i++) {
                        parent[i] = i;
                    }
                    for (vector<edge>::iterator it_2 = edge_v.begin(); it_2 != edge_v.end(); it_2++) {
                        if (it_2 != it) {
                            if (find_parent(it_2->x, parent) != find_parent(it_2->y, parent)) {
                                sum_2 += it_2->w;
                                parent[it->y] = it_2->x;
                            }
                        }
                    }
                    if (sum == sum_2) {
                        sum = -1;
                        break;
                    }       
                }
            }
        }

        if (sum == -1) {
            cout << "Not Unique!" << endl;
        }
        else {
            cout << sum << endl;
        }
    }
    return 0;
}
```
