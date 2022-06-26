/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package partbassignment;
import java.util.*;
/**
 *
 * @author Nathan
 */
public class Main {
    public static void main(String args[]){
        AdjMatrix test = new AdjMatrix();
        ArrayList<StationInfo> L = new ArrayList<>();
        
        test.ReadFromFile("ytes.txt");
        
    
        
        L = test.dft(3);
        
        
        for (int i = 0; i < 8; i++){
            System.out.println(L.get(i).getName());
        }
            
    }
        
       
        
    }
    
    

