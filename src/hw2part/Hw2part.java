/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hw2part;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Deepti
 */
public class Hw2part {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here

        Scanner scanner=new Scanner(System.in);
        int choice=0;   
        Survey sur=new Survey();
        Test t=new Test();
        List<Survey> Surveyl= new ArrayList<Survey>();
        List<Test> Testl= new ArrayList<Test>();
       
        while(choice !=16)
        {
            System.out.println("1) Create a new Survey ");
            System.out.println("2) Create a new Test ");
            System.out.println("3) Display Survey\n4) Display a Test ");
            System.out.println("5) Load a Survy \n6) Load a Test");
            System.out.println("7) Save a Survey \n8) Save a Test \n9) Modify an Exisiting Survey\n" +
"10) Modify an Existing Test \n" +
"11) Take a Survey\n" +
"12) Take a Test \n" +
"13) Grade a Test\n" +
"14) Tabulate a Survey\n" +
"15) Tabulate a Test\n 16)Quit");
            String n1= scanner.nextLine();
            //here we handle the input if the user doesnot input a no.
            while(!n1.matches("\\d+"))
                      {
                      System.out.println("Input has to be a no ");
                      n1= scanner.nextLine();
                      }
            
            choice = Integer.parseInt(n1);
            switch(choice)
            {
             case 1: /*
              * here we create a survey by adding questions to a list
              */    sur = new Survey();
                    sur.fill();
                    System.out.println("What name you want to give to the survey");
                    String qs=scanner.nextLine();
                    sur.setName(qs);
                    Surveyl.add(sur);
                    break;

             case 2:  /*
              * here we create a test by adding questions to a list
              */    t = new Test();
                    t.fill();
                    System.out.println("What name you want to give to the test");
                    String qs1=scanner.nextLine();
                    t.setName(qs1);
                    Testl.add(t);
                    break;
                    
                    
                 //survey display
             case 3:  
                    for(int i1=0;i1< Surveyl.size();i1++)
                     {
                       System.out.println((i1+1)+")"+Surveyl.get(i1).name);
                     }
                     System.out.println(" which survey u want to display?");
                     String f=scanner.nextLine();
                     int iz=Integer.parseInt(f);
                     Survey sss = Surveyl.get(iz-1);
                     sur.display(sss);
                     
                     break;
             case 4:  
                 for(int i11=0;i11< Testl.size();i11++)
                     {
                       System.out.println((i11+1)+")"+Testl.get(i11).name);
                     }
                     System.out.println(" which test u want to display?");
                     String fq1=scanner.nextLine();
                     int iz1=Integer.parseInt(fq1);
                     Test sss1 = Testl.get(iz1-1);
                     t.display(sss1);
                     
                     break;
             case 5:  
                   System.out.println("give path of the survey u want to load");
                   File f1 = new File(scanner.nextLine());
                   System.out.println("give path of the responses for this survey one by one and input quit when u r done");
                   List<File> f2 = new ArrayList<File>();
                   String input1="";
                   while (!input1.equals("quit"))
                       {
                           File ff = new File(input1);
                           if (ff.exists())
                           {
                               System.out.println("yes");
                               f2.add(ff);
                           }
                           input1 = scanner.nextLine();
                       }
                    sur = new Survey().load(f1, f2);

                   Surveyl.add(sur);
                   for(int x=0;x<Surveyl.size();x++)
                   {
                   System.out.println(Surveyl.get(x).giveans);
                   
                   }
                   //System.out.println(sur.toString());
                   
                   break;
             case 6:  
                 //here we load the test along with its answers
                    System.out.println("input the path of the test you want to load?");
                    File ft1 = new File(scanner.nextLine());
                    System.out.println("input the path of the corrsponding ans file you want to load?");
                    File fta = new File(scanner.nextLine());
                    List<File> f2r=f2r = new ArrayList<File>();
                    System.out.println("Do u want to load in the responses too?y/n");
                    if(scanner.nextLine().equals("y"))
                    {
                    System.out.println("give path of the responses for this test one by one and input quit when u r done");
                    
                    String inputt1="";
                    while (!inputt1.equals("quit"))
                       {
                           File fft = new File(inputt1);
                           if (fft.exists())
                           {
                               
                               f2r.add(fft);
                           }
                           inputt1 = scanner.nextLine();
                       }}
                    t = Test.load(ft1,fta, f2r);
                    Testl.add(t);
                    
                    
                  break;
             case 7:  //save the survey
                    for(int i1=0;i1< Surveyl.size();i1++)
                    {
        
                       System.out.println((i1+1)+")"+Surveyl.get(i1).name);
                     }
                    System.out.println("what survey you want to save?");
                    String nc1=scanner.nextLine();
                    while(!nc1.matches("\\d+"))
                      {
                      System.out.println("Input has to be a no ");
                      nc1= scanner.nextLine();
                      }
                    int ps=Integer.parseInt(nc1);
                    Surveyl.get(ps-1).save(new FileOutputStream (Surveyl.get(ps-1).name));
                    break;
             case 8:  //we save test and its corresponding answers in separate files
                    for(int ii1=0;ii1<Testl.size();ii1++)
                    {
                       System.out.println((ii1+1)+")"+Testl.get(ii1).name);
                     }
                    System.out.println("what test you want to save?");
                    String ncc1=scanner.nextLine();
                    while(!ncc1.matches("\\d+"))
                      {
                      System.out.println("Input has to be a no ");
                      ncc1= scanner.nextLine();
                      }
                    int pst=Integer.parseInt(ncc1);        
                    System.out.println("what filename u want to give to ur correct test answers");
                    String s2=scanner.nextLine();
                    Testl.get(pst-1).save(new FileOutputStream (Testl.get(pst-1).name),new FileOutputStream (s2));
                    break;
             case 9:
                    System.out.println("which survey to u want to modify?");
                        for(int i1=0;i1< Surveyl.size();i1++)
                        {
                          System.out.println((i1+1)+")"+Surveyl.get(i1).name);
                        }
                        System.out.println("choose ");
                        String nccc1=scanner.nextLine();
                    while(!nccc1.matches("\\d+"))
                      {
                      System.out.println("Input has to be a no ");
                      nccc1= scanner.nextLine();
                      }
                        int d=Integer.parseInt(nccc1);
                        sur.modify(Surveyl.get(d-1) )   ;
                 break;
             
             case 10://test modify
                 System.out.println("which test to u want to modify?");
                        for(int i1=0;i1< Testl.size();i1++)
                        {
                          System.out.println((i1+1)+")"+Testl.get(i1).name);
                        }
                        System.out.println("choose ");
                        String nc1v=scanner.nextLine();
                    while(!nc1v.matches("\\d+"))
                      {
                      System.out.println("Input has to be a no ");
                      nc1v= scanner.nextLine();
                      }
                        int dd=Integer.parseInt(nc1v);
                        t.modify(Testl.get(dd-1) )   ;
                 
                 break;
             case 11:
                    System.out.println("which survey do u want to take?");
                        for(int i1=0;i1< Surveyl.size();i1++)
                        {
                          System.out.println((i1+1)+")"+Surveyl.get(i1).name);
                        }
                        System.out.println("choose one");
                        String ncb=scanner.nextLine();
                    while(!ncb.matches("\\d+"))
                      {
                      System.out.println("Input has to be a no ");
                      ncb= scanner.nextLine();
                      }
                        int d1=Integer.parseInt(ncb);
                        Survey temp = Surveyl.get(d1-1);
                        temp.take();
                       break;
             case 12://take test
                 System.out.println("which test do u want to take?");
                        for(int izz1=0;izz1< Testl.size();izz1++)
                        {
                          System.out.println((izz1+1)+")"+Testl.get(izz1).name);
                        }
                        System.out.println("choose one");
                        String nv1=scanner.nextLine();
                    while(!nv1.matches("\\d+"))
                      {
                      System.out.println("Input has to be a no ");
                      nv1= scanner.nextLine();
                      }
                        
                        int dz1=Integer.parseInt(nv1);
                        Test temp1 = Testl.get(dz1-1);
                        temp1.take();
                    break;
             case 13://grade test
                    System.out.println("which test do u want to grade?");
                    for(int izz1=0;izz1< Testl.size();izz1++)
                        {
                          System.out.println((izz1+1)+")"+Testl.get(izz1).name);
                        }
                        System.out.println("choose one");
                        String nq1=scanner.nextLine();
                    while(!nq1.matches("\\d+"))
                      {
                      System.out.println("Input has to be a no ");
                      nq1= scanner.nextLine();
                      }
                     int dzz1=Integer.parseInt(nq1);
                     Test tempo = Testl.get(dzz1-1);
                     System.out.println("which response do u want to grade?");
                     for(int h=0;h<tempo.giveans.size();h++)
                     {
                     System.out.println((h+1)+"Response"+(h+1));
                     }  
                     int c=Integer.parseInt(scanner.nextLine());
                     List <Response> r= new ArrayList<Response>();;
                     List <Response> r1= new ArrayList<Response>();
                     r=tempo.giveans.get(c-1);
                     
                     r1=tempo.ans;
                     System.out.println("this is the giveans");
                     for(int h11=0;h11<r.size();h11++)
                     {
                     System.out.print(r.get(h11));
                     }
                     System.out.println("this is the correct ans");
                     for(int hg11=0;hg11<r1.size();hg11++)
                     {
                     System.out.print(r1.get(hg11));
                     }
                     tempo.grade(r,r1);
                     
                    break;
             case 14://tabulate survey
                 System.out.println("Which Survey do you want to tabulate\n");
                       int k;
                       for (k = 0; k < Surveyl.size(); k++)
                       {
                           System.out.print((k+1)+") "+Surveyl.get(k).name+"\n");
                       }
                       k = Integer.parseInt(scanner.nextLine());
                       sur = Surveyl.get(k-1);
                       sur.tabulate();

                    break;
                 
                    
             case 15://tabulate test
                       System.out.println("Which test do you want to tabulate\n");
                       int k1;
                       for (k1 = 0; k1 < Testl.size(); k1++)
                       {
                           System.out.print((k1+1)+") "+Testl.get(k1).name+"\n");
                       }
                       k1 = Integer.parseInt(scanner.nextLine());
                       t = Testl.get(k1-1);
                       t.tabulate();
                 break;
             default: System.out.println("wrong input");
                    break;
        
      
            }
        }
    }
}
