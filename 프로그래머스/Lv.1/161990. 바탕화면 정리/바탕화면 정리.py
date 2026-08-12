def solution(wallpaper):
    answer = [50, 50, 0, 0]
    
    for r, row in enumerate(wallpaper):
        for c, ch in enumerate(row):
            if ch == '#':
                if r < answer[0]:
                    answer[0] = r
                if c < answer[1]:
                    answer[1] = c
                    
                if r + 1 > answer[2]:
                    answer[2] = r + 1
                if c + 1 > answer[3]:
                    answer[3] = c + 1
                    
    return answer