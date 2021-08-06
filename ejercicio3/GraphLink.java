package grafos2;

public class GraphLink<E> {
	protected ListLinked<Vertex<E>> listVertex;
	
		
	public GraphLink() {
		listVertex=new ListLinked<Vertex<E>>();
	}
	public void insertVertex(E data) {
		Vertex<E> nuevo=new Vertex<E>(data);
		if(this.listVertex.search(nuevo)!=null) {
			System.out.println("Vertice ya fue insertado anteriomente...");
			return;
		}
		this.listVertex.insertFirst(nuevo);
	}
	
	
	public void insertEdge(E verOri,E verDes) {
		Vertex<E> refOri=this.listVertex.search(new Vertex<E>(verOri));
		Vertex<E> refDes=this.listVertex.search(new Vertex<E>(verDes));
		
		if(refOri==null||refDes==null) {
			System.out.println("vertice origen y/o destino no existen ...");
			return;
		}
		if(refOri.listAdj.search(new Edge<E>(refDes))!=null) {
			System.out.println("Arista fue insertada anteriormente...");
			return;
		}
		refOri.listAdj.insertFirst(new Edge<E>(refDes));
		refDes.listAdj.insertFirst(new Edge<E>(refOri));
		
	}
	public String toString() {
		return this.listVertex.toString();
	}
	
	//dfs
	private void initLabel() {
		Node<Vertex<E>>aux=this.listVertex.first;
		for(;aux!=null;aux=aux.getNext()) {
			aux.data.label=0;
			Node<Edge<E>> auxE=aux.data.listAdj.first;
			for(;auxE!=null;auxE=auxE.getNext())
				auxE.data.label=0;
		}
	}
	public void DFS(E data) {
		Vertex<E> v= this.listVertex.search(new Vertex<E>(data));
		if(v==null) {
			System.out.println("vertice no exixte");
			return;
		}
		initLabel();
		DFSRec(v);
		
	}
	
	private void DFSRec(Vertex<E>v) {
		v.label=1;
		System.out.print(v.data+",");
		Node<Edge<E>> e=v.listAdj.first;
		for(;e!=null;e=e.getNext()) {
			if(e.data.label==0) {
				Vertex<E>w=e.data.refDest;
				if(w.label==0) {
					e.data.label=1;
					DFSRec(w);
				}
				else
					e.data.label=2;
			}
		}
	}
	
	
}
