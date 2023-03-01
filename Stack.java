/*
 * @author Narongchai Rongthong
 * 652115013
 * written on 28/02/2023
 * https://github.com/t1ww
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

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
        if(isFull()){
            System.out.println("!!! the stack is full");
        }else{
            list[++top] = v;
        }
    }
    public String pop(){
        String temp = list[top];
        list[top] = null;
        top--;
        return temp;
    }
    public void peek(){
        if(top == -1){
            System.out.println("!!! Stack is empty");
        }else{
            System.out.println("top is " + list[top]);
        }
    }
    public void clear(){
        while(!isEmpty()){
            pop();
        }
    }
    public boolean isEmpty(){
        return (top == -1)? true : false;
    }
    public boolean isFull(){
        return (top == size-1)? true : false;
    }
    public int size(){
        return top;
    }
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("input"));
        Stack stk = new Stack();
        while(scan.hasNextLine()){ // for each lines
            String dataLine = scan.nextLine();
            // iterate each char of the string
            for (int i = 0; i < dataLine.length(); i++) {
                String tok = Character.toString(dataLine.charAt(i));
                if(isNumeric(tok)){ // found number
                    stk.push(tok);// add the number to stack
                }else{
                Integer pint;
                if(stk.size() > 1) // if there's at least 2 elements in stack
                    switch(tok){ // found operators do calculation and push result in the stack
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
                        default : // found other letters
                            stk.clear();
                            i = dataLine.length()-1;// break this for loop
                        break;
                        
                    }
                }
            }
            isValid(stk);
            stk.clear();
            // end line
        }
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
    public static void isValid(Stack stack){ // change to boolean
        if (stack.size() == 0 && isNumeric(stack.pop())) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid");
        }
    }
}