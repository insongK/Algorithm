import sys

w_c, h_c, w_s, h_s = map(int, sys.stdin.readline().split())

if w_c - w_s >= 2 and h_c - h_s >= 2:
    print(1)
else:
    print(0)
