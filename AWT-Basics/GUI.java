package GUIProjects;
import java.awt.TextField;
import java.awt.*;
import java.awt.Frame;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
class AppletFrameActions extends Frame {
	private Label label1,label2; 
	private TextField txtF1;
	private TextField passF;
	// Looking for a better way to store this.
	private final String uid = "Yedhin";
	private final String pass = "*123#";

	private int flagUid = 0, flagPass = 0;
	public AppletFrameActions(){
		super("EventHandling using Frame class of applet");
		setLayout(new FlowLayout());
		label1 = new Label();
		label1.setAlignment(Label.CENTER);
		label1.setText("Username");
		add(label1);
		txtF1 = new TextField();
		passF = new TextField();
		txtF1.setColumns(20);
		passF.setColumns(20);
		passF.setEchoChar('*');
		add(txtF1);
		label2 = new Label();
		label2.setAlignment(Label.CENTER);
		label2.setText("Password");
		add(label2);
		add(passF);
		theHandler handler = new theHandler();
		txtF1.addActionListener(handler);
		passF.addActionListener(handler);
	}
	private class theHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// Event in textField
			if(e.getSource() == txtF1) {
				if(e.getActionCommand().equals(uid))
				{
					flagUid = 1;
				}
			}
			// Event in PassField (textFiled for password)
			else if(e.getSource() == passF) {
				if(e.getActionCommand().equals(pass))
				{
					flagPass = 1;
				}
			}
			
			if( flagUid == 1 && flagPass == 1 ){
				System.out.println("Matching");
				JOptionPane.showMessageDialog(null,"Successfull Login");
				try{
					Thread.sleep(1000);
				}
				catch(InterruptedException ex){
					System.out.println("Exception "+ex+" Caught");
				}
				dispose();
			}
			else{
				 JOptionPane.showMessageDialog(null,"Invalid Login Credentials");
			}
		}
	}
	public static void main(String[] args) {
		AppletFrameActions frameObj = new AppletFrameActions();
		frameObj.setSize(600,600);
		frameObj.setVisible(true);	
	}
}
