import java.util.List;
import java.util.ArrayList;

// 2015 AP Problem #3 SparseArray
public class SparseArray {
	private int numRows;
	private int numCols;
	
	private List<SparseArrayEntry> entries;
	
	public SparseArray(){
		entries = new ArrayList<SparseArrayEntry>();
	}
	public int getNumRows(){
		return numRows;
	}
	public int getNumCols(){
		return  numCols;
	}
	public int getValueAt(int row, int col){
		int val = 0;
		for(SparseArrayEntry s : entries){
			if(s.getCol() == col && s.getRow() == row)
				val = s.getValue();
		}
		return val;
	}
	public void removeColumn(int col){
		int numRemovedCols = 0;
		for(int i = 0; i < entries.size(); i++){
			if(entries.get(i).getCol() == col){
				numRemovedCols += entries.get(i).getCol();
				entries.remove(i);
			}
			for(int j = 0; j < entries.size(); j++){
				if(entries.get(i).getCol() > col)
					entries.get(i).setCol(entries.get(i).getCol() - 1);
			}
		}
		numCols -= numRemovedCols;
	}
}
