def bst(start, end, enemy, k, n):
    if start == end:
        return start

    mid = (start + end + 1) // 2
    li = sorted(enemy[:mid], reverse=True)
    li[:k] = [0] * k

    if sum(li) <= n:
        return bst(mid, end, enemy, k, n)
    else:
        return bst(start, mid - 1, enemy, k, n)


def solution(n, k, enemy):
    if k >= len(enemy):
        return len(enemy)

    return bst(0, len(enemy), enemy, k, n)