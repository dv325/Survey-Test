/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hw2part;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Deepti
 */
public class Essay extends Question
{
    
        String ques;
        int type;
        Essay()
        {
            super();
            ques="";
            type=4;
        }
        @Override
        public int getType()
        {
        return type;
        }
@Override
   public String[][] tabulate( List<Response> r) 
   {
       String[][] twod = new String[r.size()][2];
       
       for (int a = 0; a < twod.length; a++)
       {
           twod[a][0] = "Response"+a;
           twod[a][1] = "";
       }
       
       
       //horizontal 
           for (int j = 0; j < r.size(); j++)
           {
               Response res = r.get(j);
               twod[j][1] = convertResponses(res);
               
           }
       return twod;
       
   }
        @Override
        public void getQues() 
        {  
            Scanner scanner=new Scanner(System.in);
            System.out.println("enter the question");
            ques= scanner.nextLine();    
            ques="this is multiple choice"+"\n"+ques;
            
        }

        @Override
        public void modify() 
        {  
            Scanner scanner=new Scanner(System.in);
            System.out.println("enter the question");
            ques= scanner.nextLine();    
            ques="this is multiple choice"+"\n"+ques;
        }

        @Override
        public String toString() 
        {
            return ques;
        }
       
        @Override
        public Response getCorrectans() 
        {
              Scanner scanner=new Scanner(System.in);
              System.out.println("essay does not have a admin ans");
              String  s= "no ans";
              //user cannot leave the answer null therefore we ask them to give a poper input
             
              Response r=new Response();
              //user gives multiple ans to the question
              
                    
                     r.add(s);
              
              
              return r;
       }
        @Override
        public Response getUserans()
        {
        Scanner scanner=new Scanner(System.in);
        System.out.println("essays can have multiple ans./keep entering and when u r done quit");
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
        private String convertResponses(Response r)
        {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<r.size();i++)
        {
            sb.append(r.get(i));
        
        }
        return sb.toString();
        }


    
}
