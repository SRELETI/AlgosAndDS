
public class PrintInter {

	public void inter(String text1, String text2) {
		utilsInter(text1, text2, 0, 0, "");
	}
	
	public void utilsInter(String text1, String text2, int i, int j, String res) {
		if(i==text1.length() && j==text2.length()) {
			System.out.println(res);
			return;
		}
		if(i!=text1.length()) {
			utilsInter(text1,text2,i+1,j,res+text1.charAt(i));
		}
		if(j!=text2.length()) {
			utilsInter(text1,text2,i,j+1,res+text2.charAt(j));
		}
	}
	
	public static void main(String args[]) {
		PrintInter p = new PrintInter();
		String text1 = "AB";
		String text2 = "C";
		p.inter(text1, text2);
	}
	
}
