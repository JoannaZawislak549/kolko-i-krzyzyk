import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Gra {
    public static final Scanner scanner = new Scanner(System.in);

    public static void showBoardNumeration(){
        String line = "-----------";
        String firstRow = " " + "1" + " " + "|" + " " +
                "2" + " " + "|" + " " + "3" + " ";
        String secRow = " " + "4" + " " + "|" + " " +
                "5" + " " + "|" + " " + "6" + " ";
        String thirdRow = " " + "7" + " " + "|" + " " +
                "8" + " " + "|" + " " + "9" + " ";
        System.out.println(firstRow);
        System.out.println(line);
        System.out.println(secRow);
        System.out.println(line);
        System.out.println(thirdRow);
        System.out.println("Jeśli chcesz wybrać dane pole po prostu wpisz jego numer");
    }

    public static int askPlayer(String symbol, ArrayList<ArrayList<String>> board){
        while(true) {
            System.out.println("Gracz" + symbol + ": Gdzie chcesz postawić " + symbol + "?");
            showBoard(board);
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice < 1 || choice > 9) {
                System.out.println("Wybór niepoprawny. Spróbuj ponownie. Podaj liczbę z zakresu (1-9)");
                showBoardNumeration();
                continue;
            }
            int row = (choice - 1) / 3;
            int col = (choice - 1) % 3;

            if (!board.get(row).get(col).equals(" ")) {
                System.out.println("Pole zajęte. Wybierz inne.");
                showBoardNumeration();
            } else {
                return choice;
            }
        }
    }

    public static void addToBoard(String symbol, int choice, ArrayList<ArrayList<String>> board){
        int row = (choice - 1)/3;
        int col = (choice - 1)%3;
        board.get(row).set(col, symbol);
    }

    public static void showBoard(ArrayList<ArrayList<String>> board){
        String line = "-----------";
        String firstRow = " " + board.get(0).get(0) + " " + "|" + " " +
                board.get(0).get(1) + " " + "|" + " " + board.get(0).get(2) + " ";
        String secRow = " " + board.get(1).get(0) + " " + "|" + " " +
                board.get(1).get(1) + " " + "|" + " " + board.get(1).get(2) + " ";
        String thirdRow = " " + board.get(2).get(0) + " " + "|" + " " +
                board.get(2).get(1) + " " + "|" + " " + board.get(2).get(2) + " ";
        System.out.println(firstRow);
        System.out.println(line);
        System.out.println(secRow);
        System.out.println(line);
        System.out.println(thirdRow);
    }

    public static boolean whoWon(ArrayList<ArrayList<String>> board){
        for (int i = 0; i < 3; i++) {
            if (board.get(i).get(0).equals(board.get(i).get(1)) &&
                    board.get(i).get(1).equals(board.get(i).get(2))
                    && !board.get(i).get(0).equals(" ")) {
                return true;
            } else if (board.get(0).get(i).equals(board.get(1).get(i)) &&
                    board.get(1).get(i).equals(board.get(2).get(i))
                    && !board.get(0).get(i).equals(" ")) {
                return true;
            }
        }
        if (board.get(0).get(0).equals(board.get(1).get(1)) &&
                board.get(1).get(1).equals(board.get(2).get(2))
                && !board.get(0).get(0).equals(" ")) {
            return true;
        } else return board.get(2).get(0).equals(board.get(1).get(1)) &&
                board.get(1).get(1).equals(board.get(0).get(2))
                && !board.get(2).get(0).equals(" ");
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<String>> board = new ArrayList<ArrayList<String>>();
        for (int i = 0; i < 3; i++) {
            board.add(new ArrayList<>(Arrays.asList(" ", " ", " ")));
        }
        String currentPlayer = "X";
        showBoardNumeration();
        for(int i = 0; i < 9; i++){
            addToBoard(currentPlayer, askPlayer(currentPlayer,board), board);

            if (whoWon(board)){
                System.out.println("Wygrywa Gracz " + currentPlayer);
                break;
            }
            if (i == 8) {
                System.out.println("Remis!");
                break;
            }

            currentPlayer = currentPlayer.equals("X") ? "O" : "X";
        }
        showBoard(board);
    }
}
