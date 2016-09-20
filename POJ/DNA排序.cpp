#include <iostream>
#include <cstring>

using namespace std;

int main(void){
	int n = 0;
	cin >> n;
	int m = 0;
	cin >> m;
	char temp[10];
	gets(temp);
	char ch[100][50] ;
	int count[100];
	memset(count, 0, 100 * sizeof(int));
	for(int i = 0; i < m; i++){
		cin >> ch[i];
		for(int j = 0; j < n; j++){
			for(int k = j; k < n; k++){
				if(ch[i][j] > ch[i][k])
					count[i]++;
			}
		}
	}
	int num = 100000;
	int loc = 0;
	for(int i = 0; i < m; i++){
		num = 100000;
		for(int j = 0; j < m; j++){
			if(count[j] < num){
				num = count[j];
				loc = j;
			}
		}
		cout << ch[loc] << endl;
		count[loc] = 100000;
	}
	return 0;
}

/* http://bailian.openjudge.cn/practice/4086/ */