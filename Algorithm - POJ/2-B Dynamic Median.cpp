#include <cstdio>
#include <iostream>
#include <queue>

using namespace std;

int main(void)
{
    int group;
    scanf("%d", &group);
    while (group > 0) {
        priority_queue<int> smallq;
        priority_queue<int, vector<int>, greater<int> > bigq;

        int n;
        int count = 0;
        scanf("%d", &n);
        while (n > 0) {
            char ins;
            scanf("%c", &ins);
            while (ins == '\n' || ins == ' ') {
                scanf("%c", &ins);
            }
            if (ins == 'I') {
                int num;
                scanf("%d", &num);
                count++;
                // insert
                if (bigq.size() == 0 || num > bigq.top()) {
                    bigq.push(num);
                }
                else if (smallq.size() == 0 || num < smallq.top()) {
                    smallq.push(num);
                }
                else if (bigq.size() > smallq.size()) {
                    smallq.push(num);
                }
                else {
                    bigq.push(num);
                }
                while (((int)bigq.size() - (int)smallq.size()) > 1) {
                    smallq.push(bigq.top());
                    bigq.pop();
                }
                while (((int)smallq.size() - (int)bigq.size()) > 1) {
                    bigq.push(smallq.top());
                    smallq.pop();
                }
            }
            else if (ins == 'Q') {
                // query
                if (bigq.size() > smallq.size()) {
                    printf("%d\n", bigq.top());
                }
                else {
                    printf("%d\n", smallq.top());
                }
            }
            else if (ins == 'D') {
                // delete
                if (bigq.size() > smallq.size()) {
                    bigq.pop();
                }
                else {
                    smallq.pop();
                }
            }
            n--;
        }
        group--;
    }
    return 0;
}
