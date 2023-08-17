import javax.swing.*;
import java.awt.*;

public class TimeComponent extends JFrame {
    private SuperHomeObserverable observerable;
    TimeComponent(SuperHomeObserverable observerable){
        this.observerable=observerable;

        setTitle("TV Living room");
        setTitle("Speaker Living room");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setSize(400,350);
        setLayout(null);
        setLocationRelativeTo(null);
        setLocation(880,190);

        JLabel hourLabel=new JLabel("Start Hour");
        hourLabel.setBounds(20,230,65,30);
        JLabel minLabel=new JLabel("Start Minute");
        minLabel.setBounds(160,230,70,30);

        JLabel hourEndLabel=new JLabel("End Hour");
        hourEndLabel.setBounds(20,270,65,30);
        JLabel minEndLabel=new JLabel("End Minute");
        minEndLabel.setBounds(160,270,70,30);

        SpinnerNumberModel startHours =new SpinnerNumberModel(0,0,24,1);
        JSpinner startHourSpinner = new JSpinner(startHours);
        startHourSpinner.setBounds(90,230,50,30);
        JComponent startHourSetter =new JSpinner.NumberEditor(startHourSpinner,"00");
        startHourSpinner.setEditor(startHourSetter);

        SpinnerNumberModel startMinute =new SpinnerNumberModel(0,0,60,1);
        JSpinner startMinuteSpinner = new JSpinner(startMinute);
        startMinuteSpinner.setBounds(235,230,50,30);
        JComponent startMinuteSetter =new JSpinner.NumberEditor(startMinuteSpinner,"00");
        startMinuteSpinner.setEditor(startMinuteSetter);

        SpinnerNumberModel endHours =new SpinnerNumberModel(0,0,24,1);
        JSpinner endHourSpinner = new JSpinner(endHours);
        endHourSpinner.setBounds(90,270,50,30);
        JComponent endHourSetter =new JSpinner.NumberEditor(endHourSpinner,"00");
        endHourSpinner.setEditor(endHourSetter);

        SpinnerNumberModel endMinute =new SpinnerNumberModel(0,0,60,1);
        JSpinner endMinuteSpinner = new JSpinner(endMinute);
        endMinuteSpinner.setBounds(235,270,50,30);
        JComponent endMinuteSetter =new JSpinner.NumberEditor(endMinuteSpinner,"00");
        endMinuteSpinner.setEditor(endMinuteSetter);

        DefaultListModel listModel=new DefaultListModel<TimeModel>();
        JList list=new JList<TimeModel>();
        list.setBounds(20,70,340,150);
        list.setFont(new Font("",1,15));
        list.setModel(listModel);
        listModel.addElement(new TimeModel(""+10,""+35,""+01,""+05));


        JButton setBtn=new JButton();
        setBtn.setFocusable(false);
        setBtn.setText("set");
        setBtn.setFont(new Font("",1,15));
        setBtn.setBounds(295,240,80,50);
        setBtn.addActionListener(evt ->{
            String startHour=""+startHourSpinner.getValue();
            String startMin=""+startMinuteSpinner.getValue();

            String endHour=""+endHourSpinner.getValue();
            String endMin=""+endMinuteSpinner.getValue();

           listModel.addElement (new TimeModel(startHour,startMin,endHour,endMin));
           observerable.setTime(startHour,startMin,endHour,endMin);

        });

        add(list);
        add(hourLabel);
        add(minLabel);
        add(hourEndLabel);
        add(minEndLabel);
        add(startHourSpinner);
        add(startMinuteSpinner);
        add(endHourSpinner);
        add(endMinuteSpinner);
        add(setBtn);



    }
}
