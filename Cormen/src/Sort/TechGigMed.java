package Sort;

import java.util.Arrays;

public class TechGigMed {

	public static void main(String[] args) {
		//int[] input1 = { 6, 3, 5, 17, 19, 15, 13, 15, 6, 3, 5, 18, 19 };
		int[] input1 = {1,1,1,1,1,1};
		// int[] input1 = { 1,1,1,2,1,2,1,2};

		System.out.println(getPoints60(input1, input1.length));
	}

	public static String getPoints60(int[] input1, int input2) {

		if (input1.length == 0 || input1.length != input2 || input2 <= 0)
			return "Invalid";

		for (int i = 0; i < input1.length; i++) {
			if (input1[i] < 0 || input1[i] > 20)
				return "Invalid";
		}

		String output = "";
		for (int i = 0; i < input1.length; i++) {
			if (i == 0)
				output = output + "0";
			else if (i == 1) {
				if (input1[i] == input1[i - 1])
					output = output + "," + "1";
				else
					output = output + "," + "0";
			} else {
				int k = i;
				int j = 0;
				int localoutput = 0;
				String str1 = "";
				String str2 = "";
				while (j <= i / 2 && k > i / 2) {
					str1 = str1 + input1[j];
					str2 = input1[k] + str2;
					if (str1.equals(str2)) {
						localoutput = j + 1;
					}
					j++;
					k--;
				}
				output = output + "," + localoutput;

			}

		}

		/*
		 * String reverseInput = ""; int[] reverseInputInt = new
		 * int[input1.length]; reverseInput = reverseInput +
		 * input1[input1.length - 1]; reverseInputInt[0] = input1[input1.length
		 * - 1]; int j = 1; for(int i = input1.length - 2; i >= 0 ; i--){
		 * reverseInput = reverseInput + '~' + input1[i]; reverseInputInt[j++] =
		 * input1[i];
		 * 
		 * }
		 */

		// System.out.println(Arrays.toString(reverseInputInt));
		return output;
	}
	
	public static String getPoints(int[] input1, int input2) {

		if (input1.length == 0 || input1.length != input2 || input2 <= 0)
			return "Invalid";

		for (int i = 0; i < input1.length; i++) {
			if (input1[i] < 0 || input1[i] > 20)
				return "Invalid";

		}

		String strInput = encode(input1);
		String output = "";

		for (int i = 0; i < input1.length; i++) {
			// System.out.println(i + " " + strInput.charAt(i));

			if (i == 0)
				output = output + "0";
			else if (i == 1) {
				if (input1[i] == input1[i - 1])
					output = output + "," + "1";
				else
					output = output + "," + "0";
			} else {
				int[] localoutput = new int[i];
				String str1 = strInput.substring(0, i);
				//System.out.println(str1 + " " + i);

				for (int j = 0; j <= i / 2; j++) {
				 //System.out.println(str1.substring(0, i-j) + " " +
				 //strInput.substring(str1.length()-j,i+1));
					localoutput[j] = findOccurance(str1.substring(0, i-j), strInput.substring(str1.length() - j, i + 1)) * (j + 1);
				}
				// System.out.println(Arrays.toString(localoutput));
				Arrays.sort(localoutput);
				output = output + "," + localoutput[localoutput.length - 1];

			}

		}

		return output;
	}

	public static int findOccurance(String str, String findStr) {

		int lastIndex = 0;
		int count = 0;
		int i = 0;

		while (lastIndex < str.length()) {

			lastIndex = str.indexOf(findStr, lastIndex);

			if (lastIndex != -1) {
				count++;
				lastIndex = lastIndex + findStr.length();
				i = lastIndex;
			} else
				lastIndex = i++;
		}

		return count;
	}

	public static String encode(int[] input1) {
		String str = "";
		for (int i = 0; i < input1.length; i++) {
			switch (input1[i]) {
			case 0:
				str = str + "a";
				break;
			case 1:
				str = str + "b";
				break;
			case 2:
				str = str + "c";
				break;
			case 3:
				str = str + "d";
				break;
			case 4:
				str = str + "e";
				break;
			case 5:
				str = str + "f";
				break;
			case 6:
				str = str + "g";
				break;
			case 7:
				str = str + "h";
				break;
			case 8:
				str = str + "i";
				break;
			case 9:
				str = str + "j";
				break;
			case 10:
				str = str + "k";
				break;
			case 11:
				str = str + "l";
				break;
			case 12:
				str = str + "m";
				break;
			case 13:
				str = str + "n";
				break;
			case 14:
				str = str + "o";
				break;
			case 15:
				str = str + "p";
				break;
			case 16:
				str = str + "q";
				break;
			case 17:
				str = str + "r";
				break;
			case 18:
				str = str + "s";
				break;
			case 19:
				str = str + "t";
				break;
			case 20:
				str = str + "u";
				break;
			default:
				break;
			}

		}
		return str;
	}



}
