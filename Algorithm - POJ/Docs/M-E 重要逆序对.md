# 重要逆序对

### 描述
给定N个数的序列a1,a2,...aN，定义一个数对(ai, aj)为“重要逆序对”的充要条件为 i < j 且 ai > 2aj。求给定序列中“重要逆序对”的个数。

### 输入
本题有多个测试点，每个测试点分为两行：第一行为序列中数字的个数N（1 ≤ N ≤ 200000），第二行为序列a1, a2 ... aN(0 ≤a ≤ 10000000)，由空格分开。N=0表示输入结束。

### 输出
每个测试点一行，输出一个整数，为给序列中“重要逆序对”的个数。

### 样例输入
```
10
0 9 8 7 6 5 4 3 2 1
0
```

### 样例输出
```
16
```

### 提示
请注意答案范围，如果使用printf输出long long类型，请用%lld

### 代码

```cpp
#include <iostream>
#include <cstdio>
#include <cstring>

using namespace std;

int n;
int num[10000010];
int temp[10000010];

long long mergesort(int a, int b) {
    long long sum = 0;
    if ((b - a) <= 0) {
        return sum;
    }
    sum += mergesort(a, (a + b) / 2);
    sum += mergesort((a + b) / 2 + 1, b);
    int x = a;
    int y = (a + b) / 2 + 1;
    int mid = (a + b) / 2;
    // 重要逆序对，要求i < j 且 ai > 2aj
    // 所以先算一遍有多少ai > 2aj
    while (x <= (a + b) / 2 && y <= b) {
        if (num[x] > 2 * num[y]) {
            sum += mid - x + 1;
            y++;
        }
        else {
            x++;
        }
    }
    // 然后再做Merge Sort
    x = a;
    y = (a + b) / 2 + 1;
    int i = a;
    while (x <= (a + b) / 2 && y <= b) {
        if (num[x] < num[y]) {
            temp[i++] = num[x++];
        }
        else {
            temp[i++] = num[y++];
        }
    }
    // 同样，后面不用再算了，因为前面都已经算过了
    while (x <= (a + b) / 2) {
        temp[i++] = num[x++];
    }
    while (y <= b) {
        temp[i++] = num[y++];
    }
    for (int i = a; i <= b; i++) {
        num[i] = temp[i];
    }
    return sum;
}

int main(void) {
    long long res;
    scanf("%d", &n);
    while (n > 0) {
        for (int i = 0; i < n; i++) {
            scanf("%d", &num[i]);
        }
        res = mergesort(0, n - 1);
        printf("%lld\n", res);
        scanf("%d", &n);
    }
    return 0;
}
```
