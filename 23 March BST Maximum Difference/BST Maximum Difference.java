

//User function Template for Java

class Solution
{
    static int res;
    public static int maxDifferenceBST(Node root,int target)
    {
        //Please code here
        int sum=0;
        Node  curr=root;
        while(curr!=null)
        {
            if(curr.data==target)
            break;
            else if(curr.data < target)
            {
                sum+= curr.data;
                curr =curr.right;
            }
            else
            {
                sum+=curr.data;
                curr=curr.left;
            }
        }
       if(curr==null)
       return -1;
       
       else{
           
           if(curr.left==null && curr.right==null)
           return sum;
           //now have to cover each path , comparing which path gives min value,
        // while traversing the path maintiain path sum and if reached leaves return the max diff
        res=Integer.MIN_VALUE;
        if(curr.left!=null)
        {
            solve(curr.left, 0, sum);
        }
        
        if(curr.right!=null)
        {
            solve(curr.right, 0, sum);
        }
       }
       return res;
        
    }
     static void solve(Node root, int path_sum , int sum)
    {
        
        if(root==null)
        return;
        
        //bc if reached leaves return the diff
        if(root.left==null && root.right==null)
        {
            res=Math.max(res, sum - (path_sum+root.data));
            return;
        }
        
        solve(root.left, path_sum+root.data, sum);
        solve(root.right, path_sum+root.data, sum);
        
        
    }
}
