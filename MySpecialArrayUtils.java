package sheet_1;
import java.util.Scanner;

public class MySpecialArrayUtils {
	
	static Scanner reader=new Scanner(System.in);
	
	public static void main(String [] args) {
		
	}
	public static void reverse(int[] arr) {
		int k;
		for (int i = 0; i < arr.length/2; i++) {
			k=arr[i];
			arr[i]=arr[arr.length-1-i];
			arr[arr.length-1-i]=k;
		}
		//for (int i = 0; i < arr.length; i++) {
		//	System.out.print(arr[i]+" ");
		//}
	}
	public static int[] sumEvenOdd(int[] arr) {
		int[] result=new int[2];
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]==0)
				continue;
		    else if(arr[i]%2==0)
				result[0]+=arr[i];
			else
				result[1]+=arr[i];
		}
		return result;
	}
	public static double average(int[] arr) {
		double sum=0;
		for (int i = 0; i < arr.length; i++) {
			sum+=arr[i];
		}
		double result=sum/arr.length;
		return result;
	}
	public static void movevalue(int[] arr,int val) {
		int counter=0;
		int i=0;
		while(i<arr.length-counter) {
			if(arr[i]==val) {
				counter++;
				for (int j = i; j < arr.length-1; j++) {
					arr[j]=arr[j+1];
				}
				i--;
			}
			i++;
		}
		for (int h = 0; h < counter; h++) {
			arr[arr.length-1-h]=val;
		}
		for (int k = 0; k < arr.length; k++) {
			System.out.print(arr[k]+" ");
		}
		System.out.println();
	}
	public static void transpose(int[][] arr) {
		int save;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if(i>j) {
					save=arr[i][j];
					arr[i][j]=arr[j][i];
					arr[j][i]=save;
				}
			}
		}
		/*for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}*/
	}
	public static void Fibonacci(int n) {
		int x=0;
		int y=1;
		int save;
		if(n==1)
			System.out.println(x);
		else {
			for(int i=0;i<n-1;i++) {
				save=y;
				y=x+y;
				x=save;
			}
		}
		System.out.println(x);
	}
}
