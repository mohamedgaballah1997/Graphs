import java.util.Comparator;

public class Edge implements Comparable<Edge>{
		 Vertex v1;
		 Vertex v2;
		 int weight;

		public Edge(Vertex v1,Vertex v2, int weight) {
			super();
			this.v1 = v1;
			this.v2 = v2;
			this.weight = weight;
		}
		public Vertex getNeigbor(Vertex v) {
			if(v.equals(v2))
				return v1;
			else if(v.equals(v1))
				return v2;
			else {
			return	v1.isVisited==false ?  v1:v2;
			}
			
			
		}

		@Override
		public String toString() {
			return "Edge [v1=" + v1.value + ", v2=" + v2.value + ", weight=" + weight + "]";
		}

		@Override
		public int compareTo(Edge o) {
			if(o.weight<weight) return 1;
		return -1;

		}
		
}
	