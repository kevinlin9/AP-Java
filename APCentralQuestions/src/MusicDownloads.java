import java.util.ArrayList;
import java.util.List;
// 2013 AP Problem #1
public class MusicDownloads {
	private List<DownloadInfo> downloadList;
	
	public MusicDownloads(){
		downloadList = new ArrayList<DownloadInfo>();
	}
	public DownloadInfo getDownloadInfo(String title){
		for(DownloadInfo d : downloadList){
			if(d.getTitle().equals(title))
				return d;
		}
		return null;
	}
	public void updateDownloads(List<String> titles){
		for(String t : titles){
			DownloadInfo info = getDownloadInfo(t);
			if(info == null)
				downloadList.add(new DownloadInfo(t));
			else
				info.incrementTimesDownloaded();
		}
	}
}
