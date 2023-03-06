class Solution:
    def noConseBits(self, n : int) -> int:
        # code here
        # code here
        count=0
        for i in range(31,-1,-1):
            if n & (1<<i):
                count+=1
            else:
                count=0
            if count==3:
                n=n & (~(1<<i))
                count=0
        return n
      
      
