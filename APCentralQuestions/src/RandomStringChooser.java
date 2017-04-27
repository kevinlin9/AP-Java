import java.util.Arrays;

public class RandomStringChooser {
	private String[] wordArray;
	private String[] copyArray;
	
	public RandomStringChooser(String[] wArray){
		wordArray = wArray;
		copyArray = wArray;
	}
	public String getNext(){
		int randomIndex = 0;
		String w = "";
		while(copyArray.length > 0){
			randomIndex = (int)(Math.random() * wordArray.length);
			w = wordArray[randomIndex];
			int idx = 0;
			for(int i = 0; i < copyArray.length; i++){
				if(w.equals(copyArray[i])){
					System.out.println(Arrays.toString(copyArray));
					String[] temp = new String[copyArray.length - 1];
					for(int j = 0; j < copyArray.length; j++){
						if(j != i){
							temp[idx] = copyArray[j];
							idx++;
						}
					}
					copyArray = temp;
					return w;
				}			
			}
		}
		return "NONE";
	}
}
