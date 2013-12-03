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
public class TF extends MChoice{
    String ques;
    String fullques;
    int type;
    
    public TF()
    {
      super();
      choices=2; 
      type=1;
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
        ques= scanner.nextLine();
        getChoices();
        ques="this is true or false"+"\n"+ques;
       
           fullques=ques+"\n"+"1)"+list.get(0)+"2)"+list.get(1);
    
   }
    
   @Override
    public void getChoices()
    {
       String s;
       
            s= "true";
            list.add(s);
            s= "false";
            list.add(s);
       
    }
   @Override
        public void modify() 
        {  
            Scanner scanner=new Scanner(System.in);
            System.out.println("enter the question");
            String s= scanner.nextLine();    
            ques="answer in true or false"+"\n"+s;
            fullques=ques+"\n"+"1)"+list.get(0)+"2)"+list.get(1);

            
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

        //user cannot leave the answer null therefor we check if the input is null
         
        
        //we create an object of class response and add the correct ans to the list of type response
        
        System.out.println("enter the ans 1 for true and 2 for false");
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
              
                     r.add(s);
              
             // System.out.println(r);
              return r;
    }
    public Response getUserans()
    {  
        
                Scanner scanner=new Scanner(System.in);

        //user cannot leave the answer null therefor we check if the input is null
         
        
        //we create an object of class response and add the correct ans to the list of type response
        
        System.out.println("enter the ans");
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
              
                     r.add(s);
              
             // System.out.println(r);
              return r;
    }
}
