package frame;
import java.awt.*;
import javax.swing.*;
import Mode.Mode;

public class UML extends JFrame{
    private Canva canva;
    private JToolBar toolbar;
    private JMenuBar menubar;
    public UML(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("UML Editor");
        setSize(1200,1000);
        getContentPane().setLayout(new BorderLayout());

        canva=Canva.get_canva();
        toolbar=new toolbar();
        getContentPane().add(toolbar,BorderLayout.WEST);
        getContentPane().add(canva,BorderLayout.CENTER);
        menubar=new menu();
        getContentPane().add(menubar,BorderLayout.NORTH);
    }

    public static void main(String[] args) {
        UML uml=new UML();
        uml.setVisible(true);
    }
}