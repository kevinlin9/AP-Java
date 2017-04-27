public class Utilities
{
	public static int getRandomInteger(int min, int max){
		int result = (int)(min + Math.random() * (max - min));
		return result;
	}
	public static int sum(int[] arr){
		int sum = 0;
		for(int i = 0; i < arr.length; i++)
			sum += arr[i];
		return sum;
	}
	public static double average(int[] arr){
		double avg = sum(arr) / arr.length;
		return avg;
	}
	public static void printArr(int[] arr){
		for (int num : arr)
			System.out.print(num + " ");
	}
	public static void printArr(String[] arr){
		for (String str : arr)
			System.out.print(str + " ");
	}
	public static int largestValue(int[] arr){
		int largest = Integer.MIN_VALUE; 
		for(int i = 0; i < arr.length; i++){
			if(arr[i] > largest)
				largest = arr[i];
		}
		return largest;
	}	
	public static int positionOfLargest(int[] arr){
		int pos = 0;
		for(int i = 1; i < arr.length; i++)
			if(arr[i] > arr[pos])
				pos = i;
		return pos;
	}	
	public static int[] insertElement(int value, int[] arr, int idx){//precondition: index >= 0 && index <= arr.length
		int[] arr2 = new int[arr.length + 1];
		for(int i = 0; i < idx; i++)
			arr2[i] = arr[i];
		arr2[idx] = value;
		for(int i = idx + 1; i < arr2.length; i++)
			arr2[i] = arr[i-1];
		return arr2;		
	}
	public static int[] deleteElement(int[] arr, int idx){
		int[] arr2 = new int[arr.length - 1];
		for(int i = 0; i < idx; i++)
			arr2[i] = arr[i];
		for(int i = idx + 1; i < arr.length; i++)
			arr2[i - 1] = arr[i];
		return arr2;
	}
	public static int[] createIntArray(int arrLength){
		return new int[arrLength];
	}
	// String Utilities
	public static String reverseString(String str){
		String reversedString = "";
		for(int i = str.length() - 1; i >= 0; i--){
			reversedString += str.substring(i, i + 1);
		}
		return reversedString;
	}
	public static boolean isPalindrome(String str){
		return str.equals(reverseString(str));
	}
	public static boolean isVowel(String str){
		String[] vowels = {"a","e","i","o","u"};
		if(str.length() == 1)
			for(int i = 0; i < vowels.length; i++)
				if(str.equalsIgnoreCase(vowels[i]))
					return true;
		return false;
	}
	public static void selectionSort(double[] values){
		for(int j = 0; j < values.length - 1; j++){
			int minIndex = j;
			for(int k = j + 1; k < values.length; k++)
				if(values[k] > values[minIndex])
					minIndex = k;
			swap(values, minIndex, j);
		}
		
	}
	private static void swap(double[] arr,int valueIndex, int pivotIndex){
		double storage = arr[pivotIndex];
		arr[pivotIndex] = arr[valueIndex];
		arr[valueIndex] = storage;
	}
	public static void selectionSort(String[] values){
		for(int j = 0; j < values.length - 1; j++){
			int minIndex = j;
			for(int k = j + 1; k < values.length; k++)
				if(values[k].compareTo(values[minIndex]) < 0 )
					minIndex = k;
			swap(values, minIndex, j);
		}
		
	}
	private static void swap(String[] arr,int valueIndex, int pivotIndex){
		String storage = arr[pivotIndex];
		arr[pivotIndex] = arr[valueIndex];
		arr[valueIndex] = storage;
	}
}
