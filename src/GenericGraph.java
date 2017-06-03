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

            // Inner "try" just to show we can minimize skips
            try {
                graph.addVertex(p10);
                graph.removeVertex(p10);
                graph.removeVertex(p10); // double remove - should fail as n/a!
                graph.removeVertex(p11); // this point will never be removed...

            } catch (NoSuchVertexException e) {
                // Show a message and never go back, but continue below only
                System.out.println("Ignoring invalid vertex & on!");
            }

            graph.addVertex(p12);
            graph.addVertex(p12); // duplicate - will throw an exception!
            graph.addVertex(p33); // this point will never be added (skipped)

        } catch (DuplicateVertexException e) {
            System.out.println("Ignoring duplicate vertex & on!");
        }

        // Try to add (and remove) some edges
        try {
            graph.addEdge(p00, p01);
            graph.addEdge(p12, p11);
            graph.addEdge(p11, p01);
            graph.addEdge(p11, p12);

            System.out.println("Before an edge removal = " + graph);
            graph.removeEdge(p11, p01);
            System.out.println("After the edge removal = " + graph);

            graph.addEdge(p00, p01); // double add - throws exception!
            graph.addEdge(p10, p01); // no such vertex, but it's unreachable...
            graph.removeEdge(p33, p33); // no such edge, but won't be reached.

        } catch (DuplicateEdgeException e) {
            System.out.println("Ignoring duplicate edge & on!");

        } catch (NoSuchVertexException e) {
            System.out.println("Ignoring invalid vertex & on!"); // won't reach

        } catch (NoSuchEdgeException ex) {
            System.out.println("Ignoring invalid edge & on!"); // won't reach

        }

        System.out.println("Final graph have not changed = " + graph);
    }
}
