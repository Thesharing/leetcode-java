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
