

class Solution{
	long no_of_subarrays(int N, int [] arr) {
		//Write your code here
		long ans=0;
		long cnt=0;
		for(int i=0; i<N; i++)
		{
		    if(arr[i]==0)
		    cnt++;
		    else
		    {
		        ans += (cnt+1)*cnt/2;
		        cnt=0;
		    }
		}
		 ans += (cnt+1)*cnt/2;
		return ans;
	}
}
