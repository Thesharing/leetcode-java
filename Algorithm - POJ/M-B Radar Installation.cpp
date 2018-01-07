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