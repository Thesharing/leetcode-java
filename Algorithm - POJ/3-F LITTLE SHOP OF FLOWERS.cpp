#include <cstdio>
#include <iostream>

using namespace std;

int MIN = -100000;
int F, V;
int val[100][100];
int res[100][100];

int max(int a, int b)
{
    return a > b ? a : b;
}

int solve(int f, int v)
{
    if(f >= F || v >= V){
        return 0;
    }
    if (res[f][v] == MIN) {
        int max = 0;
        for (int i = 0; f + i < F; i++) {
            max += val[f + i][v + i];
        }
        for (int i = v; i <= V - F + f; i++) {
            int sum = val[f][i] + solve(f + 1, i + 1);
            if (sum > max) {
                max = sum;
            }
        }
        res[f][v] = max;
    }
    return res[f][v];
}

int main(void)
{
    scanf("%d %d", &F, &V);
    for (int i = 0; i < F; i++) {
        for (int j = 0; j < V; j++) {
            scanf("%d", &val[i][j]);
            res[i][j] = MIN;
        }
    }
    // int max = MIN;
    // for (int i = 0; i <= V - F; i++) {
    //     int sum = solve(0, i);
    //     if (sum > max) {
    //         max = sum;
    //     }
    // }
    printf("%d\n", solve(0, 0));
    // for (int i = 0; i < F; i++) {
    //     for (int j = 0; j < V; j++) {
    //         cout << res[i][j] << "\t\t";
    //     }
    //     cout << endl;
    // }
    return 0;
}