

class Solution {
    public static ArrayList<Integer> getDistinctDifference(int n, int[] A) {
        // code here
        
        Map<Integer, Integer> x = new HashMap<>();
         Map<Integer, Integer> y = new HashMap<>();
         for(int i=0; i<n; i++)
         y.put(A[i], y.getOrDefault(A[i],0)+1);
         
         ArrayList<Integer> al = new ArrayList<Integer>();
          for(int i=0; i<n; i++)
          {
              //decrese count of curr ele from y
              y.put(A[i], y.get(A[i])-1);
              //if becomes 0 remove its existence
              if(y.get(A[i])==0) y.remove(A[i]);
              
              int curr_ans = x.size()-y.size();
              al.add(curr_ans);
              
              //place this curr_ele in left to help process for next tr
               x.put(A[i], x.getOrDefault(A[i],0)+1);
          }
        
        return al;
       
    }
}     
