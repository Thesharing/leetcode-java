#include <iostream>
#include <cstring>

using namespace std;

int map[1000][1000];
int d[1000];
bool final[1000];

int main (void){
    memset(map, 0b01111111, 1000 * 1000 * sizeof(int));
    int MAX = map[0][0];
    int t, n;
    cin >> t >> n;
    int x, y, value;

    // Input
    for (int i = 0; i < t; i++){
        cin >> x >> y;
        cin >> value;
        if (value < map[x - 1][y - 1]) {
            map[x - 1][y - 1] = value;
            map[y - 1][x - 1] = value;
        }
    }

    // Dijkstra Algorithm
    for (int i = 0; i < n; i++){
        final[i] = false;
        d[i] = map[0][i];
    }
    d[0] = 0;
    final[0] = true;
    for(int i = 1; i < n; i++){
        int min = MAX;
        int v = 0;
        for (int w = 0; w < n; w++){
            if(!final[w]){
                if(d[w] < min){
                    v = w;
                    min = d[w];
                }
            }
        }
        final[v] = true;
        for(int w = 0; w < n; w++){
            if(!final[w] && (min + map[v][w] < d[w])){
                d[w] = min + map[v][w];
            }
        }
    }
    cout << d[n - 1] << endl;
    return 0;
}
