package Sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * This was wrong... 
 * 
 * 
 * 
 * 
 */

public class TechGigExpert2 {
	public static void main(String[] args) {
		
		int input1 = 4;
		int input2 = 6;
		int[] input3 = {1,1,1,0,0,1,
						1,1,1,0,0,1,
						0,0,0,0,0,0,
						0,0,0,0,0,0};
		//int[] input3 = {1,1,1, 0,0,0, 0,0,0, 0,0,0};
		
		
		System.out.println(requiredTetriminos(input1, input2, input3));
		//System.out.println(requiredTetriminos(input1, input2, input3));

	}

		
	public static int requiredTetriminos(int input1,int input2,int[] input3)
    {
		if(input1*input2 != input3.length)
			return 0;
			
		int[][] matrix = prepareMatrix(input1, input2, input3);
		
		//for(int i = 0; i<input1; i++)
			//System.out.println(Arrays.toString(matrix[i]));
		
		List<String> empty = new ArrayList<String>();
		List<String> filled = new ArrayList<String>();
		for(int i =0;i<input1;i++)
			for(int j=0;j<input2;j++){
				if(matrix[i][j] == 0)
					empty.add(i +"~~"+ j);
				if(matrix[i][j] == 1)
					filled.add(i +"~~"+ j);
			}
		
		int count=0;
					
		//System.out.println(empty);
		///System.out.println(filled);
		Collections.sort(empty);
		//System.out.println(empty.get(0));
		//System.out.println(checkIsolatedBlock(empty, filled, input1, input2));
		
		
		if(validSubMatrix(empty, filled, input1) == 0)
			return 0;
		count = checkBlocks(empty, filled, input1, input2, count);
		//System.out.println(empty);
		///System.out.println(filled);
		//Write code here
		return count;
    }
	
	
	
