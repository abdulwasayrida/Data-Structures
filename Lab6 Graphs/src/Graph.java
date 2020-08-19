
/**
 * Graph.java   
 * @author abdulwasayrida
 * @author ameyadighe
 * CIS 22C, Lab 6
 */

import java.util.ArrayList;

public class Graph {
	private int vertices;
	private int edges;
	private ArrayList<List<Integer>> adj;
	private ArrayList<Character> color;
	private ArrayList<Integer> distance;
	private ArrayList<Integer> parent;

	/** Constructor */

	/**
	 * initializes an empty graph, with n vertices and 0 edges, and initializes all
	 * array lists to contain default values from indices 1 to n
	 * 
	 * @param n the number of vertices in the graph
	 */
	public Graph(int n) {
		vertices = n;
		edges = 0;
		adj = new ArrayList<>(n + 1);
		color = new ArrayList<>(n + 1);
		distance = new ArrayList<>(n + 1);
		parent = new ArrayList<>(n + 1);

		for (int i = 0; i <= n; i++) {
			adj.add(i, new List<>());
			color.add(i, 'W');
			distance.add(i, -1);
			parent.add(i, 0);
		}
	}

	/*** Accessors ***/

	/**
	 * Returns the number of edges in the graph
	 * 
	 * @return the number of edges
	 */
	public int getNumEdges() {
		return edges;
	}

	/**
	 * Returns the number of vertices in the graph
	 * 
	 * @return the number of vertices
	 */
	public int getNumVertices() {
		return vertices;
	}

	/**
	 * returns whether the graph is empty (no edges)
	 * 
	 * @return whether the graph is empty
	 */
	public boolean isEmpty() {
		return edges == 0;
	}

	/**
	 * Returns the value of the distance[v]
	 * 
	 * @param v a vertex in the graph
	 * @precondition 0 < v <= vertices
	 * @return the distance of vertex v
	 * @throws IndexOutOfBoundsException when the precondition is violated
	 */
	public Integer getDistance(Integer v) throws IndexOutOfBoundsException {
		if (v < 0 || v > vertices) {
			throw new IndexOutOfBoundsException("getDistance(): Cannot get distance! Index is out of bounds!");
		} else {
			return distance.get(v);
		}
	}

	/**
	 * Returns the value of the parent[v]
	 * 
	 * @param v a vertex in the graph
	 * @precondition 0 < v <= vertices
	 * @return the parent of vertex v
	 * @throws IndexOutOfBoundsException when the precondition is violated
	 */
	public Integer getParent(Integer v) throws IndexOutOfBoundsException {
		if (v < 0 || v > vertices) {
			throw new IndexOutOfBoundsException("getParent(): Cannot get parent! Index is out of bounds!");
		}
		return parent.get(v);
	}

	/**
	 * Returns the value of the color[v]
	 * 
	 * @param v a vertex in the graph
	 * @precondition 0 < v <= vertices
	 * @return the color of vertex v
	 * @throws IndexOutOfBoundsException when the precondition is violated
	 */
	public Character getColor(Integer v) throws IndexOutOfBoundsException {
		if (v < 0 || v > vertices) {
			throw new IndexOutOfBoundsException("getColor(): Cannot get color! Index is out of bounds!");
		}
		return color.get(v);
	}

	/**
	 * Returns the List stored at index v
	 * 
	 * @param v a vertex in the graph
	 * @return the adjacency List a v
	 * @precondition 0 < v <= vertices
	 * @throws IndexOutOfBoundsException when the precondition is violated
	 */
	public List<Integer> getAdjacencyList(Integer v) throws IndexOutOfBoundsException {
		if (v < 0 || v > vertices) {
			throw new IndexOutOfBoundsException(
					"getAdjacencyList(): Cannot get adjacency list! Index is out of bounds!");
		}
		return adj.get(v);
	}

	/*** Manipulation Procedures ***/

