import java.util.ArrayList;

public class Vertex implements Comparable<Vertex>{
		
		 String value;
		 ArrayList<Edge> edges;
		boolean isVisited;
		int distance;
		int startTime;
		int finishTime;
		int color;
		public Vertex(String value) {
			super();
			distance=Integer.MAX_VALUE;
			isVisited = false;
			this.value = value;
			edges=new ArrayList<>();
			
		}
		public Vertex(String value, ArrayList<Vertex> neighbors ,ArrayList<Integer> weights,boolean directed) {
			super();
			distance=Integer.MAX_VALUE;
			isVisited = false;
			this.value = value;
			edges=new ArrayList<>();
			for(int i=0;i<neighbors.size();i++) {
				Edge e=new Edge(this, neighbors.get(i), weights.get(i));
				edges.add(e);
				if(!directed)
				neighbors.get(i).edges.add(e);
			}
			
		}
		
		@Override
		public String toString() {
			return "Vertex [value=" + value + ", distance=" + distance + "]";
		}

		@Override
		public int compareTo(Vertex o) {
			if(o.distance<distance) return 1;
			return -1;
		}
	}