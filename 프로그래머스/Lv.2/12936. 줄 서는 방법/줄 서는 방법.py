from math import factorial

def solution(n, k):
    answer = []
    people = list(range(1, n + 1))
    k -= 1  # 0-indexed로 변환

    for i in range(n, 0, -1):
        f = factorial(i - 1)
        idx = k // f
        answer.append(people.pop(idx))
        k %= f

    return answer