

//User function Template for Java

class Solution 
{ 
    static long solve(int X,int Y, String S)
	{    
	    // code here
        // x//- pr(s1) , Y -rp(s2)
        String s1="pr" ; String s2="rp";
        if(X<Y)
        {
            int temp = X; X=Y; Y=temp;
	       
	       String t =s1; s1=s2; s2=t;
        }
        long ans=0;
        // //now we know X has larger cost in any case and has string associated named s1.
        Stack<Character> st = new Stack<>();
	   for(int i =S.length()-1; i>=0; i--)
	   {
	       Character curr= S.charAt(i), first=s1.charAt(0), second = s1.charAt(1);
	       if(st.size()>0 && curr ==first && st.peek()==second)
	       {
	           st.pop();
	           ans+=X;
	       }
	       else
	       st.push(curr);
	   }
	   
	    //step -2
	    StringBuilder rem = new StringBuilder();
	   while(st.size()>0)
	   rem.append(st.pop());
	   
	    S = rem.toString();
	   //in rem string check for the other cost Y, if any instances present , remove them now
	  
	   for(int i =S.length()-1; i>=0; i--)
	   {
	       Character curr= S.charAt(i), first=s2.charAt(0), second = s2.charAt(1);
	       if(st.size()>0 && curr ==first && st.peek()==second)
	       {
	           st.pop();
	           ans+=Y;
	       }
	       else
	       st.push(curr);
	   }
	   return ans;
	}
} 
