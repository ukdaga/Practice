package org.ukdaga.practise;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LegoWall {

	/* Sample Input 
	3
	XOOXOOO
	XXOOOXO
	OXOOOXO*/

    // Complete the numberOfWalls function below.
    static int numberOfWalls(List<String> board) {
        char [][] matrix = new char [board.size()][board.get(0).length()];
        for (int i =0; i<board.size(); i++)
        {
            for(int j = 0; j < board.get(0).length(); j++)
            {
                matrix[i][j] = board.get(i).charAt(j);
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }

        return 3;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int boardCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> board = new ArrayList<>();

        IntStream.range(0, boardCount).forEach(i -> {
            try {
                board.add(bufferedReader.readLine());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int res = numberOfWalls(board);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
