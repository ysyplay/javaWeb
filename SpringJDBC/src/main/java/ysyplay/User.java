package ysyplay;

/**
 * Created by ysyplay on 2017/10/11.
 */
public class User
{
    private int id;
    private String name;


    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public String toString()
    {
        return "id"+id+"   "+"name"+name+"\n";
    }



}
