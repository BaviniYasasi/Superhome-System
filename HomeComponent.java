import javax.swing.*;
import java.awt.*;

public class HomeComponent extends JFrame {
    private SuperHomeObserverable observerable;
    public HomeComponent(SuperHomeObserverable observerable){
        this.observerable=observerable;

        setTitle("Controller");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setSize(400,375);
        setLayout(null);
        setLocationRelativeTo(null);
        setLocation(90,180);

        DefaultListModel listModel=new DefaultListModel<>();
        listModel.addElement("TV | Living room");
        listModel.addElement("Speaker | Living room");
        listModel.addElement("Light | Living room");
        listModel.addElement("Window | Living room");

        JList list=new JList<>();
        list.setFont(new Font("",1,20));
        list.setBounds(20,70,350,150);
        list.setModel(listModel);

        list.getSelectionModel().addListSelectionListener(e->{
            if (!e.getValueIsAdjusting()&& ! list.isSelectionEmpty()) {
                int listIndex = list.getSelectedIndex();
                observerable.setIndex(listIndex);
                new TimeComponent(observerable).setVisible(true);
            }

        });

        add(list);

        setVisible(true);


    }
}
