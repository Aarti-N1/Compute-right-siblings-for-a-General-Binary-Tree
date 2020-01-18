package medium;

public class ComputeRightSiblingTreeForGeneralBT_117 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Input [1,2,3,4,null,5,6,null,null,7,null,8,9]
		//Output [1,#,2,3,#,4,5,6,#,7,8,9,#]
		Node root = new Node(1);
		root.left=new Node(2);
		root.right=new Node(3);
		root.left.left=new Node(4);
		root.right.left=new Node(5);
		root.right.right=new Node(6);
		root.right.left.left=new Node(7);
		root.right.right.left=new Node(8);
		root.right.right.right=new Node(9);
		Node res = connect(root);
		System.out.println(res.val);
	}

	    public static Node connect(Node root) {
	    	if(root == null)
	            return null;
	        root.next= null;
	        Node cur = root;
	        Node levelStart = root;
	        Node nextPointer;
	        while(cur!=null){
	            if(cur.left!=null){
	                if(cur.right!=null)
	                    cur.left.next = cur.right;
	                else{
	                    nextPointer= findNext(cur);
	                    cur.left.next = nextPointer;
	                }
	            }
	            if(cur.right!=null){
	                nextPointer= findNext(cur);
	                cur.right.next = nextPointer;
	            }
	            if(cur.next != null){
	                cur = cur.next;
	            }else{
	                if(levelStart.left != null){
	                    levelStart = levelStart.left;
	                    cur= levelStart;
	                }else if(levelStart.right != null){
	                    levelStart = levelStart.right;
	                    cur= levelStart;
	                }else{
	                    cur = findNext(levelStart);
	                    levelStart = cur;
	                }
	            }
	        }
	        return root;
	    }
	    public static Node findNext(Node root){
	        while(root.next!=null){
	            root=root.next;
	            if(root.left!=null)
	                return root.left;
	            if(root.right!=null)
	                return root.right;
	        }
	        return null;
	    }
		static class Node {
		    public int val;
		    public Node left;
		    public Node right;
		    public Node next;

		    public Node() {}
		    
		    public Node(int _val) {
		        val = _val;
		    }

		    public Node(int _val, Node _left, Node _right, Node _next) {
		        val = _val;
		        left = _left;
		        right = _right;
		        next = _next;
		    }
		};
		
		

}
