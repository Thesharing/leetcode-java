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