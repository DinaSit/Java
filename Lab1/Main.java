import static java.lang.Math.random;

import java.lang.System;
import java.util.Scanner;
public class Main {
    static Numb prev;
    static Field field;
    static Un telling;


    public static void main(String[] args) {

        //Работа с полем
        Numb prev = new Numb();
        Field field = new Field();
        Un telling = new Un();

        System.out.println("Length and width: ");
        Scanner scan = new Scanner(System.in);
        prev.i = scan.nextInt();   //Размеры поля
        prev.j = scan.nextInt();

        prev.tiles=new char[prev.i][prev.j];

        for (int k = 0; k < prev.i; ++k) {
            for (int c = 0; c < prev.j; ++c) {
                int deb = (int) (Math.random() * 4);
                if (deb == 0) prev.tiles[k][c] = '0';
                if (deb == 1) prev.tiles[k][c] = '+';
                if (deb == 2) prev.tiles[k][c] = '-';
                if (deb == 3) prev.tiles[k][c] = '?';
            }
        }

        prev.newI = 0;
        prev.newJ = 0;

        prev.tiles[prev.newI][prev.newJ] = '&';
        for (int k = 0; k < prev.i; ++k) {
            for (int c = 0; c < prev.j; ++c) {
                System.out.print(prev.tiles[k][c] + " ");
            }
            System.out.println();
        }

        prev.plus = 1;
        int d = 0;
        while (d != 1 && prev.plus >= 0 && d < 5) {

            int sw = field.field2();
            System.out.println(sw);

            switch (sw) {
                case 0: d = 1;
                    break;
                case 1:
                    if (prev.newI + 1 == 7) {System.out.println("You can't go there "); break; }
                        if (prev.tiles[prev.newI + 1][prev.newJ] == '?') {
                            System.out.println("You can't go there ");
                            break;
                        }
                        prev.tiles[prev.newI][prev.newJ] = '.';
                        prev.newI = prev.newI + 1;

                        if (prev.tiles[prev.newI][prev.newJ] == '+') prev.plus = prev.plus + 1;
                        if (prev.tiles[prev.newI][prev.newJ] == '-') prev.plus = prev.plus - 1;

                        prev.tiles[prev.newI][prev.newJ] = '&';

                        break;

                case 2:
                    if (prev.newJ + 1 == 7) {System.out.println("You can't go there "); break;}
                    if (prev.tiles[prev.newI][prev.newJ+1] == '?') { System.out.println("You can't go there "); break;}
                    prev.tiles[prev.newI][prev.newJ] = '.';
                    prev.newJ = prev.newJ + 1;
                    if (prev.tiles[prev.newI][prev.newJ] == '+') prev.plus=prev.plus+1;
                    if (prev.tiles[prev.newI][prev.newJ] == '-') prev.plus=prev.plus-1;
                    prev.tiles[prev.newI][prev.newJ] = '&';
                    break;
                case 3:
                    if (prev.newI - 1 < 0) {System.out.println("You can't go there "); break;}
                    if (prev.tiles[prev.newI - 1][prev.newJ]=='?') { System.out.println("You can't go there "); break;}
                    prev.tiles[prev.newI][prev.newJ] = '.';
                    prev.newI = prev.newI - 1;
                    if (prev.tiles[prev.newI][prev.newJ] == '+') prev.plus=prev.plus+1;
                    if (prev.tiles[prev.newI][prev.newJ] == '-') prev.plus=prev.plus-1;
                    prev.tiles[prev.newI][prev.newJ] = '&';
                    break;
                case 4:
                    if (prev.newJ - 1 < 0) { System.out.println("You can't go there "); break;}
                    if (prev.tiles[prev.newI][prev.newJ-1] == '?') { System.out.println("You can't go there "); break;}
                    prev.tiles[prev.newI][prev.newJ] = '.';
                    prev.newJ = prev.newJ - 1;
                    if (prev.tiles[prev.newI][prev.newJ] == '+') prev.plus=prev.plus+1;
                    if (prev.tiles[prev.newI][prev.newJ] == '-') prev.plus=prev.plus-1;
                    prev.tiles[prev.newI][prev.newJ] = '&';
                    break;
            }

            for (int k = 0; k < prev.i; ++k)
            {
                for (int c = 0; c < prev.j; ++c)
                {
                    System.out.print(prev.tiles[k][c] + " ");
                }
                System.out.println();
            }
        }

      String tellme = telling.Story();
        for (int k = 0; k < prev.plus; ++k) tellme = tellme + " bonus ";
        System.out.println(tellme);

    }
}