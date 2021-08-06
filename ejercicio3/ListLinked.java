package grafos2;

public class ListLinked <T>{
	
	protected Node<T> first;
	
	public ListLinked() {
		this.first=null;
	}

	boolean isEmpty() {
		return this.first==null;
	}
	
	
	public T search(T data) {
		Node<T> nodo= this.first;
		while(nodo!=null && !nodo.data.equals(data))
			nodo=nodo.getNext();
		if(nodo!=null)
			return nodo.data;
		return null;
			
		
	}
	
	void insertFirst(T data) {
		this.first=new Node<T> (data,this.first);
	}
	
	public String toString() {
		String r="";
		Node<T>aux=this.first;
		while(aux!=null) {
			r=r+aux.getData();
			aux=aux.getNext();
		}
		return r;
		
	}
	public T remove(T data) {
		T item=null;
		Node<T> aux=this.first;
		if(this.first!=null &&this.first.data.equals(data)) {
			item=first.data;
			first=first.next;
			
			
		}
		else {
			while(aux.next!=null&&aux.next.data.equals(data))
				aux=aux.getNext();
			
			if(aux.getNext()!=null) {
				item=aux.next.data;
				aux.next=aux.next.next;
			}
		}
		return item;
	}
	
	
}
