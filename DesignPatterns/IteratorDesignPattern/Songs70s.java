import java.util.ArrayList;
import java.util.Iterator;


public class Songs70s implements SongIterator{

	private ArrayList<SongInfo> bestSongs;
	
	public Songs70s() {
		bestSongs = new ArrayList<SongInfo>();
		addSongs("Bhaje Bhaje","Gopala Gopala",1975);
		addSongs("Neede Neede","Gopala Gopala",1976);
		addSongs("jalsa", "Jalsa Movie", 1979);
	}
	
	public void addSongs(String songName, String bandName, int year) {
		SongInfo song = new SongInfo(songName,bandName,year);
		bestSongs.add(song);
	}

	@Override
	public Iterator createIterator() {
		// TODO Auto-generated method stub
		return bestSongs.iterator();
	}
	

}
