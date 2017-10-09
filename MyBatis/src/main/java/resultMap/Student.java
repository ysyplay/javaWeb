package resultMap;

import java.util.List;

/**
 * Created by runa on 2017/8/16.
 */
public class Student
{
    private int id;
    private String userName;
    private String corp;
    private List<Course> courses;
    public Student()
    {
        super();
    }
    public Student(Integer id, String userName, String corp)
    {
        this.userName = userName;
        this.id = id;
        this.corp = corp;
    }
    public List<Course> getCourses()
    {
        return courses;
    }
    public void setCourses(List<Course> courses)
    {
        this.courses = courses;
    }
    public int getId()
    {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getCorp() {
        return corp;
    }
    public void setCorp(String corp) {
        this.corp = corp;
    }
}
