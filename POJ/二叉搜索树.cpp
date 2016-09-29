#include <iostream>

using namespace std;

class TreeNode{
public:
	int val;
	TreeNode* left;
	TreeNode* right;
	TreeNode(int val){
		this->val = val;
		this->left = NULL;
		this->right = NULL;
	}
};

void build(TreeNode* node, int val){
	if(val < node->val){
		if(!node->left){
			node->left = new TreeNode(val);
		}
		else{
			build(node->left, val);
		}
	}
	else if(val > node->val){
		if(!node->right){
			node->right = new TreeNode(val);
		}
		else{
			build(node->right, val);
		}
	}
}

void display(TreeNode* node){
	if(node){
		cout << node->val << " ";
		display(node->left);
		display(node->right);
	}
}

int main(void){
	int temp = 0;
	cin >> temp;
	TreeNode * root = new TreeNode(temp);
	while(cin >> temp){
		build(root, temp);
	}
	display(root);
	cout << endl;
}

/* http://bailian.openjudge.cn/practice/4079/ */