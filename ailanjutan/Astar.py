import heapq

class Node:
    def __init__(self, position, parent=None, g=0, h=0):
        self.position = position # Posisi (x, y)
        self.parent = parent # Parent node
        self.g = g # Jarak dari start node
        self.h = h # Heuristik (jarak ke goal)
        self.f = g + h # Total biaya

    def __lt__(self, other):
        return self.f < other.f # Untuk priority queue

def heuristic(a, b):
    """Menghitung jarak Manhattan sebagai heuristik"""
    return abs(a[0] - b[0]) + abs(a[1] - b[1])

def astar_search(grid, start, goal):
    """Implementasi algoritma A*"""
    open_list = []
    closed_set = set()
    start_node = Node(start, None, 0, heuristic(start, goal))
    heapq.heappush(open_list, (start_node.f, start_node))

    while open_list:
        current_node = heapq.heappop(open_list)[1]
        if current_node.position == goal:
            path = []
            while current_node:
                path.append(current_node.position)
                current_node = current_node.parent
            return path[::-1] # Kembalikan jalur dari start ke goal
        closed_set.add(current_node.position)

        neighbors = [
            (0, -1), (0, 1), (-1, 0), (1, 0) # Atas, Bawah, Kiri, Kanan
        ]

        for dx, dy in neighbors:
            neighbor_pos = (current_node.position[0] + dx, current_node.position[1] + dy)
            
            if 0 <= neighbor_pos[0] < len(grid) and 0 <= neighbor_pos[1] < len(grid[0]) and grid[neighbor_pos[0]][neighbor_pos[1]] == 0 and neighbor_pos not in closed_set:
                g_score = current_node.g + 1
                h_score = heuristic(neighbor_pos, goal)
                neighbor_node = Node(neighbor_pos, current_node, g_score, h_score)
                heapq.heappush(open_list, (neighbor_node.f, neighbor_node))

    return None # Jika tidak ada jalur

# Contoh grid (0 = jalan, 1 = halangan)
grid = [
    [0, 0, 0, 0, 1, 0],
    [0, 1, 1, 0, 1, 0],
    [0, 0, 0, 0, 0, 0],
    [0, 1, 1, 1, 1, 0],
    [0, 0, 0, 0, 0, 0],
]

start = (0, 0) # Titik mulai
goal = (4, 4) # Titik tujuan

path = astar_search(grid, start, goal)

if path:
    print("Jalur terpendek:", path)
else:
    print("Tidak ada jalur yang tersedia")