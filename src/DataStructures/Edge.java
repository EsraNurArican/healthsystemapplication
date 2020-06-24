package DataStructures;

/** An Edge represents a relationship between two
 *  vertices.
 *  @author Koffman and Wolfgang
 */
public class Edge<E> {
    /** The source vertex */
    private E source;
    /** The destination vertex */
    private E dest;
    /** The weight */
    private double weight;
    /** Construct an Edge with a source of from
     * and a destination of to. Set the weight to 1.0.
     * @param source - The source vertex
     * @param dest - The destination vertex
     */
    public Edge(E source, E dest) {
        this.source = source;
        this.dest = dest;
        weight = 1.0;
    }
    /** Construct a weighted edge with a source of from and a destination of to.
     * Set the weight to w.
     * @param source - The source vertex
     * @param dest - The destination vertex
     * @param w - The weight
     */
    public Edge(E source, E dest, double w) {
        this.source = source;
        this.dest = dest;
        weight = w;
    }
    /** Get the source
     * @return The value of source
     */
    public E getSource() {
        return source;
    }
    /** Get the destination
     * @return The value of dest
     */
    public E getDest() {
        return dest;
    }
    /** Get the weight
     * @return the value of weight
     */
    public double getWeight() {
        return weight;
    }
    /** Return a String representation of the edge
     * @return A String representation of the edge
     */
    public String toString() {
        StringBuffer sb = new StringBuffer("[(");
        sb.append(source.toString());
        sb.append(", ");
        sb.append(dest.toString());
        sb.append("): ");
        sb.append(weight);
        sb.append("]");
        return sb.toString();
    }
    /** Return true if two edges are equal.
     * Edges are equal if the source and destination are equal.
     * Weight is not considered.
     * @param obj The object to compare to
     * @return true if the edges have the same source and destination
     */
    public boolean equals(Object obj) {
        if (obj instanceof Edge) {
            Edge<E> edge = (Edge) obj;
            return (source == edge.source && dest == edge.dest);
        }
        else {
            return false;
        }
    }
}
