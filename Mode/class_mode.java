package Mode;
import java.awt.event.MouseEvent;

import Obj.class_obj;
import frame.Canva;

public class class_mode extends Mode{
    public void mousePressed(MouseEvent e){
        //System.out.println("click class");
        canva.addObj(new class_obj(e.getPoint().x,e.getPoint().y));
        canva.repaint();
    }
}