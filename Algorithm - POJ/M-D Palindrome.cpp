#include <cstring>
#include <iostream>
#define MAX 100000

using namespace std;

char str[5050];
int n;
//int dp[5050][5050];
int dp[2][5050];

int main(void)
{
    cin >> n >> str;
    int k = 0;
    for (int i = n - 1; i >= 0; i--) {
        for (int j = i; j < n; j++) {
            if (i == j) {
                // dp[i][j] = 0;
                dp[k][j] = 0;
            }
            else if (str[i] == str[j]) {
                // dp[i][j] = dp[i + 1][j - 1];
                dp[k][j] = dp[1 - k][j - 1];
            }
            else {
                // dp[i][j] = min(dp[i + 1][j] + 1, dp[i][j - 1] + 1);
                dp[k][j] = min(dp[1 - k][j] + 1, dp[k][j - 1] + 1);
            }
        }
        k = 1 - k;
    }
    cout << dp[1 - k][n - 1] << endl;
    return 0;
}