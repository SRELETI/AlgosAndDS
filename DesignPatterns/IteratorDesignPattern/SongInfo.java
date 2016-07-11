
public class SongInfo {

	private String songName;
	private String bandName;
	private int yearReleased;
	
	public SongInfo(String newSong, String newBand, int newYear) {
		songName = newSong;
		bandName = newBand;
		yearReleased = newYear;
	}
	
	public String getSong() { return songName; }
	public String getBand() { return bandName; }
	public int getYear() { return yearReleased;}
}
