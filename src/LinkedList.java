
public class LinkedList {
	List first;
	List last;
	int length;
	
	public LinkedList(){
		first= null;
		last=first;
	}
	
	public void add(String msg) {
		if(first == null) {
			first= new List(); 
			last= first;
			List newNode= new List();
			newNode.setMsg(msg);
			newNode.setNext(null);
			last.setNext(newNode);
			last = newNode;
		}else {
			List newNode= new List();
			newNode.setMsg(msg);
			newNode.setNext(null);
			last.setNext(newNode);
			last = newNode;
			length++;
		}
	}
	
	public void removeItem(String NomeParaRemover, List location, List Anterior){
	
		List Remove= location;
		List sentinel= Anterior;
		
		if(first != null) {
			while(Remove!= null) {
				if(Remove.getMsg().equals(NomeParaRemover)) {
					if(Remove.getNext()==null) {
						last = sentinel;
						last.setNext(null);
						Remove = null;
						length--;
					}else {
					sentinel.setNext(Remove.getNext());
					Remove.setNext(null);
					Remove=null;
					length--;
					break;
					}
				}
				if(Remove != null) {
				Remove= Remove.getNext();
				sentinel= sentinel.getNext();
				}
			 }
			System.gc();
		}
	}


	public void printList() {
		List loop= first.getNext();
		while(loop!= null) {
			System.err.println(""+loop.getMsg());
			loop= loop.getNext();
		}
		
	}
	
	public void Look() {
		List loop= first.getNext();
		while(loop!= null) {
			find(loop.getMsg(), loop);
			loop= loop.getNext();
		}
	}
	
	public void find(String nome, List location) {
		List loop= location.getNext();
		List Anterior= location;
		//loop=loop.getNext();
		
		while(loop!= null) {
			
			if(nome.equals(loop.getMsg())) {
				removeItem(loop.getMsg(), loop, Anterior);
				System.out.println("removed");
				break;
			}
					
			loop= loop.getNext();
			Anterior= Anterior.getNext();
		}
	}
	
}
