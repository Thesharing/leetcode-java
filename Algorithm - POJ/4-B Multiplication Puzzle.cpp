#include <climits>
#include <cstdlib>
#include <cstring>
#include <iostream>

using namespace std;

int n;
int c[110];
int d[110][110];

int rec(int a, int b)
{
    if (d[a][b] < 0) {
        if ((b - a) == 1) {
            d[a][b] = 0;
        }
        else {
            int min = INT_MAX;
            for (int i = a + 1; i < b; i++) {
                int l = rec(a, i);
                int r = rec(i, b);
                if (min > l + r + c[a] * c[i] * c[b]) {
                    min = l + r + c[a] * c[i] * c[b];
                }
            }
            d[a][b] = min;
        }
    }
    return d[a][b];
}

int main(void)
{
    cin >> n;
    memset(d, -1, sizeof(d));
    for (int i = 0; i < n; i++) {
        cin >> c[i];
    }
    cout << rec(0, n - 1) << endl;
    return 0;
}