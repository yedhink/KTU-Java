package GUIProjects;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

class gui extends Frame {
	private static JComboBox<String> jcb = new JComboBox<>();
	private static String pathReg = "./reg.txt" , pathSgpa = "./sgpa.txt"; 
	private static String key,value;
	private static HashMap<String,String> map = new HashMap<>();
	public static synchronized void populate() throws FileNotFoundException, IOException {
		FileInputStream fReg = new FileInputStream(pathReg);
		FileInputStream fSgpa = new FileInputStream(pathSgpa);
		BufferedReader fileR = new BufferedReader(new InputStreamReader(fReg));
		BufferedReader fileS = new BufferedReader(new InputStreamReader(fSgpa));
		while ( ( ( key = fileR.readLine() ) != null ) && ( value = fileS.readLine() ) != null ) {
			jcb.addItem(key);
			map.put(key, value);
		}
	}
	public gui(){
		// explictely setting layout. default is Flow itself
		setLayout(new FlowLayout());

		//jcb = new JComboBox<>();
		jcb.setEditable(true);

		add(jcb);

		
		/*jcb.getEditor().addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent arg0) {

			String selectedRegNum = (String) jcb.getSelectedItem();
			value = map.get(selectedRegNum);
			if (value!=null) {
				JOptionPane.showMessageDialog(null,value);
			} 
			else {
				JOptionPane.showMessageDialog(null,"No such register number in S3 CS");
			}
			}               
		});*/
		theHandler handler = new theHandler();
		jcb.addItemListener(handler);
		//jcb.setEnabled(false);
	}

	// EventHandling class
	private class theHandler implements ItemListener {
	public void itemStateChanged(ItemEvent event) {	
		String selectedRegNum = (String) jcb.getSelectedItem();
		value = map.get(selectedRegNum);
		//if(event.SELECTED == 1){
			//jcb.setEnabled(true);
			if (value!=null) {
				JOptionPane.showMessageDialog(null,value);
			} 
			else {
				JOptionPane.showMessageDialog(null,"No such register number in S3 CS");
			}
		//}
	}
	}
}
public class CheckSgpa {
	public static void main(String[] args) throws IOException , InterruptedException, FileNotFoundException {
		Thread t = new Thread(new Runnable(){
			public void run(){
				try{
					gui.populate();
					Thread.sleep(100);
				}
				catch (Exception e){
					System.out.println(e);
				}
			}
		});
		t.start();
		t.join();
		gui frame = new gui();
		frame.setSize(600,600);
		frame.setVisible(true);	
	}
}

