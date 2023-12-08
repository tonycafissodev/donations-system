import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.entites.Donation;
import model.entites.DonationFileParsing;
import view.Menu;
/**
 * Classe principal que inicia a aplicação.
 */
public class App {

    /**
     * Método principal que inicia a execução da aplicação.
     *
     * @param args Os argumentos da linha de comando (não são usados nesta aplicação).
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the path file: ");
        String path = sc.nextLine();

        System.out.print("Enter the file name: ");      
        String fileName = sc.nextLine();
        DonationFileParsing donationFile = new DonationFileParsing(fileName, path, new File(path));
        donationFile.readFile();
        
        Menu.menuView(donationFile); 
    }
}
