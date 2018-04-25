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
	private static JComboBox<String> jcb;
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

		jcb = new JComboBox<>();
		jcb.setEditable(true);

		add(jcb);

		theHandler handler = new theHandler();
		jcb.addActionListener(handler);
	}

	// EventHandling class
	private class theHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			String selectedBook = (String) jcb.getSelectedItem();

			if (selectedBook.equals("FIT16CS086")) {
				System.out.println("Good choice!");
			} else if (selectedBook.equals("Head First Java")) {
				System.out.println("Nice pick, too!");
			}
		}
	}
}
public class CheckSgpa {
	public static void main(String[] args) throws IOException , InterruptedException, FileNotFoundException {
		gui frame = new gui();
		Thread t = new Thread(new Runnable(){
			public void run(){
				try{
					frame.populate();
				}
				catch (Exception e){
					System.out.println(e);
				}
			}
		});
		t.start();
		t.join();
		frame.setSize(600,600);
		frame.setVisible(true);	
	}
}

