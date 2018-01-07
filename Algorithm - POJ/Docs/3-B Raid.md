# Raid

### 描述
After successive failures in the battles against the Union, the Empire retreated to its last stronghold. Depending on its powerful defense system, the Empire repelled the six waves of Union's attack. After several sleepless nights of thinking, Arthur, General of the Union, noticed that the only weakness of the defense system was its energy supply. The system was charged by N nuclear power stations and breaking down any of them would disable the system.

The general soon started a raid to the stations by N special agents who were paradroped into the stronghold. Unfortunately they failed to land at the expected positions due to the attack by the Empire Air Force. As an experienced general, Arthur soon realized that he needed to rearrange the plan. The first thing he wants to know now is that which agent is the nearest to any power station. Could you, the chief officer, help the general to calculate the minimum distance between an agent and a station?

### 输入
The first line is a integer T representing the number of test cases.
Each test case begins with an integer N (1 ≤ N ≤ 1000).
The next N lines describe the positions of the stations. Each line consists of two integers X (0 ≤ X ≤ 1000000000) and Y (0 ≤ Y ≤ 1000000000) indicating the positions of the station.
The next following N lines describe the positions of the agents. Each line consists of two integers X (0 ≤ X ≤ 1000000000) and Y (0 ≤ Y ≤ 1000000000) indicating the positions of the agent. 　

### 输出
For each test case output the minimum distance with precision of three decimal placed in a separate line.

### 样例输入
```
2
4
0 0
0 1
1 0
1 1
2 2
2 3
3 2
3 3
4
0 0
0 0
0 0
0 0
0 0
0 0
0 0
0 0
```

### 样例输出
```
1.414
0.000
```

### 代码

```cpp
#include <algorithm>
#include <cmath>
#include <cstdio>
#include <iostream>
#include <vector>

using namespace std;

double MAX = 100000000000;

struct point {
    int x;
    int y;
    bool type; // true: station; false: agent;
};

struct point p[1050];
int y[1050];
int t[1050];
int area[1050];


bool compareByX(const point &a, const point &b)
{
    return a.x < b.x;
}

bool compareByY(const point &a, const point &b)
{
    return a.y < b.x;
}

int minInt(int a, int b)
{
    return a < b ? a : b;
}

double minDouble(double a, double b)
{
    return a < b ? a : b;
}

int MERGE(int start, int end, double left, double right)
{
    int start1 = start, end1 = (start + end) / 2;
	int start2 = (start + end) / 2 + 1, end2 = end;
	int k = start;
	while (start1 <= end1 && start2 <= end2)
        t[k++] = p[y[start1]].y < p[y[start2]].y ? y[start1++] : y[start2++];
	while (start1 <= end1)
		t[k++] = y[start1++];
	while (start2 <= end2)
        t[k++] = y[start2++];
    int i = 0;
	for (k = start; k <= end; k++){
        if(p[t[k]].x >= left && p[t[k]].x <= right){
            area[i++] = t[k];
        }
        y[k] = t[k];
    }
    return i;
}

double dist(point &a, point &b)
{
    if (a.type == b.type) {
        return MAX;
    }
    else {
        return sqrt(pow((double)(a.x - b.x), 2) + pow((double)(a.y - b.y), 2));
    }
}

double closestPair(int start, int end)
{
    if ((end - start) <= 0) {
        y[start] = start;
        return MAX;
    }
    else if ((end - start) == 1) {
        if (p[start].y < p[end].y) {
            y[start] = start;
            y[end] = end;
        }
        else {
            y[start] = end;
            y[end] = start;
        }
        return dist(p[start], p[start + 1]);
    }
    // 分治为左边和右边（已经基于X坐标排序过）
    double min = minDouble(closestPair(start, (start + end) / 2), closestPair((start + end) / 2 + 1, end));
    // 然后划分中间区域
    double left = (double)(p[(start + end) / 2].x) - min;
    double right = (double)(p[(start + end) / 2].x) + min;
    //
    int areaLen = MERGE(start, end, left, right);
    for (int i = 0; i < areaLen; i++) {
        for (int j = i + 1; j < areaLen; j++) {
            if (p[area[j]].y >= p[area[i]].y + min){
                break;
            }
            double d = dist(p[area[i]], p[area[j]]);
            if (d < min) {
                min = d;
            }
        }
    }
    return min;
}

int main(void)
{
    int t;
    scanf("%d", &t);
    while (t--) {
        int n;
        int x, y;
        scanf("%d", &n);
        for (int i = 1; i <= n; i++) {
            scanf("%d %d", &p[i].x, &p[i].y);
            p[i].type = true;
        }
        for (int i = n + 1; i <= 2 * n; i++) {
            scanf("%d %d", &p[i].x, &p[i].y);
            p[i].type = false;
        }
        // 基于X坐标排序
        sort(p + 1, p + 2 * n + 1, compareByX);
        printf("%.3lf\n", closestPair(1, 2 * n));
    }
    return 0;
}
```