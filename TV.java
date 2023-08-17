import javax.swing.*;
import java.awt.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

class Tv extends JFrame implements HomeObserver{
    private int startHour,startMinute,endHour,endMinute;

    private String startTime,endTime;

    private JLabel tvLabel;
    Tv(){
        setSize(250,150);
        setTitle("TV");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        //setLocation();

        tvLabel=new JLabel();
        tvLabel.setText("OFF");
        tvLabel.setFont(new Font("MV Boli",Font.PLAIN,60));
        tvLabel.setBounds(0,12,200,100);
        tvLabel.setVerticalAlignment(JLabel.CENTER);
        tvLabel.setHorizontalAlignment(JLabel.CENTER);

        add(tvLabel);
        setVisible(true);
    }
    @Override
    public void update(int superHome) {
        tvLabel.setText(superHome==0 ? "OFF":"ON");

    }
    @Override
    public void setTime(String startHour, String startMinute, String endHour, String endMinute) {
        this.startHour=Integer.parseInt(startHour);
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
           tvLabel.setText("ON");
       }else if (currentTime.format(DateTimeFormatter.ofPattern("HH:mm:ss")).equals(endTime)){
           tvLabel.setText("OFF");
       }
    }
}

