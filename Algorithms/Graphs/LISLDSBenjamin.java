package Graphs;
/*
> - We want to have a sub sequence increasing and
> decreasing as long as possible and as close in size to
> each other as possible: a*b is maximize for (a+b)=n
> when a=b.
> - So we need to grow these two subsequences in the same
> time.
> 
> We first start from a random node (though in general 1
> or N are good candidate, and we keep track of the
> lowest in our increasing sub sequence and highest in
> decreasing subsequences.
> From the current node we do a BFS until we explore a
> node which is relatively close to one of the extremity
> (such it will increase our sequence). We need to fix a
> criteria, for example for big test we can decide to
> accept a node once it's ~current + 10, and once we find
> such a node, we append the path to get there to our
> current path, and restart the same process from this
> new node.
> 
> Doing so will grow nicely both our sequence in
> parallel.
> I generate as many path like that that I could within
> 5s and kept the best one.
> That's basically my algorithm. I improved it a bit
> after the challenge was over adding another 7% using
> beam search (basically keeping track of more than one
> solution).


#include <stdio.h>
#include <vector>
#include <map>
#include <set>
#include <unordered_map>
#include <unordered_set>
#include <algorithm>
#include <deque>
#include <ctime>
 
auto begin = std::clock();
double LIMIT = 4.6;
int JUMP = 0;
int SQRT = 1;
int ADD = 0;
bool MAPPING = false;
int INC = 1;
 
int N, M, T;
 
const int MAXN = 1<<18;
 
std::vector<int> Links[MAXN + 1];
int visited[MAXN + 1];
int currCounter = 1;
 
void ParseInput() {
	int j = scanf("%d %d %d\n", &N, &M, &T);
	for (int i = 0; i < M; i++) {
		int u, v;
		j = scanf("%d %d\n", &u, &v);
		Links[u].push_back(v);
		Links[v].push_back(u);
	}
}
 
std::vector<int> SolveGreedyBFS(int node);
 
void Shuffler() {
	for (int i = 1; i <= N ; i++) {
		std::random_shuffle(Links[i].begin(), Links[i].end());
	}
}
void SortInc() {
	for (int i = 1; i <= N ; i++) {
		std::sort(Links[i].begin(), Links[i].end());
	}
}
void SortDec() {
	for (int i = 1; i <= N ; i++) {
		std::sort(Links[i].rbegin(), Links[i].rend());
	}
}
 
long long Key(long long a, long long b) {
	return (a<<32ll)|b;
}
 
int tree[2*MAXN];
template<class Container>
long long Max(Container& arr, bool dir) {
 	std::fill(tree, tree + 2*N, 0);
 	int n = arr.size();
  for (int i = 0; i < n; i++ ) {
  	int leaf = dir ? (2 * N - arr[i]) : (arr[i]-1 + N);
		int max = 0;
		int l = leaf;
		while (l & (l-1)) {
			if (l%2) l /= 2;
			else l = l/2 - 1;
			max = std::max(max, tree[l]);
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
 
template<class Container>
long long Score(Container ans) {
	return Max(ans, true) * Max(ans, false);
}
 
int MaxDFS[MAXN+1];
int NextMaxDFS[MAXN+1];
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
 
template<class Container>
void Print(Container ans) {
#ifdef LOCAL
	printf("%lld\n", (long long)(100.0 * Score(ans) / (1.0 * M)));
#else
	printf("%d\n", ans.size());
	for (int v : ans) printf("%d ", v);
	printf("\n");
#endif
#ifdef INFO
  printf("%zd %lld - %lld\n", ans.size(), Max(ans, true), Max(ans, false));
#endif
}
 
bool TAKEN[MAXN];
 
void SolveGen1() {
	std::vector<int> best = SolveGreedyBFS(N);
	int bs = Score(best);
	for (int i = 1; ; i++) {
		JUMP =  1 + (i % 4);
		SQRT = rand()%2;
		auto ans = SolveGreedyBFS((rand()%N) + 1);
		int s = Score(ans);
		if (s > bs) {
			bs = s;
			best = std::move(ans);
		}
		auto end = std::clock();
		double elapsed_secs = double(end - begin) / CLOCKS_PER_SEC;
		if (elapsed_secs > LIMIT) break;
		Shuffler();
	}
	Print(best);
}
 
int mapping(int i) {
	if (i%2) return N - i/2;
	return i / 2;
}
 
void SolveGen2() {
	std::vector<int> best;
	long long bs= 0;
	for (int i = 1; ; i++) {
		int r = 1 + (rand()%N);
		if (MAPPING) {
			while (4 * i < N && TAKEN[mapping(i)]) i++;
			if (4*i < N && !TAKEN[mapping(i)]) r = mapping(i);
		}
		auto ans = SolveGreedyBFS(r);
		long long s = Score(ans);
		if (s > bs) {
			bs = s;
			best = std::move(ans);
		}
		auto end = std::clock();
		double elapsed_secs = double(end - begin) / CLOCKS_PER_SEC;
		if (elapsed_secs > LIMIT) break;
		Shuffler();
	}
	Print(best);
}
 
void SolveGen3() {
	std::vector<int> best = SolveGreedyBFS(N);
	int bs = Score(best);
	for (int i = 1; i < N; i++) {
		auto ans = SolveGreedyBFS(mapping(i));
		int s = Score(ans);
		if (s > bs) {
			bs = s;
			best = std::move(ans);
		}
		auto end = std::clock();
		double elapsed_secs = double(end - begin) / CLOCKS_PER_SEC;
		if (elapsed_secs > LIMIT) break;
		Shuffler();
	}
	Print(best);
}
 
int FromBFS[MAXN+1];
int FromBFSDist[MAXN+1];
std::vector<int> q;
std::vector<int> SolveGreedyBFS(int node) {
	bool open = true;
	visited[node] = ++currCounter;
	std::vector<int> ans = {node};
	int min = 1;
	int max = N;
	q.resize(N);
	while (open) {
		q.clear();
		q.push_back(node);
		if (min < max) TAKEN[node] = true;
		FromBFS[node] = -1;
		FromBFSDist[node] = 0;
		open = false;
		int closest = -1;
		int dist = 200*N;
		for (int i = 0; ; i++) {
			int t = q[i];
			int d = FromBFSDist[t] + 1;
			for (int v : Links[t]) {
				if (FromBFS[v]) continue;
				if (visited[v] == currCounter) continue;
				FromBFS[v] = t;
				FromBFSDist[v] = d;
				q.push_back(v);
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
//			if (FromBFSDist[q[i+1]] == FromBFSDist[q[i]]) continue;
			if (INC * dist <= JUMP + SQRT * d * d && closest > 0) {
				int next = closest;
				open = true;
				std::vector<int> aa;
				while (closest != node) {
					visited[closest] = currCounter;
					aa.push_back(closest);
					closest = FromBFS[closest];
				}
				ans.insert(ans.end(), aa.rbegin(), aa.rend());
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
		int n = ans.back();
		ans.pop_back();
		visited[n]--;
		std::fill(MaxDFS, MaxDFS + N + 1, 0);
		std::fill(NextMaxDFS, MaxDFS + N + 1, 0);
	  MaxDfs(n);
	  while (n) {
			ans.push_back(n);
			n = NextMaxDFS[n];
		}
		if (i == 0) std::reverse(ans.begin(), ans.end());
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
			LIMIT = std::min(LIMIT, 4.0);
			SolveGen2();
			break;
		case 14:
			LIMIT = std::min(LIMIT, 4.4);
		case 13: case 12:
			SolveGen2();
			break;
		default: SolveGen2();
	}
}
 
int main() {
  srand(71990);
  MAPPING = true;
  ParseInput();
  SortInc();
  Solve();
  return 0;
}
 
/*
Process: data/1
Time: 4504 [4502, 4509]
Score: 249 [229, 283]
 
Process: data/2
Time: 4505 [4503, 4514]
Score: 204 [187, 222]
 
Process: data/3
Time: 4504 [4503, 4514]
Score: 108 [105, 116]
 
Process: data/4
Time: 4505 [4503, 4515]
Score: 437 [427, 454]
 
Process: data/5
Time: 4506 [4504, 4513]
Score: 297 [289, 307]
 
Process: data/6
Time: 4507 [4504, 4517]
Score: 193 [190, 202]
 
Process: data/7
Time: 4510 [4505, 4519]
Score: 96 [94, 100]
 
Process: data/8
Time: 4540 [4507, 4587]
Score: 2552 [2533, 2578]
 
Process: data/9
Time: 4581 [4515, 4664]
Score: 4286 [3952, 4738]
 
Process: data/10
Time: 4570 [4515, 4670]
Score: 2790 [2074, 3510]
 
Process: data/11
Time: 4533 [4511, 4602]
Score: 254 [171, 389]
 
Process: data/12
Time: 4517 [4505, 4528]
Score: 1803 [1781, 1842]
 
Process: data/13
Time: 4540 [4508, 4575]
Score: 2872 [2812, 2923]
 
Process: data/14
Time: 4104 [4020, 4261]
Score: 4637 [4374, 4726]
 
Process: data/15
Time: 3747 [3598, 3945]
Score: 7521 [7012, 7749]
 
Final score: 1887
*/
 