class TreeNode{
    int val;
    TreeNode left,right;

    public TreeNode(int val){
        this.val=val;
        this.left=this.right=null;
    }
}

public class boundaryvalue {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(3);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(6);
        root.left.right.left = new TreeNode(4);
        root.left.right.right = new TreeNode(7);
        root.right.right = new TreeNode(14);
        root.right.right.left = new TreeNode(13);
        boundaryTraversal(root);
    }

    static void boundaryTraversal(TreeNode root){
        if(root==null){
            return;
        }
        System.out.print(root.val+" ");
        printleft(root.left);
        printleave(root.left);
        printleave(root.left);
        printright(root.right);
    }

    static void printleft(TreeNode root){
        if(root==null || (root.left==null && root.right==null)){
            return;
        }
        System.out.print(root.val+" ");
        if(root.left!=null){
            printleft(root.left);
        }else{
            printleft(root.right);
        }
    }

    static void printright(TreeNode root){
        if(root==null || (root.left==null && root.right==null)){
            return;
        }
        if(root.right!=null){
            printleft(root.right);
        }else{
            printleft(root.left);
        }
        System.out.print(root.val+" ");
    }


    static void printleave(TreeNode root){
        if(root==null){
            return;
        }
        if(root.left==null && root.right==null){
            System.out.print(root.val);
            return;
        }
        printleave(root.left);
        printleave(root.right);
    }
}
