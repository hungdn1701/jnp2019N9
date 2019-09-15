/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson3_mvc;

/**
 *
 * @author mam
 */
public class LoginController {
    LoginModel user;

    
    public LoginController() {
        // display login view
        new LoginView();
    }

    public LoginController(String _strUser, String _strPass){
        if(_strUser.equals("admin")&& _strPass.equals("abc123"))
        {
            this.user = new LoginModel(_strUser, _strPass);
            // display detail view // 
            new LoginView(user);
        }
        else
            // display login view
            new LoginView();
    }
    
    public LoginController(LoginModel user) {
        this.user = user;
        // diplay details view
        new LoginView(user);
    }
    
}
