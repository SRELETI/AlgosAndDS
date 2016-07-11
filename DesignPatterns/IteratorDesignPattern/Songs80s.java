
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;


public class Songs80s implements SongIterator{

	private SongInfo[] bestSongs;
	private int count= 0;
	public Songs80s() {
		bestSongs = new SongInfo[3];
		addSongs("tham","Thamudu",1985);
		addSongs("Neede","Gopala",1986);
		addSongs("Galilo", "Jalsa Movie", 1989);
	}
	
	public void addSongs(String songName, String bandName, int year) {
		SongInfo song = new SongInfo(songName,bandName,year);
		bestSongs[count++] = song;
	}

	@Override
	public Iterator createIterator() {
		// TODO Auto-generated method stub
		return Arrays.asList(bestSongs).iterator();
	}
	

}
