package com.assignment.no4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Assignment2_1 {
	static int temp = -1;
	public static int func(int m, int n, int[][] arr) {
		int sum = 0;
		int sum1 = arr[m-1][0]; // 시작 지점의 값으로 초기화
		int sum2 = arr[0][n-1]; // 도착 지점의 값으로 초기화

		if(m==1) { // 행이 하나만 존재할 경우 열 원소를 모두 더하는 방식으로 예외처리
			for(int j=0; j<n; j++)
				sum += arr[0][j];
			return sum;
		}
		if(n==1) { // 열이 하나만 존재할 경우 행 원소를 모두 더하는 방식으로 예외처리
			for(int i=0; i<m; i++)
				sum += arr[i][0];
			return sum;
		}
		
		// 시작 지점에서 도착 지점으로 이동하는 경우
		for(int i=m-1; i>=0; i--) { // 시작 지점이 좌측 하단이므로 i=m-1부터 1까지 올라가는 방식 사용
			for(int j=0; j<=n-1; j++) { // j는 왼쪽에서 오른쪽으로 이동하므로 0부터 n-1까지 이동하는 방식 사용
				if(temp>-1) { // temp가 j값을 0이상 갖고 있을 경우에만 if문 실행
					j = temp; // i값이 갱신되면 j는 0부터 시작하므로 temp에 저장해뒀던 값을 j에 대입해줌으로써 열 위치 유지
					temp = -1; // temp는 재사용되면 안되므로 값을 -1로 갱신
				}
				if(i>0 && j==n-1) { // 위쪽 끝까지 온 경우 위쪽으로 이동 방지+ 오른쪽 끝까지 왔을 경우 위쪽으로만 이동
					sum1 += arr[i-1][j]; // 위쪽 원소를 sum에 더하기
					temp = j; // j값을 유지한채 행을 -1해주기 위해서 정적 변수 temp에 임시로 값을 대입
					break; // j값은 유지하고 i값만 갱신해주기 위해서 해당 반복문을 빠져나감
				}
				else if(j<n-1 && i==0) { // 오른쪽 끝까지 온 경우 오른쪽으로 이동 방지 + 위쪽 끝까지 왔을 경우 오른쪽으로만 이동 가능
					sum1 += arr[i][j+1]; // 오른쪽 원소를 sum에 더하기
				}
				else if(i>0 && j<n-1) { // 해당 원소가 오른쪽 끝에 있지 않은 일반적인 경우에 대한 처리
					if(arr[i][j+1] < arr[i-1][j])// 오른쪽이 위쪽보다 작다면 오른쪽으로 이동
						sum1 += arr[i][j+1]; // 오른쪽 원소를 sum에 더하기
					else { // 위쪽이 오른쪽보다 작다면 위로 이동
						sum1 += arr[i-1][j]; // 위쪽 원소를 sum에 더하기
						temp = j; // j값을 유지한채 행을 -1해주기 위해서 정적 변수 temp에 임시로 값을 대입
						break; // j값은 유지하고 i값만 갱신해주기 위해서 해당 반복문을 빠져나감
					}
				}
			}
		}
		
		// 도착 지점에서 시작 지점으로 이동하는 경우
		for(int i=0; i<m; i++) { // 시작 지점이 우측 상단이므로 i=0부터 m-1까지 올라가는 방식 사용
			for(int j=n-1; j>0; j--) { // j는 오른쪽에서 왼쪽으로 이동하므로 n-1부터 0까지 이동하는 방식 사용
				if(temp>-1) { // temp가 j값을 0이상 갖고 있을 경우에만 if문 실행
					j = temp; // i값이 갱신되면 j는 0부터 시작하므로 temp에 저장해뒀던 값을 j에 대입해줌으로써 열 위치 유지
					temp = -1; // temp는 재사용되면 안되므로 값을 -1로 갱신
				}
				if(j==0) { // 왼쪽 끝까지 왔을 경우, 아래쪽으로만 이동한다.
					sum2 += arr[i+1][j]; // 아래쪽 원소를 sum에 더하기
					temp = j; // j값을 유지한채 행을 +1해주기 위해서 정적 변수 temp에 임시로 값을 대입
					break;
				}
				else if(i==m-1) { // 아래쪽 끝까지 왔을 경우, 왼쪽으로만 이동한다.
					sum2 += arr[i][j-1]; // 왼쪽 원소를 sum2에 더하기
				}
				else { 
					// 위의 예외들을 제외한 일반적인 경우로, 왼쪽 원소와 아래쪽 원소를 비교해서
					// 더 작은 값을 sum에 더해주고 그쪽으로 위치를 이동한다.
					if(arr[i][j-1] < arr[i+1][j]) // 왼쪽 원소가 아래쪽 원소보다 작을 경우
						sum2 += arr[i][j-1]; // 왼쪽 원소를 sum2에 더하기
					else { // 아래쪽 원소가 위쪽 원소보다 작을 경우
						sum2 += arr[i+1][j]; // 아래쪽 원소를 sum2에 더하기
						temp = j; // j값을 유지한채 행을 +1해주기 위해서 정적 변수 temp에 임시로 값을 대입
						break;
					}
				}
			}
		}
		return Math.min(sum1, sum2); // 두 개의 방식 중에서 더 작은 값을 반환
	}
	public static void main(String[] args) {
		try {
			// 테스트 케이스를 파일로부터 읽어와서 테스트 해보기 위해서 구현
			String fileName = "E:\\학교\\4-1\\알고리즘\\과제\\test.txt";
			File file = new File(fileName);
			FileReader reader = new FileReader(file);
			BufferedReader bufReader = new BufferedReader(reader);
			System.out.println(fileName);
			
			String[] size = bufReader.readLine().split(" "); // // 테스트 케이스를 입력받는 변수
			int m = Integer.parseInt(size[0]); // 올라가야하는 계단의 개수
			int n = Integer.parseInt(size[1]); // 올라가야하는 계단의 개수
			int[][] grid = new int[m][n];
			
			for(int i=0; i<m; i++) {
				String[] input = bufReader.readLine().split(" "); // // 테스트 케이스를 입력받는 변수
				for(int j=0; j<n; j++) {
					grid[i][j] = Integer.parseInt(input[j]);
				}
			}

			System.out.println(func(m, n, grid));
			
			reader.close();
		} catch(FileNotFoundException e) {
			e.getStackTrace();
		} catch(IOException e) {
			e.getStackTrace(); 
		}
	}
}
