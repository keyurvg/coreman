package Sort;

import java.util.Arrays;

public class SortAll {
	public static void main(String args[]) {
		Integer[] input = {10, 22, 23 };
				//, 98, 78, 56, 1, 23, 54, 76, 45, 12, 96, 27, 41, 5, 7, 9, 4, 444, 66, 3, 24, 53 };
		int[] input2 = {2,3,1,4,6};
		int[] input3 = {53,45,21,6,100};
	

		String[][] keypad = {{"A", "B", "C"}, {"D", "E", "F"}, {"G", "H", "I"}, {"", "J", ""}};
		
for(int i = 0; i<4; i++)
{
    for(int j = 0; j<3; j++)
    {
        System.out.print(keypad[i][j]);
    }
    System.out.println();
}
		
		//input = mergeSort(input, 0 , input.length);
		//bubbleSort(input2, input3);
		//System.out.println(Arrays.toString(bubbleSort(input2)));

	}

	public static void bubbleSort(int[] input2, int[] input3){
		for(int i = 0; i < input2.length ; i++)
		{
			for(int j = i; j < input2.length ; j ++)
			{
				if(input2[i] > input2[j]){
					int key = input2[j];
					input2[j] = input2[i];
					input2[i] = key;
				}					
				
				if(input3[i] > input3[j]){
					int key = input3[j];
					input3[j] = input3[i];
					input3[i] = key;
				}
			}
		}
		
		System.out.println(Arrays.toString(input2));
		System.out.println(Arrays.toString(input3));
		
	}
	
	public static Integer[] mergeSort(Integer[] array, int leftIndex, int rightIndex) {
		Integer[] outputLeft = null;
		Integer[] outputRight = null;
		if (rightIndex - leftIndex > 2) {
			int middleIndex = (leftIndex + rightIndex) / 2;
			outputLeft = mergeSort(array, leftIndex, middleIndex - 1);
			outputRight = mergeSort(array, middleIndex, rightIndex);
			array = mergeSortedArray(outputLeft, outputRight);
			return array;
		} else {
			Integer[] output = new Integer[3];
			
			return output;
		}

	}
	
	public static Integer[] mergeSortedArray(Integer[] left, Integer[] right) {

		int total = left.length + right.length;
		Integer[] merged = new Integer[total];
		int l = 0;
		int r = 0;
		int i = 0;
		while (l < left.length && r < right.length) {
			if (left[l] < right[r])
				merged[i++] = left[l++];
			else
				merged[i++] = right[r++];
		}

		while (l < left.length)
			merged[i++] = left[l++];

		while (r < right.length)
			merged[i++] = right[r++];

		return merged;
	}
	
	public static Integer[] selectionSort(Integer[] input) {
		for (int j = 0; j < input.length - 1; j++) {
			int curr_num = input[j];
			int curr_index = j;
			for (int i = j; i < input.length; i++) {
				if (input[i] < curr_num) {
					curr_num = input[i];
					curr_index = i;
				}
			}
			input[curr_index] = input[j];
			input[j] = curr_num;
		}

		return input;

	}

	public static Integer[] insertionSort(Integer[] input) {

		for (int j = 1; j < input.length; j++) {
			int key = input[j];
			int i = j - 1;
			while (i >= 0 && input[i] < key) {
				input[i + 1] = input[i];
				i = i - 1;
			}
			input[i + 1] = key;
		}

		return input;
	}


}
