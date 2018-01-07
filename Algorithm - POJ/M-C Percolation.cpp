#include <cstring>
#include <iostream>

int parent[1000060];
int map[1005][1005];
int n, m, t;

int find_parent(int loc)
{ 
    //int loc = (x - 1) * n + y;
    if (parent[loc] == -1) {
        parent[loc] = loc;
    }
    if (loc != parent[loc]) {
        parent[loc] = find_parent(parent[loc]);
    }
    return parent[loc];
}

int calc_loc(int x, int y)
{
    return (x - 1) * n + y;
}

int main(void)
{
    scanf("%d", &t);
    while (t-- > 0) {
        memset(parent, -1, sizeof(parent));
        memset(map[0], 0, 1005 * 1005 * sizeof(int));
        scanf("%d %d", &n, &m);
        int result = -1;
        int x, y, ancestor, loc;
        for (int i = 1; i <= m; i++) {
            scanf("%d %d", &x, &y);
            if (result == -1) {
                map[x][y] = 1;
                loc = calc_loc(x, y);
                if (x > 1 && map[x - 1][y] == 1) {
                    ancestor = find_parent(calc_loc(x - 1, y));
                    parent[ancestor] = find_parent(loc);
                }
                if (x == 1) {
                    ancestor = find_parent(0);
                    parent[ancestor] = find_parent(loc);
                }
                if (x < n && map[x + 1][y] == 1) {
                    ancestor = find_parent(calc_loc(x + 1, y));
                    parent[ancestor] = find_parent(loc);
                }
                if (x == n) {
                    ancestor = find_parent(n * n + 1);
                    parent[ancestor] = find_parent(loc);
                }
                if (y > 1 && map[x][y - 1] == 1) {
                    ancestor = find_parent(calc_loc(x, y - 1));
                    parent[ancestor] = find_parent(loc);
                }
                if (y < n && map[x][y + 1] == 1) {
                    ancestor = find_parent(calc_loc(x, y + 1));
                    parent[ancestor] = find_parent(loc);
                }
                if (find_parent(0) == find_parent(n * n + 1)) {
                    result = i;
                }
            }
        }
        printf("%d\n", result);
    }
    return 0;
}