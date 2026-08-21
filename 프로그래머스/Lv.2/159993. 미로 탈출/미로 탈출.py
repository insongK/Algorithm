dr = [-1, 0, 1, 0] #상우하좌
    visit[start[0]][start[1]] = True
    while len(q) != 0:
        r,c,dist = q.pop(0)
        
        if maps[r][c] == end:
            return dist
        
        for d in range(4):
            nr = r + dr[d]
            nc = c + dc[d]
            if nr >= 0 and nr < W and nc >= 0 and nc < H and visit[nr][nc] == False and maps[nr][nc] != "X":   
                    q.append((nr, nc, dist + 1))
                    visit[nr][nc] = True
    
    return -1

def solution(maps):
    answer = 0
    start_S = [0, 0]
    start_L = [0, 0]
    for i, map in enumerate(maps):
        if map.find("S") >= 0:
            start_S[0] = i
            start_S[1] = map.find("S")
        if map.find("L") >= 0:
            start_L[0] = i
            start_L[1] = map.find("L")
            
    score = bfs(len(maps), len(maps[0]), maps, start_S, "L")
    if score < 0:
        return -1
    answer += score
    score = bfs(len(maps), len(maps[0]), maps, start_L, "E")
    if score < 0:
        return -1
    answer += score
    return answer


