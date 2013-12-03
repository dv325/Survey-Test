/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hw2part;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author Deepti
 */
public class Test implements Serializable {
    
    
       
       List<Question> list;//this list has all the questions of a test
       List<Response> ans;//this list has all the ans of a test
       List <List<Response>> giveans;
       
       String name;
        Test()
        {   giveans= new ArrayList<List<Response>>();
            list= new ArrayList<Question>();
            ans= new ArrayList<Response>();
            name="";
        }
        public void setName(String s)
        {
        name=s;

        }
        public void addQuestion(Question q)
        {//this adds a question to the list 'list'
            //this adds a ans to the list ans
            q.getQues();
            ans.add(q.getCorrectans());
            list.add(q);
        }
        public void fill()
        {
            Scanner scanner=new Scanner(System.in);
            int n111  =0;
                    while(n111!=7)
                    {
                      System.out.println("which type of question u want to add?");
                      System.out.println("1)multiple choice");
                      System.out.println("2)true/false");
                      System.out.println("3)short ans");
                      System.out.println("4)essay");
                      System.out.println("5)ranking");
                      System.out.println("6)match the following");
                      System.out.println("7)quit");
                      String  n= scanner.nextLine();
                      while(!n.matches("\\d"))
                      {
                      System.out.println("Input has to be a digit");
                      n= scanner.nextLine();
                      }
                      n111 = Integer.parseInt(n);
                      switch(n111)
                        {
                          case 1:  
                                 Question m=new MChoice();
                                 addQuestion(m);
                                 break;
                          case 2:  
                                 Question m1=new TF();
                                 addQuestion(m1);
                                 break;
                          case 3:
                                 Question m3=new Shortans();
                                 addQuestion(m3);
                                 break;
                          case 4:
                                 Question m4=new Essay();
                                 addQuestion(m4);
                                 break;
                          case 5:
                                 Question m5=new Ranking();
                                 addQuestion(m5);
                                 break;
                          case 6:
                                 Question m6=new Matching();
                                 addQuestion(m6);
                                 break;
                          case 7:
                               
                                 break;
                          default: System.out.println("wrong input,input has to be betwwen 1 to 7");
                                  break;


                      }
                    }
         }
        

        public void display(Test s) 
        {//displays all the question currently in the list
            System.out.println(s.toString());
    
        }
         
        public String toString()
        {//get all the questions and their corresponding answersin the list 'list' to one string
            String str="";
            for(int i = 0; i < list.size(); i++)
             {
                str+=(list.get(i).toString()+"\n");
                str+=(ans.get(i).toString()+"\n");
             }
            return str;
        }

        public static Test load(File list,File ans, List<File> res) 
        {
            try
           {
               Test s = new Test(); 

               ObjectInputStream input = new ObjectInputStream(new FileInputStream(list));
               s.list = (List<Question>) input.readObject();
               s.setName(list.getName()); 
               ObjectInputStream input1 = new ObjectInputStream(new FileInputStream(ans));
               s.ans = (List<Response>) input1.readObject();
               for (File f : res)
               {
                   try
                   {
                       ObjectInputStream input2 = new ObjectInputStream(new FileInputStream(f));
                       s.giveans.add((List<Response>) input2.readObject());
                       input2.close();
                   }
                   catch(Exception e)
                   {
                       e.printStackTrace();
                   }
               }
               input1.close();
               input.close();
               return s;
           }
           catch(Exception ex)
           {
               System.err.println(ex.getMessage());
           }

           //check for null in main
           return null;

        }

