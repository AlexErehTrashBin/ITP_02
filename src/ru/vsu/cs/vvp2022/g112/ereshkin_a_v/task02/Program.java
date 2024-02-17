package ru.vsu.cs.vvp2022.g112.ereshkin_a_v.task02;

import java.util.Scanner;

public class Program {
    public static boolean areCollidingWithAnotherQ(int Q1, int Q2, double b){
        if (b == 0){
            return false;
        }
        if (Q1 == 1 && Q2 == 3){
            return true;
        } else if (Q1 == 3 && Q2 == 1){
            return true;
        } else if (Q1 == 2 && Q2 == 4){
            return true;
        } else if (Q1 == 4 && Q2 == 2){
            return true;
        } else {
            return false;
        }
    }
    public static int getQuadrantOfPoint(double x, double y){
        if (x > 0 && y > 0){ // 1 четверть
            return 1;
        } else if (x < 0 && y > 0){ // 2 четверть
            return 2;
        } else if (x < 0 && y < 0){ // 3 четверть
            return 3;
        } else if (x > 0 && y < 0){
            return 4; //4 четверть
        } else {
            return 5; // Точка на осях
        }
    }
    public static void printResult(boolean firstQ, boolean secondQ, boolean thirdQ, boolean fourthQ){
        int firstQBin = firstQ ? 1 : 0;
        int secondQBin = secondQ ? 1 : 0;
        int thirdQBin = thirdQ ? 1 : 0;
        int fourthQBin = fourthQ ? 1 : 0;
        int numberOfQuadrants = firstQBin + secondQBin + thirdQBin + fourthQBin;
        int counter = 1;
        System.out.print("Четверти, в которых лежит треугольник: ");
        System.out.printf("%s", firstQ ? firstQBin : "");
        if (counter != numberOfQuadrants && firstQ){
            System.out.print(", ");
            counter++;
        }
        System.out.printf("%s", secondQ ? secondQBin * 2 : "");
        if (counter != numberOfQuadrants && secondQ){
            System.out.print(", ");
            counter++;
        }
        System.out.printf("%s", thirdQ ? thirdQBin * 3 : "");
        if (counter != numberOfQuadrants && thirdQ){
            System.out.print(", ");
        }
        System.out.printf("%s", fourthQ ? fourthQBin * 4 : "");
    }
    public static void solve(double x1, double y1, double x2, double y2, double x3, double y3){
        boolean liesOnFirst = false;
        boolean liesOnSecond = false;
        boolean liesOnThird = false;
        boolean liesOnFourth = false;

        ///Получаем четверти каждой из точек
        int firstPointQ = getQuadrantOfPoint(x1, y1);
        int secondPointQ = getQuadrantOfPoint(x2, y2);
        int thirdPointQ = getQuadrantOfPoint(x3, y3);

        // Учитываем четверть первой точки
        switch (firstPointQ){
            case 1:
                liesOnFirst = true;
                break;
            case 2:
                liesOnSecond = true;
                break;
            case 3:
                liesOnThird = true;
                break;
            case 4:
                liesOnFourth = true;
                break;
            case 5: break;
        }

        // Учитываем четверть второй точки
        switch (secondPointQ){
            case 1:
                liesOnFirst = true;
                break;
            case 2:
                liesOnSecond = true;
                break;
            case 3:
                liesOnThird = true;
                break;
            case 4:
                liesOnFourth = true;
                break;
            case 5: break;
        }

        // Учитываем четверть третьей точки
        switch (thirdPointQ){
            case 1:
                liesOnFirst = true;
                break;
            case 2:
                liesOnSecond = true;
                break;
            case 3:
                liesOnThird = true;
                break;
            case 4:
                liesOnFourth = true;
                break;
            case 5: break;
        }

        /// Проверяем четверти для каждой стороны треугольника

        // Для 1 и 2
        if (x1 != x2 && y1 != y2){
            double k = (y2-y1)/(x2-x1);
            double b = y1 - k * x1;
            double xOfOXPoint = -(b/k);
            double yOfOYPoint = b;
            int quadrantOfSomePointInOtherQ = getQuadrantOfPoint(xOfOXPoint/2, yOfOYPoint/2);
            if (areCollidingWithAnotherQ(firstPointQ, secondPointQ, b)){
                // Учитываем точку, которая находится в сторонней четверти
                switch (quadrantOfSomePointInOtherQ){
                    case 1:
                        liesOnFirst = true;
                        break;
                    case 2:
                        liesOnSecond = true;
                        break;
                    case 3:
                        liesOnThird = true;
                        break;
                    case 4:
                        liesOnFourth = true;
                        break;
                    case 5: break;
                }
            }
        }

        // Для 1 и 3
        if (x1 != x3 && y1 != y3){
            double k = (y3-y1)/(x3-x1);
            double b = y1 - k * x1;
            double xOfOXPoint = -(b/k);
            double yOfOYPoint = b;
            int quadrantOfSomePointInOtherQ = getQuadrantOfPoint(xOfOXPoint/2, yOfOYPoint/2);
            if (areCollidingWithAnotherQ(firstPointQ, thirdPointQ, b)){
                // Учитываем точку, которая находится в сторонней четверти
                switch (quadrantOfSomePointInOtherQ){
                    case 1:
                        liesOnFirst = true;
                        break;
                    case 2:
                        liesOnSecond = true;
                        break;
                    case 3:
                        liesOnThird = true;
                        break;
                    case 4:
                        liesOnFourth = true;
                        break;
                    case 5: break;
                }
            }
        }

        // Для 2 и 3
        if (x2 != x3 && y2 != y3){
            double k = (y3-y2)/(x3-x2);
            double b = y3 - k * x3;
            double xOfOXPoint = -(b/k);
            double yOfOYPoint = b;
            int quadrantOfSomePointInOtherQ = getQuadrantOfPoint(xOfOXPoint/2, yOfOYPoint/2);
            if (areCollidingWithAnotherQ(thirdPointQ, secondPointQ, b)){
                // Учитываем точку, которая находится в сторонней четверти
                switch (quadrantOfSomePointInOtherQ){
                    case 1:
                        liesOnFirst = true;
                        break;
                    case 2:
                        liesOnSecond = true;
                        break;
                    case 3:
                        liesOnThird = true;
                        break;
                    case 4:
                        liesOnFourth = true;
                        break;
                    case 5: break;
                }
            }
        }
        printResult(liesOnFirst, liesOnSecond, liesOnThird, liesOnFourth);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите X1: ");
        double x1 = scanner.nextDouble();
        System.out.print("Введите Y1: ");
        double y1 = scanner.nextDouble();

        System.out.print("Введите X2: ");
        double x2 = scanner.nextDouble();
        System.out.print("Введите Y2: ");
        double y2 = scanner.nextDouble();

        System.out.print("Введите X3: ");
        double x3 = scanner.nextDouble();
        System.out.print("Введите Y3: ");
        double y3 = scanner.nextDouble();

        solve(x1, y1, x2, y2, x3, y3);
    }
}