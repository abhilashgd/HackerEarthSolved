package Graphs;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Vector;

public class LISLDS {
	Double begin = (double) System.nanoTime();
	double LIMIT = 4.6;
	int JUMP = 0;
	int SQRT = 1;
	int ADD = 0;
	boolean MAPPING = false;
	int INC = 1;
	 
	int N, M, T;
	
	private static final int MAXN = 1<<18;
	 
	@SuppressWarnings("unchecked")
	Vector<Integer>[] Links=new Vector[MAXN + 1];
	
	int[] visited = new int[MAXN + 1];
	int currCounter = 1;
	
	
	void ParseInput() {
		 N=nextInt();
		 M=nextInt();
		 T=nextInt();
		for(int i=0;i<(MAXN+1);i++) Links[i]=new Vector<Integer>();

		for (int i = 0; i < M; i++) {
			int u=nextInt();
			int v=nextInt();
			Links[u].addElement(v);
			Links[v].addElement(u);
		}
	}
	 
	//Vector<Integer> SolveGreedyBFS(int node);
	 
	void Shuffler() {
		for (int i = 1; i <= N ; i++) {
			Collections.shuffle(Links[i]);
		}
	}
	void SortInc() {
		for (int i = 1; i <= N ; i++) {
			Collections.sort(Links[i]);
		}
	}
	void SortDec() {
		for (int i = 1; i <= N ; i++) {
			Collections.reverse(Links[i]);
		}
	}
	 
	long Key(long a, long b) {
		return (a<<32l)|b;
	}
	
	 long Max(Vector<Integer> best, boolean dir) {
		int[] tree=new int[2*MAXN];
	 	Arrays.fill(tree, 0);
	 	int n = best.size();
	  for (int i = 0; i < n; i++ ) {
	  	int leaf = dir ? (2 * N - best.get(i)) : (best.get(i)-1 + N);
			int max = 0;
			int l = leaf;
			while (l==1 && (l-1)==1) {
				if (l%2==0) l /= 2;
				else l = l/2 - 1;
				max = Math.max(max, tree[l]);
			}
	    tree[leaf] = 1 + max;
	    while (leaf > 1) {
	    	if (tree[leaf] <= tree[leaf/2]) break;
	    	tree[leaf/2] = tree[leaf];
	    	leaf /= 2;
	    }
	  }
	  return tree[1];
	}
	 
	
	 long Score(Vector<Integer> best) {
		return Max(best, true) * Max(best, false);
	}
	 
	int[] MaxDFS=new int[MAXN+1];
	int[] NextMaxDFS=new int[MAXN+1];
	int MaxDfs(int node) {
		if (visited[node] == currCounter) return 0;
		visited[node] = currCounter;
		int max = 1;
		for (int v : Links[node]) {
			int s = MaxDfs(v) + 1;
			if (s > max) {
				max = s;
				NextMaxDFS[node] = v;
			}
		}
		return MaxDFS[node] = max;
	}
	 
	
	void Print(Vector<Integer> ans) {
	if(ans.size()==1)
		pw.println(100.0 * Score(ans) / (1.0 * M));
	else{
		pw.println(ans.size());
		for (int v : ans) pw.println(v+" ");
	}
	}
	 
	boolean[] TAKEN= new boolean[MAXN];
	 
	void SolveGen1() {
		Vector<Integer> best = SolveGreedyBFS(N);
		long bs = Score(best);
		for (int i = 1; ; i++) {
			JUMP =  1 + (i % 4);
			SQRT = (int) (Math.random()%2);
			Vector<Integer> ans = SolveGreedyBFS((int)(Math.random()%N) + 1);
			long s = Score(ans);
			if (s > bs) {
				bs = s;
				best = (Vector<Integer>) ans.clone();
			}
			Double end = (double) System.nanoTime();
			double elapsed_secs = (end - begin) / 60;
			if (elapsed_secs > LIMIT) break;
			Shuffler();
		}
		Print(best);
	}
	 
	int mapping(int i) {
		if (i%2==0) return N - i/2;
		return i / 2;
	}
	 
	void SolveGen2() {
		Vector<Integer> best=new Vector<Integer>();
		 long bs= 0;
		for (int i = 1; ; i++) {
			int r = (int) (1 + (Math.random()%N));
			if (MAPPING) {
				while (4 * i < N && TAKEN[mapping(i)]) i++;
				if (4*i < N && !TAKEN[mapping(i)]) r = mapping(i);
			}
			Vector<Integer> ans = SolveGreedyBFS(r);
			 long s = Score(ans);
			if (s > bs) {
				bs = s;
				best = (Vector<Integer>) ans.clone();
			}
			Double end = (double) System.nanoTime();
			double elapsed_secs = (end - begin) / 60;
			if (elapsed_secs > LIMIT) break;
			Shuffler();
		}
		Print(best);
	}
	 
