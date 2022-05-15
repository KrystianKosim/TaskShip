package com.company;

public class Main {

    public static void main(String[] args) {
        int[][] tab = createTab();
        int countOfShips = findAllShips(tab);
        System.out.println(countOfShips);
    }

    private static int findAllShips(int[][] tab) {
        int[][] replacementTab = tab;
        int count = 0;
        for (int i = 0; i < replacementTab.length; i++) {
            for (int j = 0; j < replacementTab[i].length; j++) {
                if (replacementTab[i][j] == 1) {
                    count++;
                    shipWasFound(replacementTab, i, j);
                }
            }
        }
        return count;
    }


    private static void shipWasFound(int[][] tab, int i, int j) {
        tab[i][j] = 0;
        Main.checkDown(tab, i, j);
        Main.checkRight(tab, i, j);
    }

    private static void checkDown(int[][] tab, int i, int j) {
        int checkingIndex = i + 1;
        int lastIndexInTab = tab.length - 1;
        if (i < lastIndexInTab) {
            if (tab[checkingIndex][j] == 1) {
                tab[checkingIndex][j] = 0;
                checkDown(tab, checkingIndex, j);
            }
        }
    }

    private static void checkRight(int[][] tab, int i, int j) {
        int checkingIndex = j + 1;
        /**
         * Zakladam ze plansza do gry jest kwadratem o wymiarach X na X
         */
        int lastIndexInTab = tab.length - 1;
        if (j < lastIndexInTab) {
            if (tab[i][checkingIndex] == 1) {
                tab[i][checkingIndex] = 0;
                checkRight(tab, i, checkingIndex);
            }

        }
    }

    private static int[][] createTab() {
        int[][] tab = new int[10][10];
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[i].length; j++) {
                tab[i][j] = 0;
            }
        }
        tab[0][3] = 1;
        tab[0][4] = 1;
        tab[0][5] = 1;
        tab[0][9] = 1;
        tab[2][2] = 1;
        tab[3][2] = 1;
        tab[4][2] = 1;
        tab[5][2] = 1;
        tab[3][4] = 1;
        tab[2][6] = 1;
        tab[2][7] = 1;
        tab[6][4] = 1;
        tab[6][5] = 1;
        tab[5][8] = 1;
        tab[5][9] = 1;
        tab[8][1] = 1;
        tab[8][2] = 1;
        tab[8][3] = 1;
        tab[8][6] = 1;
        tab[8][8] = 1;
        return tab;
    }
}
