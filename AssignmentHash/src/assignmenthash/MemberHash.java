/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmenthash;
import java.util.*;

/**
 *
 * @author Nathan
 */
public class MemberHash implements IMemberDB{
   
            
    
    Member[][] table = new Member[30][15];
    int tableI = table.length;
    int tablej = table[0].length;
    
    
    public MemberHash(){
        System.out.println("Hash Table");
        clearDB();
        
    }
    
    @Override
     public void clearDB(){
         try{
         for (int i=0; i<tableI; i++){
             for (int j = 0; j<tablej; j++){
             table[i][j] = new Member("", "");
         }
         }
         }catch (NullPointerException npe){
                 
                 }
                 
                 }
     

     
    @Override
      public boolean containsName( String name){
          
          boolean flag = false; 
          try{
          for (int j = 0; j < tablej; j++){
     
          if (table[hash(name, tableI)][j].getName().toUpperCase().contains(name.toUpperCase())){
              flag = true;
              
              break;
          
              
          }else {
              flag = false;
          }
          }
          }catch (NullPointerException npe){
             
          }
          
          
          return flag;
          
    
      }
      
      @Override
      public Member get(String name){
          Member temp = null;
          double LF = size() / tableI;
          for (int j = 0; j < tablej; j++){
              if (table[hash(name, tableI)][j].getName().toUpperCase().contains(name.toUpperCase())){
                  temp = table[hash(name, tableI)][j];
                  Logger(LF, name, hash(name, tableI),j, false);
                  break;
              }
          }
          return temp;
          
      }
      
    @Override
      public int size(){
          int count = 0;
          try{
          for (int i = 0; i < tableI; i++){
               for (int j = 0; j<tablej; j++){
              if (table[i][j].getName() != ""){
                  count += 1;
              }
               }
              
          }
          }catch (NullPointerException npe){
              
              
          }
           return count;
      }

      
      @Override
      public boolean isEmpty(){
         boolean flag = true;
          for (int i=0; i<tableI; i++){
              for (int j = 0; j<tablej; j++){
             if (table[i][j].getName() != "" || table[i][j].getName() != null ){
                 flag = false;   
                 break;
          }else{
                 flag = true;
             }
              }
         }
      return flag;
      }
    @Override
       public Member put(Member member){
           Member temp = null;
           double LF = size() / tableI;
    
           
           for (int j = 0; j < tablej; j++){
               if (table[hash(member.getName(), tableI)][j].getName().toUpperCase().contains(member.getName().toUpperCase())){
                temp = table[hash(member.getName(), tableI)][j]; 
                table[hash(member.getName(), tableI)][j] = member;
 
                Logger(LF, member.getName(),hash(member.getName(), tableI),j, true);
                break;
           }else if (table[hash(member.getName(), tableI)][j].getName() == ""){
               table[hash(member.getName(), tableI)][j] = member;
               Logger(LF, member.getName(),hash(member.getName(), tableI),j, false);
               break;
           }
           }    
           LF = size() / tableI;
           
          
                
           return temp;
       }

    @Override
          public Member remove(String name){
              Member temp = null;
           double LF = size() / tableI;
             
           for (int j = 0; j < tablej; j++){
               if (table[hash(name,tableI)][j].getName() != "" ){
                   temp = table[hash(name,tableI)][j];
                   table[hash(name,tableI)][j] = new Member("", "");
                   Logger(LF, name, hash(name, tableI),j, true);
                   break;
                   
               }else {
                   table[hash(name,tableI)][j] = new Member("", "");
                   Logger(LF, name, hash(name, tableI),j, true);
                   break;
               }
           }
          LF = size() / tableI;
           
           System.out.println("The current load factor is: "  + LF);
            
              return temp;
          }
                        

    @Override
         public void displayDB(){
  
             ArrayList<String> Names = new ArrayList<String>(); 
             
              for (int i=0; i < tableI; i++){
                  for (int j = 0; j < tablej; j++){
                      if (table[i][j].getName() != ""){
                          Names.add(table[i][j].getName());
                      }
                  }
              }
 
              Collections.sort(Names);
              System.out.println(Names);
                      
                 }

       
    public static int hash(String key, int HTS) //I utilised a simple hash value process, so clustering will occur, but I've rectified this issue through chaining, by utilising a 2D array
  { 
     int hash_value = 0;
    for(int j=0; j<key.length(); j++)
       hash_value=hash_value+(int)key.charAt(j);
    hash_value = (hash_value % HTS);
    return hash_value;
 
   
  }
    
    public void Logger(double LF, String name, int X, int Y, boolean overwritten){
        int HashmapSize = tableI * tablej;
        
        
        System.out.println("HashMap Size: " + HashmapSize);
        System.out.println("Load Factor: " + LF);
        if (overwritten == true){
              System.out.println("Member Removed/Overwritten! " + "Member Name: " + name + ", " + "Hash Value: " + hash(name,tableI) + ", " + "Allocated to Index: " + X +","+ Y);    
        }else {
             System.out.println("Member Name: " + name + ", " + "Hash Value: " + hash(name,tableI) + ", " + "Allocated to Index: " + X +","+ Y);  
        }
               
        
    }
}
