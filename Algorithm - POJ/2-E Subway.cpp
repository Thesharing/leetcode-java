/*

描述
You have just moved from a quiet Waterloo neighbourhood to a big, noisy city. Instead of getting to ride your bike to school every day, you now get to walk and take the subway. Because you don't want to be late for class, you want to know how long it will take you to get to school. 
You walk at a speed of 10 km/h. The subway travels at 40 km/h. Assume that you are lucky, and whenever you arrive at a subway station, a train is there that you can board immediately. You may get on and off the subway any number of times, and you may switch between different subway lines if you wish. All subway lines go in both directions.

输入
Input consists of the x,y coordinates of your home and your school, followed by specifications of several subway lines. Each subway line consists of the non-negative integer x,y coordinates of each stop on the line, in order. You may assume the subway runs in a straight line between adjacent stops, and the coordinates represent an integral number of metres. Each line has at least two stops. The end of each subway line is followed by the dummy coordinate pair -1,-1. In total there are at most 200 subway stops in the city.

输出
Output is the number of minutes it will take you to get to school, rounded to the nearest minute, taking the fastest route.

样例输入
0 0 10000 1000
0 200 5000 200 7000 200 -1 -1 
2000 600 5000 600 10000 600 -1 -1

样例输出
21

*/

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

    // Read the input and calculate the distance of subway line
    while (scanf("%lf %lf", &x, &y) != EOF) {
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

    // Calculate the distance of walking
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
    
    // Dijkstra - Preparation
    for (int i = 0; i < c; i++) {
        final[i] = false;
        d[i] = map[0][i];
    }

    // Dijkstra - Greedy Part
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

    // The goal is at point 1
    double t = d[1] / 1000 / 40 * 60;
    int time = (int)(t + 0.5);
    printf("%d\n", time);
	return 0;
}
