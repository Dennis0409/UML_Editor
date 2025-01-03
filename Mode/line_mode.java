package Mode;
import frame.Canva;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

import Obj.*;
public class line_mode extends Mode{
    protected port from_p,to_p;
    public void getfrom(MouseEvent e){
        ArrayList<object> ret=canva.getobject(e.getPoint());
        if(ret.size()!=0){
            from_p=ret.get(0).getcloseport(e.getPoint());
            if(canva.select_obj.size()!=0) canva.select_obj.clear();
            canva.set_select(ret.get(0));
        }else{
            canva.select_obj.clear();
        }
    }
}
