arr = list(map(int, input().split(" ")))

while True:
    if arr[0]>arr[1]:
        temp = arr[0]
        arr[0] = arr[1]
        arr[1] = temp
        for i in arr:
            print(i, end=" ")
        print()
    if arr[1]>arr[2]:
        temp = arr[1]
        arr[1] = arr[2]
        arr[2] = temp
        for i in arr:
            print(i, end=" ")
        print()   
    if arr[2]>arr[3]:
        temp = arr[2]
        arr[2] = arr[3]
        arr[3] = temp
        for i in arr:
            print(i, end=" ")
        print()
    if arr[3]>arr[4]:
        temp = arr[3]
        arr[3] = arr[4]
        arr[4] = temp
        for i in arr:
            print(i, end=" ")
        print()
    if arr[0]!=1 or arr[1]!=2 or arr[2]!=3 or arr[3]!=4 or arr[4]!=5: continue
    break