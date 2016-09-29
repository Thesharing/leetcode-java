#include <iostream>
#include <string.h>
#include <algorithm>

using namespace std;

struct data{
	char ch[12];
};

bool function(struct data a, struct data b){
	if(strcmp(a.ch, b.ch) >= 0)
		return false;
	else
		return true;
}

int main(void){
	int count = 0;
	cin >> count;
	struct data str[10000];
	for(int i = 0; i < count; i++){
		bool res = true;
		int num = 0;
		cin >> num;
		for(int j = 0; j < num; j++){
			cin >> str[j].ch;
		}
		sort(str, str + num, function);
		for(int j = 1; j < num; j++){
			int a = strlen(str[j - 1].ch);
			int b = strlen(str[j].ch);
			if(a <= b && strncmp(str[j - 1].ch, str[j].ch, a) == 0){
				res = false;
				break;
			}
		}
		if(res){
			cout << "YES" << endl;
		}
		else{
			cout << "NO" << endl;
		}
	}
	return 0;
}