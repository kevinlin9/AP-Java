// 2013 AP Problem #1
public class DownloadInfo {
	private String title;
	private int numDl;
	
	public DownloadInfo(String title){
		this.title = title;
		numDl = 1;
	}
	public String getTitle(){
		return title;
	}
	public void incrementTimesDownloaded(){
		numDl++;
	}
	public int getNumberOfDownloads(){
		return numDl;
	}
}