	void SolveGen3() {
		Vector<Integer> best = SolveGreedyBFS(N);
		long bs = Score(best);
		for (int i = 1; i < N; i++) {
			Vector<Integer> ans = SolveGreedyBFS(mapping(i));
			long s = Score(ans);
			if (s > bs) {
				bs = s;
				best = (Vector<Integer>) ans.clone();
			}
			Double end = (double) System.nanoTime();
			double elapsed_secs = (end - begin) / 60;
			if (elapsed_secs > LIMIT) break;
			Shuffler();
		}
		Print(best);
	}
	 
	
	Vector<Integer> SolveGreedyBFS(int node) {
		int[] FromBFS=new int[MAXN+1];
		int[] FromBFSDist=new int[MAXN+1];
		
		boolean open = true;
		visited[node] = ++currCounter;
		Vector<Integer> ans = new Vector<Integer>();
		ans.addElement(node);
		int min = 1;
		int max = N;
		Vector<Integer> q=new Vector<Integer>(N);
		while (open) {
			q.clear();
			q.add(node);
			if (min < max) TAKEN[node] = true;
			FromBFS[node] = -1;
			FromBFSDist[node] = 0;
			open = false;
			int closest = -1;
			int dist = 200*N;
			for (int i = 0; ; i++) {
				int t = q.get(i);
				int d = FromBFSDist[t] + 1;
				for (int v : Links[t]) {
					if (FromBFS[v]==1) continue;
					if (visited[v] == currCounter) continue;
					FromBFS[v] = t;
					FromBFSDist[v] = d;
					q.add(v);
					if (v >= min && v < min + dist) {
						dist = v - min;
						closest = v;
					}
					if (v <= max && v + dist > max) {
						dist = max - v;
						closest = v;
					}
				}
				if (i+1 == q.size()) break;
//				if (FromBFSDist[q[i+1]] == FromBFSDist[q[i]]) continue;
				if (INC * dist <= JUMP + SQRT * d * d && closest > 0) {
					int next = closest;
					open = true;
					Vector<Integer> aa = new Vector<Integer>();
					while (closest != node) {
						visited[closest] = currCounter;
						aa.add(closest);
						closest = FromBFS[closest];
					}
					ans.add(ans.lastElement());
					ans.add(aa.lastElement());
					ans.add(aa.firstElement());
					node = next;
					i = q.size();
					if (next >= min && next == min + dist) {
						min = next;
						if (min < max) min += ADD;
					}
					if (next <= max && next + dist == max) {
						max = next;
						if (min < max) max -= ADD;
					}
					while (visited[min] == currCounter) min++;
					while (visited[max] == currCounter) max--;
					break;
				}
			}
			for (int i : q) FromBFS[i] = 0;
		}
	 
		for (int i = 0; i < 2; i++) {
			int n = ans.lastElement();
			ans.remove(ans.lastElement());
			visited[n]--;
			Arrays.fill(MaxDFS, 0);
			Arrays.fill(NextMaxDFS, 0);
		  MaxDfs(n);
		  while (n==1) {
				ans.add(n);
				n = NextMaxDFS[n];
			}
			if (i == 0) Collections.reverse(ans);
		}
		return ans;
	}
	void Solve() {
		switch (T) {
			case 1: case 2: case 3: case 4: case 5: case 6: case 7:
			    LIMIT = 4.8;
				SolveGen1();
				break;
	 
			case 8: case 9: case 10:
				SolveGen2();
				break;
	 
			case 11:
				JUMP = 45;
				SQRT = 0;
				SolveGen3();
				break;
	 
			case 15:
				LIMIT = Math.min(LIMIT, 4.0);
				SolveGen2();
				break;
			case 14:
				LIMIT = Math.min(LIMIT, 4.4);
			case 13: case 12:
				SolveGen2();
				break;
			default: SolveGen2();
		}
	}

	  public static void main(String[] args) throws Exception { new LISLDS().run(); }
	  
	InputStream is;
    PrintWriter pw;
    String INPUT = "";
    void run() throws Exception {
        is = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(INPUT.getBytes());
        pw = new PrintWriter(System.out);
        long s = System.currentTimeMillis();
		  MAPPING = true;
		  ParseInput();
		  SortInc();
		  Solve();
        pw.flush();
        if(!INPUT.isEmpty())tr(System.currentTimeMillis()-s+"ms");
    }
   
	private byte[] inbuf = new byte[1024];
    public int lenbuf = 0, ptrbuf = 0;
 
    private int readByte() {
        if(lenbuf == -1)throw new InputMismatchException();
        if(ptrbuf >= lenbuf){
            ptrbuf = 0;
            try { lenbuf = is.read(inbuf); } catch (IOException e) { throw new InputMismatchException(); }
            if(lenbuf <= 0)return -1;
        }
        return inbuf[ptrbuf++];
    }

    private int nextInt() {
        int num = 0, b;
        boolean minus = false;
        while((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
        if(b == '-'){
            minus = true;
            b = readByte();
        }
 
        while(true){
            if(b >= '0' && b <= '9'){
                num = num * 10 + (b - '0');
            }else{
                return minus ? -num : num;
            }
            b = readByte();
        }
    }
     private void tr(Object... o) { if(INPUT.length() > 0)System.out.println(Arrays.deepToString(o)); }
}

