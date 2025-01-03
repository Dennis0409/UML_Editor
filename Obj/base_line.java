package Obj;
import java.awt.Point;
import java.awt.Graphics;

abstract public class base_line extends object{
    protected port from_p,to_p;
    protected int arrow_height=20;
    protected int arrow_width=20;
    public base_line(port from,port to){
        from_p=from;
        to_p=to;
        isLine=true;
    }
    public void draw(Graphics g){
        paintline(g);
        paintTraiangle(g);
    }
    public Point get_line_end(){
        double x1=from_p.x,y1=from_p.y,x2=to_p.x,y2=to_p.y;
        double dx=x2-x1,dy=y2-y1;
        double v=Math.sqrt(Math.pow(arrow_height,2)/(Math.pow(dx,2)+Math.pow(dy,2)));
        Point ret=new Point();
        ret.x=(int)(x2-v*dx);
        ret.y=(int)(y2-v*dy);
        return ret;
    }
    public Point[] get_triangle_point(Point line_end,Point end){
        Point[] p=new Point[2];
        p[0]=new Point();
        p[1]=new Point();
        double x1=from_p.x,y1=from_p.y,x2=to_p.x,y2=to_p.y;
        double dx=x2-x1,dy=y2-y1;
        double v=Math.sqrt(Math.pow(arrow_width,2)/(Math.pow(dx,2)+Math.pow(dy,2)));
        p[0].x=(int)(line_end.x+v*dy);
        p[0].y=(int)(line_end.y-v*dx);
        p[1].x=(int)(line_end.x-v*dy);
        p[1].y=(int)(line_end.y+v*dx);
        return p;
    }
    public void paintline(Graphics g){
        Point p=get_line_end();
        g.drawLine(from_p.x, from_p.y, p.x, p.y);
    }
    public Point[] getpoints(){
        Point[] p=new Point[2];
        p[0]=new Point(from_p.x,from_p.y);
        p[1]=new Point(to_p.x,to_p.y);
        return p;
    }
    public port[] get_from_to(){
        port[] ret=new port[2];
        ret[0]=from_p;
        ret[1]=to_p;
        return ret;
    }
    abstract public void paintTraiangle(Graphics g);
    
}
