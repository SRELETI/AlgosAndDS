
public class RegexWell {

	private String cleanTerm(String term) {
		if (term!=null) {
			term = term.replaceAll("__+|  +|\\?\\?+", " ").trim();
//			if (term.trim().length()==0) {
//				term = null;
//			}
		}
		return term;
	}
	
	public static void main(String args[]) {
		RegexWell r = new RegexWell();
		System.out.println(r.cleanTerm("clemens.reiners@oclc.org"));
	}
}
