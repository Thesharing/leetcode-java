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
        // cout << "Start: " << start << " End: " << end << " 1: " << start << endl;
        y[start] = start;
        return MAX;
    }
    else if ((end - start) == 1) {
        // cout << "Start: " << start << " End: " << end << " 2: " << dist(p[start], p[start + 1]) << endl;
        if (p[start].y < p[end].y) {
            y[start] = start;
            y[end] = end;
        }
        else {
            y[start] = end;
            y[end] = start;
        }
        // cout << "Y:" << endl;
        // for(int i = start; i <= end; i++){
        //     cout << y[i] << ' ' << p[y[i]].x << ' ' << p[y[i]].y << endl;
        // }
        return dist(p[start], p[start + 1]);
    }
    double min = minDouble(closestPair(start, (start + end) / 2), closestPair((start + end) / 2 + 1, end));
    // cout << "Start: " << start <<  " End: " << end << " Min: " << min << endl;
    double left = (double)(p[(start + end) / 2].x) - min;
    double right = (double)(p[(start + end) / 2].x) + min;
    int areaLen = MERGE(start, end, left, right);
    // cout << "Y:" << endl;
    // for(int i = start; i <= end; i++){
    //     cout << y[i] << ' ' << p[y[i]].x << ' ' << p[y[i]].y << endl;
    // }
    // cout << "AREA:" << endl;
    // for(int i = 0; i < areaLen; i++){
    //     cout << area[i] << ' ' << p[area[i]].x << ' ' << p[area[i]].y << endl;
    // }
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
    // cout << "MIN: " << min << endl;
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
        sort(p + 1, p + 2 * n + 1, compareByX);
        printf("%.3lf\n", closestPair(1, 2 * n));
    }
    return 0;
}