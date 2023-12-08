package view;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import model.entites.Donation;
import model.entites.DonationFileParsing;
import model.entites.Donor;
/**
 * Classe responsável por realizar operações de entrada de dados e escrita em arquivo.
 */
public class Input {
    /**
     * Obtém informações do usuário para criar uma nova doação.
     *
     * @return Uma instância de Donation com as informações fornecidas pelo usuário.
     */
    public static Donation InputNewDonation() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Donor name: ");
        String name = sc.nextLine();
        System.out.print("Enter Donor document number: ");
        String documentNumber = sc.nextLine();
        System.out.print("Enter Donor birthday date (dd/mm/YYYY)");
        String birthdayDate = sc.nextLine();
        System.out.print("Enter Donor blood type: ");
        String bloodType = sc.nextLine();
        System.out.print("Enter the blood amount: ");
        Integer bloodAmount = sc.nextInt();
        Donor donor = new Donor(name, documentNumber, birthdayDate, bloodType);
        Donation donation = new Donation(donor, bloodAmount);

        return donation;
    }
    /**
     * Escreve uma nova doação em um arquivo CSV.
     *
     * @param donation A doação a ser escrita no arquivo.
     */
    public static void WriteNewDonationOnFile(Donation donation) {
        Scanner sc = new Scanner(System.in);
        int listSize = DonationFileParsing.getListLenght();
        donation.setId(listSize+1);
        System.out.println("Please type the hole file path: (ex: c://temp//doacoes.csv)");
        String path = sc.nextLine();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
            bw.write(donation.toCsvString());
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
