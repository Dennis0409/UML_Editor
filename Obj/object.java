package Obj;
import java.awt.*;

abstract public class object {
    protected int x,y;
    protected boolean isGroup=false;
    protected boolean isLine=false;
    abstract public void draw(Graphics g);
    public boolean isInside(Point p){
        return false;
    }
    public void showport(Graphics g){}
    public void relocate(int x1,int y1){}
    public Point[] getpoints(){return null;}
    public port getcloseport(Point p){
        return null;
    }
    public boolean get_isGroup(){
        return isGroup;
    }
    public boolean get_isLine(){
        return isLine;
    }
}
