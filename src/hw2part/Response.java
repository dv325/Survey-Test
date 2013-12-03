/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hw2part;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Deepti
 */
public class Response implements Serializable{
    //this saves the answers of a test to a list
    protected List<String> rlist;
    protected String name;
    public Response()
    {
        rlist=new ArrayList<String>();
        name="";
    }
    //keeps adding the answer to the list rlist
    public void add(String ans)
    {
         rlist.add(ans);
    }
    public String toString()
    {//puts al the separate strings in the list in one string
        
        //System.out.println(rlist);
        String str = "";
        for (String s : rlist)
            str += s+" ";
        return str;
    }
    public void setName(String s)
    {
    name=s;
    
    }
    public int size()
    {
    return rlist.size();
    }
    public String get(int i)
    {
    
    return rlist.get(i);
    }
}