	/**
	 * Inserts vertex v into the adjacency list of vertex u (i.e. inserts v into the
	 * list at index u)
	 * 
	 * @precondition 0 < u <= vertices, 0 < v <= vertices
	 * @throws IndexOutOfBounds exception when the precondition is violated
	 */
	public void addDirectedEdge(Integer u, Integer v) throws IndexOutOfBoundsException {
        if (u <= 0 || v > vertices) {
            throw new IndexOutOfBoundsException("addDirectedEdge(): " + "the index is not in the range.");
        } else {
            if (adj.get(u).isEmpty() || (v <= adj.get(u).getFirst())) {
                adj.get(u).addFirst(v);
            } else if (v >= adj.get(u).getLast()) {
                adj.get(u).addLast(v);
            } else {
                adj.get(u).placeIterator();
                while (v > adj.get(u).getIterator()) {
                    adj.get(u).advanceIterator();
                }
                adj.get(u).reverseIterator();
                adj.get(u).addIterator(v);
            }
            edges++;
        }
    }

	/**
	 * Inserts vertex v into the adjacency list of vertex u (i.e. inserts v into the
	 * list at index u) and inserts u into the adjacent vertex list of v
	 * 
	 * @precondition 0 < u <= vertices, 0 < v <= vertices
	 * @throws IndexOutOfBounds exception when the precondition is violated
	 */
	public void addUndirectedEdge(Integer u, Integer v) throws IndexOutOfBoundsException {
        if ((u <= 0 ||  u > vertices) || (v <= 0 || v > vertices)) {
            throw new IndexOutOfBoundsException(
                    "addUndirectedEdge(): Cannot add undirected edge! Index is out of bounds!");

        } else {
            addDirectedEdge(u,v);
            addDirectedEdge(v,u);
            edges--;
            
        }
    }
	/*
	 * } else { adj.get(v).addLast(u); adj.get(u).addLast(v); edges++; } }
	 */

	/*** Additional Operations ***/

	/**
	 * Creates a String representation of the Graph Prints the adjacency list of
	 * each vertex in the graph, vertex: <space separated list of adjacent vertices>
	 */
	@Override
	public String toString() {
		String result = "";
		for (int i = 1; i <= vertices; i++) {
			result += i + ": " + adj.get(i);
		}
		return result;
	}



	/**
	 * Prints the current values in the parallel ArrayLists after executing BFS.
	 * First prints the heading: v <tab> c <tab> p <tab> d Then, prints out this
	 * information for each vertex in the graph Note that this method is intended
	 * purely to help you debug your code
	 */
	public void printBFS() {
		System.out.println("v\tc\tp\td");
		for (int i = 1; i <= vertices; i++) {
			System.out.println(i + "\t" + color.get(i) + "\t" + parent.get(i) + "\t" + distance.get(i));
		}
	}

	/**
     * Performs breath first search on this Graph give a source vertex
     * 
     * @param source the source vertex
     * @precondition graph must not be empty
     * @precondition source is a vertex in the graph
     * @throws IllegalStateException     if the graph is empty
     * @throws IndexOutOfBoundsException when vertex is outside the bounds of the
     *                                   graph
     */

	public void BFS(Integer source) throws IllegalStateException, IndexOutOfBoundsException {
        if (isEmpty()) {
            throw new IllegalStateException("BFS(): Graph is empty! Cannot perform BFS!");
        } else if (source <= 0 || source > vertices) {
            throw new IndexOutOfBoundsException("BFS(): Source vertix is not in graph! Cannot perform BFS!");
        } else {
            List<Integer> queue = new List<>();
            for (int i = 1; i <= vertices; i++) {
                color.set(i, 'W');
                distance.set(i, -1);
                parent.set(i, null);
            }
            color.set(source, 'G');
            distance.set(source, 0);
            queue.addLast(source);
            while (!queue.isEmpty()) {
                int x = queue.getFirst();
                queue.removeFirst();
                List<Integer> adjX = adj.get(x);
                adj.get(x).placeIterator();
                for (int i = 1; i <= adjX.getLength(); i++) {
                    if (i != 1){
                        adj.get(x).advanceIterator();
                }
                    int y = adjX.getIterator();
                    if (color.get(y) == 'W') {
                        color.set(y, 'G');
                        distance.set(y, distance.get(x) + 1);
                        parent.set(y, x);
                        queue.addLast(y);
                    }
                }
                color.set(x, 'B');
            }
        }
    }

}