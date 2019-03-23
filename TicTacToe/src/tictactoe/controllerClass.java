/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.util.ArrayList;

/**
 *
 * @author Dell
 */
public class controllerClass {
    modelClass obj;
    
    String username;
    String wins;
    
     controllerClass(){
        obj=new modelClass();
    }
    
    
    controllerClass(String username, String score){
        this();
        this.username=username;
        this.wins=score;
    }
    
     ArrayList<controllerClass> LoadAllUsers() {
        return obj.LoadAllUsers();
    }
    
    
    void addUser(String username){
        if (obj.userExistsOrNot(username).equals(""))
        {
            obj.addNewUser(username,"0");
        }
    }
    
    int getScore(String username){
       String score= obj.getCurrentScore(username);
       System.out.println(score);
       int result = Integer.parseInt(score);
       return result;
    }
    
    void updateScore(String username, String score){
        obj.setScore(username, score);
    }
    
   
}
