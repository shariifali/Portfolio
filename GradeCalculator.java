import java.util.*;   
import java.io.*;   
import java.text.*;  
 
public class GradeCalculator
{
//Start CLASS  
 
public static DecimalFormat td = new DecimalFormat("0.00");   
public static Scanner scan = new Scanner(System.in);   
public static void main (String args[]) throws FileNotFoundException

{
//Start MAIN 
  File text= new File("Prog7.txt");
  Scanner infile = new Scanner(text);
  String [] fname = new String[25];
  String [] lname = new String[25];
  int [] g1 = new int[25];
  int [] g2 = new int[25];
  int [] g3 = new int[25];
  int [] g4 = new int[25];
  int [] g5 = new int[25];
  double [] total = new double[25];
  double [] ave = new double[25];
  int counter = 0;
  while(infile.hasNext())
  { 
  fname[counter]=infile.next();
  lname[counter]=infile.next();
  g1[counter]=infile.nextInt();
  g2[counter]=infile.nextInt();
  g3[counter]=infile.nextInt();
  g4[counter]=infile.nextInt();
  g5[counter]=infile.nextInt();
  total [counter]= g1[counter]+g2[counter]+g3[counter]+g4[counter]+g5[counter]; 
  ave[counter]=total[counter]/5;
  counter++;
   }
    for(int p=0;p<25;p++)
  {
  System.out.println(fname[p]+" "+lname[p]+" "+td.format(ave[p]));
  }
         
  String to = fname[21];
  fname[21] = fname[1];
  fname[1] = to;
  String t = lname[21];
  lname[21] = lname[1];
  lname[1] = t;
  double temp = ave[21];
  ave[21] = ave[1];
   ave[1] = temp;
         
  String l = fname[6];
  fname[6] = fname[2];
  fname[2] = l;
  String k = lname[6];
  lname[6] = lname[2];
  lname[2] = k;
 double jo = ave[6];
  ave[6] = ave[2];
  ave[2] = jo;
         
  String m = fname[9];
  fname[9] = fname[3];
  fname[3] = m;
  String n = lname[9];
  lname[9] = lname[3];
  lname[3] = n;
  double yo = ave[9];
  ave[9] = ave[3];
  ave[3] = yo;
         
         
  String h = fname[11];
  fname[11] = fname[4];
  fname[4] = h;
  String d = lname[11];
  lname[11] = lname[4];
  lname[4] = d;
  double no = ave[11];
         ave[11] = ave[4];
         ave[4] = no;
   
          
      System.out.println("******************************************************");
      System.out.println("*These are the top 5 people averages!!****************");
      System.out.println("******************************************************");
      for(int i=0;i<5;i++)
      if(ave[i]>=90)
         System.out.println(fname[i]+" "+lname[i]+" "+td.format(ave[i])+"  A");
         else if(ave[i]>=80)
         System.out.println(fname[i]+" "+lname[i]+" "+td.format(ave[i])+"  B");
         else if(ave[i]>=70)
         System.out.println(fname[i]+" "+lname[i]+" "+td.format(ave[i])+"  C");
         else if(ave[i]>=60)
         System.out.println(fname[i]+" "+lname[i]+" "+td.format(ave[i])+"  D");
         else
         System.out.println(fname[i]+" "+lname[i]+" "+td.format(ave[i])+"  F");
      
        

                

}//End MAIN   

}//End CLASS 