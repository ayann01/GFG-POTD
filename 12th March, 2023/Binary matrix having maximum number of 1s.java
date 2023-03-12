

//User function Template for Java

class Solution {
    public int[] findMaxRow(int mat[][], int N) {
        // code here
        int row=0; int j=N-1; int res[] = new int[2];
        for(int i=0; i<N; i++)
        {
            while(j>=0 && mat[i][j]==1)
            {
                row=i;
                j--;
            }
        }
        res[0] = row;
        res[1] = N-j-1;
        return res;
    }
};
