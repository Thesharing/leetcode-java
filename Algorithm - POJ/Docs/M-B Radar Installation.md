# Radar Installation

### 描述
Assume the coasting is an infinite straight line. Land is in one side of coasting, sea in the other. Each small island is a point locating in the sea side. And any radar installation, locating on the coasting, can only cover d distance, so an island in the sea can be covered by a radius installation, if the distance between them is at most d.

We use Cartesian coordinate system, defining the coasting is the x-axis. The sea side is above x-axis, and the land side below. Given the position of each island in the sea, and given the distance of the coverage of the radar installation, your task is to write a program to find the minimal number of radar installations to cover all the islands. Note that the position of an island is represented by its x-y coordinates.

Figure A Sample Input of Radar Installations

### 输入
The input consists of several test cases. The first line of each case contains two integers n (1<=n<=1000) and d, where n is the number of islands in the sea and d is the distance of coverage of the radar installation. This is followed by n lines each containing two integers representing the coordinate of the position of each island. Then a blank line follows to separate the cases.

The input is terminated by a line containing pair of zeros

### 输出
For each test case output one line consisting of the test case number followed by the minimal number of radar installations needed. "-1" installation means no solution for that case.

### 样例输入
```
3 2
1 2
-3 1
2 1

1 2
0 2

0 0
```

### 样例输出
```
Case 1: 2
Case 2: 1
```

### 代码

```cpp
#include <algorithm>
#include <cmath>
#include <cstdio>
#include <iostream>
#include <vector>

using namespace std;

int d, n;

struct point {
    int x, y;
    double start, end;

    // Here we assume y is always smaller than d
    // We'll check whether y is larger than d when input
    point(int x, int y) : x(x), y(y)
    {
        double range = sqrt(pow(double(d), 2.0) - pow(double(y), 2.0));
        start = double(x) - range;
        end = double(x) + range;
    }

    bool operator<(const point &p) const
    {
        return start < p.start;
    }

    bool operator>(const point &p) const
    {
        return start > p.start;
    }
};

int main(void)
{
    cin >> n >> d;
    int case_num = 0;
    while (n != 0 && d != 0) {
        case_num++;
        vector<point> v;
        int x, y;
        bool has_result = true;
        for (int i = 0; i < n; i++) {
            cin >> x >> y;
            if (y > d) {
                has_result = false;
            }
            v.push_back(point(x, y));
        }
        if (!has_result) {
            cout << "Case " << case_num << ": " << -1 << endl;
        }
        else {
            sort(v.begin(), v.end());
            double radar_x = -1000000000;
            int radar_num = 0;
            for (vector<point>::iterator it = v.begin(); it != v.end(); it++) {
                if (it->start > radar_x) {
                    radar_num++;
                    radar_x = it->end;
                }
                else {
                    if (it->end < radar_x) {
                        radar_x = it->end;
                    }
                }
            }
            cout << "Case " << case_num << ": " << radar_num << endl;
        }
        cin >> n >> d;
    }
    return 0;
}
```
