import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

import javax.management.Query;

public class Graph {

	ArrayList<Vertex> vertices;
	boolean directed;

	public Graph(boolean directed) {
		super();
		this.vertices = new ArrayList<>();
		this.directed = directed;
	}

	public Vertex addVertex(String value, ArrayList<Vertex> neighbors, ArrayList<Integer> weights) {
		for (Vertex v : vertices) {
			if (v.value.equals(value))
				return v;
		}
		Vertex v = new Vertex(value, neighbors, weights, directed);
		vertices.add(v);
		return v;

	}

	public Vertex addVertex(String value) {
		return addVertex(value, new ArrayList<>(), new ArrayList<>());

	}	public void printGraph() {

		for (Vertex V : vertices) {
			System.out.print("*" + V.value + "* ");
			for (Edge E : V.edges) {
				System.out.print(E.getNeigbor(V).value + E.weight + " ");
			}
			System.out.println();
		}
	}

	// add edge
	public void addEdge(Vertex v1, Vertex v2, int weight) {
		Edge e = new Edge(v1, v2, weight);
		v1.edges.add(e);
		if (!directed) {
			v2.edges.add(e);
		}
	}

	public void addEdge(Vertex v1, Vertex v2) {
		addEdge(v1, v2, 0);
	}
	public void addEdge(int i, int j, int weight) {
		Vertex v1=vertices.get(i);
		Vertex v2=vertices.get(j);
		Edge e = new Edge(v1, v2, weight);
		v1.edges.add(e);
		if (!directed) {
			v2.edges.add(e);
		}
	}

	public void addEdge(int i,int j ) {
		Vertex v1=vertices.get(i);
		Vertex v2=vertices.get(j);
		addEdge(v1, v2, 0);
	}


	// refresh
	public void refresh() {
		for (Vertex v : vertices) {
			v.isVisited = false;
			v.distance = Integer.MAX_VALUE;
		}

	}

	public void Dijkstra(Vertex v) {
		int path = 0;
		v.distance = 0;
		PriorityQueue<Vertex> availableVertices = new PriorityQueue<>();
		while (true) {

			path = v.distance;
			v.isVisited = true;
			System.out.println(v.value + " " + v.distance);

			for (Edge e : v.edges) {
				if (e.getNeigbor(v).distance > path + e.weight) {
					e.getNeigbor(v).distance = path + e.weight;

				}
				if (!e.getNeigbor(v).isVisited) {
					availableVertices.remove(e.getNeigbor(v));
					availableVertices.add(e.getNeigbor(v));
				}
			}
			if (availableVertices.isEmpty())
				break;
			v = availableVertices.poll();

		}
		refresh();

	}
	
	public Graph transpose() {
		Graph g=new Graph(this.directed);
		for(Vertex v:this.vertices) {
			//g.vertices.add(new Vertex(v.value));
		}
		return g;
	}
	public Graph clone() {
		Graph g=new Graph(directed);
		for(Vertex v:this.vertices) {
			g.vertices.add(new Vertex(v.value));
		}
		for(int i=0;i<vertices.size();i++) {
			Vertex v=this.vertices.get(i);
			for(int j=0;j<v.edges.size();j++) {
				Edge e=v.edges.get(j);
				Vertex neighbor=e.getNeigbor(v);
				int index=this.vertices.indexOf(neighbor);
				g.vertices.get(i).edges.add(new Edge(g.vertices.get(i),g.vertices.get(index) , e.weight));
			}
		}
		return g;
	}
		public void dfs(Vertex v) {
	System.out.println(	dfs(v,new Stack<Vertex>(),1,true));
	}
	public void dfs(Vertex v,Stack<Vertex> s,int time) {
		//System.out.println("\t"+v.value + "    "+time);
		if(v.color==0)
		v.startTime=time++;
		v.color=1;
		boolean flag=false;
		for(Edge e:v.edges) {
			if(e.getNeigbor(v).color==0) {
				s.push(v);
				flag=true;
				dfs(e.getNeigbor(v),s,time);
			}
		}
		if(!flag) {
			v.finishTime=time++;
			System.out.println(v.value +"    "+ v.startTime + "     "+ v.finishTime);
			v.isVisited=true;
			v.color=2;
			
			if(s.isEmpty()) return;
		//	System.out.println("\t\t"+s.peek().value);
			dfs(s.pop(),s,time);
		}
	}
	public boolean dfs(Vertex v,Stack<Vertex> s,int time,boolean isDAC) {
		//System.out.println("\t"+v.value + "    "+time);
		
		if(v.color==0)
		v.startTime=time++;
		v.color=1;
		boolean flag=false;
		for(Edge e:v.edges) {
		//	System.out.println("\t\t"+v.value + "    "+e.getNeigbor(v).value);
			if(e.getNeigbor(v).color==1 && v.startTime>e.getNeigbor(v).startTime) {
			System.out.println("Back edge: "+v.value+"  "+e.getNeigbor(v).value);
				isDAC=false;
			}
			if(e.getNeigbor(v).color==0) {
				s.push(v);
				flag=true;
				return dfs(e.getNeigbor(v),s,time,isDAC);
			}
		}
		if(!flag) {
			v.finishTime=time++;
			System.out.println(v.value +"    "+ v.startTime + "     "+ v.finishTime);
			v.isVisited=true;
			v.color=2;
			
			if(s.isEmpty()) return isDAC;
		//	System.out.println("\t\t"+s.peek().value);
			return dfs(s.pop(),s,time,isDAC);
		}
	//	System.out.println(isDAC+v.value);
		return isDAC;
	}
		public void prim(Vertex v) {

		PriorityQueue<Edge> availableEdges = new PriorityQueue<>();
		while (true) {
			v.isVisited = true;
			System.out.println(v.value);
			for (Edge e : v.edges) {
				if (!e.getNeigbor(v).isVisited) {
					availableEdges.add(e);
				}
			}

			while (!availableEdges.isEmpty() && availableEdges.peek().getNeigbor(v).isVisited == true) {
				availableEdges.poll();
			}

			if (availableEdges.isEmpty())
				break;
			Edge selectedEdge = availableEdges.poll();

			v = selectedEdge.getNeigbor(v);

		}
		refresh();

	}
}
