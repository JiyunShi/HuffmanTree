
public class HuffmanTreeNode implements Comparable<HuffmanTreeNode>{
	Letters value;   
	HuffmanTreeNode nextLeft, nextRight; 
	String huffmanCode ="";
	boolean isRoot =false;
    
	HuffmanTreeNode(Letters val, HuffmanTreeNode left, HuffmanTreeNode right)
    {
        value = val;
        nextLeft = left;
        nextRight = right;
        
    } 
    
	HuffmanTreeNode(Letters val)
    {
       // Call the other (sister) constructor.
       this(val, null, null);            
    }
    
    public String toString() {
    	return value.toString();
    }

	@Override
	public int compareTo(HuffmanTreeNode o) {
		// TODO Auto-generated method stub
		return this.value.compareTo(o.value);
	}
}
