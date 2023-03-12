#User function Template for python3

class Solution:
    def findMaxRow(self, mat, N):
        # Code here
        row=0; j=N-1; res = [0]*2;
        for i in range(N):
            while(j>=0 and mat[i][j]==1):
                row=i
                j-=1
        res[0] = row
        res[1] = N-j-1
        return res
