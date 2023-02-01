/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author tungtn
 */
public class Account extends BaseModel{
    private String id, password;
    private boolean admin;

    public Account(String id, String password, boolean admin) {
        this.id = id;
        this.password = password;
        this.admin = admin;
    }

    public Account() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    @Override
    public String toString() {
        return "Account{" + "id=" + id + ", password=" + password + ", admin=" + admin + '}';
    }
    
}
