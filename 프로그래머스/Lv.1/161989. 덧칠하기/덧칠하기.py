def solution(n, m, section):
    answer = 0
    cur = 0
    for s in section:
        if cur <= s:
            cur = s + m
            answer += 1
    
    return answer

