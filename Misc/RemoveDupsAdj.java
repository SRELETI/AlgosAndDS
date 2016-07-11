import java.util.ArrayList;
class wrapper_ch {
	char r= ' ';
}

public class RemoveDupsAdj {

	public String remove(String text, wrapper_ch remove) {
		if(text.length()<=1)
			return text;
		int i=1;
		if(text.charAt(i-1)==text.charAt(i)) {
			remove.r = text.charAt(i-1);
			while(i<text.length() && text.charAt(i-1)==text.charAt(i))
				i++;
			return remove(text.substring(i, text.length()),remove);
		}
	//	System.out.println(text.substring(1,text.length()));
		String rem_str = remove(text.substring(1, text.length()),remove);
		
		if(rem_str.length()>0 && text.charAt(0)==rem_str.charAt(0))
		{
			remove.r = rem_str.charAt(0);
		//	System.out.println(rem_str.substring(1, rem_str.length()));
			return rem_str.substring(1, rem_str.length());
		}
		if((rem_str==null || rem_str.length()==0) && remove.r==text.charAt(0)) {
		//	System.out.println(text.charAt(0));
			return rem_str;
		}
	//	System.out.println(rem_str);
		rem_str = text.charAt(0)+rem_str;
	//	System.out.println(rem_str);
		return rem_str;
	}
	
	public static void main(String args[]) {
		RemoveDupsAdj r = new RemoveDupsAdj();
		String text = "acbbcddc";
		System.out.println(r.remove(text, new wrapper_ch()));
	}
}
