import java.math.BigDecimal;
import java.util.List;
import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;

public class C {

    private List<String> fnum;
    private int cnum;
    List<String> result;
    String finalresult;

    public void setFinalConversion(int conum, List<String> finalnum) {
        this.cnum = conum;
        this.fnum = finalnum;
    }

    public String getFinalConversion() {
        B

        b = new B();
        String splitlength = "0";

        if (cnum == 3) {
            splitlength = "(?<=\\G...)";
        } else if (cnum == 4) {
            splitlength = "(?<=\\G....)";
        }

        switch (cnum) {

            case 1:

                result = numberConvert(fnum);

                // fnum = concatonateDigits(fnum);
            case 2:
                result = fnum;
                // result = convertedFromBinary(fnum, splitlength);

                /*
                 * // List<String> digits; StringBuilder sb = new StringBuilder(fnum.size());
                 * for (String digit : fnum) { sb.append(digit); }
                 * 
                 * System.out.println(Arrays.asList(sb)); System.out.println(Arrays.asList(sb));
                 * Arrays.asList(sb.toString());
                 */
                break;
            case 3, 4:

                fnum = convertedFromBinary(fnum, splitlength);// Splits up decimal or binary
                System.out.println(Arrays.asList(fnum.size()));
                fnum = b.FillBinary(fnum, fnum.size(), cnum);// filld remainig space with 0 or 1s
                System.out.println(Arrays.asList(fnum));
                System.out.println(Arrays.asList(fnum));
                System.out.println(Arrays.asList(fnum));

                fnum = numberConvert(fnum);// converts it to a number
                finalresult = concatonateDigits(fnum);
                break;

        }
        return finalresult;
    }

    public List<String> convertedFromBinary(List<String> fc, String sl) {
        List<String> seq;
        List<String> neworder = new ArrayList<String>();
        Boolean afterDecimalPoint = false;

        if (sl == "0") {
        } else {
            for (int h = 0; h < fnum.size(); h++) {// dermial

                StringBuilder rev = new StringBuilder().append(fc.get(h)).reverse();
                System.out.println(rev);

                if (fc.get(h).contains(".")) {
                    afterDecimalPoint = true;
                }
                if (afterDecimalPoint == true) {
                    rev.reverse();
                }

                seq = new ArrayList<String>(Arrays.asList(rev.toString().trim().split(sl)));

                System.out.println(Arrays.asList(seq));
                for (int swap = 0; swap * 2 < seq.size(); swap++) {
                    Collections.swap(seq, swap, (seq.size() - 1) - swap);
                    System.out.println(Arrays.asList(seq));
                }

                for (int u = 0; u < seq.size(); u++) {
                    rev = new StringBuilder().append(seq.get(u)).reverse();
                    neworder.add((rev.toString()));
                    System.out.println("Final ones");
                }
            }
        }
        return neworder;
    }

    public List<String> numberConvert(List<String> nc) {
        StringBuilder cv;
        int c = 0;
        int[] ch = {1, 2, 8, 16,2};
       
        int base = ch[0];
        List<String> indlist = new ArrayList<>();
        int var = ch[4];
        Boolean afterDecimalPoint = false;

        for (int k = 0; k < nc.size(); k++) {
            cv = new StringBuilder().append(nc.get(k)).reverse();

            if (cv.indexOf(".") >= 0) {
                indlist.add("null");
                System.out.println(Arrays.asList(indlist));
                if (cnum == 1) {
                    c = 1;
                    var = ch[c];
                    afterDecimalPoint = true;
                }
                else if (cnum == 3) {
                    c = 2;
                    var = ch[c];
                    afterDecimalPoint = true;
                }else if (cnum == 4) {
                    c = 3;
                    var = ch[c]; 
                    afterDecimalPoint = true;
                }

            } else {
                int index = 0;
                int strvl = 0;
                if (afterDecimalPoint == true) {
                    cv.reverse();
                }
                index = cv.indexOf("1");
                System.out.println(index);
                System.out.println(Arrays.asList(cv));
                while (index >= 0) {

                    base = ch[c];
                    for (int g = 0; g < index; g++) {
                        base *= var;
                    }
                    strvl += base;
                    index = cv.indexOf("1", index + 1);
                    System.out.println(index);
                }
                //int adec = String.valueOf(strvl).substring(cv.indexOf(".")).length() - 1;
                //System.out.println(adec);

                indlist.add(Integer.valueOf(strvl).toString());
                
            }
            System.out.println(Arrays.asList(indlist));
        }
        return indlist;
    }

    public String concatonateDigits(List<String> digits) {
        StringBuilder sb = new StringBuilder(digits.size());

        for (String digit : digits) {
            if (digit == "null") {
                sb.append(".");
            } else {
                sb.append(digit);
            }
        }
        System.out.println(Arrays.asList(sb));

        return sb.toString();
    }
}