def solution(maps):
    R = len(maps)
    C = len(maps[0])
    
    visit = [[False] * C for _ in range(R)]
    d = [(-1, 0), (0, 1), (1, 0), (0 , -1)]
    
    queue = []
    queue.append((0, 0, 1))
    visit[0][0] = True
    
    while len(queue) != 0:
        r, c, count = queue.pop(0)
        if r == R - 1 and c == C - 1:
            return count
        
        for dr, dc in d:
            nr = r + dr
            nc = c + dc
            if 0 <= nr < R and 0 <= nc < C and maps[nr][nc] == 1 and not visit[nr][nc]:
                queue.append((nr, nc, count + 1))
                visit[nr][nc] = True
    
    
    return -1

