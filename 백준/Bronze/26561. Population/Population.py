import sys

count = int(sys.stdin.readline())

answer = []

for _ in range(count):
    p, t = count = map(int, sys.stdin.readline().split())
    answer.append(p + t // 4 - t // 7)

for a in answer:
    print(a)
