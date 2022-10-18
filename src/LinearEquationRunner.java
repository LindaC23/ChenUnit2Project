import java.util.Scanner;

public class LinearEquationRunner {
    public static void main(String[] args) {
        // creating Scanner object
        Scanner scan = new Scanner(System.in);

        // welcoming the user and prompting them to enter coordinates
        System.out.println("Welcome!");
        System.out.print("Enter coordinate 1: ");
        String coord1 = scan.nextLine();
        System.out.print("Enter coordinate 2: ");
        String coord2 = scan.nextLine();

        // getting the values of the coordinate points
        int x1 = Integer.parseInt(coord1.substring(coord1.indexOf("(") + 1, coord1.indexOf(",")));
        int y1 = Integer.parseInt(coord1.substring(coord1.indexOf(", ") + 2, coord1.indexOf(")")));
        int x2 = Integer.parseInt(coord2.substring(coord2.indexOf("(") + 1, coord2.indexOf(",")));
        int y2 = Integer.parseInt(coord2.substring(coord2.indexOf(", ") + 2, coord2.indexOf(")")));

        // creating LinearEquation object
        LinearEquation lineareq = new LinearEquation(x1, y1, x2, y2);
        System.out.println(lineareq.lineInfo());

    }
}
