import sys

N = int(sys.stdin.readline())
times = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]

times.sort(key=lambda x: (x[1], x[0]))
answer = 0
cur = 0

for s, e in times:
    if cur <= s:
        cur = e
        answer += 1

print(answer)
