#include <cstdio>
#include <iostream>

using namespace std;

int res[1000];
int num[1000];
int n;

int findLongestSeq()
{
    for (int i = 0; i < n; i++) {
        int max = 1;
        for (int j = 0; j < i; j++) {
            if (num[i] > num[j]) {
                if (max < (res[j] + 1)) {
                    max = res[j] + 1;
                }
            }
        }
        res[i] = max;
    }
    int max = 0;
    for (int i = 0; i < n; i++) {
        if (max < res[i]) {
            max = res[i];
        }
    }
    return max;
}

int main(void)
{
    scanf("%d", &n);
    for (int i = 0; i < n; i++) {
        scanf("%d", &num[i]);
    }
    printf("%d\n", findLongestSeq());
    // for(int i = 0; i < n; i++){
    //     printf("%d ", res[i]);
    // }
    return 0;
}