# Palindrome

### 描述
A palindrome is a symmetrical string, that is, a string read identically from left to right as well as from right to left. You are to write a program which, given a string, determines the minimal number of characters to be inserted into the string in order to obtain a palindrome.

As an example, by inserting 2 characters, the string "Ab3bd" can be transformed into a palindrome ("dAb3bAd" or "Adb3bdA"). However, inserting fewer than 2 characters does not produce a palindrome.

### 输入
Your program is to read from standard input. The first line contains one integer: the length of the input string N, 3 <= N <= 5000. The second line contains one string with length N. The string is formed from uppercase letters from 'A' to 'Z', lowercase letters from 'a' to 'z' and digits from '0' to '9'. Uppercase and lowercase letters are to be considered distinct.

### 输出
Your program is to write to standard output. The first line contains one integer, which is the desired minimal number.

### 样例输入
```
5
Ab3bd
```

### 样例输出
```
2
```

### 代码

```cpp
#include <cstring>
#include <iostream>
#define MAX 100000

using namespace std;

char str[5050];
int n;
int dp[5050][5050];

int main(void)
{
    cin >> n >> str;
    int k = 0;
    for (int i = n - 1; i >= 0; i--) {
        for (int j = i; j < n; j++) {
            if (i == j) {
                dp[i][j] = 0;
            }
            else if (str[i] == str[j]) {
                dp[i][j] = dp[i + 1][j - 1];
            }
            else {
                dp[i][j] = min(dp[i + 1][j] + 1, dp[i][j - 1] + 1);
            }
        }
        k = 1 - k;
    }
    cout << dp[0][n - 1] << endl;
    return 0;
}
```

### 改进版本

```cpp
#include <cstring>
#include <iostream>
#define MAX 100000

using namespace std;

char str[5050];
int n;
int dp[2][5050];

int main(void)
{
    cin >> n >> str;
    int k = 0;
    for (int i = n - 1; i >= 0; i--) {
        for (int j = i; j < n; j++) {
            if (i == j) {
                dp[k][j] = 0;
            }
            else if (str[i] == str[j]) {
                dp[k][j] = dp[1 - k][j - 1];
            }
            else {
                dp[k][j] = min(dp[1 - k][j] + 1, dp[k][j - 1] + 1);
            }
        }
        k = 1 - k;
    }
    cout << dp[1 - k][n - 1] << endl;
    return 0;
}
```

