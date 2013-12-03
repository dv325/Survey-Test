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
public class Ranking extends Question
{
    
    String ques;
    int type;
    Ranking()
    {            
        super();
        ques="Rank the following"+"\n";
        type=5;
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
        System.out.println("enter the items to be ranked");
        System.out.println("enter quit when you are done");
        String match1 = scanner.nextLine();
        int i=1;
        ques=ques+i+")"+match1+"\n";    
        while(!match1.equals("quit"))
        {   i=i+1;
           match1 = scanner.nextLine();
           if( !match1.equals("quit"))
           {
                ques=ques+i+")"+match1+"\n";
           }
        }
    }

    @Override
    public void modify() 
    {
        getQues();  
    
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
        System.out.println("enter the ans as 1342"
                + " and then enter quit");
        String s=scanner.nextLine();
        //user cannot leave the answer null therefor we check if the input is null
        while(s.isEmpty())
              {
                   System.out.println("ans cannot be left empty");
                   s= scanner.nextLine();

              }
                 //we create an object of class response and add the correct ans to the list of type response

              Response r=new Response();
              
              //user gives multiple ans to the question
              
                     r.add(s);
              
             // System.out.println(r);
              return r;
        
    }
    
    @Override
    public Response getUserans() 
    {  
        Scanner scanner=new Scanner(System.in);
        System.out.println("enter the ans as 1342" +" and then enter quit");
        String s=scanner.nextLine();
        //user cannot leave the answer null therefor we check if the input is null
        while(s.isEmpty())
              {
                   System.out.println("ans cannot be left empty");
                   s= scanner.nextLine();

              }
                 //we create an object of class response and add the correct ans to the list of type response

              Response r=new Response();
              
              //user gives multiple ans to the question
              
                     r.add(s);
              
             // System.out.println(r);
              return r;
        
    }

    @Override
    public String[][] tabulate(List<Response> r) 
   {
               
       String[][] twod = new String[r.size()][2];
       
       for (int a = 0; a < twod.length; a++)
       {
           twod[a][0] = convertResponses(r.get(a));
           twod[a][1] = "0";
       }
       
       //horizontal 
       for (int i = 0; i < r.size(); i++)
       {
           Response res = r.get(i);
           for (int j = 0; j < twod.length; j++)
           {
               if (convertResponses(res).equalsIgnoreCase(twod[j][0]))
               {
                   twod[j][1] = (Integer.parseInt(twod[j][1])+1)+"";
               }
           }
       }
       return twod;
   }
     private String convertResponses(Response r)
        {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<r.size();i++)
        {
            sb.append(r.get(i)).append(" ");
        
        }
        return sb.toString();
        }
}
