def solution(data, ext, val_ext, sort_by):
    names = ["code", "date", "maximum", "remain"]
    for i in range(4):
        if ext == names[i]:
            ext = i
        if sort_by == names[i]:
            sort_by = i
    filtered = [x for x in data if x[ext] <= val_ext]
    filtered.sort(key = lambda x: x[sort_by])
    return filtered