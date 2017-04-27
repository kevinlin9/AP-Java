import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param height the height of the desired picture
   * @param width the width of the desired picture
   */
  public Picture(int height, int width)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   * @param copyPicture the picture to copy
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }
  
  /** Method to set the blue to 0 */
  public void zeroBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setBlue(0);
      }
    }
  }
  
  public void keepOnlyBlue() {
	  Pixel[][] pixels = this.getPixels2D();
	  for (Pixel[] rowArray : pixels)
		  for (Pixel pixelObj : rowArray) {
			  pixelObj.setRed(0);
			  pixelObj.setGreen(0);
		  }
  }
  
  public void keepOnlyRed() {
	  Pixel[][] pixels = this.getPixels2D();
	  for (Pixel[] rowArray : pixels)
		  for (Pixel pixelObj : rowArray) {
			  pixelObj.setBlue(0);
			  pixelObj.setGreen(0);
		  }
  }
  
  public void keepOnlyGreen() {
	  Pixel[][] pixels = this.getPixels2D();
	  for (Pixel[] rowArray : pixels)
		  for (Pixel pixelObj : rowArray) {
			  pixelObj.setRed(0);
			  pixelObj.setBlue(0);
		  }
  }
  
  public void negate() {
	  Pixel[][] pixels = this.getPixels2D();
	  for (Pixel[] rowArray : pixels)
		  for (Pixel pixelObj : rowArray) {
			  pixelObj.setRed(255 - pixelObj.getRed());
			  pixelObj.setGreen(255 - pixelObj.getGreen());
			  pixelObj.setBlue(255 - pixelObj.getBlue());
		  }
  }
  
  public void grayscale() {
	  Pixel[][] pixels = this.getPixels2D();
	  for (Pixel[] rowArray : pixels)
		  for (Pixel pixelObj : rowArray) {
			  int avg = (pixelObj.getRed() + pixelObj.getGreen() + pixelObj.getBlue()) / 3;
			  pixelObj.setRed(avg);
			  pixelObj.setGreen(avg);
			  pixelObj.setBlue(avg);
		  }
  }
  
  
  /** Method that mirrors the picture around a 
    * vertical mirror in the center of the picture
    * from left to right */
  public void mirrorVertical()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        rightPixel.setColor(leftPixel.getColor());
      }
    } 
  }
  
  public void mirrorVerticalRightToLeft()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        leftPixel.setColor(rightPixel.getColor());
      }
    } 
  }
  
  public void mirrorHorizontal() {
	  Pixel[][] pixels = this.getPixels2D();
	  Pixel upPixel = null;
	  Pixel downPixel = null;
	  int height = pixels.length;
	  int width = pixels[0].length;
	  for (int col = 0; col < width; col++) {
		  for (int row = 0; row < height / 2; row++) {
			  upPixel = pixels[row][col];
			  downPixel = pixels[height - 1 - row][col];
			  downPixel.setColor(upPixel.getColor());
		  }
	  }
  }
  
  public void mirrorHorizontalBotToTop() {
	  Pixel[][] pixels = this.getPixels2D();
	  Pixel upPixel = null;
	  Pixel downPixel = null;
	  int height = pixels.length;
	  int width = pixels[0].length;
	  for (int col = 0; col < width; col++) {
		  for (int row = 0; row < height / 2; row++) {
			  upPixel = pixels[row][col];
			  downPixel = pixels[height - 1 - row][col];
			  upPixel.setColor(downPixel.getColor());
		  }
	  }
  }
  
  public void mirrorDiagonal() {
	  Pixel[][] pixels = this.getPixels2D();
	  int dim = pixels.length;
	  if (pixels[0].length < dim)
		  dim = pixels[0].length;
	  for (int row = 1; row < dim; row++)
		  for (int col = 0; col < row; col++) {
			  Color leftPixel = pixels[row][col].getColor();
			  pixels[col][row].setColor(leftPixel);
		  }
  }
  
  /** Mirror just part of a picture of a temple */
  public void mirrorTemple()
  {
    int mirrorPoint = 276;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();
    
    // loop through the rows
    for (int row = 27; row < 97; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 13; col < mirrorPoint; col++)
      {
        leftPixel = pixels[row][col];      
        rightPixel = pixels[row]                       
                         [mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
        count++;
      }
    }
    System.out.println(count);
  }
  
  public void mirrorArms(){
	  int mirrorPoint = 207;
	  Pixel upPixel = null;
	  Pixel downPixel = null;
	  int height = 195 * 2 - 157;
	  Pixel[][] pixels = this.getPixels2D();
	  for (int row = 157; row < height; row++) {
		  for (int col = 103; col < mirrorPoint; col++) {
			  upPixel = pixels[row][col];
			  downPixel = pixels[height + 157 - row][col];
			  downPixel.setColor(upPixel.getColor());
		  }
		  for (int col2 = 293; col2 > mirrorPoint; col2--) {
			  upPixel = pixels[row][col2];
			  downPixel = pixels[height + 157 - row][col2];
			  downPixel.setColor(upPixel.getColor()); 
		  }
	  }
	  
  }
  
  public void mirrorGull(){
	  Pixel[][] pixels = this.getPixels2D();
	  Pixel leftPixel = null;
	  Pixel rightPixel = null;
	  int rowMax = 323;
	  int colMax = 345;
	  for (int row = 233; row < rowMax; row++)
	  {
		  for (int col = 238; col < colMax; col++)
		  {
			  leftPixel = pixels[row][col];
			  rightPixel = pixels[row][colMax * 2 - 1 - col];
			  rightPixel.setColor(leftPixel.getColor());
		  }
	  }
  }
  /** copy from the passed fromPic to the
    * specified startRow and startCol in the
    * current picture
    * @param fromPic the picture to copy from
    * @param startRow the start row to copy to
    * @param startCol the start col to copy to
    */
  public void copy(Picture fromPic, 
                 int startRow, int startCol)
  {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = 0, toRow = startRow; 
         fromRow < fromPixels.length &&
         toRow < toPixels.length; 
         fromRow++, toRow++)
    {
      for (int fromCol = 0, toCol = startCol; 
           fromCol < fromPixels[0].length &&
           toCol < toPixels[0].length;  
           fromCol++, toCol++)
      {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }   
  }
  
  public void copy(Picture fromPic, int startRow, int startCol, int beginRow, int beginCol, int endRow, int endCol) {
	Pixel fromPixel = null;
	Pixel toPixel = null;
	Pixel[][] toPixels = this.getPixels2D();
	Pixel[][] fromPixels = fromPic.getPixels2D();
	for (int fromRow = beginRow, toRow = startRow; fromRow < endRow && toRow < toPixels.length; fromRow++, toRow++)
		for (int fromCol = beginCol, toCol = startCol; fromCol < endCol && toCol < toPixels[0].length; fromCol++, toCol++) {
			fromPixel = fromPixels[fromRow][fromCol];
			toPixel = toPixels[toRow][toCol];
			toPixel.setColor(fromPixel.getColor());
		}
  }

  /** Method to create a collage of several pictures */
  public void createCollage()
  {
    Picture flower1 = new Picture("flower1.jpg");
    Picture flower2 = new Picture("flower2.jpg");
    this.copy(flower1,0,0);
    this.copy(flower2,100,0);
    this.copy(flower1,200,0);
    Picture flowerNoBlue = new Picture(flower2);
    flowerNoBlue.zeroBlue();
    this.copy(flowerNoBlue,300,0);
    this.copy(flower1,400,0);
    this.copy(flower2,500,0);
    this.mirrorVertical();
    this.write("collage.jpg");
  }
  
  public void myCollage() {
	  Picture seagull = new Picture("seagull.jpg");
	  Picture beach = new Picture("beach.jpg");
	  Picture forest = new Picture("CumberlandIsland.jpg");
	  seagull.mirrorHorizontal();
	  beach.mirrorDiagonal();
	  forest.keepOnlyRed();
	  this.copy(seagull, 241, 150, 140, 175, 222, 214);
	  this.copy(beach, 100, 100, 100, 100, 212, 285);
	  this.copy(forest, 180, 231, 244, 211, 320, 285);	  
  }
  public void fixUnderwater() {
	  Pixel[][] pixels = this.getPixels2D();
	  for (Pixel[] row : pixels)
		  for (Pixel pixel : row)
			  pixel.setRed(pixel.getRed() * 4);
  }
  
  /** Method to show large changes in color 
    * @param edgeDist the distance for finding edges
    */
  public void edgeDetection(int edgeDist)
  {
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    Color rightColor = null;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; 
           col < pixels[0].length-1; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][col+1];
        rightColor = rightPixel.getColor();
        if (leftPixel.colorDistance(rightColor) > 
            edgeDist)
          leftPixel.setColor(Color.BLACK);
        else
          leftPixel.setColor(Color.WHITE);
      }
    }
  }
  
  public void edgeDetection2(int edgeDist)
  {
    Pixel upPixel = null;
    Pixel downPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    Color upColor = null;
    for (int row = 0; row < pixels.length - 1; row++)
    {
      for (int col = 0; 
           col < pixels[0].length; col++)
      {
        upPixel = pixels[row][col];
        downPixel = pixels[row + 1][col];
        upColor = downPixel.getColor();
        if (upPixel.colorDistance(upColor) > 
            edgeDist)
          upPixel.setColor(Color.BLACK);
        else
          upPixel.setColor(Color.WHITE);
      }
    }
  }  
  public void edgeDetection3(int edgeDist)
  {
	  Pixel leftPixel = null;
	  Pixel rightPixel = null;
	  Pixel upPixel = null;
	  Pixel downPixel = null;
	  Pixel[][] pixels = this.getPixels2D();
	  Color rightColor = null;
	  Color upColor = null;
	  for (int row = 0; row < pixels.length - 1; row++)
	  {
		  for (int col = 0; 
				  col < pixels[0].length - 1; col++)
		  {
			  leftPixel = pixels[row][col];
			  rightPixel = pixels[row][col+1];
			  rightColor = rightPixel.getColor();
			  upPixel = pixels[row][col];
			  downPixel = pixels[row + 1][col];
			  upColor = downPixel.getColor();
			  if (leftPixel.colorDistance(rightColor) > 
	            edgeDist || upPixel.colorDistance(upColor) > 
			  edgeDist)
				  upPixel.setColor(Color.BLACK);
			  else
				  upPixel.setColor(Color.WHITE);
		  }
	  }
  }  
  
  public void encode(Picture messagePict) {
	  Pixel[][] messagePixels = messagePict.getPixels2D();
	  Pixel[][] currPixels = this.getPixels2D();
	  Pixel currPixel = null;
	  Pixel messagePixel = null;
	  for (Pixel[] pixels : currPixels) {
		  for (Pixel pixel : pixels)
			  if (pixel.getRed() % 2 != 0)
				  pixel.setRed(pixel.getRed() + 1);
	  }
	  for (int row = 0; row < this.getHeight(); row++) {
		  for (int col = 0; col < this.getWidth(); col++) {
			  messagePixel = messagePixels[row][col];
			  if (messagePixel.getColor().equals(Color.BLACK)) {
				currPixel = currPixels[row][col];
				currPixel.setRed(currPixel.getRed() + 1);
			  }
			  
		  }
	  }
  }
  
  public Picture decode() {
	  Pixel[][] currPixels = this.getPixels2D();
	  int height = this.getHeight();
	  int width = this.getWidth();
	  Pixel currPixel = null;
	  Pixel messagePixel = null;
	  Picture messagePicture = new Picture(height, width);
	  Pixel[][] messagePixels = messagePicture.getPixels2D();
	  for (int row = 0; row < this.getHeight(); row++) {
		  for (int col = 0; col < this.getWidth(); col++) {
			  currPixel = currPixels[row][col];
			  if (currPixel.getRed() % 2 != 0) {
				  messagePixel = messagePixels[row][col];
				  messagePixel.setColor(Color.BLACK);
			  }
		  }
	  }
	  return messagePicture;
  }

  public void chromakey(Picture newBack) {
	  Pixel fromPixel = null;
	  Pixel toPixel = null;
	  Pixel[][] toPixels = this.getPixels2D();
	  Pixel[][] fromPixels = newBack.getPixels2D();
	  for (int row = 0; row < this.getHeight(); row++) {
		  for (int col = 0; col < this.getWidth(); col++) {
			  toPixel = toPixels[row][col];
			  if (toPixel.getBlue() > toPixel.getRed()) {
				  fromPixel = fromPixels[row][col];
				  toPixel.setColor(fromPixel.getColor());
			  }
		  }
	  }
  }
  /* Main method for testing - each class in Java can have a main 
   * method 
   */
  public static void main(String[] args) 
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  
} // this } is the end of class Picture, put all new methods before this
