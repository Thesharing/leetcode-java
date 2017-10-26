#include <iostream>
#include <cmath>

using namespace std;

int max(int num){
	int i;
	for (i = 15; i >= 0; i --) {
		if (int(pow(2, i) + 0.5) <= num) {
			return i;
		}
	}
	return 0;
}

int main(void){
	char map[16][30] = {"(0)", "", "(2)", "(2+2(0))", "(2(2))", "(2(2)+2(0))", "(2(2)+2)", "(2(2)+2+2(0))",
						"(2(2+2(0)))", "(2(2+2(0))+2(0))", "(2(2+2(0))+2)", "(2(2+2(0))+2+2(0))", "(2(2+2(0))+2(2))",
						"(2(2+2(0))+2(2)+2(0))", "(2(2+2(0))+2(2)+2)","(2(2+2(0))+2(2)+2(2)+2+2(0)))"};
	int num;
	cin >> num;
	int n = max(num);
	for(int i = n; i >= 0; i--){
		int diff = num - (int)(pow(2, i) + 0.5);
		if(diff > 0){
			cout << "2" << map[i] << "+";
			num = diff;
		}
		else if(diff == 0){
			cout << "2" << map[i] << endl;
			break;
		}
	}
	return 0;
}
