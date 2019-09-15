/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson3_mvc;

import java.util.Scanner;

/**
 *
 * @author mam
 */
public class LoginView {
    LoginModel user;

    public LoginView() {
        String _strUser, _strPass;
        System.out.println(" login view  ");
        Scanner in = new Scanner(System.in);
        _strUser = in.nextLine();
        _strPass = in.nextLine();
        new LoginController(_strUser, _strPass);
    }
    // details
    public LoginView(LoginModel user) {
        this.user = user;
        System.out.println(" details view ");
        System.out.println("user: " + this.user.getUser());
        System.out.println("pass: *******");
    }
    
}
