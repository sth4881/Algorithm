import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Stairs1 {
	// �� n���� ����� �ö� �� 1�� Ȥ�� 3���� ��ܸ� ����ؼ� �ö󰡴� ����� ���� func(n)��� �� ��
	// �� n���� ��� �߿��� 1���� ����� ����ؼ� ����� �ö󰡴� ����� ���� func(n-1)��� ǥ���� �� �ְ�,
	// �� n���� ��� �߿��� 3���� ����� ����ؼ� ����� �ö󰡴� ����� ���� func(n-3)��� ǥ���� �� �ִ�.
	// �׷��ٸ� func(n)�� 1���� ����� ����ؼ� �ö󰡴� ����� ���� 3���� ����� ����ؼ� �ö󰡴� ����� ���� ���� �� �ְ�,
	// ���� func(n) = func(n-1) + func(n-3)��� ǥ���� �� �ִ�.
	public static void func(int n) {
		int[] arr = new int[n+1];
		arr[0] = 1; // �ö󰡾� �ϴ� ����� ������ 0�̹Ƿ� �ö��� �ʴ� ��� ���� �ϳ��� ���� ������ �� �ִ�.
		for(int i=0; i<=n; i++) {
			if(i-1>=0) { // i�� ������ �� �� �����Ƿ� i-1>=0 ��쿡�� �Ʒ� �������� �����Ѵ�.
				arr[i] += arr[i-1];
				if(i-3>=0) arr[i] += arr[i-3];  // i�� ������ �� �� �����Ƿ� i-3>=0 ��쿡�� if���� �����Ѵ�.
			}
			// System.out.println("arr["+i+"] = "+arr[i]);
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
			
			int n = Integer.parseInt(bufReader.readLine()); // �ö󰡾��ϴ� ����� ����
			func(n);
			
			reader.close();
		} catch(FileNotFoundException e) {
			e.getStackTrace();
		} catch(IOException e) {
			e.getStackTrace(); 
		}
	}
}
