package tictactoe;

import java.util.Scanner;

enum State {
    empty, X, O
}

enum Position {
    topLeft("topLeft", State.empty, 0, 0, 1, 3),
    topCenter("topCenter", State.empty, 0, 1, 2, 3),
    topRight("topRight", State.empty, 0, 2, 3, 3),
    centerLeft("centerLeft", State.empty, 1, 0, 1, 2),
    centerCenter("centerCenter", State.empty, 1, 1, 2, 2),
    centerRight("centerRight", State.empty, 1, 2, 3, 2),
    bottomLeft("bottomLeft", State.empty, 2, 0, 1, 1),
    bottomCenter("bottomCenter", State.empty, 2, 1, 2, 1),
    bottomRight("bottomRight", State.empty, 2, 2, 3, 1);

    String name;
    State state;
    int pos1;
    int pos2;
    int pos3;
    int pos4;

    Position(String name, State state, int pos1, int pos2, int pos3, int pos4) {
        this.name = name;
        this.state = state;
        this.pos1 = pos1;
        this.pos2 = pos2;
        this.pos3 = pos3;
        this.pos4 = pos4;
    }

    public State getState() {
        return state;
    }

    public int getPos1() {
        return pos1;
    }

    public int getPos2() {
        return pos2;
    }

    public int getPos3() {
        return pos3;
    }

    public int getPos4() {
        return pos4;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Position[] positions = Position.values();
        State lastMove = State.O;
        PrintGame(positions);
        boolean someoneWon = false;
        int usedSpaces = 0;
        while (usedSpaces < 9) {
            System.out.println("Enter the coordinates:");
            final int cords1 = scanner.nextInt();
            final int cords2 = scanner.nextInt();
            for (Position position : positions) {
                if (cords1 > 3 || cords2 > 3) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    break;
                }
                if (position.getPos3() == cords1 && position.getPos4() == cords2) {
                    if (position.state == State.empty) {
                        lastMove = lastMove == State.X ? State.O : State.X;
                        position.state = lastMove;
                        usedSpaces++;
                        PrintGame(positions);
                    } else {
                        System.out.println("This cell is occupied! Choose another one!");
                        break;
                    }
                }
            }
            someoneWon = Position.topLeft.state != State.empty && Position.topLeft.state == Position.topCenter.state && Position.topCenter.state == Position.topRight.state
                    || Position.centerLeft.state != State.empty && Position.centerLeft.state == Position.centerCenter.state && Position.centerCenter.state == Position.centerRight.state
                    || Position.bottomLeft.state != State.empty && Position.bottomLeft.state == Position.bottomCenter.state && Position.bottomCenter.state == Position.bottomRight.state
                    || Position.topLeft.state != State.empty && Position.topLeft.state == Position.centerLeft.state && Position.centerLeft.state == Position.bottomLeft.state
                    || Position.topCenter.state != State.empty && Position.topCenter.state == Position.centerCenter.state && Position.centerCenter.state == Position.bottomCenter.state
                    || Position.topRight.state != State.empty && Position.topRight.state == Position.centerRight.state && Position.centerRight.state == Position.bottomRight.state
                    || Position.topLeft.state != State.empty && Position.topLeft.state == Position.centerCenter.state && Position.centerCenter.state == Position.bottomRight.state
                    || Position.bottomLeft.state != State.empty && Position.bottomLeft.state == Position.centerCenter.state && Position.centerCenter.state == Position.topRight.state;
            if (someoneWon) {
                System.out.println(lastMove + " wins");
                break;
            }
        }
        if (!someoneWon && usedSpaces == 9) {
            System.out.println("Draw");
        }
    }

    private static void PrintGame(Position[] positions) {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                for (Position position : positions) {
                    if (position.getPos1() == i && position.getPos2() == j) {
                        if (position.state == State.empty) {
                            System.out.print("  ");
                        } else {
                            System.out.print(position.getState() + " ");
                        }
                    }
                }
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println("---------");
    }
}