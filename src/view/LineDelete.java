package view;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
/**
 * Classe responsável por manipular operações de exclusão de linhas em um arquivo.
 */
public class LineDelete {
    public static Integer LineDeleteInput() {
        Scanner sc = new Scanner(System.in);
        boolean isValidInput = false;
        int value = 0;
        while (!isValidInput) {
            try {
                System.out.print("What donation number do you like to delete?");
                value = sc.nextInt();
                isValidInput = true;
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
            }
        }
        return value;
    }

    /**
     * Exclui uma doação de um arquivo CSV com base no número da linha.
     *
     * @param lineNumber O número da linha da doação a ser excluída.
     */
    public static void DeleteDonationOnfile(int lineNumber) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please type the hole file path: (ex: c://temp//doacoes.csv)");
        String path = sc.nextLine();

        List<String> lines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            int currentLine = 0;

            while ((line = br.readLine()) != null) {
                currentLine++;
                if (currentLine != lineNumber) {
                    lines.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            for (String line : lines) {
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
