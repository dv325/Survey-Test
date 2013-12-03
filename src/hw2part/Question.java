/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hw2part;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Deepti
 */
//this is the abstract classes and has all the types of questions its children
public abstract class Question implements Serializable
{
    public Question()
    {
       
    }
    //gets the question
    public abstract void getQues();
    //gets the question user want to add on
    public abstract void modify();
    //returns question
    public abstract String toString();
    //gets the correctans if its a test
    public abstract Response getCorrectans();
    public abstract Response getUserans();
    public abstract int getType();
    public abstract String[][] tabulate(List <Response>r);
}
