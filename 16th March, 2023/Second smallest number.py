#User function Template for python3

class Solution:
    def secondSmallest(self, S, D):
        # code here 
        if S>=D*9:
            return '-1'
        S=S-1
        ans = [0]*D
        for i in range(D-1,0,-1):
            if S>9:
                ans[i] = 9
                S -= 9
            else:
                ans[i] = S
                S=0
        ans[0]=S+1
        
        idx=D-1
        for i in range(D-1,-1,-1):
            if ans[i]==9:
                idx=i
            else:
                break
        ans[idx] -= 1
        ans[idx-1] += 1
        return ''.join(str(e) for e in ans)
