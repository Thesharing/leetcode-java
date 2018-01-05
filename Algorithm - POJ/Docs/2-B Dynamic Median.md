# Dynamic Median

### 描述
设计一个数据结构，初始为空，支持以下操作：

（1）增加一个元素，要求在log(n)时间内完成，其中n是该数据结构中当前元素的个数。注意：数据结构中允许有重复的元素。

（2）返回当前元素集合的中位数，要求在常数时间内完成。如果当前元素的个数为偶数，那么返回下中位数（即两个中位数中较小的一个）。

（3）删除中位数，要求在log(n)时间内完成。

### 输入
输入的第一行是一个自然数T，代表测试数据的组数((1 ≤ T ≤ 600))。每组测试数据的第一行是个自然数N，代表操作的次数，1<=N<=10000。后面的N行中的每行代表一个操作，每次操作首先输入一个单字符代表操作的类型：

I表示插入，后面跟着输入一个正整数（这是唯一带有输入数值的操作）。
Q表示查询，输出当前的中位数（这是唯一产生输出的操作）。
D表示删除当前的中位数。

输入保证是正确的：查询时集合保证不为空（即中位数是存在的），删除时保证集合中有足够可供删除的元素。

### 输出
每次查询操作Q时输出的中位数，每次输出单独占一行。

### 样例输入
```
1
8
I 4
I 3
I 5
Q  
D
I 10
I 2
Q
```

### 样例输出
```
4
3
```

### 提示
123

### 代码

```cpp
#include <cstdio>
#include <iostream>
#include <queue>

using namespace std;

int main(void)
{
    int group;
    scanf("%d", &group);
    while (group > 0) {
        priority_queue<int> smallq;
        priority_queue<int, vector<int>, greater<int> > bigq;

        int n;
        int count = 0;
        scanf("%d", &n);
        while (n > 0) {
            char ins;
            scanf("%c", &ins);
            while (ins == '\n' || ins == ' ') {
                scanf("%c", &ins);
            }
            if (ins == 'I') {
                int num;
                scanf("%d", &num);
                count++;
                // insert
                if (bigq.size() == 0 || num > bigq.top()) {
                    bigq.push(num);
                }
                else if (smallq.size() == 0 || num < smallq.top()) {
                    smallq.push(num);
                }
                else if (bigq.size() > smallq.size()) {
                    smallq.push(num);
                }
                else {
                    bigq.push(num);
                }
                while (((int)bigq.size() - (int)smallq.size()) > 1) {
                    smallq.push(bigq.top());
                    bigq.pop();
                }
                while (((int)smallq.size() - (int)bigq.size()) > 1) {
                    bigq.push(smallq.top());
                    smallq.pop();
                }
            }
            else if (ins == 'Q') {
                // query
                if (bigq.size() > smallq.size()) {
                    printf("%d\n", bigq.top());
                }
                else {
                    printf("%d\n", smallq.top());
                }
            }
            else if (ins == 'D') {
                // delete
                if (bigq.size() > smallq.size()) {
                    bigq.pop();
                }
                else {
                    smallq.pop();
                }
            }
            n--;
        }
        group--;
    }
    return 0;
}
```
