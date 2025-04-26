import sys

lines = list(map(int, sys.stdin.readline().split()))

lines.sort(reverse=True)

if lines[0] >= lines[1] + lines[2]:
    print((lines[1] + lines[2]) * 2 - 1)

else:
    print(lines[0] + lines[1] + lines[2])
