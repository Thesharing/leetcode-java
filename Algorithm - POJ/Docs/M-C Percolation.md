# Percolation

### 描述
定义一个N行N列的矩阵，矩阵中的每个元素是个方格，每个方格有两种可能的状态：开通的或关闭的。初始时，所有方格都是关闭的。输入数据的每一步会指定矩阵中某个原来关闭的方格变成开通的。要求编写程序判断当前是否存在从矩阵中最上面一行的任何一个开着的方格走到最下面一行的任何一个开着的方格的路径。如果存在的话，输出当前的步数。比如走到第14步时，矩阵变成上下通透的，那么就输出14。注意：输入数据中只会把矩阵中的一部分方格打开。如果所有步骤都执行完了，矩阵仍然不是上下通透的，那么输出-1。显然，矩阵变成上下通透的一个必要条件是：最上面一行和最下面一行都至少要有一个方格是打开的。

在矩阵中行走时，只能横着走或竖着走，不能斜着走，也不能走出矩阵的边界。

### 输入
输入的第一行是一个自然数T(1≤T≤10)，代表测试数据的组数。每组测试数据的第一行有两个自然数N和M，其中N（1≤N≤1,000）代表方阵的维度，M（1≤M≤N*N）代表本组测试中打开的方格数目。随后的M行中每行有两个自然数，分别代表所打开的方格的行、列下标。注意：本题中矩阵的下标从1开始，即所有下标的取值都是[1, N]区间中的正整数。

### 输出
每组测试数据输出一个自然数K，表示打开第K个方格后，矩阵变成上下通透的。如果M个方格都打开后，矩阵仍然不是上下通透的，那么输出-1。

### 样例输入
```
1
4 10 
2 2
3 1
4 2
4 4
1 2
2 3
2 1
3 2
3 4
3 1
```

### 样例输出
```
8
```

### 代码

```cpp
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
```