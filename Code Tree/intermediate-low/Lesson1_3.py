abc, n = list(map(str, input().split(" ")))

n = int(n)
arr = list()
for i in range(n):
    select = input()
    if select=="1":
        abc = abc.replace(abc[0], '')+abc[0]
        arr.append(abc)
    elif select=="2":
        abc = abc[-1]+abc.replace(abc[-1], '')
        arr.append(abc)
    elif select=="3":
        abc = abc[::-1]
        arr.append(abc)

for i in arr:
    print(i)