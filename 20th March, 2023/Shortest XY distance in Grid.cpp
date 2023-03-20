// User function Template for C++

class Solution {
  public:
    int shortestXYDist(vector<vector<char>> grid, int N, int M) {
        // code here
         vector<vector<int>> dist(N, vector<int>(M));

        // initialize dist with maximum values
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                dist[i][j] = INT_MAX-1;
            }
        }

        // check top and left
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (grid[i][j] == 'X')
                    dist[i][j] = 0;
                else {
                    if (i-1 >= 0)  //top
                        dist[i][j] = std::min(dist[i][j], dist[i - 1][j] + 1);
                    // if(j+1<M) //right --
                    //      dist[i][j] = std::min(dist[i][j], dist[i][j + 1] + 1);
                    // if(i+1<N)//bottom --
                        //  dist[i][j] = std::min(dist[i][j], dist[i+1][j] + 1);
                    if (j-1>=0) //left
                        dist[i][j] = std::min(dist[i][j], dist[i][j - 1] + 1);
                }
            }
        }

        // check bottom and right
        for (int i = N - 1; i >= 0; i--) {
            for (int j = M - 1; j >= 0; j--) {
               if (grid[i][j] == 'X')
                    dist[i][j] = 0;
                else {
                    // if (i-1 >= 0)  //top
                    //     dist[i][j] = std::min(dist[i][j], dist[i - 1][j] + 1);
                    if(j+1<M) //right --
                         dist[i][j] = std::min(dist[i][j], dist[i][j + 1] + 1);
                    if(i+1<N)//bottom --
                         dist[i][j] = std::min(dist[i][j], dist[i+1][j] + 1);
                    // if (j-1>=0) //left
                    //     dist[i][j] = std::min(dist[i][j], dist[i][j - 1] + 1);
                }
            }
        }

    int ans = INT_MAX-1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) 
            {
                if (grid[i][j] == 'Y') ans = std::min(ans, dist[i][j]);
            }
        }

        return ans;

    }
};
