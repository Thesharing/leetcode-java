# Til the Cows Come Home

### 描述
Bessie is out in the field and wants to get back to the barn to get as much sleep as possible before Farmer John wakes her for the morning milking. Bessie needs her beauty sleep, so she wants to get back as quickly as possible.
Farmer John's field has N (2 <= N <= 1000) landmarks in it, uniquely numbered 1..N. Landmark 1 is the barn; the apple tree grove in which Bessie stands all day is landmark N. Cows travel in the field using T (1 <= T <= 2000) bidirectional cow-trails of various lengths between the landmarks. Bessie is not confident of her navigation ability, so she always stays on a trail from its start to its end once she starts it.
Given the trails between the landmarks, determine the minimum distance Bessie must walk to get back to the barn. It is guaranteed that some such route exists.

### 输入
* Line 1: Two integers: T and N
* Lines 2..T+1: Each line describes a trail as three space-separated integers. The first two integers are the landmarks between which the trail travels. The third integer is the length of the trail, range 1..100.

### 输出
* Line 1: A single integer, the minimum distance that Bessie must travel to get from landmark N to landmark 1.

### 样例输入
```
5 5
1 2 20
2 3 30
3 4 20
4 5 20
1 5 100
```

### 样例输出
```
90
```

### 代码

```cpp
#include <iostream>
#include <cstring>

using namespace std;

int map[1000][1000];
int d[1000];
bool final[1000];

int main (void){
    memset(map, 0b01111111, 1000 * 1000 * sizeof(int));
    int MAX = map[0][0];
    int t, n;
    cin >> t >> n;
    int x, y, value;

    // Input
    for (int i = 0; i < t; i++){
        cin >> x >> y;
        cin >> value;
        if (value < map[x - 1][y - 1]) {
            map[x - 1][y - 1] = value;
            map[y - 1][x - 1] = value;
        }
    }

    // Dijkstra Algorithm
    for (int i = 0; i < n; i++){
        final[i] = false;
        d[i] = map[0][i];
    }
    d[0] = 0;
    final[0] = true;
    for(int i = 1; i < n; i++){
        int min = MAX;
        int v = 0;
        for (int w = 0; w < n; w++){
            if(!final[w]){
                if(d[w] < min){
                    v = w;
                    min = d[w];
                }
            }
        }
        final[v] = true;
        for(int w = 0; w < n; w++){
            if(!final[w] && (min + map[v][w] < d[w])){
                d[w] = min + map[v][w];
            }
        }
    }
    cout << d[n - 1] << endl;
    return 0;
}
```