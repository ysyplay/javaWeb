package ysyplay;


import javax.annotation.Resource;

/**
 * Created by ysyplay on 2017/9/5.
 */
public class ScrewDriver
{

    private Header straightHeader;
//    public ScrewDriver(Header header)
//    {
//        this.straightHeader = header;
//    }
    public void setHeader(Header StraightHeader)
    {
        this.straightHeader = StraightHeader;
    }

    public void use()
    {
        System.out.println("use screwDriver  "+straightHeader.getInfo());
    }
    public void init()
    {
        System.out.println("这是初始化方法");
    }
    public void whenDestroy()
    {
        System.out.println("这是销毁方法");
    }
}
