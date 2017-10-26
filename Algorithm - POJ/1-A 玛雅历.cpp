#include <iostream>
#include <cstdlib>
#include <cstring>

using namespace std;

int convertMonthToInt(char str[], char habb[][10]){
	int res = -1;
	for (int i = 0; i < 19; i++){
		if (strcmp(str, habb[i]) == 0) {
			res = i;
		}
	}
	return res;
}

int main(void){
	char habb[19][10] = {"pop", "no", "zip", "zotz", "tzec", "xul", "yoxkin", "mol", "chen", "yax", "zac", "ceh", "mac", "kankin", "muan", "pax", "koyab", "cumhu", "uayet"};
	char tzolkin[20][10] = {"imix", "ik", "akbal", "kan", "chicchan", "cimi", "manik", "lamat", "muluk", "ok", "chuen", "eb", "ben", "ix", "mem", "cib", "caban", "eznab", "canac", "ahau"};
	int count;
	cin >> count;
	cout << count << endl;
	char dayStr[10];
	int day;
	char monthStr[10];
	int month;
	int year;
	for (int i = 0; i < count; i++){
		cin >> dayStr >> monthStr >> year;
		dayStr[strlen(dayStr) - 1] = 0;
		day = atoi(dayStr);
		month = convertMonthToInt(monthStr, habb);
		int totalDay = year * 365 + month * 20 + day;
		int newYear = totalDay / 260;
		int dayOfYear = totalDay % 260;
		int newMonth = dayOfYear % 13 + 1;
		int newDay = dayOfYear % 20;
		cout << newMonth << ' ' << tzolkin[newDay] << ' ' << newYear << endl; 
	}
	return 0;
} 
