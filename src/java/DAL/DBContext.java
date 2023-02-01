/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import Model.BaseModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tungtn
 * @param <T>
 */
public abstract class DBContext<T extends BaseModel> {
    protected Connection connection;
    public DBContext()
    {
        try {
            String user = "tungtn1";
            String pass = "12345";
            String url = "jdbc:sqlserver://DESKTOP-Q1QG6EI\\SQLEXPRESS:1433;databaseName=BasicCRUD";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public abstract ArrayList<T> list();
    public abstract void insert(T model);
    public abstract void update(T model);
}
