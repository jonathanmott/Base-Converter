import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.math.BigDecimal;
/*
Title: Caclulator
Author: Jonathan Mott
Date: 
Decription: THis code converts any given number to another base.
Strings were used instead of pre defined functions for converting and caclulation to each of the bases.


*/
public class index {
    static boolean valid = true;

    static int i;
    static double process;
    static String results;
    static final String[] notation = { "Decimal", " Binary", "Octal", " Hexadecimal" };
    static Scanner sc = new Scanner(System.in);
    static String s = new String();

    public static void main(String[] args) {
        while (valid == true) {

            int bin = 0;
            int cin = 0;
            String baseNumber = " ";
            Exceptions d = new Exceptions();
            Exceptions e = new Exceptions();
            A a = new A();
            B b = new B();
            C c = new C();

            Format();
            System.out.printf("Choose a Base: ");
            bin = d.Except(bin);
            Format();
            System.out.printf("What Base you want it to be converted to?: ");
            cin = e.Except(cin);

            System.out.printf("Type in your number: ");
            if (cin == bin) {
                baseNumber = sc.next();

                System.out.printf("The number %s was unconverted: \n", baseNumber);
            } else {

                a.setNumList(bin, cin);// sends base and convert inputs in 

                List<String> numlist = a.getNumList();// takes input for number, and converts it into a string array
                                // with each value as an element in that array.
                b.setBinaryArray(cin, bin, numlist);// sends the inputs to convert to binary correctly;1
                System.out.println(Arrays.asList(numlist));
                List<String> midList = b.getBinaryArray();
                c.setFinalConversion(cin, midList);
                results = c.getFinalConversion();

                System.out.printf("The converted number is :\n %s", results);

            }
            System.out.println("Do you want to Continue?: \n\n1: Yes  2: No");
            i = sc.nextInt();
            if (i == 1) {
                valid = true;// Not needed
            } else if (i == 2) {
                valid = false;// False so while loop checks valid at end of loop and ends program
            } else {
                valid = false;
            }
        }
    }
    public static void Format() {
        System.out.println(String.format("\n1: %-5s \n2:%-5s \n3: %-5s \n4:%-5s", notation[0], notation[1], notation[2],
                notation[3]));
    }

    public void BaseConvert() {

    }
}