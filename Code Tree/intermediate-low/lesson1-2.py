n = int(input())
arr = list(map(int, input().split()))

arr.sort()
min_num = arr[0]

cnt = 0
for item in arr:
    if item==min_num:
        cnt = cnt+1

print(min_num, end=" ")
print(cnt)