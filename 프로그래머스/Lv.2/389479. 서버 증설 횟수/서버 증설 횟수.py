def solution(players, m, k):
    answer = 0
    server = [1] * 24
    for i, p in enumerate(players):
        if p >= m * server[i]:
            add = int(p/m) - server[i] + 1
            for _ in range(i, i + k if i + k < 24 else 24):
                server[_] += add
            answer += add
    return answer