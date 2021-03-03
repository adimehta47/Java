package com.inn.demo;

public class Fixxy {

	public static void main(String[] args) {
//		int a[] = { 1, 5, 4, 6, 5,4,7 };
		int a[] = {5,4,9,4,9,5};
		int x = 4;
		int y = 5;
		int yIndex = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] == x && i!=a.length-1) {
				
				for (int j = yIndex; j < a.length; j++) {
                  if(a[j]==y && (j==0 || a[j-1]!=x)) {
                	  int temp=a[i+1];
                	  a[i+1]=y;
                	  a[j]=temp;
                  }
				}
			}
		}
		for (int i = 0; i < a.length; i++) 
		     System.out.println(a[i]);
	}
}
