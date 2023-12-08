package model.entites;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 * Classe responsável por manipular operações de leitura e escrita de doações em um arquivo CSV.
 */

public class DonationFileParsing {
    private String fileName;
    private String path;
    private File file;

    private static List<Donation> donationList = new ArrayList<>();

    public DonationFileParsing() {

    }

    /**
     * Construtor que inicializa a classe com nome do arquivo, caminho e objeto File.
     *
     * @param fileName Nome do arquivo.
     * @param path     Caminho do arquivo.
     * @param file     Objeto que representa o arquivo.
     */
    public DonationFileParsing(String fileName, String path, File file) {
        this.fileName = fileName;
        this.path = path;
        this.file = file;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    /**
     * Obtém o tamanho da lista de doações.
     *
     * @return O tamanho da lista de doações.
     */
    public static int getListLenght() {
        return donationList.size();
    }

    
    /**
     * Realiza o parsing dos campos de uma linha do arquivo CSV para criar um objeto Donation.
     *
     * @param fields Os campos da linha do arquivo CSV.
     * @return Uma instância de Donation.
     */
    public Donation donationParsing(String[] fields) {
        int id = Integer.parseInt(fields[0]);
        String name = fields[1];
        String documentNumber = fields[2];
        String birthdayDate = fields[3];
        String bloodType = fields[4];
        Integer bloodAmount = Integer.parseInt(fields[5]);

        Donor newDonor = new Donor(name, documentNumber, birthdayDate, bloodType);
        return new Donation(id, newDonor, bloodAmount);
    }

    /**
     * Realiza a leitura do arquivo CSV, faz o parsing das linhas e adiciona as doações à lista.
     */
    public void readFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();
            while (line != null) {
                String[] fields = line.split(",");
                Donation donation = donationParsing(fields);
                donationList.add(donation);
                line = br.readLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Exibe na saída padrão as doações presentes na lista.
     */
    public void ReturnDonationList() {
        for (Donation d : donationList) {
            System.out.println(d.toString());
        }
    }

}
