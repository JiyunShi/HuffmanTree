import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeSet;

public class HuffmanTree implements Iterable<Letters>{

private HuffmanTreeNode root, mover;
	
	public HuffmanTree(){
		root = null;
		
	}
	
	public boolean isEmpty(){
		return root == null;
	}
	
	
	public void buildTree(TreeSet<HuffmanTreeNode> allnodes){
		while(allnodes.size()>1){
			HuffmanTreeNode node1 = allnodes.pollFirst();
			HuffmanTreeNode node2 = allnodes.pollFirst();
			allnodes.add(this.add(node1, node2));
		}
	}

	
	public HuffmanTreeNode add(HuffmanTreeNode e1, HuffmanTreeNode e2){
		//assume e1.value.times < e2.value.times
		Letters newLetter= new Letters(e1.value.letter+e2.value.letter,
				e1.value.times+e2.value.times,false);
		
		if(this.isEmpty()||e1.isRoot||e2.isRoot){
			e1.isRoot=false;
			e2.isRoot=false;
			root = new HuffmanTreeNode(newLetter, e1,e2);
			root.isRoot=true;
			return root;
			
		}else{
			
			return new HuffmanTreeNode(newLetter,e1,e2);
			
		}

	}
	
	
	public String getCode(){
		String codes = "";
		mover = root;
		Queue<HuffmanTreeNode> queue = new LinkedList<HuffmanTreeNode>();
		queue.add(mover);
		while(queue.size()>0){
			
			mover = queue.poll();
			Letters currentLetter = mover.value;
			if(currentLetter.isLeaf){
				codes += currentLetter.letter+":"+mover.huffmanCode+"\n";
			}
			if(mover.nextLeft!=null){
				mover.nextLeft.huffmanCode= mover.huffmanCode+"0";
				queue.add(mover.nextLeft);
			}
			if(mover.nextRight!=null){
				mover.nextRight.huffmanCode=mover.huffmanCode+"1";
				queue.add(mover.nextRight);
			}

		}

		return codes;
	}

	
	@Override
	public Iterator<Letters> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
