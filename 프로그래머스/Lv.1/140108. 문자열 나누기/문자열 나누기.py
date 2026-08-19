def solution(s):
    answer = 0
    i = 0
    while i < len(s):
        first = s[i]
        t = 1
        f = 0
        cnt = 1
        if i == len(s) - 1:
            answer += 1
            break
        for c in s[i + 1:]:
            if first == c:
                t += 1
            else:
                f += 1
            cnt += 1
            if t == f:
                break
        i += cnt
        answer += 1
        
    return answer

