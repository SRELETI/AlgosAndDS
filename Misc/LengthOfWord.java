import java.util.ArrayList;
import java.util.List;


public class LengthOfWord {

	public int lengthOfLastWord(String s) {
        if(s.length()==0)
            return 0;
        int last = s.length()-1;
        if(s.charAt(last)==' ')
            last++;
        int count=0;
        while(last>=0) {
            if(s.charAt(last)==' ')
                break;
                last--;
                count++;
        }
        return count;
        
    }
	
	


	
	public static void main(String args[]) {
		LengthOfWord l = new LengthOfWord();
		System.out.println(l.lengthOfLastWord(""));
	}
}
