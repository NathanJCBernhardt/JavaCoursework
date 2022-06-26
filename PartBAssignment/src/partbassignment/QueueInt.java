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
public class QueueInt extends AbsQueueInt{
    
    public QueueInt(int capacity){
        super(capacity);
    }
    
    @Override
    public void addToBack(int n){
        assert getSize() != getCapacity();
        queue[getSize()] = n; size++;
        
    }
    
    @Override
    public int removefromFront(){
        int result = queue[0]; 
        for (int i = 1; i< getSize(); i++){
            queue[i-1] = queue[i];
        }
        size--;
        return result;
    }
    
}
