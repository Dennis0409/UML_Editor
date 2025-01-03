package Mode;
//package project1;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.*;
import frame.Canva;
public abstract class Mode implements MouseListener,MouseMotionListener{
    protected Canva canva=Canva.get_canva();

    public void mouseDragged(MouseEvent e){}
    
    public void mouseMoved(MouseEvent e){}
    
    public void mouseClicked(MouseEvent e){}
    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}
    
    public void mousePressed(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}
    
}
