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
public class StackInt extends AbsStackInt{
    
    public StackInt(int capacity){
        super (capacity);
    }
     
    
    @Override
    public void push(int n){ assert size != capacity; stack[size] = n; size++;}     
    
    @Override
    public int peek(){assert size != 0; return stack[size-1];}
    
    @Override
    public int pop(){assert size != 0; size--; return stack[size];}
    
}
