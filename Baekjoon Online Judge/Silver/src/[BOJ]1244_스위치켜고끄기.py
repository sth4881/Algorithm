size = int(input())
arr = list(map(int, input().split(" ")))

n = int(input())
for i in range(n):
    sex, num = map(int, input().split(" "))
    # 남학생인 경우
    if sex==1:
        for j in range(len(arr)):
            if (j+1)%num==0:
                if arr[j]==0: arr[j] = 1
                elif arr[j]==1: arr[j] = 0

    # 여학생인 경우
    else:

        idx = 1
        while True:
            # 범위를 벗어나면 탈락
            if num-1-idx<0 or num-1+idx>=size: break
            # 배정받은 스위치의 이전/다음 스위치의 상태가 같지 않으면 탈락
            if arr[num-1-idx]!=arr[num-1+idx]: break
            # 이전/다음 스위치의 상태를 변환
            if arr[num-1-idx]==0: 
                arr[num-1-idx] = 1
                arr[num-1+idx] = 1
            else:
                arr[num-1-idx] = 0
                arr[num-1+idx] = 0
            idx = idx+1
        if arr[num-1]==0: arr[num-1] = 1
        elif arr[num-1]==1: arr[num-1] = 0

# 출력 방식
for i in range(len(arr)):
    if i>0 and (i)%20==0:
        print()
    print(arr[i], end=" ")