     public void save(OutputStream out,OutputStream out1) 
    {//save the survey to a file through serializaton
        try
        {
            ObjectOutputStream output=new ObjectOutputStream(out);
            output.writeObject(list);
            output.flush();
            output.close();
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
         try
        {
            ObjectOutputStream output1=new ObjectOutputStream(out1);
            output1.writeObject(ans);
            output1.flush();
            output1.close();
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
        for(int i=0;i<giveans.size();i++)
        {
        try
        { 
            File f = new File(name+i);
            ObjectOutputStream output=new ObjectOutputStream(new FileOutputStream(f));
            output.writeObject((List<Response>)giveans.get(i));
            output.flush();
            output.close();
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
        
        
        }
    }       
     public void modify(Test s)
    {
        Scanner scanner=new Scanner(System.in);
        display(s);
        System.out.println("1) Modify the ques "
                + "2) modify the correct ans given");
        String g11=scanner.nextLine();
        if(g11.equals("1"))
        {
        System.out.println("which question no do you want to modify?");
        String g=scanner.nextLine();
        Question q=s.list.get(Integer.parseInt(g)-1);
        q.modify();
        }
        if(g11.equals("2"))
        {
        System.out.println("which ques no's ans  do you want to modify?");
        String g=scanner.nextLine();
        Response q=s.ans.get(Integer.parseInt(g)-1);
        for(int i=0;i<q.rlist.size();i++)
        {   
            System.out.println((i+1)+") "+q.rlist.get(i));
        
        }
        System.out.println("which one do you want to modify");
        int z=Integer.parseInt(scanner.nextLine());
        q.rlist.remove(z-1);
        System.out.println("enter the new ans");
        q.rlist.add(z-1,scanner.nextLine());
        }
       
    }
     public void take()
    {
        Scanner scanner=new Scanner(System.in);
        List <Response> r=new ArrayList<Response>();
        for(int i=0;i<list.size();i++)
        {
            System.out.println(list.get(i));
            Response r1=list.get(i).getUserans();
            r.add(r1);
        }
        giveans.add(r);
        
        }    
     
    public void grade(List <Response> r, List <Response> r1)
    {
    System.out.println("here");
    
    List <String> q=new ArrayList<String>();
    List <String> q1=new ArrayList<String>();
   /* String rr=r.get(0).rlist.get(0);
    String rr1=r.get(0).rlist.get(1);
    String rr2=r1.get(0).rlist.get(0);
    String rr22=r1.get(0).rlist.get(1);
   q.add(rr);
   q.add(rr1);
   q1.add(rr2);
   q1.add(rr22);
  if( q.containsAll(q1))
      System.out.println("t");**/
    int grade=0;
    int total=0;
    for(int i=0;i<r.size();i++)
    {System.out.print("inside");
        total=total+10;
        q.clear();
        q1.clear();
        for(int q11=0;q11<r.get(i).rlist.size();q11++)
        {System.out.print("inside1");
            String z=r.get(i).rlist.get(q11);
            q.add(z);
        }
        for(int w=0;w<r1.get(i).rlist.size();w++)
        {System.out.print("inside2");
            String z=r1.get(i).rlist.get(w);
            q1.add(z);
        }
        if( q.containsAll(q1))
        { grade=grade+10;}
    }
    int count=0;
    for(int i=0;i<r.size();i++)
    {
        if(r1.get(i).rlist.get(0).equals("no ans"))
        {
        total=total-10;
        
        count++;
        }
    }
      System.out.println("your score is"+grade+"/"+total+"there were"+count+"essay questions therefore not graded");
    
    }
      public void tabulate()
   {
       try 
       {
           List<String[][]> table = new ArrayList<String[][]>();
           
           for (int i = 0; i < list.size(); i++)
           {
               //get all responsei
               List<Response> temp = new ArrayList<Response>();
               
               for (int j = 0; j < giveans.size(); j++)
               {
                   temp.add(giveans.get(j).get(i));
               }
               
               String[][] two = (list.get(i).tabulate(temp));
               table.add(two);

               System.out.println("Q"+i);
               
               
               for (int a = 0; a < two.length; a++)
               {
                   for (int b = 0; b < two[a].length; b++)
                   {
                       System.out.print(two[a][b]+": ");
                       
                   }
                 System.out.println();
               }
               
           }
           
           //{Q0={ee=1, we=1, me=1, se=1}}
           //{Q0={ee=1, we=1, me=1, se=1}}
           //{Q0={se=1}}
       } 
       catch (Exception ex) {}
   }
   
}
