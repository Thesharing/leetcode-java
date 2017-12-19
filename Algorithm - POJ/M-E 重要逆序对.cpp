#include <iostream>
#include <cstdio>
#include <cstring>

using namespace std;

int n;
int num[10000010];
int temp[10000010];

long long merge_sort(int a, int b) {
	long long sum = 0;
	if ((b - a) <= 0) {
		return sum;
	}
	sum += merge_sort(a, (a + b) / 2);
	sum += merge_sort((a + b) / 2 + 1, b);
	// printf("%lld", sum);
	int x = a;
	int y = (a + b) / 2 + 1;
	int mid = (a + b) / 2;
	while (x <= (a + b) / 2 && y <= b) {
		if (num[x] > 2 * num[y]) {
			sum += mid - x + 1;
			y++;
		}
		else {
			x++;
		}
	}
	x = a;
	y = (a + b) / 2 + 1;
	int i = a;
	while (x <= (a + b) / 2 && y <= b) {
		if (num[x] < num[y]) {
			temp[i++] = num[x++];
		}
		else {
			temp[i++] = num[y++];
		}
	}
	while (x <= (a + b) / 2) {
		temp[i++] = num[x++];
	}
	x = (a + b) / 2;
	while (y <= b) {
		temp[i++] = num[y++];
	}
	for (int i = a; i <= b; i++) {
		num[i] = temp[i];
	}
	return sum;
}

int main(void) {
	long long res;
	scanf("%d", &n);
	while (n > 0) {
		for (int i = 0; i < n; i++) {
			scanf("%d", &num[i]);
		}
		res = merge_sort(0, n - 1);
		printf("%lld\n", res);
		scanf("%d", &n);
	}
	return 0;
}