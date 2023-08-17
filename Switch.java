import javax.swing.*;
import java.awt.*;

public class Switch extends JFrame {
    private SuperHomeObserverable observerable;
    Switch(SuperHomeObserverable observerable) {
        this.observerable=observerable;

        setTitle("Switch");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setSize(400, 350);
        setLayout(null);
        setLocationRelativeTo(null);

        JToggleButton onOffBtn = new JToggleButton();
        onOffBtn.setFocusable(false);
        onOffBtn.setText("OFF");
        onOffBtn.setFont(new Font("", 1, 15));
        onOffBtn.setBounds(90, 100, 200, 40);
        onOffBtn.addActionListener(evt -> {
            if (onOffBtn.isSelected()) {
                onOffBtn.setText("ON");
                observerable.setSuperHome(1);
            } else {
                onOffBtn.setText("OFF");
                observerable.setSuperHome(0);
            }
        });

        JButton settingsBtn=new JButton();
        settingsBtn.setFocusable(false);
        settingsBtn.setText("Settings");
        settingsBtn.setFont(new Font("",1,15));
        settingsBtn.setBounds(90,180,200,40);
        settingsBtn.setBorder(BorderFactory.createEtchedBorder());
        settingsBtn.addActionListener(evt->{
            new HomeComponent(observerable);

        });
        add(settingsBtn);
        add(onOffBtn);
    }
}

