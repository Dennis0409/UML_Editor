package Obj;
import java.awt.Graphics;
import java.awt.Point;
public class compition_obj extends base_line{
    public compition_obj(port from,port to){
        super(from,to);
    }
    public void paintTraiangle(Graphics g){
        Point start=get_line_end();
        Point end=new Point();
        end.x=to_p.x;
        end.y=to_p.y;
        Point[] p=get_triangle_point(start,end);
        g.drawLine(p[0].x,p[0].y,to_p.x,to_p.y);
        g.drawLine(p[1].x,p[1].y,to_p.x,to_p.y);
        int x1=to_p.x-start.x;
        int y1=to_p.y-start.y;
        g.drawLine(p[0].x,p[0].y,start.x-x1,start.y-y1);
        g.drawLine(p[1].x,p[1].y,start.x-x1,start.y-y1);
    }
    public void paintline(Graphics g){
        Point start=get_line_end();
        int x1=to_p.x-start.x;
        int y1=to_p.y-start.y;
        g.drawLine(from_p.x,from_p.y,start.x-x1,start.y-y1);
    }
}
