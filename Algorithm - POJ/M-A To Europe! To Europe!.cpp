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