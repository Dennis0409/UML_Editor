package Mode;
import java.awt.event.*;
import java.util.ArrayList;
import Obj.*;
import java.awt.Point;
public class compittion_mode extends line_mode{
    private base_line temp_line;
    private port temp_port;
    public void mousePressed(MouseEvent e){
        getfrom(e);
        if(canva.select_obj.size()!=0){
            temp_port=new port(e.getX(),e.getY());
            temp_line=new compition_obj(from_p,temp_port);
            canva.addObj(temp_line);
        }
    }
    public void mouseDragged(MouseEvent e){
        if(canva.select_obj.size()!=0){
            temp_port.setport(e.getX(), e.getY());
            canva.repaint();
        }
    }
    public void mouseReleased(MouseEvent e){
        if(canva.select_obj.size()!=0){
            canva.get_obj_list().remove(temp_line);
            Point p=new Point(e.getX(),e.getY());
            ArrayList<object> ret=canva.getobject(p);
            if(ret.size()!=0&&canva.select_obj.get(0)!=ret.get(0)){
                port t=ret.get(0).getcloseport(p);
                canva.addObj(new compition_obj(from_p,t));
            }
            canva.repaint();
        }
    }
}
