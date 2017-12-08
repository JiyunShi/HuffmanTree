
public class Letters implements Comparable<Letters> {

	public String letter;
	public int times;
	public boolean isLeaf;
	
	public Letters(String letters, int times, boolean isLeaf){
		this.letter =letters;
		this.times = times;
		this.isLeaf=isLeaf;
	}
	
	
	
	
	@Override
	public int compareTo(Letters o) {
		// TODO Auto-generated method stub
		if(this.times!=o.times)	return this.times-o.times;
		//determine the order of 2 letters has same times.
		return o.letter.compareTo(this.letter);
	}

}
