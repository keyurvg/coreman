package Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Techgig {
	public static void main(String args[]) {
		
		int input1 = 15;
		System.out.println(combinationCounts(input1));

	}

	
	public static int combinationCounts(int input1){
		int combination = 0;

		Map<String,Integer> level2combinations =  new HashMap<String, Integer>();
		level2combinations.put("A", 3);
		level2combinations.put("B", 4);
		level2combinations.put("C", 3);
		level2combinations.put("D", 4);
		level2combinations.put("E", 5);
		level2combinations.put("F", 4);
		level2combinations.put("G", 3);
		level2combinations.put("H", 5);
		level2combinations.put("I", 3);
		level2combinations.put("J", 2);
		
		if(input1 <=0)
			return 0;
		
		if(input1 == 1)
			return 10;
		
		if(input1 == 2){
			for(Integer i : level2combinations.values()){
				combination = combination + i;
			}
			return combination;
		}

		
		HashMap<String, List<String>> keypad = new HashMap<String, List<String>>();
		keypad.put("A", new ArrayList<String>(Arrays.asList("B", "D")));
		keypad.put("B", new ArrayList<String>(Arrays.asList("A", "E", "C")));
		keypad.put("C", new ArrayList<String>(Arrays.asList("B", "F")));
		keypad.put("D", new ArrayList<String>(Arrays.asList("A", "E","G")));
		keypad.put("E", new ArrayList<String>(Arrays.asList("B", "D","F", "H")));
		keypad.put("F", new ArrayList<String>(Arrays.asList("C", "E", "I")));
		keypad.put("G", new ArrayList<String>(Arrays.asList("D", "H")));
		keypad.put("H", new ArrayList<String>(Arrays.asList("E", "I", "J", "G")));
		keypad.put("I", new ArrayList<String>(Arrays.asList("F", "H")));
		keypad.put("J", new ArrayList<String>(Arrays.asList("H")));
		
		
		for(Map.Entry<String, List<String>> i : keypad.entrySet()){
			combination = combination + getBranchCombination(level2combinations, keypad, input1-1, i.getKey());
			for(String s : i.getValue()){
				combination = combination + getBranchCombination(level2combinations, keypad, input1-1, s);
			}
		}
		return combination;
		
	}

	public static int getBranchCombination(Map<String, Integer> level2combinations,
			HashMap<String, List<String>> keypad, int level, String key) {
		if (level == 2) {
			return level2combinations.get(key);
		} else {
			List<String> traverse = keypad.get(key);
			int value = 0;
			value = value + getBranchCombination(level2combinations, keypad, level - 1, key);
			for (String s : traverse)
				value = value + getBranchCombination(level2combinations, keypad, level - 1, s);

			return value;
		}

	}
	

	public static String getOutput(int input1, int[] input2, int[] input3){
		if(input2.length != input1 || input3.length != input1 || input2.length != input3.length)
			return "Invalid";
		
		int sumInput2 = 0;
		int sumInput3 = 0;
		for(int i=0; i < input2.length; i++)
		{
			if(input2[i]< 0)
				return "Invalid";
			sumInput2 = sumInput2 + input2[i]; 
		}
		for(int i=0; i < input3.length; i++)
		{
			if(input3[i]< 0)
				return "Invalid";
			sumInput3 = sumInput3 + input3[i];
		}
			
		if(sumInput2 != sumInput3)
			return "Unequal";
		else{
			for(int i = 0; i < input2.length ; i++)
			{
				for(int j = i; j < input2.length ; j++)
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
			
			for(int i = 0; i <  input2.length; i++){
				if(input2[i] != input3[i])
					return "Unequal";
			}
		}
		return "Equal";
	}
	
}
