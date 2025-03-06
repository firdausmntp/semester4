#include <iostream>
#include <queue>
#include <vector>
using namespace std;

struct Node
{
    int id;
    int h; // Heuristic value

    bool operator>(const Node &other) const
    {
        return h > other.h;
    }
};

void GreedyBFS(vector<vector<int>> &graph, vector<int> &heuristics, int start)
{
    priority_queue<Node, vector<Node>, greater<Node>> pq;
    vector<bool> visited(graph.size(), false);
    pq.push({start, heuristics[start]});

    while (!pq.empty())
    {
        Node current = pq.top();
        pq.pop();
        if (visited[current.id])
            continue;
        visited[current.id] = true;
        cout << current.id << " ";

        for (int neighbor : graph[current.id])
        {
            if (!visited[neighbor])
            {
                pq.push({neighbor, heuristics[neighbor]});
            }
        }
    }
}

int main()
{
    vector<vector<int>> graph = {
        {1, 2}, {0, 3, 4}, {0, 3}, {1, 2, 4}, {1, 3}};
    vector<int> heuristics = {3, 2, 1, 4, 5};
    cout << "Greedy BFS Traversal: ";
    GreedyBFS(graph, heuristics, 0);
    return 0;
}