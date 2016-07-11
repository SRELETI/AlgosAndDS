import java.util.Iterator;


public class RadiStation {

	private Songs70s s70s;
	private Songs80s s80s;
	private Songs90s s90s;
	
	public RadiStation(Songs70s newSongs, Songs80s new80s, Songs90s new90s) {
		s70s = newSongs;
		s80s = new80s;
		s90s = new90s;
	}
	
	public void showSongs() {
		Iterator it = s70s.createIterator();
		printThem(it);
		Iterator it2 = s80s.createIterator();
		printThem(it2);
		Iterator it3 = s90s.createIterator();
		printThem(it3);
		
	}
	
	private void printThem(Iterator it) {
		while(it.hasNext()) {
			SongInfo song = (SongInfo) it.next();
			System.out.println(song.getSong());
			System.out.println(song.getBand());
			System.out.println(song.getYear());
		}
	}
}
