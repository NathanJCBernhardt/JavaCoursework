/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmenttree;
/**
 *
 * @author Nathan
 */
import java.util.ArrayList; 

public class MemberBST implements IMemberDB {
int i = 0;
ArrayList<Integer> NodeValues = new ArrayList<Integer>();


    public class Node {
    private Member data;
    private Node left, right;
    public Node(Member s) {data = s; left = null; right = null;}     
}
    
    
  private Node insert (Node tree, Member m) {     
    if (tree == null){
        tree = new Node(m);
        
    }else {
       int compare = m.getName().compareTo(tree.data.getName());
       NodeValues.add(compare);

       if (compare< 0){ // name < tree.data.name
          tree.left = insert(tree.left, m);
        }
      else if (compare > 0) {
      tree.right = insert(tree.right, m);

      }// name < tree.data.name; insert at right
      else { tree.data = m;          
  }
  }
  return tree;
    }

private int sizeof(Node n){    
    if(n != null){
            i =  i +1;
            if(n.left != null){        
                sizeof(n.left);
            } if (n.right != null){        
                sizeof(n.right);
            }
        }
    return i;
}
    
private Node Display(Node n){
    if(n != null){
            System.out.println(n.data.getName() + ": " + n.data.getAffiliation());
            if(n.left != null){
                Display(n.left);
            }if (n.right != null){
                Display(n.right);
            }

        }
    return n;
}
    
    
    
    private boolean contains(Node tree, String N) {
        if (tree == null) {
            return false;
        }else{
             int val = N.compareTo(tree.data.getName());
        if (val > 0) {
            return contains(tree.right, N);
        } else if (val < 0) {
            return contains(tree.left, N);
        } else { 
            return true;
            
                    
        }
     }
    }
    
    private Member SearchTree(Node n, String name){
         if (n == null) {
            return null;
        }else{
             int val = name.compareTo(n.data.getName());
             NodeValues.add(val);
        if (val > 0) {
            return SearchTree(n.right, name);
        } else if (val < 0) {
            return SearchTree(n.left, name);
        } else { 
            
            return n.data;
    }
         }
         
    }
            
    private void clearTree(Node n){
        if (n != null) {
        clearTree( n.left);
        clearTree( n.right);
        n = null;
        }

    }
    
    private static Node minimumElement(Node root) {
		if (root.left == null)
			return root;
		else {
			return minimumElement(root.left);
		}
	}
  
    
    private Node DeleteNode(Node n, String name){
        if (n == null){
			return null;}else{
            int value = name.compareTo(n.data.getName());
            NodeValues.add(value);
        
		if (value < 0) {
			n.left = DeleteNode(n.left, name);
		} else if (value > 0) {
			n.right = DeleteNode(n.right, name);
 
		} else {
			// if nodeToBeDeleted have both children
			if (n.left != null && n.right != null) {
				Node temp = n;
				// Finding minimum element from right
				Node minNodeForRight = minimumElement(temp.right);
				// Replacing current node with minimum node from right subtree
				n.data = minNodeForRight.data;
				// Deleting minimum node from right now
				n.right = DeleteNode(n.right, minNodeForRight.data.getName());
 
			}
			// if nodeToBeDeleted has only left child
			else if (n.left != null) {
				n = n.left;
			}
			// if nodeToBeDeleted has only right child
			else if (n.right != null) {
				n = n.right;
			}
			// if nodeToBeDeleted do not have child (Leaf node)
			else
				n = null;
		}
        }    
        return n;
    }

    

    private Node root;

   
  
    public MemberBST(){
        System.out.println("Binary Search Tree");
    }
    
    
    @Override
    public void clearDB(){
        clearTree(root);
    }
    
    @Override
    public boolean containsName(String name){
        return contains(root, name);
    }
    
    @Override
    public Member get(String name){
        Member k = SearchTree(root, name);
        
        Logger(k.getName(), 2);
        return k;
        
    }


    @Override
    public int size(){
        int k = sizeof(root);
        i = 0;
      return k;
    }
    
    @Override
    public boolean isEmpty(){
       if(root  == null){
            return true;
       }else{
           return false;
       }
       
    }
    
    @Override
    public Member put(Member m) {
            
    if(containsName(m.getName())){
        root = insert(root, m);
        Logger(m.getName(), 1);
    }else{
        root = insert(root, m);
        Logger(m.getName(), 1);
        m = null;
    }

    return m;
}


    @Override
    public Member remove(String name){        
        Member k = get(name);
        
        
        
        DeleteNode(root, name);
        Logger(name, 3);
       
        return k;
    } 

    
    
    
    
    
    @Override
    public void displayDB(){
        Display(root);
    }
    
    public void Logger(String name, int added){
        
    switch (added) {
        case 1: //addition to binary tree
            System.out.println();
            System.out.println("Name of Member: " + name);
            System.out.println("Nodes visited: " + NodeValues);
            System.out.println("Member Added to Binary Tree!");
            System.out.println();
            break;
        case 2: //getting from binary tree
            System.out.println();
            System.out.println("Name of Member: " + name);
            System.out.println("Nodes visited: " + NodeValues);
            System.out.println("Member has been obtained from Binary Tree! ");
            System.out.println();
            break;
        default: //Removing from binary tree
            System.out.println();
            System.out.println("Name of Member: " + name);
            System.out.println("Nodes visited: " + NodeValues);
            System.out.println("Member has been removed from Binary Tree! ");
            System.out.println();
            break;
    }
        
        NodeValues.clear();
    }
        

    
    }

        
    
    
 

