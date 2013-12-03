/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hw2part;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Deepti
 */
public class Survey  implements Serializable{
            
    List<Question> list;//this list has all the questions of a survey
    String name;  
    List <List<Response>> giveans;
    public Survey()
    {
        name="";
        list= new ArrayList<Question>();
        giveans= new ArrayList<List<Response>>();
    }       
    public void setName(String s)
    {
    name=s;
    
    }
    public void fill()
    {
        Scanner scanner=new Scanner(System.in);
        int n11  =0;
        while(n11!=7)
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
          //here we handle the input if the user doesnot input a no.

          while(!n.matches("\\d"))
          {
          System.out.println("Input has to be a digit");
          n= scanner.nextLine();
          }
          n11 = Integer.parseInt(n);
          switch(n11)
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
    }}
    }
    public void addQuestion(Question q)
    {//this adds a question to the list
            q.getQues();
            list.add(q);
    }
    
    public void display(Survey s) 
    {//displays all the question currently in the list
       System.out.println(s.toString());
    
    }
    
    public String toString()
    {//get all the questions in the list 'list' to one string
        String str="";
        for( int i=0;i<list.size();i++)
        {
            str+=("Question"+(i+1)+")"+"\n"+list.get(i).toString()+"\n");
    
        }
        return str;
    }
           
    public  Survey load(File list, List<File> res) 
    {
        
        try
       {
           Survey s = new Survey(); 
           
           ObjectInputStream input = new ObjectInputStream(new FileInputStream(list));
           s.list = (List<Question>) input.readObject();
           s.setName(list.getName()); 
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
           
           input.close();
           System.out.println(s.giveans.size());
           for (int i=0;i<s.giveans.size();i++)
        {
        System.out.println(s.giveans.get(i));
        
        }
           
           return s;
       }
       catch(Exception ex)
       {
           System.err.println(ex.getMessage());
       }
        
       //check for null in main
       return null;

    }
 
           
    public void save(OutputStream out) 
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
    
    public void modify(Survey s)
    {
        Scanner scanner=new Scanner(System.in);
        display(s);
        System.out.println("which question no do you want to modify?");
        String g=scanner.nextLine();
        Question q=s.list.get(Integer.parseInt(g)-1);
        q.modify();
        
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
    

   
   
