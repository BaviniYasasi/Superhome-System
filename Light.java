import javax.swing.*;
import java.awt.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Light extends JFrame implements HomeObserver {
    private int startHour,startMinute,endHour,endMinute;
    private String startTime,endTime;
    private JLabel lightLabel;
    Light(){

        setSize(250,150);
        setTitle("Light");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        //setLocation();

        lightLabel=new JLabel();
        lightLabel.setText("OFF");
        lightLabel.setFont(new Font("MV Boli",Font.PLAIN,60));
        lightLabel.setBounds(0,12,200,100);
        lightLabel.setVerticalAlignment(JLabel.CENTER);
        lightLabel.setHorizontalAlignment(JLabel.CENTER);

        add(lightLabel);

        setVisible(true);


    }
    @Override
    public void update(int superHome){
        lightLabel.setText(superHome==0?"OFF":"ON");
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
            lightLabel.setText("ON");
        }else if (currentTime.format(DateTimeFormatter.ofPattern("HH:mm:ss")).equals(endTime)){
            lightLabel.setText("OFF");
        }*/
    }
}


