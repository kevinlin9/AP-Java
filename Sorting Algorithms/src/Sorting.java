//@author Kevin Lin
public class Sorting {
	public static void main(String[] args){
		// Selection Sort Integers
		double[] arr1 = {98.5,104.2,85.2,90.4,123.77,225.1};
		for(double d:arr1)
			System.out.print(d + ", ");
		System.out.println();
		Utilities.selectionSort(arr1);
		for(double d:arr1)
			System.out.print(d + ", ");
		// Selection Sort Strings
		String[] arr2 = {"Armin", "Benny","Tsuma","Xiwang","Daiyo"};
		Utilities.printArr(arr2);
		System.out.println();
		Utilities.selectionSort(arr2);
		Utilities.printArr(arr2);
		System.out.println();
	}
}
