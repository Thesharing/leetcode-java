#include <iostream>

using namespace std;


struct node {
	int parent;
	int left;
	int right;
};

void swap(int a, int b, struct node tree[]){
	// Parent
	if(tree[a].parent == tree[b].parent){
		if(tree[tree[a].parent].left == a){
			tree[tree[a].parent].left = b;
			tree[tree[a].parent].right = a;
		}
		else{
			tree[tree[a].parent].right = b;
			tree[tree[a].parent].left = a;
		}
	}
	else{
		if(tree[tree[a].parent].left == a){
			tree[tree[a].parent].left = b;
		}
		else{
			tree[tree[a].parent].right = b;
		}
		int temp = tree[a].parent;
		tree[a].parent = tree[b].parent;
		if(tree[tree[b].parent].left == b){
			tree[tree[b].parent].left = a;
		}
		else {
			tree[tree[b].parent].right = a;
		}
		tree[b].parent = temp;
	}
}

int check(int p, struct node tree[]){
	while(tree[p].left != -1){
		p = tree[p].left;
	}
	return p;
}

void output(struct node tree[], int n){
	for(int i = 0; i < n; i++){
		cout << "Tree: " << i << " Left: " << tree[i].left << " Right: " << tree[i].right << " Parent: " << tree[i].parent << endl;
	}
}

int main (void){
	struct node tree[100];
	int group;
	cin >> group;
	for(int g = 0; g < group; g++){
		int n, m;
		cin >> n >> m;
		tree[0].parent = -1;
		int tag, left, right;
		for(int i = 0; i < n; i++){
			cin >> tag >> left >> right;
			tree[tag].left = left;
			tree[tag].right = right;
			tree[left].parent = tag;
			tree[right].parent = tag;
		}
		int type;
		for(int i = 0; i < m; i++){
			cin >> type;
			if(type == 1){
				int a, b;
				cin >> a >> b;
				swap(a, b, tree);
			}
			else if(type == 2){
				int p;
				cin >> p;
				cout << check(p, tree) << endl;
			}
		}
	}
	return 0;
}
