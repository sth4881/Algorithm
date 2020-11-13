package com.algorithm.dnc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MergeSort {
	public static void mergeSort(int[] arr, int first, int last) {
		if(first<last) {
			int mid = (first+last)/2; // 분할하기 위해서 중간값 설정
			mergeSort(arr, first, mid); // 왼쪽 그룹으로 분할
			mergeSort(arr, mid+1, last); // 오른쪽 그룹으로 분할
			merge(arr, first, mid, last); // 분할한 그룹들을 다시 병합
		}
	}
	public static void merge(int[] arr, int first, int mid, int last) {
		int left = first; // arr[first]~arr[mid]
		int right = mid+1; // arr[mid+1]~arr[last]
		int[] temp = new int[arr.length]; // 병합하기 위한 임시 배열 생성
		int cnt = left; // temp의 인덱스를 count하기 위한 변수 
		
		while(left<=mid && right <= last) { 
			if(arr[left] <= arr[right]) { // 오른쪽 원소가 왼쪽 원소보다 셀 경우 왼쪽 원소 퇴장
				temp[cnt] = arr[left];
				left++;
			} else { // 왼쪽 원소가 오른쪽 원소보다 셀 경우 오른쪽 원소 퇴장
				temp[cnt] = arr[right];
				right++;
			}
			cnt++; // 어떤 원소가 이기든 다음 대결을 위한 공간을 준비해야하므로 인덱스 증가
		}
		
		// 끝까지 버텨서 이긴 그룹은 그대로 내려온다
		if(left <= mid) { // 왼쪽 그룹이 오른쪽 그룹을 이겨서 내려왔을 경우
			for(int i=left; i<=mid; i++) { // 남아있는 왼쪽 원소들의 처음부터 끝까지
				temp[cnt] = arr[i];
				cnt++;
			}
		} else { // 오른쪽 그룹이 왼쪽 그룹을 이겨서 내려왔을 경우
			for(int i=right; i<=last; i++) { // 남아있는 오른쪽 원소들의 처음부터 끝까지
				temp[cnt] = arr[i];
				cnt++;
			}
		}
		
		for(int i=first; i<=last; i++)
			arr[i] = temp[i]; // 임시 공간에 정렬된 원소를 원래 배열에 순차적으로 대입해서 과정 마무리
	}
	public static void main(String[] args) {
		try {
			// 테스트 케이스를 파일로부터 읽어와서 테스트 해보기 위해서 구현
			String fileName = "E:\\학교\\4-1\\알고리즘\\과제\\test.txt";
			File file = new File(fileName);
			FileReader reader = new FileReader(file);
			BufferedReader bufReader = new BufferedReader(reader);
			System.out.println(fileName);
			
			int n = Integer.parseInt(bufReader.readLine()); // 테스트 케이스의 개수를 입력받기 위한 변수
			String[] input = bufReader.readLine().split(" "); // // 테스트 케이스를 입력받는 변수
			
			int[] arr = new int[n];
			for(int i=0; i<n; i++)
				arr[i] = Integer.parseInt(input[i]);
			
			for(int i=0; i<n; i++)
				System.out.print(arr[i] + " ");
			System.out.println();
			mergeSort(arr, 0, n-1);
			for(int i=0; i<n; i++)
				System.out.print(arr[i] + " ");
			System.out.println();
			
			reader.close();
		} catch(FileNotFoundException e) {
			e.getStackTrace();
		} catch(IOException e) {
			e.getStackTrace(); 
		}
	}
}
