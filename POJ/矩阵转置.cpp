#include <iostream>

using namespace std;

int main(void){
	int m, n;
	cin >> m >> n;
	int a[100][100];
	for(int i = 0; i < m; i++)
		for(int j = 0; j < n; j++)
			cin >> a[i][j];
	for(int j = 0; j < n; j++){
		for(int i = 0; i < m; i++)
			if(i < m - 1){
				cout << a[i][j] << ' ';
			}
			else{
				cout << a[i][j];
			}
		cout << endl;
	}
	return 0;
}