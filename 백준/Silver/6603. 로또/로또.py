import sys
from itertools import combinations

input = []

while True:
    rl = list(map(int, sys.stdin.readline().split()))
    if rl[0] == 0:
        break
    rl.pop(0)
    input.append(rl)

for a in input:
    for c in combinations(a, 6):
        for i in c:
            print(i, end=" ")
        print()
    print()
