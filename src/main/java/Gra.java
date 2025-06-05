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

    public static int askFirstPlayer(ArrayList<ArrayList<String>> board){
        System.out.println("Gracz 1: Gdzie chcesz postawić X?");
        showBoard(board);
        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }

    public static int askSecondPlayer(ArrayList<ArrayList<String>> board){
        System.out.println("Gracz 2: Gdzie chcesz postawić O?");
        showBoard(board);
        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }

    public static void addXToBoard(int choice, ArrayList<ArrayList<String>> board){
        switch (choice){
            case 1:
                board.get(0).set(0, "X");
                break;
            case 2:
                board.get(0).set(1, "X");
                break;
            case 3:
                board.get(0).set(2, "X");
                break;
            case 4:
                board.get(1).set(0, "X");
                break;
            case 5:
                board.get(1).set(1, "X");
                break;
            case 6:
                board.get(1).set(2, "X");
                break;
            case 7:
                board.get(2).set(0, "X");
                break;
            case 8:
                board.get(2).set(1, "X");
                break;
            case 9:
                board.get(2).set(2, "X");
                break;
        }


    }

    public static void addOToBoard(int choice, ArrayList<ArrayList<String>> board){
        switch (choice){
            case 1:
                board.get(0).set(0, "O");
                break;
            case 2:
                board.get(0).set(1, "O");
                break;
            case 3:
                board.get(0).set(2, "O");
                break;
            case 4:
                board.get(1).set(0, "O");
                break;
            case 5:
                board.get(1).set(1, "O");
                break;
            case 6:
                board.get(1).set(2, "O");
                break;
            case 7:
                board.get(2).set(0, "O");
                break;
            case 8:
                board.get(2).set(1, "O");
                break;
            case 9:
                board.get(2).set(2, "O");
                break;
        }


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
        boolean result = false;
        if (board.get(0).get(0).equals(board.get(0).get(1)) &&
                board.get(0).get(1).equals(board.get(0).get(2))
                && !board.get(0).get(0).equals(" ")){
            result = true;
        } else if (board.get(1).get(0).equals(board.get(1).get(1)) &&
                board.get(1).get(1).equals(board.get(1).get(2))
                && !board.get(1).get(0).equals(" ")) {
            result = true;
        } else if (board.get(2).get(0).equals(board.get(2).get(1)) &&
                board.get(2).get(1).equals(board.get(2).get(2))
                && !board.get(2).get(0).equals(" ")) {
            result = true;
        } else if (board.get(0).get(0).equals(board.get(1).get(0)) &&
                board.get(1).get(0).equals(board.get(2).get(0))
                && !board.get(0).get(0).equals(" ")) {
            result = true;
        } else if (board.get(0).get(1).equals(board.get(1).get(1)) &&
                board.get(1).get(1).equals(board.get(2).get(1))
                && !board.get(0).get(1).equals(" ")) {
            result = true;
        } else if (board.get(0).get(2).equals(board.get(1).get(2)) &&
                board.get(1).get(2).equals(board.get(2).get(2))
                && !board.get(0).get(2).equals(" ")) {
            result = true;
        } else if (board.get(0).get(0).equals(board.get(1).get(1)) &&
                board.get(1).get(1).equals(board.get(2).get(2))
                && !board.get(0).get(0).equals(" ")) {
            result = true;
        } else if (board.get(2).get(0).equals(board.get(1).get(1)) &&
                board.get(1).get(1).equals(board.get(0).get(2))
                && !board.get(2).get(0).equals(" ")) {
            result = true;
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<String>> board = new ArrayList<ArrayList<String>>();
        for (int i = 0; i < 3; i++) {
            board.add(new ArrayList<>(Arrays.asList(" ", " ", " ")));
        }

        for(int i = 0; i < 9;){
            showBoardNumeration();
            addXToBoard(askFirstPlayer(board), board);
            i++;
            if (whoWon(board)){
                System.out.println("Wygrywa Gracz 1");
                break;
            }
            if (i == 9){
                System.out.println("Remis!");
                break;
            }
            addOToBoard(askSecondPlayer(board), board);
            i++;
            if (whoWon(board)){
                System.out.println("Wygrywa Gracz 2");
                break;
            }
            if (i == 9){
                System.out.println("Remis!");
                break;
            }

        }
        showBoard(board);
    }
}
