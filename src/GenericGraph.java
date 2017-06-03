/*
 * Maman 14 course 20554 question 2 by Yuval Melamed, ID 035870864
 */

/**
 * @author yuval.melamed
 */
public class GenericGraph {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Graph<Point> graph = new Graph<>();

        // Define some points
        Point p00 = new Point(0, 0);
        Point p01 = new Point(0, 1);
        Point p11 = new Point(1, 1);
        Point p10 = new Point(1, 0);
        Point p12 = new Point(1, 2);
        Point p33 = new Point(3, 3);

        try {
            graph.addVertex(p00);
            graph.addVertex(p01);
            graph.addVertex(p11);

            graph.addVertex(p10);
            graph.removeVertex(p10);

            graph.addVertex(p12);
            graph.addVertex(p12); // duplicate - throws an exception!
            graph.addVertex(p33); // this point will never be added...
        } catch (DuplicateVertexException e) {
            System.out.println("Ignoring duplicate vertex & anything thereafter!");
        } catch (NoSuchVertexException e) {
            e.printStackTrace();
        }
        try {
            graph.addEdge(p00, p01);
        } catch (DuplicateEdgeException e) {
            e.printStackTrace();
        } catch (NoSuchVertexException e) {
            e.printStackTrace();
        }
        System.out.println("graph = " + graph);
    }
}
