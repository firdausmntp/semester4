#include <iostream>
#include <vector>
using namespace std;

void DFS(vector<vector<int>> &graph, vector<bool> &visited, int node)
{
    cout << node << " ";
    visited[node] = true;
    for (int neighbor : graph[node])
    {
        if (!visited[neighbor])
        {
            DFS(graph, visited, neighbor);
        }
    }
}

int main()
{
    vector<vector<int>> graph = {
        {1, 2}, {0, 3, 4}, {0, 3}, {1, 2, 4}, {1, 3}};
    vector<bool> visited(graph.size(), false);
    cout << "DFS Traversal: ";
    DFS(graph, visited, 0);
    return 0;
}