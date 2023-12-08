package view;

import java.util.InputMismatchException;
import java.util.Scanner;

import model.entites.Donation;
import model.entites.DonationFileParsing;
/**
 * Classe responsável por exibir e gerenciar o menu de interação com o usuário.
 */
public class Menu {
    /**
     * Exibe o menu principal e realiza operações com base na escolha do usuário.
     *
     * @param donationFile O objeto DonationFileParsing para manipular as operações de arquivo.
     */
    public static void menuView(DonationFileParsing donationFile) {
        Scanner sc = new Scanner(System.in);
        int option = 0;
        boolean isValidInput = false;

        // while (!isValidInput) {
            try {
                System.out.println("Main Menu");
                System.out.println("[1] Read file and print the donations");
                System.out.println("[2] Insert new donation");
                System.out.println("[3] Delete donation");
                System.out.println("Option: ");
                option = sc.nextInt();
                isValidInput = true;
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Format incorrect, is expected just numbers");
                sc.nextLine();
            }

            switch (option) {
                case 1:
                    isValidInput = false;
                    donationFile.readFile();
                    donationFile.ReturnDonationList();
                    break;
                case 2:
                    Donation newDonation = Input.InputNewDonation();
                    Input.WriteNewDonationOnFile(newDonation);
                    break;
                case 3:
                    int lineToDelete = LineDelete.LineDeleteInput();
                    LineDelete.DeleteDonationOnfile(lineToDelete);
                default:
                    break;
            }
        // }
    }
}
