# Multiplication Puzzle

### 描述
The multiplication puzzle is played with a row of cards, each containing a single positive integer. During the move player takes one card out of the row and scores the number of points equal to the product of the number on the card taken and the numbers on the cards on the left and on the right of it. It is not allowed to take out the first and the last card in the row. After the final move, only two cards are left in the row.

The goal is to take cards in such order as to minimize the total number of scored points.

For example, if cards in the row contain numbers 10 1 50 20 5, player might take a card with 1, then 20 and 50, scoring
10\*1\*50 + 50\*20\*5 + 10\*50\*5 = 500+5000+2500 = 8000

If he would take the cards in the opposite order, i.e. 50, then 20, then 1, the score would be
1\*50\*20 + 1\*20\*5 + 10\*1\*5 = 1000+100+50 = 1150.

### 输入
The first line of the input contains the number of cards N (3 <= N <= 100). The second line contains N integers in the range from 1 to 100, separated by spaces.

### 输出
Output must contain a single integer - the minimal score.

### 样例输入
```
6
10 1 50 50 20 5
```

### 样例输出
```
3650
```

### 代码

```cpp
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
```