	public static int checkBlocks(List<String> empty, List<String> filled, int input1, int input2, int count){

		List<String> options = new ArrayList<String>();

		String str;
		if (!empty.isEmpty())
			str = empty.get(0);
		else
			return count;
		String[] s = str.split("~~");
		int x = Integer.parseInt(s[0]);
		int y = Integer.parseInt(s[1]);

		int temp = 0;
		int i = 0;

		while (i < 19) {
			
			//L0
			if (empty.contains((x+1) + "~~" + y) && empty.contains((x+2) + "~~" + y)
					&& empty.contains((x + 2) + "~~" + (y+1)) && i == 0) {
				filled.add(str);
				empty.remove(empty.indexOf(str));
				filled.add((x+1) + "~~" + y);
				empty.remove(empty.indexOf((x+1) + "~~" + y));
				filled.add((x+2) + "~~" + y);
				empty.remove(empty.indexOf((x+2) + "~~" + y));
				filled.add((x + 2) + "~~" + (y+1));
				empty.remove(empty.indexOf((x + 2) + "~~" + (y+1)));
				count++;

				//System.out.println("L0 " + empty);

				temp = checkBlocks(empty, filled, input1, input2, count);

				if (temp == 0) {
					count--;
					empty.add(str);
					filled.remove(filled.indexOf(str));
					empty.add((x+1) + "~~" + y);
					filled.remove(filled.indexOf((x+1) + "~~" + y));
					empty.add((x+2) + "~~" + y);
					filled.remove(filled.indexOf((x+2) + "~~" + y));
					empty.add((x + 2) + "~~" + (y+1));
					filled.remove(filled.indexOf((x + 2) + "~~" + (y+1)));
					Collections.sort(empty);
				} else {
					count = temp;
				}
			}

			//L1
			if (empty.contains(x + "~~" + (y + 1)) && empty.contains((x + 1) + "~~" + (y+1))
					&& empty.contains((x +2) + "~~" + (y+1)) && i == 1) {
				filled.add(str);
				empty.remove(empty.indexOf(str));
				filled.add(x + "~~" + (y + 1));
				empty.remove(empty.indexOf(x + "~~" + (y + 1)));
				filled.add((x +1) + "~~" + (y + 1));
				empty.remove(empty.indexOf((x + 1) + "~~" + (y + 1)));
				filled.add((x +2) + "~~" + (y+1));
				empty.remove(empty.indexOf((x +2) + "~~" + (y+1)));
				count++;

				//System.out.println("L1" + empty);

				temp = checkBlocks(empty, filled, input1, input2, count);

				if (temp == 0) {
					count--;
					empty.add(str);
					filled.remove(filled.indexOf(str));
					empty.add(x + "~~" + (y + 1));
					filled.remove(filled.indexOf(x + "~~" + (y + 1)));
					empty.add((x +1) + "~~" + (y + 1));
					filled.remove(filled.indexOf((x +1) + "~~" + (y + 1)));
					empty.add((x +2) + "~~" + (y+1));
					filled.remove(filled.indexOf((x +2) + "~~" + (y+1)));
					Collections.sort(empty);
				} else {
					count = temp;
				}
			}


			//L2
			if (empty.contains((x+1) + "~~" + y) && empty.contains((x+1)  + "~~" + (y-1))
					&& empty.contains((x+1) + "~~" + (y-2)) && i == 2) {
				filled.add(str);
				empty.remove(empty.indexOf(str));
				filled.add((x+1) + "~~" + y);
				empty.remove(empty.indexOf((x+1) + "~~" + y));
				filled.add((x+1)  + "~~" + (y-1));
				empty.remove(empty.indexOf((x+1)  + "~~" + (y-1)));
				filled.add((x+1) + "~~" + (y-2));
				empty.remove(empty.indexOf((x+1) + "~~" + (y-2)));
				count++;

				//System.out.println("L2" + empty);

				temp = checkBlocks(empty, filled, input1, input2, count);

				if (temp == 0) {
					count--;
					empty.add(str);
					filled.remove(filled.indexOf(str));
					empty.add((x+1) + "~~" + y);
					filled.remove(filled.indexOf((x+1) + "~~" + y));
					empty.add((x+1)  + "~~" + (y-1));
					filled.remove(filled.indexOf((x+1)  + "~~" + (y-1)));
					empty.add((x+1) + "~~" + (y-2));
					filled.remove(filled.indexOf((x+1) + "~~" + (y-2)));
					Collections.sort(empty);
				} else {
					count = temp;
				}
			}
			
			//L3
			if (empty.contains(x + "~~" + (y+1)) && empty.contains(x  + "~~" + (y+2))
					&& empty.contains((x+1) + "~~" + y) && i == 3) {
				filled.add(str);
				empty.remove(empty.indexOf(str));
				filled.add(x + "~~" + (y+1));
				empty.remove(empty.indexOf(x + "~~" + (y+1)));
				filled.add(x  + "~~" + (y+2));
				empty.remove(empty.indexOf(x  + "~~" + (y+2)));
				filled.add((x+1) + "~~" + y);
				empty.remove(empty.indexOf((x+1) + "~~" + y));
				count++;

				//System.out.println("L3 " + empty);

				temp = checkBlocks(empty, filled, input1, input2, count);

				if (temp == 0) {
					count--;
					empty.add(str);
					filled.remove(filled.indexOf(str));
					empty.add(x + "~~" + (y+1));
					filled.remove(filled.indexOf(x + "~~" + (y+1)));
					empty.add(x  + "~~" + (y+2));
					filled.remove(filled.indexOf(x  + "~~" + (y+2)));
					empty.add((x+1) + "~~" + y);
					filled.remove(filled.indexOf((x+1) + "~~" + y));
					Collections.sort(empty);
				} else {
					count = temp;
				}
			}
			

			//L4
			if (empty.contains((x+1) + "~~" + y) && empty.contains((x+2) + "~~" + y)
					&& empty.contains((x + 2) + "~~" + (y-1)) && i == 4) {
				filled.add(str);
				empty.remove(empty.indexOf(str));
				filled.add((x+1) + "~~" + y);
				empty.remove(empty.indexOf((x+1) + "~~" + y));
				filled.add((x+2) + "~~" + y);
				empty.remove(empty.indexOf((x+2) + "~~" + y));
				filled.add((x + 2) + "~~" + (y-1));
				empty.remove(empty.indexOf((x + 2) + "~~" + (y-1)));
				count++;

				//System.out.println("L4 " + empty);

				temp = checkBlocks(empty, filled, input1, input2, count);

				if (temp == 0) {
					count--;
					empty.add(str);
					filled.remove(filled.indexOf(str));
					empty.add((x+1) + "~~" + y);
					filled.remove(filled.indexOf((x+1) + "~~" + y));
					empty.add((x+2) + "~~" + y);
					filled.remove(filled.indexOf((x+2) + "~~" + y));
					empty.add((x + 2) + "~~" + (y-1));
					filled.remove(filled.indexOf((x + 2) + "~~" + (y-1)));
					Collections.sort(empty);
				} else {
					count = temp;
				}
			}

			//L5
			if (empty.contains((x+1) + "~~" + y) && empty.contains((x + 1) + "~~" + (y+1))
					&& empty.contains((x +1) + "~~" + (y+2)) && i == 5) {
				filled.add(str);
				empty.remove(empty.indexOf(str));
				filled.add((x+1) + "~~" + y);
				empty.remove(empty.indexOf((x+1) + "~~" + y));
				filled.add((x +1) + "~~" + (y + 1));
				empty.remove(empty.indexOf((x + 1) + "~~" + (y + 1)));
				filled.add((x +1) + "~~" + (y+2));
				empty.remove(empty.indexOf((x +1) + "~~" + (y+2)));
				count++;

				//System.out.println("L5" + empty);

				temp = checkBlocks(empty, filled, input1, input2, count);

				if (temp == 0) {
					count--;
					empty.add(str);
					filled.remove(filled.indexOf(str));
					empty.add((x+1) + "~~" + y);
					filled.remove(filled.indexOf((x+1) + "~~" + y));
					empty.add((x +1) + "~~" + (y + 1));
					filled.remove(filled.indexOf((x +1) + "~~" + (y + 1)));
					empty.add((x +1) + "~~" + (y+2));
					filled.remove(filled.indexOf((x +1) + "~~" + (y+2)));
					Collections.sort(empty);
				} else {
					count = temp;
				}
			}


			//L6
			if (empty.contains((x+1) + "~~" + y) && empty.contains((x+2)  + "~~" + y)
					&& empty.contains(x + "~~" + (y+1)) && i == 6) {
				filled.add(str);
				empty.remove(empty.indexOf(str));
				filled.add((x+1) + "~~" + y);
				empty.remove(empty.indexOf((x+1) + "~~" + y));
				filled.add((x+2)  + "~~" + y);
				empty.remove(empty.indexOf((x+2)  + "~~" + y));
				filled.add(x + "~~" + (y+1));
				empty.remove(empty.indexOf(x + "~~" + (y+1)));
				count++;

				//System.out.println("L6" + empty);

				temp = checkBlocks(empty, filled, input1, input2, count);

				if (temp == 0) {
					count--;
					empty.add(str);
					filled.remove(filled.indexOf(str));
					empty.add((x+1) + "~~" + y);
					filled.remove(filled.indexOf((x+1) + "~~" + y));
					empty.add((x+2)  + "~~" + y);
					filled.remove(filled.indexOf((x+2)  + "~~" + y));
					empty.add(x + "~~" + (y+1));
					filled.remove(filled.indexOf(x + "~~" + (y+1)));
					Collections.sort(empty);
				} else {
					count = temp;
				}
			}
			
			//L7
			if (empty.contains(x + "~~" + (y+1)) && empty.contains(x  + "~~" + (y+2))
					&& empty.contains((x+1) + "~~" + (y+2)) && i == 7) {
				filled.add(str);
				empty.remove(empty.indexOf(str));
				filled.add(x + "~~" + (y+1));
				empty.remove(empty.indexOf(x + "~~" + (y+1)));
				filled.add(x  + "~~" + (y+2));
				empty.remove(empty.indexOf(x  + "~~" + (y+2)));
				filled.add((x+1) + "~~" + (y+2));
				empty.remove(empty.indexOf((x+1) + "~~" + (y+2)));
				count++;

				//System.out.println("L7 " + empty);

				temp = checkBlocks(empty, filled, input1, input2, count);

				if (temp == 0) {
					count--;
					empty.add(str);
					filled.remove(filled.indexOf(str));
					empty.add(x + "~~" + (y+1));
					filled.remove(filled.indexOf(x + "~~" + (y+1)));
					empty.add(x  + "~~" + (y+2));
					filled.remove(filled.indexOf(x  + "~~" + (y+2)));
					empty.add((x+1) + "~~" + (y+2));
					filled.remove(filled.indexOf((x+1) + "~~" + (y+2)));
					Collections.sort(empty);
				} else {
					count = temp;
				}
			}

			
			// 8 Square Block
			
			if (empty.contains(x + "~~" + (y + 1)) && empty.contains((x + 1) + "~~" + (y + 1))
					&& empty.contains((x + 1) + "~~" + y) && i == 8) {
				filled.add(str);
				empty.remove(empty.indexOf(str));
				filled.add(x + "~~" + (y + 1));
				empty.remove(empty.indexOf(x + "~~" + (y + 1)));
				filled.add((x + 1) + "~~" + y);
				empty.remove(empty.indexOf((x + 1) + "~~" + y));
				filled.add((x + 1) + "~~" + (y + 1));
				empty.remove(empty.indexOf((x + 1) + "~~" + (y + 1)));
				count++;

				//System.out.println("Square " + empty);

				temp = checkBlocks(empty, filled, input1, input2, count);

				if (temp == 0) {
					count--;
					empty.add(str);
					filled.remove(filled.indexOf(str));
					empty.add(x + "~~" + (y + 1));
					filled.remove(filled.indexOf(x + "~~" + (y + 1)));
					empty.add((x + 1) + "~~" + y);
					filled.remove(filled.indexOf((x + 1) + "~~" + y));
					empty.add((x + 1) + "~~" + (y + 1));
					filled.remove(filled.indexOf((x + 1) + "~~" + (y + 1)));
					Collections.sort(empty);
				} else {
					count = temp;
				}
			}
		
			//T9
			if (empty.contains((x+1) + "~~" + (y - 1)) && empty.contains((x + 1) + "~~" + (y + 0))
					&& empty.contains((x + 1) + "~~" + (y+1)) && i == 9) {
				filled.add(str);
				empty.remove(empty.indexOf(str));
				filled.add((x+1) + "~~" + (y - 1));
				empty.remove(empty.indexOf((x+1) + "~~" + (y - 1)));
				filled.add((x + 1) + "~~" + (y + 0));
				empty.remove(empty.indexOf((x + 1) + "~~" + (y + 0)));
				filled.add((x + 1) + "~~" + (y + 1));
				empty.remove(empty.indexOf((x + 1) + "~~" + (y + 1)));
				count++;

				//System.out.println("T9" + empty);

				temp = checkBlocks(empty, filled, input1, input2, count);

				if (temp == 0) {
					count--;
					empty.add(str);
					filled.remove(filled.indexOf(str));
					empty.add((x+1) + "~~" + (y - 1));
					filled.remove(filled.indexOf((x+1) + "~~" + (y - 1)));
					empty.add((x + 1) + "~~" + (y + 0));
					filled.remove(filled.indexOf((x + 1) + "~~" + (y + 0)));
					empty.add((x + 1) + "~~" + (y+1));
					filled.remove(filled.indexOf((x + 1) + "~~" + (y+1)));
					Collections.sort(empty);
				} else {
					count = temp;
				}
			}
			
			//T10
			if (empty.contains((x+0) + "~~" + (y + 1)) && empty.contains((x + 0) + "~~" + (y + 2))
					&& empty.contains((x + 1) + "~~" + (y+1)) && i == 10) {
				filled.add(str);
				empty.remove(empty.indexOf(str));
				filled.add((x+0) + "~~" + (y + 1));
				empty.remove(empty.indexOf((x+0) + "~~" + (y + 1)));
				filled.add((x + 0) + "~~" + (y + 2));
				empty.remove(empty.indexOf((x + 0) + "~~" + (y + 2)));
				filled.add((x + 1) + "~~" + (y + 1));
				empty.remove(empty.indexOf((x + 1) + "~~" + (y + 1)));
				count++;

				//System.out.println("T10" + empty);

				temp = checkBlocks(empty, filled, input1, input2, count);

				if (temp == 0) {
					count--;
					empty.add(str);
					filled.remove(filled.indexOf(str));
					empty.add((x+0) + "~~" + (y + 1));
					filled.remove(filled.indexOf((x+0) + "~~" + (y + 1)));
					empty.add((x + 0) + "~~" + (y + 2));
					filled.remove(filled.indexOf((x + 0) + "~~" + (y + 2)));
					empty.add((x + 1) + "~~" + (y+1));
					filled.remove(filled.indexOf((x + 1) + "~~" + (y+1)));
					Collections.sort(empty);
				} else {
					count = temp;
				}
			}
			
			//T11
			if (empty.contains((x+1) + "~~" + (y - 1)) && empty.contains((x + 1) + "~~" + (y + 0))
					&& empty.contains((x + 2) + "~~" + (y+0)) && i == 11) {
				filled.add(str);
				empty.remove(empty.indexOf(str));
				filled.add((x+1) + "~~" + (y - 1));
				empty.remove(empty.indexOf((x+1) + "~~" + (y - 1)));
				filled.add((x + 1) + "~~" + (y + 0));
				empty.remove(empty.indexOf((x + 1) + "~~" + (y + 0)));
				filled.add((x + 2) + "~~" + (y+0));
				empty.remove(empty.indexOf((x + 2) + "~~" + (y+0)));
				count++;

				//System.out.println("T11" + empty);

				temp = checkBlocks(empty, filled, input1, input2, count);

				if (temp == 0) {
					count--;
					empty.add(str);
					filled.remove(filled.indexOf(str));
					empty.add(((x+1) + "~~" + (y - 1)));
					filled.remove(filled.indexOf((x+1) + "~~" + (y - 1)));
					empty.add((x + 1) + "~~" + (y + 0));
					filled.remove(filled.indexOf((x + 1) + "~~" + (y + 0)));
					empty.add((x + 2) + "~~" + (y+0));
					filled.remove(filled.indexOf((x + 2) + "~~" + (y+0)));
					Collections.sort(empty);
				} else {
					count = temp;
				}
			}

			//T12
			if (empty.contains((x+1) + "~~" + (y +0)) && empty.contains((x + 1) + "~~" + (y + 1))
					&& empty.contains((x + 2) + "~~" + (y+0)) && i == 12) {
				filled.add(str);
				empty.remove(empty.indexOf(str));
				filled.add((x+1) + "~~" + (y +0));
				empty.remove(empty.indexOf((x+1) + "~~" + (y +0)));
				filled.add((x + 1) + "~~" + (y + 1));
				empty.remove(empty.indexOf((x + 1) + "~~" + (y + 1)));
				filled.add((x + 2) + "~~" + (y+0));
				empty.remove(empty.indexOf((x + 2) + "~~" + (y+0)));
				count++;

				//System.out.println("T12" + empty);

				temp = checkBlocks(empty, filled, input1, input2, count);

				if (temp == 0) {
					count--;
					empty.add(str);
					filled.remove(filled.indexOf(str));
					empty.add(((x+1) + "~~" + (y +0)));
					filled.remove(filled.indexOf((x+1) + "~~" + (y +0)));
					empty.add((x + 1) + "~~" + (y + 1));
					filled.remove(filled.indexOf((x + 1) + "~~" + (y + 1)));
					empty.add((x + 2) + "~~" + (y+0));
					filled.remove(filled.indexOf((x + 2) + "~~" + (y+0)));
					Collections.sort(empty);
				} else {
					count = temp;
				}
			}
			
			//S13
			if (empty.contains((x+1) + "~~" + (y +0)) && empty.contains((x + 1) + "~~" + (y + 1))
					&& empty.contains((x + 2) + "~~" + (y+1)) && i == 13) {
				filled.add(str);
				empty.remove(empty.indexOf(str));
				filled.add((x+1) + "~~" + (y +0));
				empty.remove(empty.indexOf((x+1) + "~~" + (y +0)));
				filled.add((x + 1) + "~~" + (y + 1));
				empty.remove(empty.indexOf((x + 1) + "~~" + (y + 1)));
				filled.add((x + 2) + "~~" + (y+1));
				empty.remove(empty.indexOf((x + 2) + "~~" + (y+1)));
				count++;

				//System.out.println("S13" + empty);

				temp = checkBlocks(empty, filled, input1, input2, count);

				if (temp == 0) {
					count--;
					empty.add(str);
					filled.remove(filled.indexOf(str));
					empty.add(((x+1) + "~~" + (y +0)));
					filled.remove(filled.indexOf((x+1) + "~~" + (y +0)));
					empty.add((x + 1) + "~~" + (y + 1));
					filled.remove(filled.indexOf((x + 1) + "~~" + (y + 1)));
					empty.add((x + 2) + "~~" + (y+1));
					filled.remove(filled.indexOf((x + 2) + "~~" + (y+1)));
					Collections.sort(empty);
				} else {
					count = temp;
				}
			}
			
			//S14
			if (empty.contains((x+0) + "~~" + (y + 1)) && empty.contains((x + 1) + "~~" + (y -1))
					&& empty.contains((x + 1) + "~~" + (y+0)) && i == 14) {
				filled.add(str);
				empty.remove(empty.indexOf(str));
				filled.add((x+0) + "~~" + (y + 1));
				empty.remove(empty.indexOf((x+0) + "~~" + (y + 1)));
				filled.add((x + 1) + "~~" + (y -1));
				empty.remove(empty.indexOf((x + 1) + "~~" + (y -1)));
				filled.add((x + 1) + "~~" + (y+0));
				empty.remove(empty.indexOf((x + 1) + "~~" + (y+0)));
				count++;

				//System.out.println("S14" + empty);

				temp = checkBlocks(empty, filled, input1, input2, count);

				if (temp == 0) {
					count--;
					empty.add(str);
					filled.remove(filled.indexOf(str));
					empty.add((x+0) + "~~" + (y + 1));
					filled.remove(filled.indexOf((x+0) + "~~" + (y + 1)));
					empty.add((x + 1) + "~~" + (y -1));
					filled.remove(filled.indexOf((x + 1) + "~~" + (y -1)));
					empty.add((x + 1) + "~~" + (y+0));
					filled.remove(filled.indexOf((x + 1) + "~~" + (y+0)));
					Collections.sort(empty);
				} else {
					count = temp;
				}
			}

			//S15
			if (empty.contains((x+1) + "~~" + (y - 1)) && empty.contains((x + 1) + "~~" + (y + 0))
					&& empty.contains((x + 2) + "~~" + (y-1)) && i == 15) {
				filled.add(str);
				empty.remove(empty.indexOf(str));
				filled.add((x+1) + "~~" + (y - 1));
				empty.remove(empty.indexOf((x+1) + "~~" + (y - 1)));
				filled.add((x + 1) + "~~" + (y + 0));
				empty.remove(empty.indexOf((x + 1) + "~~" + (y + 0)));
				filled.add((x + 2) + "~~" + (y-1));
				empty.remove(empty.indexOf((x + 2) + "~~" + (y-1)));
				count++;

				//System.out.println("S15" + empty);

				temp = checkBlocks(empty, filled, input1, input2, count);

				if (temp == 0) {
					count--;
					empty.add(str);
					filled.remove(filled.indexOf(str));
					empty.add(((x+1) + "~~" + (y - 1)));
					filled.remove(filled.indexOf((x+1) + "~~" + (y - 1)));
					empty.add((x + 1) + "~~" + (y + 0));
					filled.remove(filled.indexOf((x + 1) + "~~" + (y + 0)));
					empty.add((x + 2) + "~~" + (y-1));
					filled.remove(filled.indexOf((x + 2) + "~~" + (y-1)));
					Collections.sort(empty);
				} else {
					count = temp;
				}
			}

			//S16
			if (empty.contains((x+0) + "~~" + (y + 1)) && empty.contains((x + 1) + "~~" + (y + 2))
					&& empty.contains((x + 1) + "~~" + (y+1)) && i == 16) {
				filled.add(str);
				empty.remove(empty.indexOf(str));
				filled.add((x+0) + "~~" + (y + 1));
				empty.remove(empty.indexOf((x+0) + "~~" + (y + 1)));
				filled.add((x + 1) + "~~" + (y + 2));
				empty.remove(empty.indexOf((x + 1) + "~~" + (y + 2)));
				filled.add((x + 1) + "~~" + (y + 1));
				empty.remove(empty.indexOf((x + 1) + "~~" + (y + 1)));
				count++;

				//System.out.println("S16" + empty);

				temp = checkBlocks(empty, filled, input1, input2, count);

				if (temp == 0) {
					count--;
					empty.add(str);
					filled.remove(filled.indexOf(str));
					empty.add((x+0) + "~~" + (y + 1));
					filled.remove(filled.indexOf((x+0) + "~~" + (y + 1)));
					empty.add((x + 1) + "~~" + (y + 2));
					filled.remove(filled.indexOf((x + 1) + "~~" + (y + 2)));
					empty.add((x + 1) + "~~" + (y+1));
					filled.remove(filled.indexOf((x + 1) + "~~" + (y+1)));
					Collections.sort(empty);
				} else {
					count = temp;
				}
			}

			
			// horizontal line
			if (empty.contains(x + "~~" + (y + 1)) && empty.contains(x + "~~" + (y + 2))
					&& !options.contains("horizontal") && i == 17) {
				filled.add(str);
				empty.remove(empty.indexOf(str));
				filled.add(x + "~~" + (y + 1));
				empty.remove(empty.indexOf(x + "~~" + (y + 1)));
				filled.add(x + "~~" + (y + 2));
				empty.remove(empty.indexOf(x + "~~" + (y + 2)));
				count++;

				//System.out.println("Horizontal line " + empty);
				temp = checkBlocks(empty, filled, input1, input2, count);

				if (temp == 0) {
					count--;
					empty.add(str);
					filled.remove(filled.indexOf(str));
					empty.add(x + "~~" + (y + 1));
					filled.remove(filled.indexOf(x + "~~" + (y + 1)));
					empty.add(x + "~~" + (y + 2));
					filled.remove(filled.indexOf(x + "~~" + (y + 2)));
					Collections.sort(empty);
				} else {
					count = temp;
				}

			}

			// vertical line
			if (empty.contains((x + 1) + "~~" + y) && empty.contains((x + 2) + "~~" + y)
					&& !options.contains("vertical") && i == 18) {
				filled.add(str);
				empty.remove(empty.indexOf(str));
				filled.add((x + 1) + "~~" + y);
				empty.remove(empty.indexOf((x + 1) + "~~" + y));
				filled.add((x + 2) + "~~" + y);
				empty.remove(empty.indexOf((x + 2) + "~~" + y));
				count++;

				//System.out.println("Vertical line " + empty);

				temp = checkBlocks(empty, filled, input1, input2, count);

				if (temp == 0) {
					count--;
					empty.add(str);
					filled.remove(filled.indexOf(str));
					empty.add((x + 1) + "~~" + y);
					filled.remove(filled.indexOf((x + 1) + "~~" + y));
					empty.add((x + 2) + "~~" + y);
					filled.remove(filled.indexOf((x + 2) + "~~" + y));
					Collections.sort(empty);
				} else {
					count = temp;
				}
			}

			i++;
		}

		
		if (empty.size() != 0)
			return 0;
		else
			return count;
	}

		 
	public static int[][] prepareMatrix(int input1, int input2, int[] input3) {
		int[][] matrix = new int[input1][input2];
		int k = 0;
		
		for (int i = 0; i < input1; i++)
			for (int j = 0; j < input2; j++) {
				matrix[i][j] = input3[k++];
			}
		
		return matrix;
	}

public static int validSubMatrix(List<String> empty, List<String> filled, int input1){
		
		for(String str : empty){
			String[] s = str.split("~~");
			int x = Integer.parseInt(s[0]);
			int y = Integer.parseInt(s[1]);
			for(int i = x; i < input1; i++){
				if(filled.contains(i+"~~"+y))
					return 0;
			}
			
		}
		
	return 1;
	}

}


