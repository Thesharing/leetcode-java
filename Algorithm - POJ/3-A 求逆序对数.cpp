/*

描述
对于一个长度为N的整数序列A，满足i < j 且 Ai > Aj.的数对(i,j)称为整数序列A的一个逆序
请求出整数序列A的所有逆序对个数

输入
输入包含多组测试数据，每组测试数据有两行
第一行为整数N(1 <= N <= 20000)，当输入0时结束
第二行为N个整数，表示长为N的整数序列

输出
每组数据对应一行，输出逆序对的个数

样例输入
5
1 2 3 4 5
5
5 4 3 2 1
1
1
0

样例输出
0
10
0


*/

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
        // 最重要的一步: Count
        if (src[x] > src[y]) {
            // x以及x之后的都是逆序对
            res += (a + b + 1) / 2 - x;
            dst[z++] = src[y++];
        }
        else {
            dst[z++] = src[x++];
        }
    }
    // 后面的不可能再有逆序对了，因为前面都算过了
    while (x < (a + b + 1) / 2) {
        dst[z++] = src[x++];
    }
    while (y < b) {
        dst[z++] = src[y++];
    }
    // 复制一下
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