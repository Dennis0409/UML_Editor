package frame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import frame.*;;
public class menu extends JMenuBar{
    private Canva canva=Canva.get_canva();
    private JMenu file=new JMenu("File");
    private JMenu edit=new JMenu("Edit");
    private JMenuItem group=new JMenuItem("group");
    private JMenuItem ungroup=new JMenuItem("ungroup");
    private JMenuItem changeName=new JMenuItem("changeName");
    private JMenuItem removeObj=new JMenuItem("removeObj");
    private JMenuItem clearObj=new JMenuItem("clearObj");
    public menu(){
        group.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                // Group selected objects together
                canva.group_obj();
            }
        });

        ungroup.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Group selected objects together
                canva.ungroup_obj();
            }
        });

        changeName.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Group selected objects together
                canva.change_name();
            }
        });
        removeObj.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Group selected objects together
                canva.remove_obj();
            }
        });
        clearObj.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Group selected objects together
                canva.clear_obj();
            }
        });
        
        edit.add(group);
        edit.add(ungroup);
        edit.add(changeName);
        edit.add(removeObj);
        edit.add(clearObj);
        add(file);
        add(edit);
    }
}
