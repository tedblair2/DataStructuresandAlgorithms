package com.company.array.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class SearchTree {
    private TreeNode root;

    public static class TreeNode{
        int data;
        TreeNode left,right;

        public TreeNode(int data){
            this.data=data;
        }
    }
    private void levelOrderTraversal(TreeNode node){
        if (node==null){
            return;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()){
            TreeNode temp=queue.poll();
            System.out.print(temp.data+" -->");
            if (temp.left!=null){
                queue.offer(temp.left);
            }
            if (temp.right!=null){
                queue.offer(temp.right);
            }
        }
    }

    private TreeNode insertValue(TreeNode first,int value){
        TreeNode node=new TreeNode(value);
        if (first==null){
            first=node;
            return first;
        }
        if (value<first.data){
            first.left=insertValue(first.left,value);
        }else {
            first.right=insertValue(first.right,value);
        }
        return first;
    }
    private TreeNode searchTree(TreeNode current,int value){
        if (current==null || current.data==value){
            return current;
        }
        if (value<current.data){
            return searchTree(current.left,value);
        }else {
            return searchTree(current.right,value);
        }
    }
    private boolean checkValidTree(TreeNode node,long min,long max){
        if (node == null) {
            return true;
        }
        if (node.data<=min||node.data>=max){
            return false;
        }
        boolean left=checkValidTree(node.left,min,node.data);
        if (left){
            boolean right=checkValidTree(node.right,node.data,max);
            return right;
        }
        return false;
    }

    public static void main(String[] args){
        SearchTree tree=new SearchTree();
        tree.root=tree.insertValue(tree.root,9);
        TreeNode second=tree.insertValue(tree.root,10);
        TreeNode third=tree.insertValue(tree.root,4);
        TreeNode fourth=tree.insertValue(second,5);
        TreeNode fifth=tree.insertValue(second,2);
        tree.levelOrderTraversal(tree.root);
        System.out.println(" ");
        TreeNode node=tree.searchTree(tree.root,5);
        if (node==null){
            System.out.println("Key not present.");
        }else {
            System.out.println("Key "+node.data+" found.");
        }
        long min=Long.MIN_VALUE;
        long max=Long.MAX_VALUE;
        boolean valid=tree.checkValidTree(tree.root,min,max);
        if (valid){
            System.out.println("Tree is valid");
        }else {
            System.out.println("Tree is not valid");
        }
    }
}
