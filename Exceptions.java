import java.util.Scanner;

public class Exceptions {

    static Scanner scan = new Scanner(System.in);

    public int Except(int except) {

        while (except < 1 || except > 4) {
            try {
                except = scan.nextInt();
                if (except < 1 || except > 4) {
                    System.out.printf("The input was incorrect. Try again: ");
                }
                
            } catch (Exception e) {
                System.out.printf("The input was incorrect. Try again: ");
                scan.next();
            }
        }
        return except;
    }

    public void ex() {
        try {
            scan.nextInt();
        } catch (Exception e) {
        }
    }
}