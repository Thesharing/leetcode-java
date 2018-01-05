#include <iostream>

using namespace std;

int main(void)
{
    int n, s;
    cin >> n >> s;
    int c, y;
    int min_price = 6000;
    long long sum = 0;
    for (int i = 0; i < n; i++) {
        cin >> c >> y;
        if (c < (min_price + s)) {
            min_price = c;
            sum += (long long)c * (long long)y;
        }
        else {
            min_price = min_price + s;
            sum += (long long)min_price * (long long)y;
        }
    }
    printf("%lld\n", sum);
    return 0;
}
