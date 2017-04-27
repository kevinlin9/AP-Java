// My Response to AP Problem #4 - 2012
public class GrayImage {
	public static final int BLACK = 0;
	public static final int WHITE = 255;
	private int[][] pixelValues;
	
	public int countWhitePixels(){
		int count = 0;
		for(int[] a : pixelValues)
			for(int b : a)
				if(b == WHITE)
					count++;
		return count;
	}
	
	public void processImage(){
		int numRows = pixelValues.length;
		int numCols = pixelValues[0].length;
		for(int row = 0; row < numRows; row++){
			for(int col = 0; col < numCols; col++){
				if(row + 2 < numRows && col + 2 < numCols){
					int result = pixelValues[row][col] - pixelValues[row + 2][col + 2];
					if(result < BLACK)
						pixelValues[row][col] = BLACK;
					else
						pixelValues[row][col] = result;
				}
			}
		}
	}
}
