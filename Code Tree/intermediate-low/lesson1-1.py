for i in range(1, 20):
    for j in range(1, 20):
        if(j%2==1):
            print(str(i)+' * '+str(j)+' = '+str(i*j), end=" ")
        elif(j%2==0):
            print('/ '+str(i)+' * '+str(j)+' = '+str(i*j))
        if(j==19):
            print()