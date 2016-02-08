import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;
public class CSV_Reader {
	public Scanner in;
	protected String s;
	protected ArrayList<ArrayList<Integer>> data = new ArrayList<ArrayList<Integer>>();
	protected int row;
	protected int sum;
	public CSV_Reader(){
		in = new Scanner(System.in);
		System.out.println("Please enter file directory");
		s = in.nextLine().trim();
		row = 0;
		sum = 0;
	}
	public void readFille(String directory){
		try {
			in = new Scanner(new File(directory));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null,"There is no file exit.\n Please try again.", "Warning", JOptionPane.ERROR_MESSAGE);
			return;
		}
		row = 0;
		while(in.hasNext()){
			s = in.nextLine();
			ArrayList<Integer> tmp = new ArrayList<Integer>();
			for(int i=0;i<s.length();i++){
				String tmp_txt = s.substring(i,i+1).trim();
				if(tmp_txt.equals(","))continue;
				int num = Integer.parseInt(tmp_txt);
				tmp.add(num);
			}
			data.add(row,tmp);
			row++;
		}
	}
	public int sumRow(int r){
		if(r < 0 || r > data.size()){
			JOptionPane.showMessageDialog(null, "warning", "You entered the wrong number.", JOptionPane.ERROR_MESSAGE);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return 0;
		}
		sum = 0;
		for(int i=0;i<data.get(r).size();i++){
			sum += data.get(r).get(i);
		}
		return sum;
	}
	public int sumCol(int c){
		if(c < 0 || c > data.get(0).size()){
			JOptionPane.showMessageDialog(null, "Warning", "You entered the wrong number.", JOptionPane.ERROR_MESSAGE);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return 0;
		}
		sum = 0;
		for(int i=0;i<data.size();i++){
			sum += data.get(i).get(c);
		}
		return sum;
	}
}
