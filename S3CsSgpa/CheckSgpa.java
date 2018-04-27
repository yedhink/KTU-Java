/*
 * @name        Check Sgpa
 * @package     GUIProjects
 * @file        CheckSgpa.java
 * @author      Yedhin Kizhakkethara
 * @email       yedhin1998@gmail.com
 * @link        https://github.com/yedhink/KTU-Java
 * @copyright   Copyright @ ikigai, All Rights Reserved.
 * @license     MIT
 * @create      23-04-2018
 */

package GUIProjects;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class gui extends Frame {
	private static JComboBox<String> jcb = new JComboBox<>();
	private static JButton buttonFind , buttonTopTen;
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
		map = (HashMap<String,String>)sortByComparator((Map<String,String>)map,false);
		add(jcb);
		buttonFind = new JButton("Find Sgpa");
		add(buttonFind);
		buttonTopTen = new JButton("Find Top Ten");
		add(buttonTopTen);
		theHandler handler = new theHandler();
		buttonFind.addActionListener(handler);
		buttonTopTen.addActionListener(handler);
	}

	// EventHandling class
	private class theHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {	
			String selectedRegNum = (String) jcb.getSelectedItem();
			new UIManager();
			if(event.getSource() == buttonFind){
				value = map.get(selectedRegNum);
				if (value!=null) {
					if(selectedRegNum.equals("FIT16CS086")){
						JOptionPane.showMessageDialog(null,"\tCongrats!You're the topper\nYour sgpa : "+value);
					}
					else{
						//JOptionPane.showMessageDialog(null,"Your sgpa : "+value);
						UIManager.put("OptionPane.background", Color.decode("#d3d3d3"));
						UIManager.put("Panel.background", Color.decode("#d3d3d3"));
						JOptionPane.showMessageDialog(null, "Your sgpa : "+value, "Gray", JOptionPane.INFORMATION_MESSAGE);
					}
				} 
				else {
					UIManager.put("OptionPane.background", Color.decode("#FF0000"));
					UIManager.put("Panel.background", Color.decode("#FF0000"));
					JOptionPane.showMessageDialog(null, "No such register number in S3 CS", "Red", JOptionPane.INFORMATION_MESSAGE);
				}
			}
			if(event.getSource() == buttonTopTen){
				int i = 0;
				String msg = "";
				for (Map.Entry<String, String> entry : map.entrySet()) {
					if(i>10){
						break;
					}
					key = entry.getKey();
					value = entry.getValue();
					msg += key+"  "+value+"\n";
					++i;
				}
				JOptionPane.showMessageDialog(null,msg);
			}
		}
	}

	private static Map<String, String> sortByComparator(Map<String, String> unsortMap, final boolean order){
		List<Entry<String, String>> list = new LinkedList<Entry<String, String>>(unsortMap.entrySet());
		// Sorting the list based on values
		Collections.sort(list, new Comparator<Entry<String, String>>(){
			public int compare(Entry<String, String> o1,Entry<String, String> o2){
				if (order){
					return o1.getValue().compareTo(o2.getValue());
				}
				else{
					return o2.getValue().compareTo(o1.getValue());
				}
			}
		});

		// Maintaining insertion order with the help of LinkedList
		Map<String, String> sortedMap = new LinkedHashMap<String, String>();
		for (Entry<String, String> entry : list){
			sortedMap.put(entry.getKey(), entry.getValue());
		}
		return sortedMap;
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
		frame.setBackground(Color.decode("#000"));
		frame.setVisible(true);
	}
}

