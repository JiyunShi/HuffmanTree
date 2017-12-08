import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeSet;

public class ReadWHuffmanTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String test = "A_DEAD_DAD_CEDED_A_BAD_BABE_A_BEADED_ABACA_BED";
		
		
		Map<Character,Integer> inputMap = new LinkedHashMap<Character,Integer>();
		
		for(int i=0; i<test.length();i++){
			char temp = test.charAt(i);
			
			if(inputMap.containsKey(temp)){
				inputMap.put(temp, inputMap.get(temp)+1);
			}else{
				inputMap.put(temp, 1);
			}
		}
		
		TreeSet<HuffmanTreeNode> allnodes = new TreeSet();
		for(char key: inputMap.keySet()){
			Letters newLetter = new Letters(String.valueOf(key),inputMap.get(key),true);
			allnodes.add(new HuffmanTreeNode(newLetter));
		}
		
			
		
		
		HuffmanTree myTree = new HuffmanTree();
		myTree.buildTree(allnodes);
		
		String keys = myTree.getCode();
		System.out.println(keys);
		

	}

}
