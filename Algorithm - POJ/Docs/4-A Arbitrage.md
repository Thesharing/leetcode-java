# Arbitrage

### 描述
Arbitrage is the use of discrepancies in currency exchange rates to transform one unit of a currency into more than one unit of the same currency. For example, suppose that 1 US Dollar buys 0.5 British pound, 1 British pound buys 10.0 French francs, and 1 French franc buys 0.21 US dollar. Then, by converting currencies, a clever trader can start with 1 US dollar and buy 0.5 * 10.0 * 0.21 = 1.05 US dollars, making a profit of 5 percent. 

Your job is to write a program that takes a list of currency exchange rates as input and then determines whether arbitrage is possible or not.

### 输入
The input will contain one or more test cases. Om the first line of each test case there is an integer n (1<=n<=30), representing the number of different currencies. The next n lines each contain the name of one currency. Within a name no spaces will appear. The next line contains one integer m, representing the length of the table to follow. The last m lines each contain the name ci of a source currency, a real number rij which represents the exchange rate from ci to cj and a name cj of the destination currency. Exchanges which do not appear in the table are impossible.
Test cases are separated from each other by a blank line. Input is terminated by a value of zero (0) for n.

### 输出
For each test case, print one line telling whether arbitrage is possible or not in the format "Case case: Yes" respectively "Case case: No".

### 样例输入
```
3
USDollar
BritishPound
FrenchFranc
3
USDollar 0.5 BritishPound
BritishPound 10.0 FrenchFranc
FrenchFranc 0.21 USDollar

3
USDollar
BritishPound
FrenchFranc
6
USDollar 0.5 BritishPound
USDollar 4.9 FrenchFranc
BritishPound 10.0 FrenchFranc
BritishPound 1.99 USDollar
FrenchFranc 0.09 BritishPound
FrenchFranc 0.19 USDollar

0
```

### 样例输出
```
Case 1: Yes
Case 2: No
```

### 代码

```cpp
#include <iostream>
#include <queue>
#include <string>
#include <vector>

using namespace std;

struct currency {
    double value;
    int source;

    currency(double n, int s) : value(n), source(s) {}
};

int n = 0;
int m = 0;

string name[35];
int count[35];
vector<currency> cur[35];

double d[35];
int t[35];
int t_max;
bool in_queue[35];
queue<int> q;

int find_money(string a)
{
    for (int i = 0; i < n; i++) {
        if (!a.compare(name[i])) {
            return i;
        }
    }
    return -1;
}

int main(void)
{
    cin >> n;
    string a, b;
    double c;
    int case_number = 0;
    while (n != 0) {
        bool res = false;
        case_number ++;
        // Read value
        for (int i = 0; i < n; i++) {
            cin >> name[i];
            cur[i].clear();
        }
        cin >> m;
        for (int i = 0; i < m; i++) {
            cin >> a >> c >> b;
            cur[find_money(b)].push_back(currency(c, find_money(a)));
        }

        //SPFA
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                t[j] = 0;
                d[j] = 0;
                in_queue[j] = false;
            }
            t_max = 0;
            q.push(i);
            t[i] = 1;
            d[i] = 1;
            in_queue[i] = true;
            while ((!q.empty()) && (t_max < n)) {
                int cur_node = q.front();
                q.pop();
                in_queue[cur_node] = false;
                for (vector<currency>::iterator it = cur[cur_node].begin(); it != cur[cur_node].end(); it++) {
                    if (d[it->source] < d[cur_node] * it->value) {
                        d[it->source] = d[cur_node] * it->value;
                        if (!in_queue[it->source]) {
                            q.push(it->source);
                            if ((++t[it->source]) > t_max) {
                                t_max = t[it->source];
                            }
                            in_queue[it->source] = true;
                        }
                    }
                }
            }
            if (t_max >= n) {
                res = true;
            }
            while (!q.empty()) {
                q.pop();
            }
        }
        if(res){
            cout << "Case " << case_number << ": Yes" << endl;
        }
        else{
            cout << "Case " << case_number << ": No" << endl;
        }
        cin >> n;
    }
    return 0;
}
```