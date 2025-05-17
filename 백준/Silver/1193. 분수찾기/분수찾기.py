import sys

X = int(sys.stdin.readline())

length = 1
step = 0
while True:
    X -= length
    if X <= 0:
        X += length
        break
    length += 1
    step += 1

if step % 2 == 1:
    print(f"{X}/{step + 2 - X}")
else:
    print(f"{step + 2 - X}/{X}")
