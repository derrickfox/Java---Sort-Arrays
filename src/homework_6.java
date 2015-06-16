/* Derrick Fox
 * CS 213
 * Homework 6
 * Double Array Sorter
 * March 9, 2014
 */

//This program takes two arrays from user's input, concatenates them, sorts them, and then prints them.

import java.util.Scanner;

public class homework_6 {
	public static void main(String[] args) {
		int[] array1 = getList();
		verifySorted(array1);
		int[] array2 = getList();
		verifySorted(array2);
		
		//Calls to the four methods in the main function.
		int[] arrayCombo = merge(array1, array2);
		sortArray(arrayCombo);
		displayArray(arrayCombo);
	}
	
	//Method that users the Scanner class to input two arrays from the user.
	public static int[] getList() {
		System.out.print("Enter list size:  ");
		Scanner input = new Scanner(System.in);
		int arraySize = input.nextInt();
		int[] array = new int[arraySize];
		System.out.println("Enter "+arraySize+" SORTED numbers for the list:  ");
		
		for(int i = 0; i < arraySize; i++) {
			System.out.println("Enter number "+(i+1)+": ");
			array[i] = input.nextInt();
		}
		return array;
	}
	
	//Method that concatenates the two arrays
	public static int[] merge(int[] array1, int[] array2) {
		int[] comboArray = new int[(array1.length + array2.length)];
		for (int i = 0; i < array1.length; i++) {
			comboArray[i] = array1[i];
		}
		for (int j = 0 ; j < array2.length; j++) {
			comboArray[(array1.length) + j] = array2[j];
		}
		return comboArray;
	}
	

	//Method that sorts the new combined array.
	public static int[] sortArray(int[] array) {
		boolean unsorted = true;
		for (int i = 1; i < array.length && unsorted; i++) {
			unsorted = false;
			for (int j = 0; j < array.length - i; j++) {
				if (array[j] > array[j + 1]) {
					int temp = array[j];
					array[j] = array[j +1];
					array[j + 1] = temp;
					
					unsorted = true;
				}
			}
		}
		return array;
	}
	
	//Method that verifies whether or not your array is sorted appropriately using a 
	//sorting algorithm. 
	public static void verifySorted(int[] array) {
		for (int i = 0; i < array.length-1; i++) {
			if (array[i] > array[i+1]) {
				System.out.println("Your arrays are not sorted");
			}
		}
	}
	
	//Method that displays the sorted new array.
	public static void displayArray(int[] array) {
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i]+" ");
		}
	}
}
	


