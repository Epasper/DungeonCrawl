import java.util.Scanner;

public class algorithm {
    public static void main(String[] args) {
        int changeDetected = 1;
        System.out.println("Type X dim");
        double x = new Scanner(System.in).nextInt();
        System.out.println("Type Y dim");
        double y = new Scanner(System.in).nextInt();
        for (int i = 1; i < y + 1; i++) {
            for (int j = 1; j < x + 1; j++) {
                if (i == (Math.round(j * (y / x)))) {
                    if (x > y) {
                        changeDetected = j;
                    } else {
                        changeDetected = j + 1;
                    }
                    System.out.print("[X]");
                } else if (j == changeDetected) {
                    System.out.print("[" + j + "]");
                } else {
                    System.out.print("[ ]");
                }
                //System.out.println(j);
                //System.out.println(Math.round(j*(y/x)));
            }
            System.out.println();
        }
    }
}