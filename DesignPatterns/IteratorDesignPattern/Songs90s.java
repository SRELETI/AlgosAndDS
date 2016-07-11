
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;


public class Songs90s implements SongIterator{

	private HashMap<Integer,SongInfo> bestSongs;
	private int keySet=0;
	public Songs90s() {
		bestSongs = new HashMap<Integer,SongInfo>();
		addSongs("Bhaje Bhaje","Gopala ",1995);
		addSongs("Neede","Gopala Gopala",1996);
		addSongs("jal", "J Movie", 1999);
	}
	
	public void addSongs(String songName, String bandName, int year) {
		SongInfo song = new SongInfo(songName,bandName,year);
		bestSongs.put(keySet++, song);
		
	}

	@Override
	public Iterator createIterator() {
		// TODO Auto-generated method stub
		return bestSongs.values().iterator();
	}
	

}
