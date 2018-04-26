package GUIProjects;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
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
	private static JButton buttonFind;
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
		fileR.close();
		fileS.close();
	}
	public gui(){
		// explictely setting layout. default is Flow itself
		setLayout(new FlowLayout());
		jcb.setEditable(true);
		add(jcb);
		buttonFind = new JButton("Find Sgpa");
		add(buttonFind);
		theHandler handler = new theHandler();
		buttonFind.addActionListener(handler);
	}

	// EventHandling class
	private class theHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {	
			String selectedRegNum = (String) jcb.getSelectedItem();
			if(event.getSource() == buttonFind){
				value = map.get(selectedRegNum);
				if (value!=null) {
					if(selectedRegNum.equals("FIT16CS086")){
						JOptionPane.showMessageDialog(null,"\tCongrats!You're the topper\nYour sgpa : "+value);
					}
					else{
						JOptionPane.showMessageDialog(null,"Your sgpa : "+value);
					}
				} 
				else {
					JOptionPane.showMessageDialog(null,"No such register number in S3 CS");
				}
			}
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

