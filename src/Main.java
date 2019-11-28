import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Graph g=new Graph(true);
		Vertex va=g.addVertex("a");
		Vertex vb=g.addVertex("b");
		Vertex vc=g.addVertex("c");
		Vertex vd=g.addVertex("d");
		Vertex ve=g.addVertex("e");
		Vertex vf=g.addVertex("f");
		Vertex vg=g.addVertex("g");
		Vertex vh=g.addVertex("h");
		g.addEdge(va, vb);
		g.addEdge(va, vc);
		g.addEdge(va, vf);
		g.addEdge(vb, ve);
		g.addEdge(vc, vd);
		g.addEdge(vd, va);
		g.addEdge(vd, vh);
		g.addEdge(ve, vf);
		g.addEdge(ve, vg);
		g.addEdge(ve, vh);
		g.addEdge(vf, vg);
		g.addEdge(vf, vb);
		g.addEdge(vh, vg);
		/*Graph g=new Graph(true);
		Vertex v0=g.addVertex("zero");
		Vertex v1=g.addVertex("one");
		Vertex v2=g.addVertex("two");
		Vertex v3=g.addVertex("three");
		Vertex v4=g.addVertex("four");
		Vertex v5=g.addVertex("five");
		Vertex v6=g.addVertex("six");
		Vertex v7=g.addVertex("seven");
		g.addEdge(v0, v3);
		g.addEdge(v0, v4);
		g.addEdge(v1, v5);
		g.addEdge(v2, v4);
		g.addEdge(v2, v6);
		g.addEdge(v3, v0);
		g.addEdge(v3, v5);
		g.addEdge(v3, v7);
		g.addEdge(v4, v0);
		g.addEdge(v4, v2);	
		g.addEdge(v4, v6);
		g.addEdge(v4, v7);
		g.addEdge(v5, v1);
		g.addEdge(v5, v3);
		g.addEdge(v6, v2);
		g.addEdge(v6, v4);
		g.addEdge(v6, v7);
		g.addEdge(v7, v3);
		g.addEdge(v7, v4);
		g.addEdge(v7, v6);
		*/

		Graph g2=g.clone();
		g2.addEdge(0, 3);
		g.printGraph();
		//Graph g2=g.();
		System.out.println();
		g2.printGraph();
		//g.Dijkstra(v0);
		//g.dfs(va);
		
	}

}
