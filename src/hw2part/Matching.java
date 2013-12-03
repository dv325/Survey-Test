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
public class Matching extends Question
{
       LinkedList<String> left;//this has the left column choces
       LinkedList<String> right;//this has right column choices
       String ques;
       String fullques;
       int type;
       Matching()
       {
           super();
           type=6;
           ques =  "Match the following ";
           right= new LinkedList<String>();
           left= new LinkedList<String>();
       }
       @Override
        public int getType()
        {
        return type;
        }
       public void getLeft()
       {
       
       System.out.println("Enter left column items");
            System.out.println("enter quit when you are done");
            Scanner scanner=new Scanner(System.in);
            String match = scanner.nextLine();
            String first=match;
            left.add(first);
            //we add all the left column choices to the linkedlist left
            while(!match.equals("quit"))
            {
                match = scanner.nextLine();
                if(!match.equals("quit"))
                {
                    first=match;
                    left.add(first);
                }
            }
       }
        public void getRight()
        {
            Scanner scanner=new Scanner(System.in);
            System.out.println("Enter right column items");
            System.out.println("enter quit when you are done");
            String match1 = scanner.nextLine();
            String first1=match1;
            right.add(first1);
           //we add all the right column choices to the linkedlist right
            while(!match1.equals("quit"))
            {
                match1 = scanner.nextLine();
                if(!match1.equals("quit"))
                {
                    first1=match1;
                    right.add(first1);
                }
                
            }
        
        }
       
       
       @Override
       public void getQues() 
       {    
           Scanner scanner=new Scanner(System.in);
           System.out.println("Enter the question");
       
            ques=ques+scanner.nextLine();
            getLeft();
            getRight();
            
            int s=left.size();
            int s1=right.size();
            while(s!=s1)
            {left.clear();
            right.clear();
            System.out.println("No of left and right choices should be same");
            System.out.println("give the inputs again");
            getLeft();
            s=left.size();
            

            getRight();
            s1=right.size();
                        

            }
            
            
            
            //here we put all the elements of left and right in proper format as follows
            /*
             * a    a
             * b    b
             * f    c
             * c
             * d
             */
        
            
        fullques=ques;
        int j1 = 0;
        while (j1 < left.size())
        {
            
            fullques += "\n"+(j1+1)+") "+left.get(j1);
            fullques += "      "+(j1+1)+") "+right.get(j1);
            j1++;
        }
       }

   @Override
   public void modify() 
   {
        Scanner scanner=new Scanner(System.in);
        System.out.println("U want to modify the 1)question 2)left choices 3)right choices");
        if(scanner.nextLine().equals("1"))
        {
        System.out.println("enter the question");
        ques=ques+ scanner.nextLine(); 
        fullques=ques;
        int j1 = 0;
        while (j1 < left.size())
        {
            
            fullques += "\n"+(j1+1)+") "+left.get(j1);
            fullques += "\n"+(j1+1)+") "+right.get(j1);
            j1++;
        }}
        if(scanner.nextLine().equals("2"))
        {
        getLeft();
        while(right.size()!=left.size())
            {
            System.out.println("No of left and right choices should be same");
            System.out.println("give the inputs again");
            getLeft();
            }
        fullques=ques;
        int j1 = 0;
        while (j1 < left.size())
        {
            
            fullques += "\n"+(j1+1)+") "+left.get(j1);
            fullques += "\n"+(j1+1)+") "+right.get(j1);
            j1++;
        }}
        if(scanner.nextLine().equals("2"))
        {
        getRight();
        while(right.size()!=left.size())
            {
            System.out.println("No of left and right choices should be same");
            System.out.println("give the inputs again");
            getRight();
            }
        fullques=ques;
        int j1 = 0;
        while (j1 < left.size())
        {
            
            fullques += "\n"+(j1+1)+") "+left.get(j1);
            fullques += "\n"+(j1+1)+") "+right.get(j1);
            j1++;
        }
                
        }
   }

   @Override
   public String toString()
   {
       return fullques;
   }

   @Override
   public Response getCorrectans() 
   {    
        
         
           
        Scanner scanner=new Scanner(System.in);
        System.out.println("enter the pair as 1,2 and keep entering the pairs"
                + " and when u r done quit");
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
        System.out.println("enter the pair as 1,2 and keep entering the pairs"
                + " and when u r done quit");
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
