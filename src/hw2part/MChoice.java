/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hw2part;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Deepti
 */
public class MChoice extends Question {
    protected int choices;
    LinkedList<String> list;
    String ques;
    String fullques;
    int type;
    MChoice()
    {
        super();
        type=2;
        ques="";
        fullques="";
        list= new LinkedList<String>();
    }
    
    @Override
   public String[][] tabulate( List<Response> r) 
   {
       String[][] twod = new String[list.size()][2];
       
       for (int a = 0; a < twod.length; a++)
       {
           twod[a][0] = list.get(a);
           twod[a][1] = "0";
       }
       
       
       //horizontal 
           for (int j = 0; j < r.size(); j++)
           {
               Response res = r.get(j);
               
               for (int k = 0; k < res.size(); k++)
               {
                   int index = Integer.parseInt(res.get(k))-1;
                   
                   twod[index][1] = (Integer.parseInt(twod[index][1])+1)+"";
               }
           }
       return twod;
   }
    @Override
    public int getType()
    {
    return type;
    }

    public void noChoices()
    {
        Scanner scanner=new Scanner(System.in);
        System.out.println("enter the no of choices you want to give");
        String s;
        s= scanner.nextLine();
        while(!s.matches("\\d"))
        {
        System.out.println("input has to b a digit");
        s= scanner.nextLine();
        }
        choices=Integer.parseInt(s);
    }
    //we get all the choices fro the question
    public void getChoices()
    {  Scanner scanner=new Scanner(System.in);
       String s;
       list.clear();
       for(int i=0;i<choices;i++)
       {
            System.out.println("enter the choice");
            s= scanner.nextLine();
            list.add(s);
       }
    }

    @Override
    public void getQues() 
    {   //here we get the multiple choice question which has choices too
        Scanner scanner=new Scanner(System.in);
        String s;
        System.out.println("enter the question");
        ques= scanner.nextLine();
        noChoices();
        getChoices();
        ques="this is multiple choice"+"\n"+ques;
        fullques=ques;
        for(int i =0;i<list.size();i++)
        {
           fullques=fullques+"\n"+(i+1)+")"+list.get(i);
        }
     /*   String n11=  list.pollFirst() ;
        ques="this is multiple choice"+"\n"+s+"\n"+"1)"+" "+n11;
        int i=2;
        while(n11!= null)
        {
            n11=list.pollFirst();
            String str = Integer.toString(i);
            if(n11!=null)
                ques=ques+"\n"+""+str+" "+n11;
            i=i+1; 
        }**/

    }
    
    @Override
    public String toString()
    { 
        return fullques;
    }
    
    @Override
    public void modify()
    {  
        Scanner scanner=new Scanner(System.in);
        System.out.println("you want to modify the question then enter 1 or else 2 for modifying  the choices");
        
        int ss= Integer.parseInt(scanner.nextLine());
        if(ss==1)
        {
        System.out.println("enter new ques");
        ques= scanner.nextLine();
        ques="this is multiple choice"+"\n"+ques;
        fullques=ques;
        for(int i =0;i<list.size();i++)
        {
           fullques=fullques+"\n"+(i+1)+")"+list.get(i);
        }}
        if(ss==2)
        {
        getChoices();
        fullques=ques;
        for(int i =0;i<list.size();i++)
        {
           fullques=fullques+"\n"+(i+1)+")"+list.get(i);
        }
        
        }
    }
    @Override
    public Response getCorrectans()
    {  
        Scanner scanner=new Scanner(System.in);
        System.out.println("multiple choice can have multiple ans./keep entering the choice"
                + " and when u r done quit");
        String  s= scanner.nextLine();
        //user cannot leave the answer null therefor we check if the input is null
        while(s.isEmpty())
              {
                   System.out.println("ans cannot be left empty");
                   s= scanner.nextLine();

              }
                 //we create an object of class response and add the correct ans to the list of type response

              Response r=new Response();
              
              //user gives multiple ans to the question
              while(!s.equals("quit"))
              {
                    
                    if(!s.equals("quit"))
                    {
                     r.add(s);
              s= scanner.nextLine();
                    }
              }
             // System.out.println(r);
              return r;
        
    }
    @Override
    public Response getUserans()
    {  
        Scanner scanner=new Scanner(System.in);
        System.out.println("multiple choice can have multiple ans./keep entering the choice"
                + " and when u r done quit");
        String  s= scanner.nextLine();
        //user cannot leave the answer null therefor we check if the input is null
        while(s.isEmpty())
              {
                   System.out.println("ans cannot be left empty");
                   s= scanner.nextLine();

              }
                 //we create an object of class response and add the correct ans to the list of type response

              Response r=new Response();
              
              //user gives multiple ans to the question
              while(!s.equals("quit"))
              {
                    
                    if(!s.equals("quit"))
                    {
                     r.add(s);
              s= scanner.nextLine();
                    }
              }
             // System.out.println(r);
              return r;
        
    }
    }
