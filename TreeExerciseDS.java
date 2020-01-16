
/**
 * Write a description of class TreeExercise here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.lang.Math;

/**
 *
 * @author csu
 */
public class TreeExercise
{
    public static void main(String args[])
    {

        TreeNode root;
        String[] myStringsChars = new String[26];

        for(int i = 0; i < 26; i++)
        {
            myStringsChars[i] = new String(Character.toChars(i+65));
            //System.out.println(myStringsChars[i]);
        }
        root = new TreeNode(myStringsChars[0], null);
        root = makeTree(root, myStringsChars, 0, 0);
        // create a traversal by levels and print as you traverse to check that the creation of the tree has happened correctly
        printTree(root);
        
        //when calling the maketree put the root for the parent when making the children
            
        // create the Tree as a linked structure from the array myStringChars
        // the Strings are stored using the representation for trees as arrays in the book
        // (e.g. for an element i, the left child is stored in position 2*i + 1, right child is 
        // on position 2*(i + 1). Also specify the level of a TreeNode

        // create the code that asks the user for two letters in uppercase and searches for the nodes in the tree that contain
        // such letters    
        TreeNode firstNode = null;
        TreeNode secondNode = null;
        int index = 0;
        int level = 0;
        
        System.out.println("Finding the lowest common anncestor only use capital letters");
        Scanner scan = new Scanner(System.in);
        System.out.println("Please select the first capital letter: ");
        String ui1 = scan.nextLine();
        System.out.println("Please select the second capital letter: ");
        String ui2 = scan.nextLine();
        //System.out.println(root.findNodeOnTree(ui1).getContents());
        TreeNode commonAncestor = findLowestCommonAncestor(root.findNodeOnTree(ui1), root.findNodeOnTree(ui2));
       // System.out.println(found.getContents());
        
       
       

        // create the code that calls the static method below and finds the lowest common ancestor of two TreeNodes
        //TreeNode commonAncestor = findLowestCommonAncestor(firstNode, secondNode);

        if(commonAncestor != null)
        {
            System.out.println(commonAncestor.getContents());
        }    
        else{
            System.out.println("No common ancestor was found");
        }
    }   

    public static TreeNode findLowestCommonAncestor(TreeNode node1, TreeNode node2)
    {
        
        if(node2.getParent().equals(node1.getParent())){
            return node1.getParent();
        }
        // if no common ancestor is found, this method returns null .
        else if (node1.getParent() == null || node2.getParent() == null ){
            return null;
        }
        else if(node1.getLevel() < node2.getLevel()){
            return findLowestCommonAncestor(node1, node2.getParent());
        }
        else if(node1.getLevel() > node2.getLevel()){
            return findLowestCommonAncestor(node1.getParent(), node2);
        }
        
        node1 = node1.getParent();
        node2 = node2.getParent();
        return findLowestCommonAncestor(node1, node2);
        // Given two nodes on the same tree, this method should return the lowest common ancestor.
        
    }

    
    
    public static TreeNode makeTree(TreeNode root, String[] nodes , int i, int level) // A will not have a parent and the parent of the cild would be root
    {
        root.setLevel(level);
        if(2* i +1 < nodes.length){
            TreeNode<String> t = new TreeNode<String>(nodes[2*i +1], root);
            root.setLeftChild(makeTree(t, nodes, 2*i +1, level + 1));   
        }
        if(2*(i+1)< nodes.length){
             TreeNode<String> t = new TreeNode<String>(nodes[2*(i+1)], root);
            root.setRightChild(makeTree(t, nodes, 2*(i+1), level + 1));
        }
        return root;
    }
    
    public static void printTree(TreeNode root) {
        ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
        queue.add(root);
        while(queue.size() > 0) {
            if (queue.get(0).getLeftChild() != null) {
                queue.add(queue.get(0).getLeftChild());
            }
            if (queue.get(0).getRightChild() != null) {
                queue.add(queue.get(0).getRightChild());
            }
            System.out.println(queue.remove(0).getContents());
        }
    }
}

