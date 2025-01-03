package Obj;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Point;
abstract public class base_obj extends object{
    protected String objname;
    protected int width,height;
    protected port[] ports=new port[4];

    public base_obj(){}
    public void draw(Graphics g){

    }
    public void paintString(Graphics g,Rectangle rect){
        FontMetrics fm=g.getFontMetrics();
        
        int x=rect.x+(rect.width-fm.stringWidth(objname))/2;
        int y=rect.y+(rect.height)/2;
        g.drawString(objname,x,y);
    }
    public void initport(){
        int portsize=new port().getsize();
        ports[0]=new port(x,y-height/2-portsize/2); //top
        ports[1]=new port(x-width/2-portsize/2,y-portsize/2); //left
        ports[2]=new port(x+width/2+portsize/2,y-portsize/2); //right
        ports[3]=new port(x,y+height/2+portsize/2); //bottom
    }
    public boolean isInside(Point p){
        Rectangle r=new Rectangle(x-width/2, y-height/2, width, height);
        return r.contains(p);
    }
    public void showport(Graphics g){
        for(int i=0;i<4;i++){
            ports[i].draw(g);
        }
    }
    public void relocate(int x1,int y1){
        
        for(int i=0;i<4;i++){
            ports[i].relocate(x1,y1);
        }
        x+=x1;
        y+=y1;
    }
    public port getcloseport(Point p){
        port close=ports[0];
        double dis=get_dis(close.x,close.y,p.x,p.y);
        for(int i=1;i<4;i++){
            if(get_dis(ports[i].x,ports[i].y,p.x,p.y)<dis){
                close=ports[i];
                dis=get_dis(close.x,close.y,p.x,p.y);
            }
        }
        return close;
    }
    public double get_dis(int x1,int y1,int x2,int y2){
        return Math.sqrt(Math.pow(x1-x2,2)+Math.pow(y1-y2,2));
    }
    public Point[] getpoints(){
        Point[] p=new Point[2];
        p[0]=new Point(x-width/2,y-height/2);
        p[1]=new Point(x+width/2,y+height/2);
        return p;
    }
    public void changename(String name){
        objname=name;
    }
    public port[] getports(){
        return ports;
    }
}
