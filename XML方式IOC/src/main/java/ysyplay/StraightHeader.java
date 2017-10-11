package ysyplay;

import jdk.nashorn.internal.objects.annotations.Property;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by ysyplay on 2017/9/6.
 */

public class StraightHeader implements Header
{

    private String color;

    private int size;

    private String weight;


    public StraightHeader(String color,int size)
    {
        this.color = color;
        this.size = size;
    }
    public StraightHeader(Map<String,String> paras)
    {
        this.color = paras.get("color");
        this.size = Integer.valueOf(paras.get("size"));
    }
    public void setWeight(String weight)
    {
        this.weight = weight;
    }
    public void doWork()
    {
        System.out.println("使用一字刀");
    }
    public String getInfo()
    {
        return "StraightHeader  "+color+"  "+size+"     "+weight;
    }
}
