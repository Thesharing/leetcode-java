#include <iostream>
#include <cstdio>
#include <queue>

using namespace std;

struct table
{
	int neighbor;
	int same;
	struct table *next;
};

struct head
{
	int type;
	bool visited;
	struct table *head;
	struct table *end;
};

struct connection
{
	int a;
	int b;
	int s;
};

struct connection conn[100000];
struct head h[1000];

int main(void)
{
	int m, n;
	int i = 0;
	int a = 0;
	queue<int> q;
	while (scanf("%d %d", &m, &n) != EOF)
	{
		bool res = true;
		for (i = 0; i < m; i++)
		{
			h[i].visited = false;
			h[i].head = new struct table;
			h[i].head->next = NULL;
			h[i].type = 0;
			h[i].end = h[i].head;
		}
		for (i = 0; i < n; i++)
		{
			scanf("%d %d %d", &conn[i].a, &conn[i].b, &conn[i].s);
			a = conn[i].a;
			h[a].end->next = new struct table;
			h[a].end = h[conn[i].a].end->next;
			h[a].end->neighbor = conn[i].b;
			h[a].end->same = conn[i].s;
			h[a].end->next = NULL;
		}
		for (i = 0; i < m; i++)
		{
			if (h[i].visited != true && h[i].head->next != NULL)
			{
				q.push(i);
				h[i].visited = true;
			}
			while (!q.empty())
			{
				int cur = q.front();
				q.pop();
				struct table *c = h[cur].head;
				while (c->next != NULL)
				{
					c = c->next;
					if (!h[c->neighbor].visited)
					{
						h[c->neighbor].visited = true;
						if (c->same == 0)
						{
							h[c->neighbor].type = h[cur].type;
						}
						else
						{
							h[c->neighbor].type = 1 - h[cur].type;
						}
						q.push(c->neighbor);
					}
				}
			}
		}
		for (int i = 0; i < n; i++)
		{
			if(conn[i].s == 0){
				if(h[conn[i].a].type != h[conn[i].b].type){
					res = false;
					break;
				}
			}
			else{
				if(h[conn[i].a].type == h[conn[i].b].type){
					res = false;
					break;
				}
			}
		}
		if (res)
		{
			printf("YES\n");
		}
		else
		{
			printf("NO\n");
		}
	}
	return 0;
}
