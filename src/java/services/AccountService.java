/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import models.User;

/**
 *
 * @author khanhhoanguyen
 */
public class AccountService extends User{

    
    
    public User login(String username, String password) {
        
        if ((username.equals("abe") || username.equals("barb"))
                && password.equals("password")) {
            User user = new User(username, null);
            return user;
        }
        else {
            return null;
        }
    }
    
    
    
}
