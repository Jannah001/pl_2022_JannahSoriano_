import java.util.Scanner;
import java.util.regex.Pattern;
public class Tokenizer_Lab3 {
    public static String x = "",dt = "int\tdouble\tchar\tString",operator="=",value="t0123456789"
            ,delimiter=";" ,opt="";
    public static  void print(){
        if(Pattern.matches("[0-9,.00]+",x)){
            System.out.print(" <value>");
        }
        else if(Pattern.matches("[A-Za-z]+",x)){
            if(dt.contains(x)){
                System.out.print(" <data type> ");
            }
            else {
                System.out.print(" <identifier> ");
            }
        }
        x="";
    }
    // prints operators
    public static void printop(){
        System.out.print(" <assignment operator> ");
        opt= "";
    }
    // identifies the tokens and converts lexemes into tokens
    public static void tokenizer(String s){
        for (int i = 0; i < s.length(); i++){
            String c = s.substring(i,i+1);
            if(c.equals(" ")) {
                if(!x.isEmpty()) print();
                if(!opt.isEmpty()) printop();
            }
            else if(operator.contains(c)){
                if(!x.isEmpty()) print();
                opt +=c;
            }
            else if(delimiter.contains(c)){
                if(!x.isEmpty()) print();
                if(!opt.isEmpty()) printop();
                System.out.println(" <delimiter> ");
            }
            else{
                if(!opt.isEmpty()) printop();
                x += c;
            }
        }
    }

    public static void main(String[] args) {
        System.out.print("Enter source Language : ");
        Scanner sc = new Scanner(System.in);
        String a = sc. nextLine();
        Tokenizer_Lab3 t = new Tokenizer_Lab3();
        t.tokenizer(a);
    }
}
