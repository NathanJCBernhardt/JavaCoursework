/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package partbassignment;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.Stack;
import java.util.ArrayList;
import java.util.*;
/**
 *
 * @author Nathan
 */
public class AdjMatrix {
    
    final double NO_LINK = Double.MAX_VALUE;
    final int MAX_STATIONS = 8;
    int NumStations = 0;
    StationInfo stations[] = new StationInfo[MAX_STATIONS];
    double distance[][] = new double[MAX_STATIONS][MAX_STATIONS];
    
    public AdjMatrix(){
        initialise();
    }
   
    public final void initialise(){
        for (int i = 0; i != MAX_STATIONS; i++) {
            stations[i] = new StationInfo("", 0, 0);
            for (int j = 0; j != MAX_STATIONS; j++) {
                distance[i][j] = NO_LINK;
            }
        }
    }
    
    public void InsertStation(String name, int x, int y){
         StationInfo temp = new StationInfo(name, x, y);
         stations[NumStations] = temp;
         NumStations++;
    }
    
    public void InsertLinks(String name1, String name2, double dist){
        if(NumStations == MAX_STATIONS){
            for (int i = 0; i< NumStations; i++){
                if(name1.equals(stations[i].getName())){
                    for (int j = 0; j< NumStations; j++){
                        if(name2.equals(stations[j].getName())){
                            distance[i][j] = dist;
                            distance[j][i] = dist;
                            break;
                        }
                    }
                }
            }
        }
    }  
    
    public void ReadFromFile(String filename){
     String[] x = new String[2];   
     int count = 0;   
         try {
      File myObj = new File(filename);
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        
        if(count > 0 && count < 9){
            x = data.split(" ");
            InsertStation(x[0], Integer.parseInt(x[1]), Integer.parseInt(x[2]));
        }
        else if (count > 9 && count < 19){
             x = data.split(" ");
             InsertLinks(x[0], x[1], Double.parseDouble(x[2]));
        }
        count++;
      }
      
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      
    }
  }
    
    public boolean isAdj(StationInfo T, StationInfo T2){
        boolean flag = false;
        int index=0,index2 = 0;
        for (int i=0; i < NumStations; i++){
            if (T.getName() == stations[i].getName()){
                index = i;
                flag = true;
                break;
            }
        }
             for (int i=0; i < NumStations; i++){
                 if (T2.getName() == stations[i].getName()){
                 index2 = i;
                 flag = true;
                 break;
             }
             }
       
        
        if(flag == true){
            flag = distance[index][index2] != NO_LINK;
            
        }
    return flag;
    }
    
    public ArrayList<StationInfo> dft(int x){
        Stack<StationInfo>  S = new Stack<>();
        ArrayList<StationInfo> L = new ArrayList<>();
        
        for(int i = 0; i < NumStations; i++){
            S.add(stations[i]);
        }
        S.remove(stations[x]);
        S.push(stations[x]);
        
        while (!S.isEmpty()){
            StationInfo T = S.pop();
            if(!L.contains(T)){
                L.add(T);  
            }   
            
            for(int i = 0; i < NumStations; i++){
                if(isAdj(T, stations[i])){
                    if(!L.contains(stations[i])){
                        S.push(stations[i]);
                    }
                }
            }
            
            }
        
        
        return L;
    }
    
    public ArrayList<StationInfo> BFS(int x){
        Queue<StationInfo> Q = new LinkedList<> ();
        ArrayList<StationInfo> L = new ArrayList<>();
        
        
        for(int i = 0; i < NumStations; i++){
            Q.add(stations[i]);
        }
        
        Q.remove(stations[x]);
        Q.add(stations[x]);
        
        while(!Q.isEmpty()){
        StationInfo S = Q.remove();
        
        if(!L.contains(S)){
            L.add(S);
            
            for(int i = 0; i < NumStations; i++){
                if(isAdj(S, stations[i])){
                    if(!L.contains(stations[i])){
                        Q.add(stations[i]);
                    }
                }
            }
        }
        }
        
        
        return L;
    }
    
    public void Dijkstra(int x, int y, int distance){
        
    }
  
    }

