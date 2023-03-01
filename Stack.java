/*
 * @author Narongchai Rongthong
 * 652115013
 * written on 28/02/2023
 * https://github.com/t1ww
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Stack {
    int top = -1;
    int size;
    String[] list;
    public Stack(){
        this.size = 20;
        this.list = new String[size];
    }
    public Stack(int s){
        this.size = s;
        this.list = new String[size];
    }
    public void push(String v){
        if(top == size -1){
            System.out.println("!!! the stack is full");
        }else{
            list[++top] = v;
        }
    }
    public String pop(){
        String temp = list[top];
        if(top > -1){
            list[top] = null;
            top--;
        }
        return temp;
    }
    public void peek(){
        if(top == -1){
            System.out.println("!!! Stack is empty");
        }else{
            System.out.println("top is " + list[top]);
        }
    }
    public boolean isEmpty(){
        return (top == -1)? true : false;
    }
    public boolean isFull(){
        return (top == size-1)? true : false;
    }
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("input"));
        Stack stk = new Stack();
        String dataLine = scan.nextLine();
        // iterate each char of the string
        for (int i = 0; i < dataLine.length(); i++) {
            String tok = Character.toString(dataLine.charAt(i));
            if(isNumeric(tok)){
                stk.push(tok);
            }else{
            Integer pint;
                switch(tok){
                    case "+" :
                        pint = Integer.parseInt(stk.pop()) + Integer.parseInt(stk.pop());
                        stk.push(pint.toString());
                    break;
                    case "-": 
                        pint = Integer.parseInt(stk.pop()) - Integer.parseInt(stk.pop());
                        stk.push(pint.toString());
                    break; 
                    case "*" :
                        pint = Integer.parseInt(stk.pop()) * Integer.parseInt(stk.pop());
                        stk.push(pint.toString());
                    break;
                    case "/" :
                        pint = Integer.parseInt(stk.pop()) / Integer.parseInt(stk.pop());
                        stk.push(pint.toString());
                    break;
                }
            }
        }
        stk.peek();
}
    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}