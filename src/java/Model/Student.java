package Model;

import java.sql.Date;


/**
 *
 * @author tungtn
 */
public class Student extends BaseModel{
    private int stuId;
    private String stuName;
    private boolean gender;
    private Date dob;
    private Department dept;

    public Student() {
    }

    public Student(int stuId, String stuName, boolean gender, Date dob, Department dept) {
        this.stuId = stuId;
        this.stuName = stuName;
        this.gender = gender;
        this.dob = dob;
        this.dept = dept;
    }

    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public Department getDept() {
        return dept;
    }

    public void setDept(Department dept) {
        this.dept = dept;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "Student{" + "stuId=" + stuId + ", stuName=" + stuName + ", gender=" + gender + ", dob=" + dob + ", dept=" + dept + '}';
    }
    
    
}
