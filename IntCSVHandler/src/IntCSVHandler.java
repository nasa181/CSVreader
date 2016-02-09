import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;
public class IntCSVHandler {
	public Scanner in;
	protected String s;
	protected ArrayList<ArrayList<Integer>> data = new ArrayList<ArrayList<Integer>>();
	protected int row;
	protected int sum;
	public IntCSVHandler(){
		in = new Scanner(System.in);
		row = 0;
		sum = 0;
	}
	
	//=========== READ FILE ===========================================
	public void readFille(String directory){
		try {
			in = new Scanner(new File(directory.trim()));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null,"There is no file exit.\n Please try again.", "Warning", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
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
	
	//========== calculate specific row ==================================
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
	
	//======== calculate specific column =====================================
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
	
	
	/*	
	* ======================= How to use =============================
	* 1.create main method >> public static void main(String[] args){}
	* 
	* 2.new IntCSVHandler object >> IntCSVHandler csv = new IntCSVHandler();
	* 
	* 3.call method readFile with file directory >> csv.readFile("test.csv");
	* 
	* 4.In case of want to calculate specific row
	* 	call method sumRow with the number of row >> csv.sumRow(0);
	* 
	* 5.In case of want to calculate specific column
	* 	call method sumCol with the number if column >> csv.sumCol(0);
	*
	*/
	
	/*
	 * ====================== example ==================================
			public static void main(String[] args){
				IntCSVHandler csv = new IntCSVHandler();
				csv.readFille("test.txt");
				int n = csv.sumRow(0);
				System.out.println(n);	
			}
	*/
}
