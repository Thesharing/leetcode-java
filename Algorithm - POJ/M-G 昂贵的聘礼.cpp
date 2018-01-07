#include <algorithm>
#include <climits>
#include <cstdio>
#include <iostream>

#define SIZE 200

using namespace std;

int map[SIZE][SIZE];
int l[SIZE];
int m, n;
int final[SIZE];
int d[SIZE];

int main(void)
{
    fill(map[0], map[0] + SIZE * SIZE, INT_MAX);
    scanf("%d %d", &m, &n);
    int x, t, v;
    for (int i = 1; i <= n; i++) {
        scanf("%d %d %d", &map[0][i], &l[i], &x);
        for (int j = 0; j < x; j++) {
            scanf("%d %d", &t, &v);
            map[t][i] = v;
        }
    }
    int min_result = INT_MAX;
    for (int bound = 0; bound <= m; bound++) {
        int upper_bound = l[1] + bound;
        int lower_bound = upper_bound - m;
        for (int i = 0; i <= n; i++) {
            final[i] = false;
            d[i] = map[0][i];
        }
        final[0] = true;
        d[0] = 0;
        for (int i = 1; i <= n; i++) {
            int min_v = INT_MAX;
            int min_w = 0;
            for (int w = 1; w <= n; w++) {
                if (!final[w] && min_v > d[w] && l[w] >= lower_bound && l[w] <= upper_bound) {
                    min_v = d[w];
                    min_w = w;
                }
            }
            final[min_w] = true;
            for (int w = 1; w <= n; w++) {
                if (map[min_w][w] < INT_MAX && l[w] >= lower_bound && l[w] <= upper_bound) {
                    d[w] = min(d[w], d[min_w] + map[min_w][w]);
                }
            }
        }
        min_result = min(min_result, d[1]);
    }
    printf("%d\n", min_result);
    return 0;
}