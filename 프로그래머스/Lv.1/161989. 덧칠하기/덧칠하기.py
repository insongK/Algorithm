def solution(n, m, section):
    answer = 0
    wall = [1] * n
    for i in section:
        wall[i - 1] = 0
        
    for i, w in enumerate(wall):
        end = n if i + m >= n else i + m
        if w == 0:
            wall[i:end] = [1] * (end - i)
            answer += 1
    return answer