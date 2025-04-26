import sys

N = int(sys.stdin.readline())

for i in range(N * 5):
    if i < N * 4:
        print("@" * N)
    else:
        print("@" * N * 5)
