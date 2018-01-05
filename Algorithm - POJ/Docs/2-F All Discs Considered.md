# 2-F All Discs Considered

### 描述
Operating systems are large software artefacts composed of many packages, usually distributed on several media, e.g., discs. You probably remember the time when your favourite operating system was delivered on 21 floppy discs, or, a few years later, on 6 CDs. Nowadays, it will be shipped on several DVDs, each containing tens of thousands of packages. 

The installation of certain packages may require that other packages have been installed previously. Therefore, if the packages are distributed on the media in an unsuitable way, the installation of the complete system requires you to perform many media changes, provided that there is only one reading device available, e.g., one DVD-ROM drive. Since you have to start the installation somehow, there will of course be one or more packages that can be installed independently of all other packages. 

Given a distribution of packages on media and a list of dependences between packages, you have to calculate the minimal number of media changes required to install all packages. For your convenience, you may assume that the operating system comes on exactly 2 DVDs. 

### 输入
The input contains several test cases. Every test case starts with three integers N1, N2, D. You may assume that 1<=N1,N2<=50000 and 0<=D<=100000. The first DVD contains N1 packages, identified by the numbers 1, 2, ..., N1. The second DVD contains N2 packages, identified by the numbers N1+1, N1+2, ..., N1+N2. Then follow D dependence specifications, each consisting of two integers xi, yi. You may assume that 1<=xi,yi<=N1+N2 for 1<=i<=D. The dependence specification means that the installation of package xi requires the previous installation of package yi. You may assume that there are no circular dependences. The last test case is followed by three zeros.

### 输出
For each test case output on a line the minimal number of DVD changes required to install all packages. By convention, the DVD drive is empty before the installation and the initial insertion of a disc counts as one change. Likewise, the final removal of a disc counts as one change, leaving the DVD drive empty after the installation.

### 样例输入
```
3 2 1
1 2
2 2 2
1 3
4 2
2 1 1
1 3
0 0 0
```

### 样例输出
```
3
4
3
```

### 代码

```cpp
#include <cstdio>
#include <iostream>
#include <queue>
#include <vector>

using namespace std;

struct point {
    int in_1;
    int in_2;
    vector<int> dep;
};

struct point disc[100010];

int main(void)
{
    int m, n, d;
    int x, y;
    scanf("%d %d %d", &m, &n, &d);
    while (m != 0 || n != 0 || d != 0) {
        int insert_1 = 0;
        queue<int> q[2];
        for (int i = 1; i <= m + n; i++) {
            disc[i].in_1 = 0;
            disc[i].in_2 = 0;
            disc[i].dep.clear();
        }
        for (int i = 0; i < d; i++) {
            scanf("%d %d", &x, &y);
            disc[y].dep.push_back(x);
            disc[x].in_1 += 1;
            disc[x].in_2 += 1;
        }
        for (int i = 1; i <= m; i++) {
            if (disc[i].in_1 == 0) {
                q[0].push(i);
            }
        }
        for (int i = m + 1; i <= m + n; i++) {
            if (disc[i].in_1 == 0) {
                q[1].push(i);
            }
        }
        int u = 0;
        while (q[u].size() > 0 || q[1 - u].size() > 0) {
            while (q[u].size() > 0) {
                int t = q[u].front();
                q[u].pop();
                for (vector<int>::iterator it = disc[t].dep.begin(); it < disc[t].dep.end(); it++) {
                    disc[*it].in_1 -= 1;
                    if (disc[*it].in_1 <= 0) {
                        if (*it <= m) {
                            q[0].push(*it);
                        }
                        else {
                            q[1].push(*it);
                        }
                    }
                }
            }
            u = 1 - u;
            insert_1++;
        }
        insert_1++;

        int insert_2 = 0;

        for (int i = 1; i <= m; i++) {
            if (disc[i].in_2 == 0) {
                q[0].push(i);
            }
        }
        for (int i = m + 1; i <= m + n; i++) {
            if (disc[i].in_2 == 0) {
                q[1].push(i);
            }
        }
        u = 1;
        while (q[u].size() > 0 || q[1 - u].size() > 0) {
            while (q[u].size() > 0) {
                int t = q[u].front();
                q[u].pop();
                for (vector<int>::iterator it = disc[t].dep.begin(); it < disc[t].dep.end(); it++) {
                    disc[*it].in_2 -= 1;
                    if (disc[*it].in_2 <= 0) {
                        if (*it <= m) {
                            q[0].push(*it);
                        }
                        else {
                            q[1].push(*it);
                        }
                    }
                }
            }
            u = 1 - u;
            insert_2++;
        }
        insert_2++;

        if (insert_1 > insert_2) {
            printf("%d\n", insert_2);
        }
        else{
            printf("%d\n", insert_1);
        }
        scanf("%d %d %d", &m, &n, &d);
    }
    return 0;
}
```