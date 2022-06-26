/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmenthash;

/**
 *
 * @author Nathan
 */
public class Member implements IMember{
    String name, affiliation;
    
    public Member(String namee, String affiliationn){
        this.name = namee;
        this.affiliation = affiliationn;
    }
    
    
      @Override

      public String getName(){
          return name;
          
      }
      
      @Override
      public String getAffiliation(){
          return affiliation;
          
      }
      
      @Override
      public String toString(){
          return "";
      }
    
}
