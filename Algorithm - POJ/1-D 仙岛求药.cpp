#include <iostream>
#include <queue> 

using namespace std;

struct pos{
    int x;
    int y;
    int layer;
};

int main (void){
    int m, n;
    cin >> m >> n;
    char map[20][20];
    while(m != 0 && n != 0){
        queue<pos> q;
        bool res = false;
        for(int i = 0; i < m; i++){
            cin >> map[i];
            for(int j = 0; j < n; j++){
                if (map[i][j] == '@'){
                    struct pos p = {i, j, 0};
                    q.push(p);
                }
            }
        }
        while(q.size() > 0){
            struct pos p = q.front();
            q.pop();
            if(p.x - 1 >= 0){
                if (map[p.x - 1][p.y] == '.'){
                    struct pos t = {p.x - 1, p.y, p.layer + 1};
                    q.push(t);
                }
                else if(map[p.x - 1][p.y] == '*'){
                    cout << p.layer + 1 << endl;
                    res = true;
                    break;
                }
            }
            if(p.y + 1 < n){
                if (map[p.x][p.y + 1] == '.'){
                    struct pos t = {p.x, p.y + 1, p.layer + 1};
                    q.push(t);
                }
                else if(map[p.x][p.y + 1] == '*'){
                    cout << p.layer + 1 << endl;
                    res = true;
                    break;
                }
            }
            if(p.y - 1 >= 0){
                if (map[p.x][p.y - 1] == '.'){
                    struct pos t = {p.x, p.y - 1, p.layer + 1};
                    q.push(t);
                }
                else if(map[p.x][p.y - 1] == '*'){
                    cout << p.layer + 1 << endl;
                    res = true;
                    break;
                }
            }
            if(p.x + 1 < m){
                if (map[p.x + 1][p.y] == '.'){
                    struct pos t = {p.x + 1, p.y, p.layer + 1};
                    q.push(t);
                }
                else if(map[p.x + 1][p.y] == '*'){
                    cout << p.layer + 1 << endl;
                    res = true;
                    break;
                }
            }
            map[p.x][p.y] = '!';
        }
        if(!res) {
            cout << -1 << endl;
        }
        cin >> m >> n;
    }
    return 0;
}
