import javax.swing.*;
import java.awt.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Window extends JFrame implements HomeObserver{
    private int startHour,startMinute,endHour,endMinute;

    private String startTime,endTime;
    private JLabel windowLabel;
    Window(){
        setSize(250,150);
        setTitle("Window");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        //setLocation();

        windowLabel=new JLabel();
        windowLabel.setText("OFF");
        windowLabel.setFont(new Font("MV Boli",Font.PLAIN,60));
        windowLabel.setBounds(0,12,200,100);
        windowLabel.setVerticalAlignment(JLabel.CENTER);
        windowLabel.setHorizontalAlignment(JLabel.CENTER);

        add(windowLabel);

        setVisible(true);
    }
    @Override
    public void update(int superHome){
        windowLabel.setText(superHome==0?"OFF":"ON");
    }
    @Override
    public void setTime(String startHour, String startMinute, String endHour, String endMinute) {
       /* this.startHour=Integer.parseInt(startHour);
        this.startMinute=Integer.parseInt(startMinute);
        this.endHour=Integer.parseInt(endHour);
        this.endMinute=Integer.parseInt(endMinute);

        startTime=String.format("%02d:%02d:00",this.startHour,this.startMinute);
        endTime=String.format("%02d:%02d:00",this.endHour,this.endMinute);
        Timer timer=new Timer(1000,e -> {
            checkTime();
        });
        timer.start();
    }
    public void checkTime(){
        LocalTime currentTime = LocalTime.now();
        if (currentTime.format(DateTimeFormatter.ofPattern("HH:mm:ss")).equals(startTime)){
            windowLabel.setText("ON");
        }else if (currentTime.format(DateTimeFormatter.ofPattern("HH:mm:ss")).equals(endTime)){
            windowLabel.setText("OFF");
        }*/

    }
}
