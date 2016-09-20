#include <iostream>
#include <string>
#include <cstring>
#include <cstdio>
#include <stdbool.h>
#include <queue>

using namespace std;

char ch[200][200];
int walked[200][200];
int m, n;

class Node{
public:
	int x;
	int y;
	int step;
	Node(){
		this->x = 0;
		this->y = 0;
		this->step = 0;
	}
	Node(int xVal, int yVal){
		this->x = xVal;
		this->y = yVal;
		this->step = 0;
	}	
};

int bfs(Node head){
	queue<Node> q;
	q.push(head);
	walked[head.x][head.y] = 1;
	Node cur, next;
	while(!q.empty()){
		cur = q.front();
		q.pop();
		int x = cur.x;
		int y = cur.y;
		if(ch[x][y] == 'E'){
			return cur.step;
		}
		if(x + 1 < m && ch[x + 1][y] != '#' && walked[x + 1][y] == 0) {
			next.x = x + 1;
			next.y = y;
			next.step = cur.step + 1;
			q.push(next);
			walked[x + 1][y] = 1;
		}
		if(x - 1 >= 0 && ch[x - 1][y] != '#' && walked[x - 1][y] == 0) {
			next.x = x - 1;
			next.y = y;
			next.step = cur.step + 1;
			q.push(next);
			walked[x - 1][y] = 1;
		}
		if(y + 1 < n && ch[x][y + 1] != '#' && walked[x][y + 1] == 0){
			next.x = x;
			next.y = y + 1;
			next.step = cur.step + 1;
			q.push(next);
			walked[x][y + 1] = 1;
		}
		if(y - 1 >= 0 && ch[x][y - 1] != '#' && walked[x][y - 1] == 0){
			next.x = x;
			next.y = y - 1;
			next.step = cur.step + 1;
			q.push(next);
			walked[x][y - 1] = 1;
		}
	}
	return 100000;
}

int main(void) {
	int count = 0;
	cin >> count;
	char temp[10];
	int x = 0, y = 0;
	for (int i = 0; i < count; i++) {
		memset(walked, 0, 40000 * sizeof(int));
		cin >> m >> n;
		gets(temp);
		for (int i = 0; i < m; i++) {
			gets(ch[i]);
		}
		bool found = false;
		for(int i = 0; i < m && !found; i++){
			for(int j = 0; j < n && !found; j++){
				if(ch[i][j] == 'S'){
					x = i;
					y = j;
					found = true;
				}
			}
		}
		Node head(x, y);
		int res = bfs(head);
		if(res < 100000){
			cout << res << endl;
		}
		else {
			cout << "oop!" << endl;
		}
	}
	return 0;
}

/* http://noi.openjudge.cn/ch0205/7218/ 
* BFS广度优先搜索
* 使用DFS会TLE，这里由于要找最短路程，所以广度找就好 */
