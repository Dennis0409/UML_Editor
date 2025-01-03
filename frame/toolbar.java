package frame;

import javax.swing.*;
import Mode.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
//import java.awt.event.ActionEvent;
// import Mode;import java.awt.event.ActionListener;
// import Canva;
public class toolbar extends JToolBar{
    private JButton select_button;
    private JButton association_button;
    private JButton generalization_button;
    private JButton composition_button;
    private JButton class_button; 
    private JButton usecase_button;
    
    toolbar(){
        select_button=new Modebutton(new select_mode(),new ImageIcon("img/select.png"));
        add(select_button);
        usecase_button=new Modebutton(new usecase(),new ImageIcon("img/usecase.png"));
        add(usecase_button);
        class_button=new Modebutton(new class_mode(),new ImageIcon("img/class.png"));
        add(class_button);
        association_button=new Modebutton(new association_mode(),new ImageIcon("img/association.png"));
        add(association_button);
        generalization_button=new Modebutton(new generalization_mode(),new ImageIcon("img/generalization.png"));
        add(generalization_button);
        composition_button=new Modebutton(new compittion_mode(),new ImageIcon("img/composition.png"));
        add(composition_button);    
        setLayout(new GridLayout(0,1));
        setFloatable(false);
    }
    public void reset_button_color(){
        Component[] components=this.getComponents();
        for(Component component:components){
            component.setBackground(Color.white);
        }
    }
    private class Modebutton extends JButton{
        private Mode button_mode;
        private Canva canva=Canva.get_canva();
        Modebutton(){
            setPreferredSize(new Dimension(150,100));
            setBackground(Color.white);
            setOpaque(true);
            setBorderPainted(false);
        }
        Modebutton(Mode mode,ImageIcon icon){
            setPreferredSize(new Dimension(150,100));
            setBackground(Color.white);
            setOpaque(true);
            setBorderPainted(false);
            button_mode=mode;
            setIcon(icon);
            this.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    //System.out.println("click");
                    canva.set_mode(mode);
                    reset_button_color();
                    setBackground(Color.gray);
                    
                }
            });
        }
    }
}

