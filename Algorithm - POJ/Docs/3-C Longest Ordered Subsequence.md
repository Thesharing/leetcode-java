# Longest Ordered Subsequence

### 描述
A numeric sequence of ai is ordered if a1 < a2 < ... < aN. Let the subsequence of the given numeric sequence (a1, a2, ..., aN) be any sequence (ai1, ai2, ..., aiK), where 1 <= i1 < i2 < ... < iK <= N. For example, sequence (1, 7, 3, 5, 9, 4, 8) has ordered subsequences, e. g., (1, 7), (3, 4, 8) and many others. All longest ordered subsequences are of length 4, e. g., (1, 3, 5, 8).

Your program, when given the numeric sequence, must find the length of its longest ordered subsequence.

### 输入
The first line of input file contains the length of sequence N. The second line contains the elements of sequence - N integers in the range from 0 to 10000 each, separated by spaces. 1 <= N <= 1000

### 输出
Output file must contain a single integer - the length of the longest ordered subsequence of the given sequence.

### 样例输入
```
7
1 7 3 5 9 4 8
```

### 样例输出
```
4
```

### 代码

```cpp
#include <cstdio>
#include <iostream>

using namespace std;

int res[1000];
int num[1000];
int n;

int findLongestSeq()
{
    for (int i = 0; i < n; i++) {
        int max = 1;
        for (int j = 0; j < i; j++) {
            if (num[i] > num[j]) {
                if (max < (res[j] + 1)) {
                    max = res[j] + 1;
                }
            }
        }
        res[i] = max;
    }
    int max = 0;
    for (int i = 0; i < n; i++) {
        if (max < res[i]) {
            max = res[i];
        }
    }
    return max;
}

int main(void)
{
    scanf("%d", &n);
    for (int i = 0; i < n; i++) {
        scanf("%d", &num[i]);
    }
    printf("%d\n", findLongestSeq());
    return 0;
}
```

### 代码 2

```cpp
#include <cstdio>
#include <cstring>
#include <iostream>

using namespace std;

int n;
int num[1010];
int res[1010];

int main(void)
{
    cin >> n;
    memset(res, 0, sizeof(res));
    for (int i = 0; i < n; i++) {
        cin >> num[i];
    }
    for (int i = 0; i < n; i++) {
        res[i] = 1;
        for (int j = 0; j < i; j++) {
            if (num[i] > num[j]) {
                res[i] = max(res[i], res[j] + 1);
            }
        }
    }
    int max_value = 0;
    for (int i = 0; i < n; i++) {
        max_value = max(max_value, res[i]);
    }
    cout << max_value << endl;
    return 0;
}
```
