import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyWindow extends JFrame {
    private JTextField field;
    private JTextArea textArea;
    private JButton button;

    public MyWindow(){
        setTitle("Чат");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300, 300, 400, 400);

        JPanel jp = new JPanel();
        jp.setLayout(new BorderLayout());

        textArea = new JTextArea();
        textArea.setLineWrap(true);
        JScrollPane jsp = new JScrollPane(textArea);
        jp.add(jsp, BorderLayout.CENTER);

        JPanel bottomJp = new JPanel();
        bottomJp.setLayout(new BorderLayout());

        addTextField();
        bottomJp.add(field, BorderLayout.CENTER);

        addButton();
        bottomJp.add(button, BorderLayout.SOUTH);
        jp.add(bottomJp, BorderLayout.SOUTH);
        add(jp);

        setVisible(true);
        field.grabFocus();
    }

    private void sendMessage(){
        if(!field.getText().isEmpty()){
            textArea.append(field.getText()+"\n");
            field.setText("");
            field.grabFocus();
        }
    }

    private void addTextField(){
        field = new JTextField();
        field.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        }
        );
    }

    private void addButton(){
        button = new JButton("Отправить");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        }
        );
    }

}
