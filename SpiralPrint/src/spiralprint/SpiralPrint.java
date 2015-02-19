/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package spiralprint;

import java.io.*;
import java.util.Scanner;

public class SpiralPrint {

    private int r_num = 0;
    private int c_num = 0;
    private int[][] a;

    public SpiralPrint(int r, int c) {
        r_num = r;
        c_num = c;
        a = new int[r][c];
    }

    public SpiralPrint() {
    }

    /**
     * Read data from command-line
     *
     * @return 0 : no error; 1 : error
     */
    public int readData() {
        Scanner scan = new Scanner(new InputStreamReader(System.in));
        System.out.println("Input data for two-demensional array a[" + r_num + "][" + c_num + "]");
        // get data from command-line
        for (int i = 0; i < r_num; i++) {
            for (int j = 0; j < c_num; j++) {
                System.out.print("a[" + i + "][" + j + "]=");
                String input = scan.nextLine();
                try {
                    a[i][j] = Integer.parseInt(input);
                } catch (NumberFormatException ex) {
                    System.out.println(ex.getMessage());
                    return 1;
                }
                System.out.println();
            }
        }
        return 0;
    }

    /**
     * Print matrix in spiral order
     */
    public void spiralPrint() {
        int i;	// i - iterator
        int k = 0; // k - starting row index
        int l = 0; // l - starting column index


        while (k < r_num && l < c_num) {
            /* Print the first row from the remaining rows */
            for (i = l; i < c_num; ++i) {
                System.out.print(a[k][i] + " ");
            }
            k++;

            /* Print the last column from the remaining columns */
            for (i = k; i < r_num; ++i) {
                System.out.print(a[i][c_num - 1] + " ");
            }
            c_num--;

            /* Print the last row from the remaining rows */
            if (k < r_num) {
                for (i = c_num - 1; i >= l; --i) {
                    System.out.print(a[r_num - 1][i] + " ");
                }
                r_num--;
            }

            /* Print the first column from the remaining columns */
            if (l < c_num) {
                for (i = r_num - 1; i >= k; --i) {
                    System.out.print(a[i][l] + " ");
                }
                l++;
            }
        }
    }

    /**
     * Main program to test above methods
     *
     * @param args
     * @return
     */
    public static void main(String[] args) {
        SpiralPrint sPrint = new SpiralPrint(3, 3);        
        sPrint.readData();
        sPrint.spiralPrint();

    }
}
