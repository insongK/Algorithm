import sys
from collections import deque
import copy

C, R, H = map(int, sys.stdin.readline().split())
farms = []
visit = [[[False] * C for _ in range(R)] for _ in range(H)]

for _ in range(H):
    farm = []
    for _ in range(R):
        farm.append(list(map(int, sys.stdin.readline().split())))
    farms.append(farm)

empty = []
tomato = deque()

for i in range(H):
    for j in range(R):
        for k in range(C):
            if farms[i][j][k] == -1:
                empty.append((i, j, k))
            elif farms[i][j][k] == 1:
                tomato.append((i, j, k))

empty_count = len(empty)


def BFS(tomato, new_tomato):
    while tomato:
        z, x, y = tomato.popleft()
        for dz, dx, dy in [
            (-1, 0, 0),
            (1, 0, 0),
            (0, -1, 0),
            (0, 1, 0),
            (0, 0, -1),
            (0, 0, 1),
        ]:
            cz = z + dz
            cx = x + dx
            cy = y + dy
            if 0 <= cz < H and 0 <= cx < R and 0 <= cy < C:
                if farms[cz][cx][cy] == 0 and not visit[cz][cx][cy]:
                    farms[cz][cx][cy] = 1
                    visit[cz][cx][cy] = True
                    new_tomato.append((cz, cx, cy))


total_tomato_count = H * R * C - empty_count - len(tomato)
answer = 0

while True:
    new_tomato = deque()
    BFS(tomato, new_tomato)
    total_tomato_count -= len(new_tomato)
    if len(new_tomato) == 0:
        if total_tomato_count == 0:
            print(answer)
        else:
            print(-1)
        break

    tomato = copy.deepcopy(new_tomato)
    answer += 1
