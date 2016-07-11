import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Finding Likely Invariants

class CompleteNode {
	public String name;
	public int support;
	public Map<CompleteNode,Integer> pairWiseSupport;
	public Set<CompleteNode> callees;
	public Set<CompleteNode> callers;

	public CompleteNode() {
		callers = new HashSet<CompleteNode>();
		callees = new HashSet<CompleteNode>();
		pairWiseSupport = new HashMap<CompleteNode,Integer>();
	}
}
public class LikelyInvariants_myVersion {

	public static void main(String args[]) throws IOException {
		if(args.length!=3) {
			System.err.println("Expected 3 parameters, received "+args.length);
			return;
		}

		int support;
		double confidence;
		try {
			support = Integer.parseInt(args[1]);
			confidence = Double.parseDouble(args[2]);
		}
		catch(Exception e) {
			System.err.println("Expected Integer and double value, but received "+e.getMessage());
		}

		FileReader fr;
		Map<String, CompleteNode> nodes = new HashMap<String,CompleteNode>();
		try {
			BufferedReader textData = new BufferedReader(new FileReader(args[0]));
			String line;
			String nodeName;
			
			Pattern rootNodePattern = Pattern.compile(
	                "(?:Call graph node for function: ')" +
	                "([_a-zA-Z][_a-zA-Z0-9]*)" +
	                "(?:'<<0x)(?:[0-9a-fA-F]+)(?:>>  #uses=)(?:\\d+)");

	            Pattern calleePattern = Pattern.compile(
	                "(?:  CS<0x)" +
	                "(?:[0-9a-fA-F]+)" +
	                "(?:> calls function ')([_a-zA-Z][_a-zA-Z0-9]*)(?:')");
	       while((line=textData.readLine())!=null) {
	    	   Matcher matcher = rootNodePattern.matcher(line);
	    	   CompleteNode currentNode = new CompleteNode();
	    	   if(line.length()==0) 
	    		   continue;
	    	   if(matcher.matches()) {
	    		   nodeName = matcher.group(1);
	    		   CompleteNode node;
	    		   if(nodes.containsKey(nodeName)==false) {
	    			   node = new CompleteNode();
	    			   nodes.put(nodeName, node);
	    		   }
	    		   else {
	    			node = nodes.get(nodeName);   
	    		   }
	    		   currentNode = node;
	    	   }
	    	   else {
	    		   matcher = calleePattern.matcher(line);
	    		   if(matcher.matches()) {
	    			   nodeName = matcher.group(1);
	    			   CompleteNode node;
	    			   if(nodes.containsKey(nodeName)==false) {
	    				   node = new CompleteNode();
	    				   nodes.put(nodeName, node);
	    			   }
	    			   else {
	    				   node = nodes.get(nodeName);
	    			   }
	    			   
	    			   if(currentNode.callees.contains(node)==false){
	    				   currentNode.callees.add(node);
	    			   }
	    			   if(node.callers.contains(currentNode)==false) {
	    				   node.callers.add(currentNode);
	    			   }
	    		   }
	    	   }
	       }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    	for(CompleteNode node:nodes.values()) {
    		for(CompleteNode calleesA:node.callees){
    			calleesA.support++;
    			for(CompleteNode calleesB:node.callees) {
    				if(calleesA!=calleesB) {
    					Map<CompleteNode,Integer> pairWise = calleesA.pairWiseSupport;
    					int supportValue = pairWise.containsKey(calleesB)? pairWise.get(calleesB):0;
    					pairWise.put(calleesB, supportValue+1);
    				}
    			}
    		}
       }
    
       for(CompleteNode node:nodes.values()) {
    	   for(CompleteNode nodeA:node.pairWiseSupport.keySet()) {
    		   double supA = nodeA.support;
    		   double supB = node.support;
    		   
    	   }
    	   
       }
    	
    	
		
	}
}