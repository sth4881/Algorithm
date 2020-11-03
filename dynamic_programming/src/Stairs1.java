import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Stairs1 {
	// 총 n개의 계단을 올라갈 때 1개 혹은 3개의 계단만 사용해서 올라가는 경우의 수를 func(n)라고 할 때
	// 총 n개의 계단 중에서 1개의 계단을 사용해서 계단을 올라가는 경우의 수를 func(n-1)라고 표현할 수 있고,
	// 총 n개의 계단 중에서 3개의 계단을 사용해서 계단을 올라가는 경우의 수를 func(n-3)라고 표현할 수 있다.
	// 그렇다면 func(n)은 1개의 계단을 사용해서 올라가는 경우의 수와 3개의 계단을 사용해서 올라가는 경우의 수로 나눌 수 있고,
	// 따라서 func(n) = func(n-1) + func(n-3)라고 표현할 수 있다.
	public static void func(int n) {
		int[] arr = new int[n+1];
		arr[0] = 1; // 올라가야 하는 계단의 개수가 0이므로 올라가지 않는 방법 또한 하나의 경우로 간주할 수 있다.
		for(int i=0; i<=n; i++) {
			if(i-1>=0) { // i는 음수가 될 수 없으므로 i-1>=0 경우에만 아래 구문들을 수행한다.
				arr[i] += arr[i-1];
				if(i-3>=0) arr[i] += arr[i-3];  // i는 음수가 될 수 없으므로 i-3>=0 경우에만 if문을 수행한다.
			}
			// System.out.println("arr["+i+"] = "+arr[i]);
		}
		System.out.println(arr[n]);
	}
	public static void main(String[] args) {
		try {
			// 테스트 케이스를 파일로부터 읽어와서 테스트 해보기 위해서 구현
			String fileName = "E:\\학교\\4-1\\알고리즘\\과제\\test.txt";
			File file = new File(fileName);
			FileReader reader = new FileReader(file);
			BufferedReader bufReader = new BufferedReader(reader);
			System.out.println(fileName);
			
			int n = Integer.parseInt(bufReader.readLine()); // 올라가야하는 계단의 개수
			func(n);
			
			reader.close();
		} catch(FileNotFoundException e) {
			e.getStackTrace();
		} catch(IOException e) {
			e.getStackTrace(); 
		}
	}
}
