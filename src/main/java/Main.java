import org.scala.*;
import java.io.*;
import board.*;

public class Main {
    public static final int USER = 1;
    public static final int ROBOT = -1;
    public static void main(String[] argv) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String nextLine = null;
            int turn = USER; // User goes first

            System.out.print("What is the board size? ");
            int size = Integer.parseInt(br.readLine());
            Board brd = new Board(size);

            do {
                if (nextLine != null) {
                    // do stuff here
                    try {
                        String[] strCoords = nextLine.split(",");
                        int[] coords = new int[strCoords.length];
                        for (int i = 0; i < strCoords.length; i++) {
                            coords[i] = Integer.parseInt(strCoords[i]);
                        }
                        brd.setCell(coords[0], coords[1], turn);
                    } catch (BoardException e) {
                        System.out.print("Invalid coordinates. What is your move? ");
                        continue;
                    }
                }

                System.out.print("It's now " + turnToString(turn) + "'s turn. What is your move? ");
            } while ((nextLine = br.readLine()) != null);

        } catch (IOException io) {
            System.out.println("IO error:");
            io.printStackTrace();
        }
    }

    public static String turnToString(int turn) {
        return turn == USER ? "USER" : "ROBOT";
    }

    private static int toggleTurn(int turn) {
        return turn == USER ? ROBOT : USER;
    }
}