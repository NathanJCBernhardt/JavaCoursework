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
public class StationInfo implements IStationInfo {
    
    private final String name;
    private final int x;
    private final int y;
    
    public StationInfo(String name, int x, int y){
       this.name = name;
       this.x = x;
       this.y = y;
    }
    
    @Override
    public String getName(){return this.name;}
    
    @Override
    public int getxPos(){return this.x;}
    
    @Override
    public int getyPos(){return this.y;} 
}
