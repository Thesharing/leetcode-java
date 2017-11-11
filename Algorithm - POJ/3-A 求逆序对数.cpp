#include <cstdio>
#include <iostream>

using namespace std;

int src[100000];
int dst[100000];
int res;

void mergesort(int a, int b)
{
    if ((b - a) <= 1) {
        return;
    }
    mergesort(a, (a + b + 1) / 2);
    mergesort((a + b + 1) / 2, b);
    int x = a;
    int y = (a + b + 1) / 2;
    int z = a;
    while ((x < (a + b + 1) / 2) && (y < b)) {
        if (src[x] > src[y]) {
            res += (a + b + 1) / 2 - x;
            dst[z++] = src[y++];
        }
        else {
            dst[z++] = src[x++];
        }
    }
    while (x < (a + b + 1) / 2) {
        dst[z++] = src[x++];
    }
    while (y < b) {
        dst[z++] = src[y++];
    }
    for (int i = a; i < b; i++) {
        src[i] = dst[i];
    }
}

int main(void)
{
    int n;
    scanf("%d", &n);
    while (n > 0) {
        res = 0;
        for (int i = 0; i < n; i++) {
            scanf("%d", &src[i]);
        }
        mergesort(0, n);
        printf("%d\n", res);
        scanf("%d", &n);
    }
    return 0;
}