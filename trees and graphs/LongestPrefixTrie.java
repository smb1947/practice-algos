import java.util.*;
public class LongestPrefixTrie{
	public static void main(String args[]){
		// LinkedList<String> strings = new LinkedList<String>();
		// strings.add("are");
		
		TrieNode tn = new TrieNode();
				
		String keys[] = {"the", "a", "there", "answer", "any", 
                         "by", "bye", "their"}; 
		// String keys[] = {"geeksforgeeks", "geeks", "geek", "geezer"};
        // String keys[] = {"apple", "ape", "april"};
        String output[] = {"Not present in trie", "Present in trie"}; 
       
       
		for(String str: keys){
			tn.insert(str);
		}
       
	   
	   // longestprefix 
		LinkedList<String> strs;
		strs = tn.autoComplete("the");
		
        System.out.println("autocomplete 'the' --- size: "+ String.valueOf(strs.size()) ); 
			for(int i =0;i<strs.size();i++){
				System.out.println(strs.get(i)); 
			}
		
        // // Search for different keys 
        // if(tn.search("the", true) == true) 
            // System.out.println("the --- " + output[1]); 
        // else System.out.println("the --- " + output[0]); 
          
        // if(tn.search("these", true) == true) 
            // System.out.println("these --- " + output[1]); 
        // else System.out.println("these --- " + output[0]); 
          
        // if(tn.search("thei", true) == true) 
            // System.out.println("thei --- " + output[1]); 
        // else System.out.println("thei --- " + output[0]); 
        
		
        // if(tn.search("thei", false) == true) 
            // System.out.println("thei(prefix) --- " + output[1]); 
        // else System.out.println("thei(prefix) --- " + output[0]); 
        
		
        // if(tn.search("thaw", true) == true) 
            // System.out.println("thaw --- " + output[1]); 
        // else System.out.println("thaw --- " + output[0]); 
		
		
	}
}

class TrieNode{
	public HashMap<Character, TrieNode> chars;
	public boolean eow;
	
	public TrieNode(){
		this.chars = new HashMap<Character, TrieNode>();
		this.eow = false;
	}
	
	public void insert(String str){
		int l = str.length();
		TrieNode root = this;
		TrieNode children;
		for(int i =0;i<l;i++){
			children = root.chars.get(str.charAt(i));
			if( children== null ){
				children = new TrieNode();
				root.chars.put(str.charAt(i), children);
			}
			root = children;
		}
		root.eow = true;
	}
	
	public boolean search(String str, boolean completeword){
		int l = str.length();
		TrieNode root = this;
		TrieNode children;
		for(int i =0;i<l;i++){
			children = root.chars.get(str.charAt(i));
			if( children== null ){
				return false;
			}
			root = children;
		}
		if(completeword){
			return root.eow;
		}
		return true;
	}
	
	public String longestprefix(){
		TrieNode root = this;
		String lp = "";
		int size =0;
		while(true){
			size = root.chars.size();
			if(size != 1 ){
				return lp;
			}
			for(Map.Entry me: root.chars.entrySet()){
				lp = lp + String.valueOf(me.getKey());
				root = (TrieNode)me.getValue();
			}			
		}
	}
	
	public LinkedList<String> autoComplete(String prefix){
		int l = prefix.length();
		TrieNode root = this;
		TrieNode children;
		for(int i =0;i<l;i++){
			children = root.chars.get(prefix.charAt(i));
			if( children== null ){
				return null;
			}
			root = children;
		}		
		return getAllStrings(root, prefix);
	}

	public static LinkedList<String> getAllStrings(TrieNode root, String prefix){
		LinkedList<String> strs = new LinkedList<String>();
		LinkedList<String> allStrs = new LinkedList<String>();
		TrieNode tn;
		if(root.chars.size() == 0 || root.eow){
			allStrs.add(prefix);
		}
		for(Map.Entry me: root.chars.entrySet()){
			tn = (TrieNode)me.getValue();
			strs = getAllStrings(tn, prefix+String.valueOf(me.getKey()));
			allStrs.addAll(strs);
		}
		return allStrs;
	}
}