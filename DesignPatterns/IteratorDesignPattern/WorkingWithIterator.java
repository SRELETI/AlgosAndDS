
public class WorkingWithIterator {

	public static void main(String args[]) {
		Songs70s s70s = new Songs70s();
		Songs80s s80s = new Songs80s();
		Songs90s s90s = new Songs90s();
		
		RadiStation rad = new RadiStation(s70s,s80s,s90s);
		rad.showSongs();
	}
}
