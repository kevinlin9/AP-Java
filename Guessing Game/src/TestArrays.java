public class TestArrays
{
	// created on 9/21/2016
	public static void main(String[] args)
	{
		/*int[] array1 = {5,-7,-11,43,0,31459,-8,30};
		int sum1 = ArrayUtils.sum(array1);
		System.out.println("sum1 = " + sum1);
		// 9/22/2016
		System.out.println("Largest value = " + largestValue(array1));
		System.out.println(positionOfLargest(array1));*/
		testDeleteElement();
	}
	public static int largestValue(int[] arr)
	{
		int largest = Integer.MIN_VALUE; // returns
		for(int i = 0; i < arr.length; i++)
		{
			if(arr[i] > largest)
				largest = arr[i];
		}
		return largest;
	}
	
	/* Static constants
	 * int Integer.MIN_VALUE == -2^31
	 * int Integer.MAX_VALUE == 2^31 - 1
	 * double Math.PI == 3.14159265...
	 * double Math.E == natural exponent ~~ 2.718...
	 */

	public static int positionOfLargest(int[] arr)
	{
		int pos = 0;
		for(int i = 1; i < arr.length; i++)
			if(arr[i] > arr[pos])
				pos = i;
		return pos;
	}
	
	// 9/28/16 my birthday hurrah~
	
	public static void testInsertElement(){
		System.out.println("Running Test for insertElement();");
		int[] tcase = {1,2,3,4,5,6,7,8,9};
		int idx = Utilities.getRandomInteger(0, tcase.length - 1);
		int val = Utilities.getRandomInteger(0, 500);
		int[] oput = ArrayUtils.insertElement(val,tcase,idx);
		System.out.println("inserted int value: " + val + "    " + "at index: " + idx);
		System.out.println("Old Array:");
		for (int i = 0; i < tcase.length; i++)
			System.out.print(tcase[i] + "    ");
		System.out.print("Length:" + tcase.length);
		System.out.println();
		System.out.println("New Array:");
		for (int i = 0; i < oput.length; i++)
			System.out.print(oput[i] + "    ");
		System.out.print("Length:" + oput.length);
	}
	
	// 9/29/16 
	
	public static void testDeleteElement(){
		System.out.println("Running Test for deleteElement();");
		int[] tcase = {1,2,3,4,5,6,7,8,9};
		int idx = Utilities.getRandomInteger(0, tcase.length - 1);
		int[] oput = ArrayUtils.deleteElement(tcase,idx);
		System.out.println("deleted value at index: " + idx);
		System.out.println("Old Array:");
		for (int i = 0; i < tcase.length; i++)
			System.out.print(tcase[i] + "    ");
		System.out.print("Length:" + tcase.length);
		System.out.println();
		System.out.println("New Array:");
		for (int i = 0; i < oput.length; i++)
			System.out.print(oput[i] + "    ");
		System.out.print("Length:" + oput.length);
		
	}
	
}