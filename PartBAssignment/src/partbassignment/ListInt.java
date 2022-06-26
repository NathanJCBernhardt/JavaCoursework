/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package partbassignment;

/**
 *
 * @author Nathan
 */
public class ListInt extends AbsListInt {
    
    public ListInt(int capacity){
        super (capacity);
    }
    
    
    @Override
    public void append(int n){
         assert size != capacity; list[size] = n; size++;
    }
    
    @Override
    public boolean contains(int x){
         int i = 0;
        while (i!= getSize() && list[i] != x){
            i++;
        }
        return i != getSize();
    }
}
