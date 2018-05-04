import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class sum_2nos extends Applet implements ActionListener
{
	TextField t1 = new TextField(10);
	TextField t2 = new TextField(10);
	TextField t3 = new TextField(10);

	Label l1 = new Label("First no");
	Label l2 = new Label("Second no");
	Label l3 = new Label("Sum ");
	Button b = new Button("ADD ");

	public void init()
	{
//		t1.setForeground(Color = Red);
		add(l1);
		add(t1);
		add(l2);
		add(t2);
		add(l3);
		add(t3);
		add(b);
		b.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == b)
		{
			int n1 = Integer.parseInt(t1.getText());
			int n2 = Integer.parseInt(t2.getText());
			t3.setText(" " + (n1+n2));
		}
	}
}

