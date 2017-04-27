public class RandomLetterChooser extends RandomStringChooser{
	
	public RandomLetterChooser(String str){
		super(getSingleLetters(str));
	}
	public static String[] getSingleLetters(String str){
		String[] sArr = new String[str.length()];
		for(int k = 0; k < sArr.length; k++){
			sArr[k] = str.substring(k, k + 1);
		}
		return sArr;
	}
	public static void main(String[] args) {
		RandomLetterChooser r = new RandomLetterChooser("ZAWARUDO");
		for(int k = 0; k < 8; k++){
			System.out.println(r.getNext());
		}
	}
}
