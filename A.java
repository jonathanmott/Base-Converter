import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class A {
    static String dec = " ";
    static Scanner scan = new Scanner(System.in);
   
    private int bin;
    private int cin;

    // StringBuffer sb = new StringBuffer(bnum);
    // List<String> mylist = new ArrayList<String>();
    // List<String> stored = new ArrayList<String>();
    public void setNumList(int bnum, int cnum) {
        this.bin = bnum;
        this.cin = cnum;
    }

    public List<String> getNumList() {
        List<String> arrOfNum = new ArrayList<String>();
        List<String> arrOfHO = new ArrayList<String>();
        List<String> arra = new ArrayList<String>();
        String bnumber;
        bnumber = scan.next();

        switch (bin) {
            case 1,2:
                arra = seperateElements(arra, bnumber);
                arrOfNum.addAll(arra);
                return arrOfNum;

            case 3, 4:

                arra = new ArrayList<String>(Arrays.asList(bnumber.split("")));
                arrOfHO.addAll(arra);

                if (bin == 4) {

                    final Map<String, Integer> map;
                    map = new HashMap<>();
                    map.put("A", 10);
                    map.put("B", 11);
                    map.put("C", 12);
                    map.put("D", 13);
                    map.put("E", 14);
                    map.put("F", 15);

                    for (int i = 0; i < arrOfHO.size(); ++i) {
                        String c1;
                        c1 = arrOfHO.get(i);
                        c1 = c1.toUpperCase();

                        if (map.containsKey(c1)) {

                            int some = (Integer) map.get(c1);
                            String s = String.valueOf(some);
                            arrOfHO.set(i, s);
                            System.out.println(s);
                        }
                    }
                }
                System.out.println(Arrays.asList(arrOfNum));
                System.out.println(Arrays.asList(arrOfHO));

                return arrOfHO;
        }
        return null;
    }

    public List<String> seperateElements(List<String> arra, String bnumber) {// This is the Issue

        arra = new ArrayList<String>();
        StringTokenizer st = new StringTokenizer(bnumber, "\\.", true);
        while (st.hasMoreTokens()) {
            System.out.println("This is array:");
            arra.add(st.nextToken().trim());
            System.out.println(Arrays.asList(arra));
        }
        return arra;
    }
}