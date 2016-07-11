import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;


class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
  }

public class MergeIntervals {

	private void merge(List<Interval> interval) {
		if(interval.size()==0)
			return;
		Stack<Interval> s = new Stack<Interval>();
		Iterator<Interval> i = interval.iterator();
		s.push(i.next());
		while(i.hasNext()) {
			if(s.peek().end>=i.next().start) {
				s.push(new Interval(s.pop().start,i.next().end));
			}
			else
				s.push(i.next());
		}
		List<Integer> lll = new LinkedList<Integer>();
		List<Interval> res = new ArrayList<Interval> ();
		while(!s.isEmpty()) {
			res.add(0,s.pop());
		}
		return;
	}
}
