package resultMap;

/**
 * Created by runa on 2017/8/16.
 */
public class Course
{
    private int id;
    private String courseName;
    private Teacher teacher;
    public Teacher getTeacher() {
        return teacher;
    }
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getCourseName() {
        return courseName;
    }
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

}
