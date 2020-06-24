package DataStructures;
import HealthSystem.Doctor;
import java.util.*;

/** A ListGraph is an extension of the AbstractGraph abstract class
 *   that uses an array of lists to represent the edges.
 *   @author Koffman and Wolfgang
 */

public class ListGraph extends AbstractGraph {

    // Data Field
    /** An array of Lists to contain the edges that
     originate with each vertex. */
    private List < Edge<Doctor> > [] edges;

    /** Construct a graph with the specified number of
     vertices and directionality.
     @param numV The number of vertices
     @param directed The directionality flag
     */
    public ListGraph(int numV, boolean directed) {
        super(numV, directed);
        edges = new List[numV];
        for (int i = 0; i < numV; i++) {
            edges[i] = new LinkedList <> ();
        }
    }
    
    public void remove(Doctor source){
        edges[source.getPersonalData().getID()].remove(source);
    }
    /** Determine whether an edge exists.
     @param source The source vertex
     @param dest The destination vertex
     @return true if there is an edge from source to dest
     */
    public boolean isEdge(Doctor source, Doctor dest) {
        return edges[source.getPersonalData().getID()].contains(new Edge<>(source, dest));
    }

    /** Insert a new edge into the graph.
     @param edge The new edge
     */
    public void insert(Edge<Doctor> edge) {
        edges[edge.getSource().getPersonalData().getID()].add(edge);
        if (!isDirected()) {
            edges[edge.getDest().getPersonalData().getID()].add(new Edge<>(edge.getDest(),
                    edge.getSource(),
                    edge.getWeight()));
        }
    }

    public Iterator < Edge <Doctor>> edgeIterator(Doctor source) {
        return edges[source.getPersonalData().getID()].iterator();
    }

    /** Get the edge between two vertices. If an
     edge does not exist, an Edge with a weight
     of Double.POSITIVE_INFINITY is returned.
     @param source The source
     @param dest The destination
     @return the edge between these two vertices
     */
    public Edge<Doctor> getEdge(Doctor source, Doctor dest) {
        Edge<Doctor> target = new Edge<>(source, dest, Double.POSITIVE_INFINITY);
        for (Edge<Doctor> edge : edges[source.getPersonalData().getID()]) {
            if (edge.equals(target))
                return edge; // Desired edge found, return it.
        }
        // Assert: All edges for source checked.
        return target; // Desired edge not found.
    }
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0;i<getNumV();i++){
            stringBuilder.append(edges[i].toString());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
