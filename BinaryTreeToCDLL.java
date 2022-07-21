class Solution
{ 
    //Function to convert binary tree into circular doubly linked list.
    Node bTreeToClist(Node root)
    { 
        return convertTree(root);
    }
    Node convertTree(Node root){
        if(root == null){
            return null;
        }
        if(root.left == null && root.right == null){
            root.left = root.right = root;
            return root;
        }
        Node head1 = convertTree(root.left);
        Node right = root.right;
        root.left = root.right = root;
        Node part1 = establishConnection(head1, root);
        Node part2 = convertTree(right);
        return establishConnection(part1, part2);
        
        
    }
    Node establishConnection(Node head1, Node head2){
        if(head1 == null){
            return head2;
        }
        if(head2 == null){
            return head1;
        }
        Node tail1 = head1.left;
        Node tail2 = head2.left;
        tail1.right = head2;
        head2.left = tail1;
        head1.left = tail2;
        tail2.right = head1;
        return head1;
    }
    
}