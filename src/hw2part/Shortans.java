/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hw2part;

import java.util.Scanner;

/**
 *
 * @author Deepti
 */
public class Shortans extends Essay{
    String ques;
    Shortans()
    { 
        super();
        type=3;
        ques="This is short ans question";
    }
    @Override
        public int getType()
        {
        return type;
        }
 @Override
    public void getQues() 
    {  
        Scanner scanner=new Scanner(System.in);
        String s;
        System.out.println("enter the question");
        s= scanner.nextLine();    
        ques=ques+"\n"+s;
    }
@Override
    public Response getCorrectans()
    {  
        Scanner scanner=new Scanner(System.in);
        System.out.println("short ans can have multiple ans./keep entering and when u r done quit");
        String  s= scanner.nextLine();
        //user cannot leave the answer null therefor we check if the input is null
        while(s.isEmpty())
              {
                   System.out.println("ans cannot be left empty");
                   s= scanner.nextLine();

              }
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
        System.out.println("short ans can have multiple ans./keep entering and when u r done quit");
        String  s= scanner.nextLine();
        //user cannot leave the answer null therefor we check if the input is null
        while(s.isEmpty())
              {
                   System.out.println("ans cannot be left empty");
                   s= scanner.nextLine();

              }
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
        public String toString() 
        {
            return ques;
        }
       

@Override
        public void modify() 
        {  
            getQues();
        }
}
