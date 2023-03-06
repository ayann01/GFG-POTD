

// User function Template for Java

class Solution {
    int parent[]; int rank[];
    ArrayList<String> avoidExlosion(int mix[][], int n, int danger[][], int m) {
        // Code Here
        ArrayList<String> ans = new ArrayList<>();
        parent = new int[n+1]; rank = new int[n+1];
        
        for(int i=0; i<=n; i++)
        parent[i]=i;
        
        for(int i=0; i<n; i++)
        {
            int a = find(mix[i][0]); int b = find(mix[i][1]);
            boolean canmix = true;
            for(int j=0; j<m; j++)
            {
                int c = find(danger[j][0]); int d = find(danger[j][1]);
                if((a==c && b==d) || (a==d && b==c))
                {
                    canmix = false;
                    break;
                }
            }
            if(canmix){
                union(a,b); ans.add("Yes");
            }
            else
            ans.add("No");
        }
        return ans;
    }   
        
        void union(int x, int y)
        {
            int x_rep = find(x); int y_rep = find(y);
            if(x_rep == y_rep) return;
            if(rank[x_rep] < rank[y_rep])
            {
                parent[x_rep] = y_rep;
            }
            else if(rank[x_rep] > rank[y_rep])
            parent[y_rep] = x_rep;
            else
            {
                parent[y_rep] = x_rep;
                rank[x_rep]++;
            }
        }
        int find(int x)
        {
            if(x==parent[x])
            return x;
            return parent[x] = find(parent[x]);
        }
    }
