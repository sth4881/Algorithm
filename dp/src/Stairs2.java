import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Stairs2 {
	public static void func(int n, int k, int[] stairs) { // n�� �ö󰡾� �ϴ� �� ��� ��, k�� �ö� �� �ִ� ����� ���� ����
		int[] arr = new int[n+1];
		arr[0] = 1; // �ö󰡾� �ϴ� ����� ������ 0�̹Ƿ� �ö��� �ʴ� ��� ���� �ϳ��� ���� ������ �� �ִ�.
		for(int i=0; i<=n; i++) {
			for(int j=0; j<k; j++) // ����� �ö� �� ����� �� �ִ�(1ȸ�� �ö� �� �ִ�) ����� ���� ������ŭ �ݺ��Ѵ�.
										// ex. ����� �� �ִ� ����� 1, 3, 5��� ����� ���� ������ 3��
				if(i-stairs[j]>=0) arr[i] += arr[i-stairs[j]]; // i�� ������ �� �� �����Ƿ� i-stairs[j]>=0 ��쿡�� if���� �����Ѵ�.
		}
		System.out.println(arr[n]);
	}
	public static void main(String[] args) {
		try {
			// �׽�Ʈ ���̽��� ���Ϸκ��� �о�ͼ� �׽�Ʈ �غ��� ���ؼ� ����
			String fileName = "E:\\�б�\\4-1\\�˰���\\����\\test.txt";
			File file = new File(fileName);
			FileReader reader = new FileReader(file);
			BufferedReader bufReader = new BufferedReader(reader);
			System.out.println(fileName);
			
			String[] temp = bufReader.readLine().split(" "); // // �׽�Ʈ ���̽��� �Է¹޴� ����
			int n = Integer.parseInt(temp[0]); // �ö󰡾��ϴ� ����� ����
			int k = Integer.parseInt(temp[1]); // �ö󰡾��ϴ� ����� ����
			String[] input = bufReader.readLine().split(" "); // // �׽�Ʈ ���̽��� �Է¹޴� ����
			
			int[] stairs = new int[k];
			for(int i=0; i<k; i++)
				stairs[i] = Integer.parseInt(input[i]); // 1ȸ�� �ö� �� �ִ� ����� ���� ����
			
			func(n, k, stairs);
			
			reader.close();
		} catch(FileNotFoundException e) {
			e.getStackTrace();
		} catch(IOException e) {
			e.getStackTrace(); 
		}
	}
}
