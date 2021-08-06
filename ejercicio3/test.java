package grafos2;

public class test {
	
	public static void main(String[]args) {
		GraphLink<String> g =new GraphLink<String>();
		g.insertVertex("lima");
		g.insertVertex("aqp");
		g.insertVertex("cusco");
		g.insertVertex("piura");
		g.insertVertex("tarapoto");
		
		g.insertEdge("lima","aqp");
		g.insertEdge("cusco","aqp");
		g.insertEdge("piura","lima");
		g.insertEdge("cusco","lima");
		g.insertEdge("piura","tarapoto");
		//g.insertEdge("aqp","lima");
		
		System.out.println("grafo no dirigido");
		System.out.println("lista de adyacencia:");
		System.out.println("(ciudad --> cuidad adyacente) \n");
		System.out.println(g);
		System.out.println("grafo dfs");
		g.DFS("aqp");
		
	}

}
