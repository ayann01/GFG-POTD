//User function Template for C++
class Solution {
  public:
    long long countSubarray(int N,vector<int> A,int M) {
        // code here
    
     return count(N, A, M) - count(N, A, M+1);
    }
    long long count(int n, vector<int> A,int m)
    {
        long  long ans=0,x=0, sum=0;
        unordered_map<int, int>map;
        map[0]=1;
        
        for(int i=0; i<n; i++)
        {
            if(A[i]>=m)
            {
                x+= map[sum];
                sum++;
            }
            else
            {
                sum--;
                x-= map[sum];
            }
            map[sum]++;
            ans+=x;
        }
        return ans;
    }
};
