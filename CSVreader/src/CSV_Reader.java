import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;
public class CSV_Reader {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("please enter the directory and the type of file.");
		String s = in.next();
		ArrayList<ArrayList<Integer>> data = new ArrayList<ArrayList<Integer>>();
		try {
			in = new Scanner(new File(s));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null,"There is no file exit.\n Please try again.", "Warning", JOptionPane.ERROR_MESSAGE);
			try {
				s = in.next();
				in = new Scanner(new File(s));
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "There is no file exit.\n Please try again.", "Warning", JOptionPane.ERROR_MESSAGE);
				try {
					s = in.next();
					in = new Scanner(new File(s));
				} catch (FileNotFoundException e2) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "There is no file exit.\n Please make sure with you admin about the file's name or file's directory.", "Warning", JOptionPane.ERROR_MESSAGE);
					System.exit(0);
				}
			}
		}
		int row = 0;
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
		in = new Scanner(System.in);
		while(true){
			System.out.println("Please select the option.");
			System.out.println("Press 1 for calculate the sum of the selected row.");
			System.out.println("Press 2 for calculate the sum of the selected colum.");
			System.out.println("Press 3 for exit.");
			int select = in.nextInt();
			if( select == 1){
				System.out.println("Please enter the row.");
				int tmp = in.nextInt();
				if(tmp < 0 || tmp > data.size()){
					JOptionPane.showMessageDialog(null, "warning", "You entered the wrong number.", JOptionPane.ERROR_MESSAGE);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					continue;
				}
				int sum =0;
				for(int i=0;i<data.get(tmp).size();i++){
					sum += data.get(tmp).get(i);
				}
				System.out.println("The result is " + sum +".");
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if(select == 2){
				System.out.println("Please enter the colum.");
				int tmp = in.nextInt();
				if(tmp < 0 || tmp > data.get(0).size()){
					JOptionPane.showMessageDialog(null, "Warning", "You entered the wrong number.", JOptionPane.ERROR_MESSAGE);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					continue;
				}
				int sum = 0;
				for(int i=0;i<data.size();i++){
					sum += data.get(i).get(tmp);
				}
				System.out.println("The result is " + sum + ".");
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if(select == 3){
				System.out.println("Thank you.");
				break;
			}
			else{
				JOptionPane.showMessageDialog(null, "warning", "You selected the wrong number.", JOptionPane.ERROR_MESSAGE);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
