import sys

N = int(sys.stdin.readline())
sol = list(sys.stdin.readline().strip())

Adrian = ["A", "B", "C"] * 34
Bruno = ["B", "A", "B", "C"] * 25
Goran = ["C", "C", "A", "A", "B", "B"] * 17

A_count = 0
B_count = 0
G_count = 0

for i in range(N):
    if sol[i] == Adrian[i]:
        A_count += 1
    if sol[i] == Bruno[i]:
        B_count += 1
    if sol[i] == Goran[i]:
        G_count += 1

max = max(A_count, B_count, G_count)

print(max)

if A_count == max:
    print("Adrian")
if B_count == max:
    print("Bruno")
if G_count == max:
    print("Goran")
