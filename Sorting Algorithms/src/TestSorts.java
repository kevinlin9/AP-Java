import java.util.ArrayList;

public class TestSorts
{
	public static void main(String[] args)
	{
		
/*		int[] nums = new int[100];
		for (int i = 0; i < nums.length; i++)
			nums[i] = (int)(Math.random() * 101);
			
		SortExamples.selectionSort(nums);
		for (int n : nums)
			System.out.println(n);
			
		for (int i = 0; i < nums.length; i++)
			nums[i] = (int)(Math.random() * 101);
			
		SortExamples.insertionSort(nums);
		for (int n : nums)
			System.out.println(n);
			
		for (int i = 0; i < nums.length; i++)
			nums[i] = (int)(Math.random() * 101);
			
		SortExamples.mergeSort(nums);
		for (int n : nums)
			System.out.println(n);
			
*/
		//selectionSort test
		System.out.print("selectionSort milliseconds: ");
		int[] nums = new int[100000];
		for (int i = 0; i < nums.length; i++)
			nums[i] = (int)(Math.random() * 101);
			
		long start = 0;
		long end = 0;
		start = System.currentTimeMillis();
		SortExamples.selectionSort(nums);
		end = System.currentTimeMillis();
		System.out.println(end - start);

		//insertionSort test
		System.out.print("insertionSort milliseconds: ");
		for (int i = 0; i < nums.length; i++)
			nums[i] = (int)(Math.random() * 101);
			
		start = System.currentTimeMillis();
		SortExamples.insertionSort(nums);
		end = System.currentTimeMillis();
		System.out.println(end - start);
		
		//mergeSort test
		System.out.print("mergeSort milliseconds: ");
		for (int i = 0; i < nums.length; i++)
			nums[i] = (int)(Math.random() * 101);
			
		start = System.currentTimeMillis();
		SortExamples.mergeSort(nums);
		end = System.currentTimeMillis();
		System.out.println(end - start);
		
		System.out.println();
		System.out.println("Tests on already sorted array");
		
		//selectionSort test
		System.out.print("selectionSort milliseconds: ");
		start = System.currentTimeMillis();
		SortExamples.selectionSort(nums);
		end = System.currentTimeMillis();
		System.out.println(end - start);
		
		//insertionSort test
		System.out.print("insertionSort milliseconds: ");
		start = System.currentTimeMillis();
		SortExamples.insertionSort(nums);
		end = System.currentTimeMillis();
		System.out.println(end - start);
		
		//mergeSort test
		System.out.print("mergeSort milliseconds: ");
		start = System.currentTimeMillis();
		SortExamples.mergeSort(nums);
		end = System.currentTimeMillis();
		System.out.println(end - start);
		
		System.out.println();				
						
/*		int[] nums = {83, 41, 68, 90, 25, 7, 14, 76};
		SortExamples.selectionSort(nums);
		for (int num : nums)
			System.out.print(num + "  ");
		System.out.println("\n");
		
		String[] names = {"Nicholas", "Chistopher", "Emilly",
			"Amal", "Isaac", "Tony", "Austin", "Justin", 
			"Rich", "Alan", "Christina", "Gerry", "Jennifer", 
			"Philip", "Sean", "Ellis", "Kenny", "Amy", 
			"Jackie", "Gerardine", "Alex", "Richard", "Carlos", 
			"Sam", "Rene", "Latif", "Damon", "Kangming", 
			"Wilson", "Zachary", "Jong Shen", "Linda",
			"Deanna", "Kyle", "Charley"};
		
		SortExamples.selectionSort(names);
		
		for (String name : names)
			System.out.println(name);
		System.out.println("\n");			

		ArrayList<String> names = new ArrayList<String>();
		names.add("Nicholas");
		names.add("Chistopher");
		names.add("Emilly");
		names.add("Amal");
		names.add("Isaac");
		names.add("Tony");
		names.add("Austin");
		names.add("Justin"); 
		names.add("Rich");
		names.add("Alan");
		names.add("Christina");
		names.add("Gerry");
		names.add("Jennifer");
		names.add("Philip");
		names.add("Sean");
		names.add("Ellis");
		names.add("Kenny");
		names.add("Amy");
		names.add("Jackie");
		names.add("Gerardine");
		names.add("Alex");
		names.add("Richard");
		names.add("Carlos");
		names.add("Sam");
		names.add("Rene");
		names.add("Latif");
		names.add("Damon");
		names.add("Kangming");
		names.add("Wilson");
		names.add("Zachary");
		names.add("Jong Shen");
		names.add("Deanna");
		names.add("Kyle");
		names.add("Charley");
		
		SortExamples.selectionSort(names);
		for (String s : names)
			System.out.println(s);	
				
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		numbers.add(new Integer(7));
		numbers.add(new Integer(2));
		numbers.add(new Integer(67));
		numbers.add(new Integer(71));
		numbers.add(new Integer(42));
		numbers.add(new Integer(8));
		numbers.add(new Integer(3));
		numbers.add(new Integer(15));
		numbers.add(new Integer(6));
		
		SortExamples.selectionSort2(numbers);
		System.out.println(numbers);
*/
	}
}