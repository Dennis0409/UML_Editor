package Obj;
import java.awt.*;
public class association_obj extends base_line{
    public association_obj(port from,port to){
        super(from,to);
    }
    public void paintTraiangle(Graphics g){
        Point line_end=get_line_end();
        Point end=new Point();
        end.x=to_p.x;
        end.y=to_p.y;
        Point[] p=get_triangle_point(line_end,end);
        g.drawLine(p[0].x,p[0].y,to_p.x,to_p.y);
        g.drawLine(p[1].x,p[1].y,to_p.x,to_p.y);
        g.drawLine(line_end.x,line_end.y,to_p.x,to_p.y);
        
    }
}
