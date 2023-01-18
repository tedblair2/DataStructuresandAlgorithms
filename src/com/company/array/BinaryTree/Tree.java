package com.company.array.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Tree {
    private TreeNode root;
    private int length;

    private static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data){
            this.data=data;
        }
    }
    private int length(){
        return length;
    }
    private void recursivepreOrderTraversal(TreeNode node){//visit left side unitl the leaf node then move until last node
        if (node==null){
            return;
        }
        System.out.print(node.data+" -->");
        recursivepreOrderTraversal(node.left);
        recursivepreOrderTraversal(node.right);
    }
    private void iterativePreOrderTraversal(TreeNode node){
        if (node==null){
            return;
        }
        System.out.println(" ");
        Stack<TreeNode> stack=new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()){
            TreeNode temp=stack.pop();
            System.out.print(temp.data+" -->");
            if (temp.right!=null){
                stack.push(temp.right);
            }
            if (temp.left!=null){
                stack.push(temp.left);
            }
        }
    }
    private void recursiveInOrderTraversal(TreeNode node){
        if (node==null){
            return;
        }
        recursiveInOrderTraversal(node.left);
        System.out.print(node.data+" -->");
        recursiveInOrderTraversal(node.right);
    }
    private void iterativeInOrderTraversal(TreeNode node){
        if (node==null){
            return;
        }
        Stack<TreeNode> stack=new Stack<>();
        TreeNode temp=node;
        while (!stack.isEmpty() || temp !=null){
            if (temp!=null){
                stack.push(temp);
                temp=temp.left;
            }else {
                temp=stack.pop();
                System.out.print(temp.data+" -->");
                temp=temp.right;
            }
        }
    }
    private void recursivePostOrderTraversal(TreeNode node){
        if (node==null){
            return;
        }
        recursivePostOrderTraversal(node.left);
        recursivePostOrderTraversal(node.right);
        System.out.print(node.data+" -->");
    }
    private void iterativePostOrderTraversal(TreeNode node){
        if (node==null){
            return;
        }
        TreeNode current=node;
        Stack<TreeNode> stack=new Stack<>();
        while (!stack.isEmpty() || current!=null){
            if (current!=null){
                stack.push(current);
                current=current.left;
            }else {
                TreeNode temp=stack.peek().right;
                if (temp==null){
                    temp=stack.pop();
                    System.out.print(temp.data+" -->");
                    while (!stack.isEmpty() && temp==stack.peek().right){
                        temp=stack.pop();
                        System.out.print(temp.data+" -->");
                    }
                }else {
                    current=temp;
                }
            }
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
    private int findMax(TreeNode node){
        if (node==null){
            return 0;
        }
        int max=node.data;
        int left=findMax(node.left);
        int right=findMax(node.right);
        if (left>max) {
            max = left;
        }
        if (right>max){
            max=right;
        }
        return max;
    }
    private boolean isSymmetric(TreeNode top){//interview question
        if (top==null){
            return true;
        }
        Stack<TreeNode> stack=new Stack<>();
        stack.push(top.right);
        stack.push(top.left);
        while (!stack.isEmpty()){
            TreeNode n1=stack.pop();
            TreeNode n2=stack.pop();
            if (n1==null && n2==null){
                continue;
            }
            if (n1==null || n2==null || n1.data != n2.data){
                return false;
            }
            stack.push(n1.left);
            stack.push(n2.right);
            stack.push(n1.right);
            stack.push(n2.left);
        }
        return true;
    }

    public static void main(String[] args){
        Tree tree=new Tree();
        tree.root=new TreeNode(3);
        TreeNode second=new TreeNode(4);
        TreeNode third=new TreeNode(4);
        TreeNode fourth=new TreeNode(6);
        TreeNode fifth=new TreeNode(1);
        TreeNode sixth=new TreeNode(1);
        TreeNode seventh=new TreeNode(6);
        tree.root.left=second;
        tree.root.right=third;
        second.left=fourth;
        second.right=fifth;
        third.left=seventh;
        third.right=sixth;
        System.out.println(tree.isSymmetric(tree.root));
//        tree.recursivepreOrderTraversal(tree.root);
//        tree.iterativePreOrderTraversal(tree.root);
//        System.out.println(" ");
//        tree.recursiveInOrderTraversal(tree.root);
//        System.out.println(" ");
//        tree.iterativeInOrderTraversal(tree.root);
//        System.out.println(" ");
//        tree.recursivePostOrderTraversal(tree.root);
//        System.out.println(" ");
//        tree.iterativePostOrderTraversal(tree.root);
//        System.out.println(" ");
//        tree.levelOrderTraversal(tree.root);
//        int max=tree.findMax(tree.root);
////        System.out.println("Maximum number in tree is "+max);

    }
}
