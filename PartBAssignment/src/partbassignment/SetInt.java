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
public class SetInt extends AbsSetInt {
    
    public SetInt(int capacity){
        super(capacity);
    }
    
    @Override
    public boolean contains(int x){
        int i = 0;
        while (i!= getSize() && set[i] != x){
            i++;
        }
        return i != getSize();
    }
    
    @Override
    public void include(int n){
        assert contains(n) || getSize() != getCapacity() : "full" + getSize();
        
        if (!contains(n)) {
            set[size++] = n;
        }

    }
    
    @Override
    public void exclude(int n){
        int i = 0;
        while (i != getSize() && set[i] != n) {
            i++;
        }
        if (i != getSize()) { 
            set[i] = set[size - 1];
            size--;
        }

    }
   

}

