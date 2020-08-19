 /*
 * GraphTest.java   
 * @author abdulwasayrida
 * @author ameyadighe
 */
public class GraphTest {
	public static void main(String[] args) {
		
		
		
		
		
		Graph g = new Graph(6);
		g.addDirectedEdge(1, 2);
		g.addDirectedEdge(2, 3);
		g.addDirectedEdge(2, 4);
		g.addDirectedEdge(2, 6);
		g.addDirectedEdge(3, 5);
		g.addDirectedEdge(4, 5);
		g.addDirectedEdge(5, 2);
		g.BFS(1);
		g.printBFS();

		
		
		
		
		/** Test for Constructor **/
		System.out.println("**Testing Constructors**");
		Graph G = new Graph(5);
		G.addUndirectedEdge(1, 2);
		G.addUndirectedEdge(2, 3);
		G.addUndirectedEdge(1, 3);
		G.addUndirectedEdge(3, 4);
		
		Graph G1 = new Graph(3);
		G1.addDirectedEdge(1, 2);
		G1.addDirectedEdge(2, 3);
		G1.addDirectedEdge(3, 1);
	
		System.out.println("Graphs successfully created!");


		System.out.println("\n**Testing getNumEdges()**");
		System.out.println("Should print 4: " + G.getNumEdges());
		System.out.println("Should print 3: " + G1.getNumEdges());
		
		System.out.println("\n**Testing getNumVertices()**");
		System.out.println("Should print 5: " + G.getNumVertices());
		System.out.println("Should print 3: " + G1.getNumVertices());
		
		System.out.println("\n**Testing isEmpty()**");
		System.out.println("Should print false: " + G.isEmpty());
		Graph G2 = new Graph(0);
		System.out.println("Should print true: " + G2.isEmpty());
		
		
		
		System.out.println("\n**Testing printBFS()**");
		System.out.println("Printing BFS for Graph 1 with source vertex 1:");
		G.BFS(1);
		G.printBFS();
		
		System.out.println("\nPrinting BFS for Graph 2 with source vertex 3::");
		G1.BFS(3);
		G1.printBFS();

		System.out.println("\n**Testing BFS()**");
		Graph G3 = new Graph(3);
		G3.addUndirectedEdge(1, 2);
		G3.addUndirectedEdge(3, 2);
		G3.addUndirectedEdge(1, 2);
		G3.addUndirectedEdge(2, 1);
		G3.BFS(1);
		System.out.println("Printing values for Graph 3 after BFS with source vertex 1:");
		G3.printBFS();
		
		Graph G4 = new Graph(7);
		G4.addDirectedEdge(1, 2);
		G4.addDirectedEdge(2, 3);
		G4.addUndirectedEdge(3, 4);
		G4.addUndirectedEdge(4, 5);
		G4.BFS(4);
		System.out.println("\nPrinting values for Graph 4 after BFS with source vertex 4:");
		G4.printBFS();

		System.out.println("\n**Testing getDistance()**");
		System.out.println("Should print 1: " + G.getDistance(3)); 
		System.out.println("Should print 2: " + G1.getDistance(2));
		
		
		System.out.println("\n**Testing getParent()**");
		System.out.println("Should print 3: " + G.getParent(4)); 
		System.out.println("Should print 1: " + G1.getParent(2));
		
		
		System.out.println("\n**Testing getColor()**");
		System.out.println("Should print B: " + G.getColor(3));
		System.out.println("Should print B: " + G1.getColor(2));
		
		System.out.println("\n**Testing getAdjacencyList()**");
		System.out.printf("Should print 2 3: " + G.getAdjacencyList(1));
		System.out.println("Should print 1: " + G1.getAdjacencyList(3)); 
		
		System.out.println("\n**Testing addUndirectedEdge()**");
		try {
			G.addUndirectedEdge(3, 6);
        } catch (IndexOutOfBoundsException e) {
       	 System.out.println("Should print error message: " + e);
        }
		G.addUndirectedEdge(3, 4);
		System.out.println("Graph 1 is: \n" + G); 
		

		System.out.println("\n**Testing addDirectedEdge()**");
		try {
			G.addDirectedEdge(1, 6);
        } catch (IndexOutOfBoundsException e) {
       	 System.out.println("Should print error message: " + e);
        }
		G.addDirectedEdge(2, 4);
		System.out.println("Graph 1 is: \n" + G);

		
		System.out.println("\n**Testing toString()**");
		System.out.println("Graph 1 is: \n" + G.toString()); 
		System.out.println("Graph 2 is: \n" + G1.toString());

	}
}