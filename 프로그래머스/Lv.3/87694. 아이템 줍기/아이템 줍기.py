
from collections import deque

def is_surface(maps, x, y):
    dx = [-1, -1, -1, 0, 0, 1, 1, 1]
    dy = [0, -1, 1, 1, -1, 0, -1, 1]
    for i in range(8):
        nx = x + dx[i]
        ny = y + dy[i]
        if maps[ny][nx] == 0:
            return True
    return False

def solution(rectangle, characterX, characterY, itemX, itemY):
    d = [(-1, 0), (0, 1), (1, 0), (0, -1)]
    size = 102
    maps = [[0] * size for _ in range(size)]
    visit = [[False] * size for _ in range(size)]

    for sx, sy, ex, ey in rectangle:
        for y in range(sy * 2, ey * 2 + 1):
            for x in range(sx * 2, ex * 2 + 1):
                maps[y][x] = 1

    cx, cy, ix, iy = characterX * 2, characterY * 2, itemX * 2, itemY * 2
    queue = deque([(cx, cy, 0)])
    visit[cy][cx] = True

    while queue:
        x, y, count = queue.popleft()
        if x == ix and y == iy:
            return count // 2

        for dx, dy in d:
            nx, ny = x + dx, y + dy
            if 0 <= nx < size and 0 <= ny < size \
               and maps[ny][nx] == 1 and not visit[ny][nx] \
               and is_surface(maps, nx, ny):
                visit[ny][nx] = True
                queue.append((nx, ny, count + 1))