# Dining

### 描述
Cows are such finicky eaters. Each cow has a preference for certain foods and drinks, and she will consume no others.

Farmer John has cooked fabulous meals for his cows, but he forgot to check his menu against their preferences. Although he might not be able to stuff everybody, he wants to give a complete meal of both food and drink to as many cows as possible.

Farmer John has cooked F (1 ≤ F ≤ 100) types of foods and prepared D (1 ≤ D ≤ 100) types of drinks. Each of his N (1 ≤ N ≤ 100) cows has decided whether she is willing to eat a particular food or drink a particular drink. Farmer John must assign a food type and a drink type to each cow to maximize the number of cows who get both.

Each dish or drink can only be consumed by one cow (i.e., once food type 2 is assigned to a cow, no other cow can be assigned food type 2).

### 输入
Line 1: Three space-separated integers: N, F, and D
Lines 2..N+1: Each line i starts with a two integers Fi and Di, the number of dishes that cow i likes and the number of drinks that cow i likes. The next Fi integers denote the dishes that cow i will eat, and the Di integers following that denote the drinks that cow i will drink.

### 输出
Line 1: A single integer that is the maximum number of cows that can be fed both food and drink that conform to their wishes

### 样例输入
```
4 3 3
2 2 1 2 3 1
2 2 2 3 1 2
2 2 1 3 1 2
2 1 1 3 3
```

### 样例输出
```
3
```

### 提示
One way to satisfy three cows is:
Cow 1: no meal
Cow 2: Food #2, Drink #2
Cow 3: Food #1, Drink #1
Cow 4: Food #3, Drink #3
The pigeon-hole principle tells us we can do no better since there are only three kinds of food or drink. Other test data sets are more challenging, of course.

### 代码

```cpp
#include <cstring>
#include <iostream>
#include <queue>

using namespace std;

int MAX_VALUE = 10000;
int n, f, d;
int dist;
// n -> cow; m -> stall;
int capacity[410][410];
int former[410];
int inqueue[410];
queue<int> bfs_queue;

bool bfs()
{
    memset(inqueue, 0, sizeof(inqueue));
    memset(former, 0, sizeof(former));
    while (!bfs_queue.empty()) {
        bfs_queue.pop();
    }
    bfs_queue.push(1);
    inqueue[1] = 1;
    while (!bfs_queue.empty()) {
        int cur = bfs_queue.front();
        bfs_queue.pop();
        if (cur == dist) {
            return true;
        }
        for (int i = 1; i <= dist; i++) {
            if (inqueue[i] == 0 && capacity[cur][i] > 0) {
                bfs_queue.push(i);
                inqueue[i] = 1;
                former[i] = cur;
            }
        }
    }
    return false;
}

int main(void)
{
    cin >> n >> f >> d;
    int fi, di, food, drink;
    dist = 1 + f + n * 2 + d + 1;
    memset(capacity, 0, sizeof(capacity));
    for (int cow = 1; cow <= n; cow++) {
        cin >> fi >> di;
        for (int i = 0; i < fi; i++) {
            cin >> food;
            capacity[1 + food][1 + f + cow] = 1;
        }
        for (int i = 0; i < di; i++) {
            cin >> drink;
            capacity[1 + f + n + cow][1 + f + n * 2 + drink] = 1;
        }
        capacity[1 + f + cow][1 + f + n + cow] = 1;
    }
    for (int i = 1; i <= f; i++) {
        capacity[1][1 + i] = 1;
    }
    for (int i = 1; i <= d; i++) {
        capacity[1 + f + n * 2 + i][dist] = 1;
    }
    // cout << "  S 1 2 3 1 2 3 4 1 2 3 4 1 2 3 E" << endl;
    // char ch[] = {' ', 'S', '1', '2', '3', '1', '2', '3', '4', '1', '2', '3', '4', '1', '2', '3', 'E'};
    // for (int i = 1; i <= dist; i++) {
    //     cout << ch[i] << ' ';
    //     for (int j = 1; j <= dist; j++) {
    //         cout << capacity[i][j] << ' ';
    //     }
    //     cout << endl;
    // }
    int max_flow = 0;
    while (bfs()) {
        // for (int i = dist; i > 1; i = former[i]) {
        //     cout << i << ' ';
        // }
        // cout << endl;
        int bottleneck = 2 * MAX_VALUE;
        for (int i = dist; i > 1; i = former[i]) {
            if (bottleneck > capacity[former[i]][i]) {
                bottleneck = capacity[former[i]][i];
            }
        }
        for (int i = dist; i > 1; i = former[i]) {
            capacity[former[i]][i] -= bottleneck;
            capacity[i][former[i]] += bottleneck;
        }
        max_flow += bottleneck;
    }
    cout << max_flow << endl;
    return 0;
}
```
