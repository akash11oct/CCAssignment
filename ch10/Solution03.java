package practice.CCAssignment.ch10;

/**
 *
 * @author Akash Gandotra
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Random;

class ExternalSort {

    /**
     * This method uses external sort to sort a large file. The method divides
     * the large file into chunks, sorts those chunks using Quicksort. Then the
     * sorted chunks are merged using MergeSort's merge algorithm.
     *
     * @param fileName name of large file to sort
     * @param M
     * @param N
     */
    public void externalSort(String fileName, int M, int N) {
        String tempFileName = "tempFileName_";
        int bufferSize = M < N ? M : N;
        int[] buffer = new int[bufferSize];
        int i = 0;
        int j = 0;

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            int chunks = (int) Math.ceil((double) N / M);

            // Iterate through the elements in the file
            for (i = 0; i < chunks; i++) {
                // Read M-element chunk at a time from the file
                for (j = 0; j < bufferSize; j++) {
                    String t = bufferedReader.readLine();
                    if (t != null) {
                        buffer[j] = Integer.parseInt(t);
                    } else {
                        break;
                    }
                }
                // Sort M elements
                Arrays.sort(buffer);

                // Write the sorted numbers to temp file
                FileWriter fw = new FileWriter(tempFileName + Integer.toString(i) + ".txt");
                PrintWriter pw = new PrintWriter(fw);
                for (int k = 0; k < j; k++) {
                    pw.println(buffer[k]);
                }

                pw.close();
                fw.close();
            }

            bufferedReader.close();

            // Now open each file and merge them, then write back to disk
            int[] topNums = new int[chunks];
            BufferedReader[] brs = new BufferedReader[chunks];

            for (i = 0; i < chunks; i++) {
                brs[i] = new BufferedReader(new FileReader(tempFileName + Integer.toString(i) + ".txt"));
                String t = brs[i].readLine();
                if (t != null) {
                    topNums[i] = Integer.parseInt(t);
                } else {
                    topNums[i] = Integer.MAX_VALUE;
                }
            }

            FileWriter fw = new FileWriter("sortedFile.txt");
            PrintWriter pw = new PrintWriter(fw);

            for (i = 0; i < N; i++) {
                int min = topNums[0];
                int minFile = 0;

                for (j = 0; j < chunks; j++) {
                    if (min > topNums[j]) {
                        min = topNums[j];
                        minFile = j;
                    }
                }

                pw.println(min);
                String t = brs[minFile].readLine();
                if (t != null) {
                    topNums[minFile] = Integer.parseInt(t);
                } else {
                    topNums[minFile] = Integer.MAX_VALUE;
                }

            }
            for (i = 0; i < chunks; i++) {
                brs[i].close();
            }

            pw.close();
            fw.close();
        } catch (FileNotFoundException e) {
            System.out.println("Caught FileNotFoundException: " + e.getLocalizedMessage());
        } catch (IOException e) {
            System.out.println("Caught IOException: " + e.getLocalizedMessage());
        }
    }

    public String prepareFileToSort(int N) {
        String fileName = "fileToSort.txt";
        Random r = new Random();

        try {
            PrintWriter printWriter = new PrintWriter(new FileWriter(fileName));
            for (int i = 0; i < N; i++) {
                printWriter.println(r.nextInt(101));
            }
            printWriter.close();
        } catch (IOException e) {
            System.out.println("Caught IOException: " + e.getLocalizedMessage());
        }
        return fileName;
    }
}

public class Solution03 {

    public static void main(String[] args) {

        int N = 2000000; // size of the file in disk
        int M = 100000; // max items the memory buffer can hold

        ExternalSort obj = new ExternalSort();
        String fileName = obj.prepareFileToSort(N);
        obj.externalSort(fileName, M, N);
    }

}
