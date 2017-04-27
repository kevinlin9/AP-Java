import java.util.ArrayList;

public class SortExamples
{
	public static void insertionSort(int[] elements)
	{
		for (int j = 1; j < elements.length; j++)
		{
			int temp = elements[j];
			int possibleIndex = j;
			while (possibleIndex > 0 && temp < elements[possibleIndex - 1])
			{
				elements[possibleIndex] = elements[possibleIndex - 1];
				possibleIndex--;
			}
			elements[possibleIndex] = temp;
		}
	}

	//postcondition: arr is sorted in ascending order
	public static void selectionSort(int[] arr)
	{
		for (int i = 0; i < arr.length - 1; i++)
		{
			int lowPosition = i;
			for (int j = i + 1; j < arr.length; j++)
			{
				if (arr[j] < arr[lowPosition])
					lowPosition = j;	
			}
			swap(i, lowPosition, arr);
		}
	}
	
	private static void swap(int a, int b, int[] array)
	{
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}

	//postcondition: arr is sorted in ascending order
	public static void selectionSort(String[] arr)
	{
		for (int i = 0; i < arr.length - 1; i++)
		{
			int lowPosition = i;
			for (int j = i + 1; j < arr.length; j++)
			{				if (arr[j].compareTo(arr[lowPosition]) < 0)
					lowPosition = j;	
			}
			swap(i, lowPosition, arr);
		}
	}
	
	private static void swap(int a, int b, String[] array)
	{
		String temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
	
	public static void selectionSort(ArrayList<String> strs)
	{
		for (int i = 0; i < strs.size() - 1; i++)
		{
			int lowPosition = i;
			for (int j = i + 1; j < strs.size(); j++)
			{
				if (strs.get(j).compareTo(strs.get(lowPosition)) < 0)
					lowPosition = j;	
			}
			//swap(i, lowPosition, strs);
			strs.set(i, strs.set(lowPosition, strs.get(i)));
		}
	}
	
	private static void swap(int a, int b, ArrayList<String> list)
	{
		String temp = list.get(a);
		list.set(a, list.get(b));
		list.set(b, temp);
	}

	public static void selectionSort2(ArrayList<Integer> nums)
	{
		for (int i = 0; i < nums.size() - 1; i++)
		{
			int lowPosition = i;
			for (int j = i + 1; j < nums.size(); j++)
			{
				if (nums.get(j).compareTo(nums.get(lowPosition)) < 0)
					lowPosition = j;	
			}
			swap2(i, lowPosition, nums);
		}
	}
	
	private static void swap2(int a, int b, ArrayList<Integer> list)
	{
		Integer temp = list.get(a);
		list.set(a, list.get(b));
		list.set(b, temp);
	}

	public static void mergeSort(int[] elements)
	{
		int n = elements.length;
		int[] temp = new int[n];
		mergeSortHelper(elements, 0, n-1, temp);
	}
	
	private static void mergeSortHelper(
		int[] elements, int from, int to, int[] temp)
	{
		if (from < to)
		{
			int middle = (from + to) / 2;
			mergeSortHelper(
				elements, from, middle, temp);
			mergeSortHelper(
				elements, middle + 1, to, temp);
				
			merge(elements, from, middle, to, temp);
		}
	}
	
	private static void merge(int[] elements, 
		int from, int mid, int to, int[] temp)
	{
		int i = from;
		int j = mid + 1;
		int k = from;
		
		while (i <= mid && j <= to)
		{
			if (elements[i] < elements[j])
			{
				temp[k] = elements[i];
				i++;
			}
			else
			{
				temp[k] = elements[j];
				j++;
			}
			k++;
		}
		
		while (i <= mid)
		{
			temp[k] = elements[i];
			i++;
			k++;
		}
		while (j <= to)
		{
			temp[k] = elements[j];
			j++;
			k++;
		}
		for (k = from; k <= to; k++)
			elements[k] = temp[k];
	}
	

}