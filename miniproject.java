import javax.swing.*;
public class miniproject {
	public static void main(String[] args) {
		String i,Select;
		i=JOptionPane.showInputDialog("Enter number students : ");
		int S,ii = Integer.parseInt(i);
		String infoST[][] = new String[ii][16];
		for(int n=0;n<ii;n++) {
			getdata(infoST,n);
			grade(infoST,n);
		}
		while(true){
			display(infoST,ii);
			Select=JOptionPane.showInputDialog("Choose ID (0 to exit):");
			S = Integer.parseInt(Select);
			if(S==0)break;
			S-=1;
			subdisplay(infoST,S);
		}
		JOptionPane.showMessageDialog( null,"Exit Program Complete","Exit",JOptionPane.INFORMATION_MESSAGE );
		System.exit( 0 );
	}
	public static void getdata(String infoST[][],int i) {
		infoST[i][0]=String.valueOf(i+1);
		for(int n=1;n<14;n++)infoST[i][n]= String.valueOf(45 + ( int ) ( Math.random() * 45 ));

	}
	public static void grade(String infoST[][],int i) {
		int score,unit=0;
		double decigrade,total=0;
			for(int n=1;n<14;n++){
				score=Integer.parseInt(infoST[i][n]);
				decigrade=scoretoGPA(score);
				if(n==7){
					total+=decigrade;
					unit+=1;
				}
				else{	
				total+=(3*decigrade);
				unit+=3;}
			}
			double val = total/unit;
			val = val*100;
			val = Math.round(val);
			val = val /100; // 2 decimal to value
			infoST[i][14]=String.valueOf((val));
	}
	public static double scoretoGPA(int score){
		double decigrade;
		if(score>=80)decigrade=4.00;
		else if(score>=75)decigrade=3.50;
		else if(score>=70)decigrade=3.00;
		else if(score>=65)decigrade=2.50;
		else if(score>=60)decigrade=2.00;
		else if(score>=55)decigrade=1.50;
		else if(score>=80)decigrade=1.00;
		else decigrade=0;
		return(decigrade);
	}
	public static void display(String infoST[][],int ii) {
		String out1,ID;
		out1 = "ID\tGPA\tstatus\n";
		for(int n=0;n<ii;n++) {
			if(n<9)out1+="0000";
			else if(n<99)out1+="000";
			out1 += infoST[n][0]+"\t";
			out1 += infoST[n][14]+"\t";
			if(Double.parseDouble(infoST[n][14])<1.5)out1+="Retry\n";
			else if(Double.parseDouble(infoST[n][14])<2)out1+="Probation\n";
			else if(Double.parseDouble(infoST[n][14])>=2)out1+="Normal\n";
		}
		JTextArea output = new JTextArea();
		output.setText(out1);
		JOptionPane.showMessageDialog( null,output,"Result",JOptionPane.INFORMATION_MESSAGE );
	}
	public static void subdisplay(String infoST[][],int Select) {
		String out1;
		out1 = "ID\t";
		if(Select<9)out1+="0000"+(Select+1)+"\n";
		else out1+="000"+(Select+1)+"\n";
		for(int n=1;n<14;n++) {
			out1+="Subject"+n+"\t"+infoST[Select][n]+"\n";
		}
		out1+="GPA\t"+infoST[Select][14]+"\n";
		if(Double.parseDouble(infoST[Select][14])<1.5)out1+="Status\t"+"Retry\n";
		else if(Double.parseDouble(infoST[Select][14])<2)out1+="Status\t"+"Probation\n";
		else if(Double.parseDouble(infoST[Select][14])>=2)out1+="Status\t"+"Normal\n";
		JTextArea output = new JTextArea();
		output.setText(out1);
		JOptionPane.showMessageDialog( null,output,"Result",JOptionPane.INFORMATION_MESSAGE );
	}
}