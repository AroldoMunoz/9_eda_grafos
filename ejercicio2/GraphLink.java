package grafos;

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

}
