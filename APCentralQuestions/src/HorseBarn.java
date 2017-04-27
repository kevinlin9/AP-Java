// AP Central 2012 Problem #3 
public class HorseBarn {
	private Horse[] spaces;
	
	public int findHorseSpace(String name){
		int loc = -1;
		for(int i = 0; i < spaces.length; i++){
			if(spaces[i] != null && spaces[i].getName().equals(name)){
				loc = i;
				return loc;
			}
		}
		return loc;
	}
	public void consolidate(){
		Horse[] temp = new Horse[spaces.length];
		int tempIdx = 0;
		for(Horse h : spaces){
			if(h != null){
				temp[tempIdx] = h;
				tempIdx++;
			}
		}
		spaces = temp;
	}
}
