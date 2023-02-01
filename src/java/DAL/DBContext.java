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
            String user = "";
            String pass = "";
            String url = "";
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
