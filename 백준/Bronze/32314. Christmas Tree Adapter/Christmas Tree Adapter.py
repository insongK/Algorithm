import sys

A = int(sys.stdin.readline())
W, V = map(int, sys.stdin.readline().split())

if W >= A * V:
    print(1)
else:
    print(0)
