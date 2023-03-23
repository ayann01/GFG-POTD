//User function Template for C++

class Solution{
public:
  int res;
    int maxDifferenceBST(Node *root,int target)
  {
        int sum=0;
        Node* curr=root;
        while(curr!=NULL)
        {
            if(curr->data==target)
                break;
            else if(curr->data < target)
            {
                sum+= curr->data;
                curr = curr->right;
            }
            else
            {
                sum+= curr->data;
                curr= curr->left;
            }
        }
        if(curr==NULL) 
            return -1;
        else 
        {   
            if(curr->left==NULL && curr->right==NULL)
            {
                return sum;
            }
            res=INT_MIN;
            if(curr->left!=NULL)
                solve(curr->left,0,sum);

            if(curr->right!=NULL)
                solve(curr->right,0,sum);

            return res;
        }
    }

    void solve(Node* root, int path_sum , int sum)
    {
        if(root==NULL)
            return;
        if(root->left==NULL && root->right==NULL)
        {
            res = max(res, sum - (path_sum+root->data));
            return;
        }
        solve(root->left, path_sum+root->data, sum);
        solve(root->right, path_sum+root->data, sum);
    }
};
