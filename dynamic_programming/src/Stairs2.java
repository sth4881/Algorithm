import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Stairs2 {
	public static void func(int n, int k, int[] stairs) { // n은 올라가야 하는 총 계단 수, k는 올라갈 수 있는 계단의 단위 개수
		int[] arr = new int[n+1];
		arr[0] = 1; // 올라가야 하는 계단의 개수가 0이므로 올라가지 않는 방법 또한 하나의 경우로 간주할 수 있다.
		for(int i=0; i<=n; i++) {
			for(int j=0; j<k; j++) // 계단을 올라갈 때 사용할 수 있는(1회에 올라갈 수 있는) 계단의 단위 개수만큼 반복한다.
										// ex. 사용할 수 있는 계단이 1, 3, 5라면 계단의 단위 개수는 3개
				if(i-stairs[j]>=0) arr[i] += arr[i-stairs[j]]; // i는 음수가 될 수 없으므로 i-stairs[j]>=0 경우에만 if문을 수행한다.
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
			
			String[] temp = bufReader.readLine().split(" "); // // 테스트 케이스를 입력받는 변수
			int n = Integer.parseInt(temp[0]); // 올라가야하는 계단의 개수
			int k = Integer.parseInt(temp[1]); // 올라가야하는 계단의 개수
			String[] input = bufReader.readLine().split(" "); // // 테스트 케이스를 입력받는 변수
			
			int[] stairs = new int[k];
			for(int i=0; i<k; i++)
				stairs[i] = Integer.parseInt(input[i]); // 1회에 올라갈 수 있는 계단의 개수 설정
			
			func(n, k, stairs);
			
			reader.close();
		} catch(FileNotFoundException e) {
			e.getStackTrace();
		} catch(IOException e) {
			e.getStackTrace(); 
		}
	}
}
