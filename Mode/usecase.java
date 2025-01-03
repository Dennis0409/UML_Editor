package Mode;
import java.awt.event.MouseEvent;

import Obj.usecase_obj;
import frame.Canva;

public class usecase extends Mode{
    public void mousePressed(MouseEvent e){
        //System.out.println("click usecase");
        canva.addObj(new usecase_obj(e.getPoint().x,e.getPoint().y));
        canva.repaint();
    }
}
