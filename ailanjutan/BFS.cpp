#include <iostream>
#include <queue>
#include <vector>
using namespace std;

void BFS(vector<vector<int>> &graph, int start)
{
    queue<int> q;
    vector<bool> visited(graph.size(), false);
    q.push(start);
    visited[start] = true;

    while (!q.empty())
    {
        int node = q.front();
        q.pop();
        cout << node << " ";
        for (int neighbor : graph[node])
        {
            if (!visited[neighbor])
            {
                q.push(neighbor);
                visited[neighbor] = true;
            }
        }
    }
}

int main()
{
    vector<vector<int>> graph = {
        {1, 2}, {0, 3, 4}, {0, 3}, {1, 2, 4}, {1, 3}};
    cout << "BFS Traversal: ";
    BFS(graph, 0);
    return 0;
}