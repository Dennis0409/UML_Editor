package Mode;
import Obj.*;
import java.awt.event.*;
import java.util.ArrayList;
public class generalization_mode extends line_mode{
    //private port from_p,to_p;
    private port temp_port;
    private base_line temp_line;
    public void mousePressed(MouseEvent e){
        getfrom(e);
        if(canva.select_obj.size()!=0){
            temp_port=new port(e.getX(),e.getY());
            temp_line=new generalization_obj(from_p,temp_port);
            canva.addObj(temp_line);
            canva.repaint();
        }
    }
    public void mouseDragged(MouseEvent e){
        if(canva.select_obj.size()!=0){
            temp_port.setport(e.getPoint().x,e.getPoint().y);
            canva.repaint();
        }
    }
    public void mouseReleased(MouseEvent e){
        if(canva.select_obj.size()!=0){
            canva.get_obj_list().remove(temp_line);
            ArrayList<object> ret=canva.getobject(e.getPoint());
            if(ret.size()!=0&&canva.select_obj.get(0)!=ret.get(0)){
                to_p=ret.get(0).getcloseport(e.getPoint());
                canva.addObj(new generalization_obj(from_p, to_p));
            }
            canva.repaint();
        }
    }
}
