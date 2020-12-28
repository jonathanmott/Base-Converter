
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class B {

    private int cnum;
    private int bnum;
    private List<String> numlist;
    private int ind;

    public void setBinaryArray(int conum, int bonum, List<String> numberlist) {
        this.cnum = conum;
        this.bnum = bonum;
        this.numlist = numberlist;
    }

    public List<String> getBinaryArray() {

        String[] cvalue;
        String dvalue;
        ArrayList<String> nvalue;

        List<Integer> declist = new ArrayList<Integer>(numlist.size());

        if (bnum == 2)// If cnum == 2, Binary then it dosent need to be converted and returns the same value 
        {
            return numlist;
        }
        for (String myInt : numlist) {// converts string list to integers and adds to int Array
            try {
                declist.add(Integer.valueOf(myInt));
            } catch (NumberFormatException e) {
                declist.add(null);
            }
            System.out.println(Arrays.asList(declist));
        }



        int size = declist.size();
        int base = 1;
        int sum;
        int r = 1;

        A a = new A();
        C c = new C();

        List<String> tr = new ArrayList<String>(size);
        StringBuilder k = new StringBuilder();
        Scanner scan = new Scanner(System.in);

        for (int j = 0; j <= size - 1; j++) {
            System.out.println(Arrays.asList(declist));
            System.out.printf("\n\n Iteration: %d \n ", j);
            int loop = 0;
            try {
                while ((declist.get(j) >= 1)) {

                    for (base = 1; (base * 2) <= declist.get(j);) {
                        base *= 2;
                        ++r;
                    }
                    loop++;
                    if (loop == 1) {
                        for (int m = 0; m < r; m++) {
                            k.append("0");
                        }
                    }
                    sum = declist.get(j) - base;
                    declist.set(j, sum); // puts new sum value into the declist array
                    k.replace(k.length() - (r), k.length() - (r - 1), "1");
                    System.out.println(Arrays.asList(declist));
                    System.out.println(k.toString());
                    scan.nextLine();
                    r = 1;
                }
                tr.add(j, k.toString());
                k.setLength(0);

            } catch (NullPointerException f) {
                k.replace(0, k.length(), ".");
                tr.add(j, k.toString());
                k.setLength(0);
            }
        }
        int sizetr = tr.size();
        System.out.println(Arrays.asList(tr));
        ind = bnum;

        switch (ind) {
            case 1, 2:
                break;
            case 3, 4:
                tr = FillBinary(tr, size, ind);
                String newnum = new String(c.concatonateDigits(tr));
                tr = new ArrayList<String>(a.seperateElements(tr, newnum));
                break;
        }
        return tr;
    }

    public List<String> FillBinary(List<String> ts, int sizetr, int ind) {

        StringBuilder str = new StringBuilder();
        int m = 0;

        System.out.println(Arrays.asList(ts));

        for (int h = 0; h < sizetr; h++) {
            int length = 0;
            System.out.println(str);
            str.append(ts.get(h));
            System.out.println(str);
            length = str.length();

            if (ts.get(h).contains(".")) {
                ts.set(h, ".");
                str.delete(0, str.length());
                if (ind == 1 || ind == 2) {
                    m = str.length();
                }
            } else {

                while (length < ind) {
                    str.insert(m, "0");
                    length++;
                }
                ts.set(h, str.toString());
                str.delete(0, str.length());
            }

            System.out.println(Arrays.asList(ts));
            System.out.println("End \n\n");
        }
        return ts;
    }
}