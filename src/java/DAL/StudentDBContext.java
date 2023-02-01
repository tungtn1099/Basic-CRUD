package DAL;

import Model.Department;
import Model.Student;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tungtn
 */
public class StudentDBContext extends DBContext<Student>
{
    public ArrayList searchByDept(int deptId){
        ArrayList<Student> students = new ArrayList<>();
        try {
            String sql = "select s.stuId, s.stuName, s.gender, s.dob, s.deptID, d.deptName\n" +
                    "from Students s INNER JOIN Departments d\n" +
                    "on s.deptId = d.deptId";
            if(deptId > 0){
                 sql += " where s.deptID = ?";
            }
            PreparedStatement stm = connection.prepareStatement(sql);
            if(deptId > 0){
                stm.setInt(1, deptId);
            }
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                Department d = new Department();
                d.setDeptId(rs.getInt("deptid"));
                d.setDeptName(rs.getString("deptname"));
                
                Student s = new Student();
                s.setStuId(rs.getInt("stuid"));
                s.setStuName(rs.getString("stuname"));
                s.setGender(rs.getBoolean("gender"));
                s.setDob(rs.getDate("dob"));
                s.setDept(d);
                
                students.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return students;
    }

    @Override
    public void insert(Student model) {
        try {
            String sql = "insert into Students\n" +
                    "values (?, ?, ?, ?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, model.getStuName());
            stm.setBoolean(2, model.isGender());
            stm.setDate(3, model.getDob());
            stm.setInt(4, model.getDept().getDeptId());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Student model) {
        try{
            String sql = "update Students\n" +
                "set stuName = ?, gender = ?, dob = ?, deptId = ?\n" +
                "where stuId = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, model.getStuName());
            stm.setBoolean(2, model.isGender());
            stm.setDate(3, model.getDob());
            stm.setInt(4, model.getDept().getDeptId());
            stm.setInt(5, model.getStuId());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(int stuId) {
        try {
        String sql = "delete from students\n" +
            "where stuid = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, stuId);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Student getStudentByID(int stuId){
        try {
            String sql = "select s.stuId, s.stuName, s.gender, s.dob, s.deptId, d.deptName from Students s\n" +
                    "inner join Departments d\n" +
                    "on s.deptId = d.deptId\n" +
                    "where s.stuId = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, stuId);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                Department d = new Department();
                d.setDeptId(rs.getInt("deptid"));
                d.setDeptName(rs.getString("deptname"));
                
                Student s = new Student();
                s.setStuId(rs.getInt("stuid"));
                s.setStuName(rs.getString("stuname"));
                s.setGender(rs.getBoolean("gender"));
                s.setDob(rs.getDate("dob"));
                s.setDept(d);
                
                return s;
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ArrayList<Student> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
