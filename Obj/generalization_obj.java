package Obj;
import java.awt.*;
public class generalization_obj extends base_line{
    public generalization_obj(port from,port to){
        super(from,to);
    }
    public void paintTraiangle(Graphics g){
        Point start=get_line_end();
        Point end=new Point();
        end.x=to_p.x;
        end.y=to_p.y;
        Point[] p=get_triangle_point(start,end);
        g.drawLine(p[0].x,p[0].y,p[1].x,p[1].y);
        g.drawLine(p[0].x,p[0].y,to_p.x,to_p.y);
        g.drawLine(p[1].x,p[1].y,to_p.x,to_p.y);
    }
}