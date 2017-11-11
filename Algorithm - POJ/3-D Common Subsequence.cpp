#include <cstdio>
#include <iostream>
#include <string>

using namespace std;

string a;
string b;

int cache[20000][20000];

int max(int a, int b)
{
    return (a > b) ? a : b;
}

int findCommonSeq(int m, int n)
{
    if (m >= a.length() || n >= b.length()) {
        return 0;
    }
    if (cache[m][n] == -1) {
        if (a[m] == b[n]) {
            cache[m][n] = 1 + findCommonSeq(m + 1, n + 1);
        }
        else {
            cache[m][n] = max(findCommonSeq(m, n + 1), findCommonSeq(m + 1, n));
        }
    }
    return cache[m][n];
}

int main(void)
{
    while (cin >> a >> b) {
        for (int i = 0; i < a.length(); i++) {
            for (int j = 0; j < b.length(); j++) {
                cache[i][j] = -1;
            }
        }
        cout << findCommonSeq(0, 0) << endl;
    }
    return 0;
}