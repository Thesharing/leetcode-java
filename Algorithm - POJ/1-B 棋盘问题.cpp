#include <iostream>

using namespace std;

long cal(char map[][9], int col[], int row[], int n, int k, int i){
    if (k == 0){
        return 1;
    }
    long res = 0;
    for (int a = i; a <= n - k; a ++){
        for (int b = 0; b < n; b ++){
            if (map[a][b] == '#' && col[a] != 1 && row[b] != 1){
                col[a] = 1;
                row[b] = 1;
                res += cal(map, col, row, n, k - 1, a + 1); 
                col[a] = 0;
                row[b] = 0;
            }
        }
    }
    return res;
}

int main(void){
    char map[9][9];
    int n, k;
    cin >> n >> k;
    while(n != -1 && k != -1){
        for(int i = 0; i < n; i++){
            cin >> map[i];
        }
        int col[8] = {0};
        int row[8] = {0};
        cout << cal(map, col, row, n, k, 0) << endl;
        cin >> n >> k;
    }
    
}
