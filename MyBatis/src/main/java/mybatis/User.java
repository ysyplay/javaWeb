package mybatis;

/**
 * Created by ysyplay on 2017/8/15.
 */

public class User {


    private int id;
    private String userName;
    private String corp;
   //注意这里的无参数构造方法，一定要写
    public User() {
        super();
    }
    public User(Integer id, String userName, String corp) {
        this.id = id;
        this.userName = userName;
        this.corp = corp;

    }
    public User(String userName, String corp) {
        this.userName = userName;
        this.corp = corp;
    }
    public int getId() {
        return id;
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