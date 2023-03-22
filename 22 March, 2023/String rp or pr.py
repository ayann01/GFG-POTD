#User function Template for python3

class Solution:
    def solve(self, X, Y, S):
        #code here
        # X - pr(String s1), Y - rp(String s2)
        s1="pr"
        s2="rp"
        # decide which has greater cost
        #if X is greater - np - proceed
        if(X<Y):
            temp = X
            X=Y
            Y=temp
            t =s1
            s1=s2
            s2=t
        ans=0
        #now we know X has larger cost in any case and has string associated named a.
        #Stack<Character> st = new Stack<>();
        st=[]
        for i in range(len(S)-1,-1,-1):
            curr=S[i]
            first = s1[0]
            second= s1[1]
            if(len(st)>0 and curr==first and st[-1]==second):
                st.pop()
                ans+=X
            else:
                st.append(curr)
        S=""
        while(len(st)>0):
            S+=st.pop()
        #in rem string check for the other cost Y, if any instances present , remove them now
        for i in range(len(S)-1,-1,-1):
            curr=S[i]
            first = s2[0]
            second= s2[1]
            if(len(st)>0 and curr==first and st[-1]==second):
                st.pop()
                ans+=Y
            else:
                st.append(curr)
        return ans

