#include <iostream> 

using namespace std;

int a[1000][1000];

int main(void){
	int count;
	cin >> count;
	for(int i = 0; i < count; i++){
		for(int j = 0; j < count; j++){
			cin >> a[i][j];
		}
	}
	int found = 0;
	int x1 = 0;
	int y1 = 0;
	for(int i = 0; i < count && !found; i++){
		for(int j = 0; j < count && !found; j++){
			if(a[i][j] == 0){
				x1 = i;
				y1 = j;
				found = 1;
			}
		}
	}
	int x2 = 0;
	int y2 = 0;
	for(int i = count - 1; i >= 0 && found; i--){
		for(int j = count -1; j>=0 && found; j--){
			if(a[i][j] == 0){
				x2 = i;
				y2 = j;
				found = 0;
			}
		}
	}
	if((x2 - x1 <= 0) || (y2 - y1 <= 0)){
		cout << 0 <<endl;
	}
	else{
		cout << (x2 - x1 - 1)*(y2 - y1 - 1) << endl;
	}
	return 0;
}