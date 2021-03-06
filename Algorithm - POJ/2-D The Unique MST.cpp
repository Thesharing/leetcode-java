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
                                parent[it_2->y] = it_2->x;
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
