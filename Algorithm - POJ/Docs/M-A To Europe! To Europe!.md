# To Europe! To Europe!

### 描述
Almost everyone in the candidate states wants to `go to Europe'', although most of the people have very vague ideas about what this actually means. Anyway, immediately after the borders are open, the inhabitants will take their cars and trucks and will `go to Europe''. This can cause many troubles, as the roads will be suddenly overloaded by vehicles of various types. You are to help to solve some of these traffic jams. 

Assume a convoy of vehicles has lined up in front of a single lane and one-way bridge over a river. Note that since the street is single lane, no vehicle can overtake any other. The bridge can sustain a given maximum load. To control the traffic on the bridge, operators are stationed on either end of the bridge. The convoy of vehicles is to be divided into groups, such that all the vehicles in any group can cross the bridge together. When a group reaches the other side, the operator on that side of the bridge uses a telephone to inform the operator on this side that the next group can start its journey over the bridge. 

The weight of each vehicle is known. The sum of the weights of the vehicles in any group cannot exceed the maximum load sustainable by the bridge. Associated with each vehicle is the maximum speed with which it can travel over the bridge. The time taken by a group of vehicles is calculated as the time taken by the slowest vehicle in the group to cross the bridge. The problem is to find the minimum amount of time in which the entire convoy can cross the bridge. 

### 输入
The input consists of several test cases. The first line of each test case contains three positive integers (separated by blanks): the first one represents the maximum load that the bridge can sustain b (in tonnes); the second one represents the length of the bridge l (in kms); and the third one is the number of vehicles (n) in the convoy. 

Each of the next n lines of input contains a pair of positive integers, wi and si (separated by blanks), where wi is the weight of the vehicle (in tonnes) and si is the maximum speed (in kmph) with which this vehicle can travel over the bridge. The weights and speeds of the vehicles are specified in the same order as the order in which the vehicles are queued up. You can assume that 1 <= n,b,l,s <= 1000 and any i in [1..n]: wi <= b. 

After the last vehicle, the next test case description begins. The last test case is followed by a line containing three zeros.

### 输出
The output of the program should be a single real number specifying the minimum time in minutes in which the convoy can cross the bridge. The number should be displayed with one digit after the decimal point.

### 样例输入
```
100 5 10
40 25
50 20
50 20
70 10
12 50
9 70
49 30
38 25
27 50
19 70
0 0 0
```

### 样例输出
```
75.0
```

### 代码
```cpp
#include <iostream>
#include <cstdio>
#define NUM 1010

using namespace std;

int w[NUM];
int s[NUM];
double t[NUM];

int main(void)
{
    int b, l, n;
    scanf("%d %d %d", &b, &l, &n);
    while (b != 0 && l != 0 && n != 0) {
        l *= 60;
        for (int i = 1; i <= n; i++) {
            scanf("%d %d", &w[i], &s[i]);
        }
        t[0] = 0;
        for (int i = 1; i <= n; i++) {
            int slowest_speed = s[i];
            int load = w[i];
            t[i] = (double)l / (double)s[i] + t[i - 1];
            for (int j = i - 1; j >= 1; j--) {
                load += w[j];
                if (load > b) {
                    break;
                }
                slowest_speed = slowest_speed < s[j] ? slowest_speed : s[j];
                t[i] = (t[i] < (t[j - 1] + (double)l / (double)slowest_speed)) ? t[i]: (t[j - 1] + (double)l / (double)slowest_speed);
            }
        }
        printf("%.1lf\n", t[n]);
        scanf("%d %d %d", &b, &l, &n);
    }
    return 0;
}
```
