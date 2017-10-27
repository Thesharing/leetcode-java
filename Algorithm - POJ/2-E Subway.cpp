#include <algorithm>
#include <climits>
#include <cmath>
#include <cstdio>
#include <iostream>

using namespace std;

double a[250];
double b[250];
double map[250][250];
double d[250];
bool final[250];

int main(void)
{
    scanf("%lf %lf %lf %lf", &a[0], &b[0], &a[1], &b[1]);
    int c = 2;
    double x, y;
    bool start_of_new_line = true;
    double distance;
    while (scanf("%lf %lf", &x, &y) != EOF) {
        // cout << x << ' ' << y << ' ' << c << endl;
        if (x > -1 && y > -1) {
            a[c] = x;
            b[c] = y;
            if (!start_of_new_line) {
                distance = sqrt(pow((x - a[c - 1]), 2) + pow((y - b[c - 1]), 2));
                map[c][c - 1] = distance;
                map[c - 1][c] = distance;
            }
            start_of_new_line = false;
            c += 1;
        }
        else {
            start_of_new_line = true;
        }
    }

    for (int i = 0; i < c; i++) {
        map[i][i] = INT_MAX;
        for (int j = i + 1; j < c; j++) {
            if (!(map[i][j] > 0)) {
                distance = 4 * sqrt(pow((a[i] - a[j]), 2) + pow((b[i] - b[j]), 2));
                map[i][j] = distance;
                map[j][i] = distance;
            }
        }
    }

    // for (int i = 0; i < c; i++) {
    //     for (int j = 0; j < c; j++) {
    //         cout << map[i][j] << "\t";
    //     }
    //     cout << endl;
    // }
    
    for (int i = 0; i < c; i++) {
        final[i] = false;
        d[i] = map[0][i];
    }

    d[0] = 0;
    final[0] = true;
    for (int i = 1; i < c; i++) {
        double min = INT_MAX;
        int v = 0;
        for (int w = 0; w < c; w++) {
            if (!final[w]) {
                if (d[w] < min) {
                    v = w;
                    min = d[w];
                }
            }
        }
        final[v] = true;
        for (int w = 0; w < c; w++) {
            if (!final[w] && (min + map[v][w] < d[w])) {
                d[w] = min + map[v][w];
            }
        }
    }
    double t = d[1] / 1000 / 40 * 60;
    int time = (int)(t + 0.5);
    printf("%d\n", time);
	return 0;
}
