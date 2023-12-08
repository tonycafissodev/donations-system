package model.entites;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * Representa uma doação de sangue feita por um doador.
 */
public class Donation {
    private Integer id;
    private Donor donor;
    private Integer bloodAmount;


    public Donation() {

    }

    /**
     * Construtor que inicializa uma doação com um doador e quantidade de sangue.
     *
     * @param donor        O doador associado à doação.
     * @param bloodAmount  A quantidade de sangue doada em mililitros.
     */

    public Donation(Donor donor, Integer bloodAmount) {
        this.donor= donor;
        this.bloodAmount= bloodAmount;
    }

    /**
     * Construtor que inicializa uma doação com um identificador, doador e quantidade de sangue.
     *
     * @param id           Identificador único da doação.
     * @param donor        O doador associado à doação.
     * @param bloodAmount  A quantidade de sangue doada em mililitros.
     */
    public Donation(Integer id, Donor donor, Integer bloodAmount) {
        this.id = id;
        this.donor = donor;
        this.bloodAmount = bloodAmount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Donor getDonor() {
        return donor;
    }

    public void setDonor(Donor donor) {
        this.donor = donor;
    }

    public Integer getBloodAmount() {
        return bloodAmount;
    }

    public void setBloodAmount(Integer bloodAmount) {
        this.bloodAmount = bloodAmount;
    }

    /**
     * Retorna uma representação de string da doação, incluindo seu identificador, informações do doador
     * e a quantidade de sangue doada.
     *
     * @return Uma representação de string da doação.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Id:" + id);
        sb.append(donor.toString());
        sb.append("Amount:" + bloodAmount + "\n"); 
        return sb.toString();
    }

    /**
     * Retorna uma representação de string da doação no formato CSV, contendo
     * o identificador, nome do doador, número do documento, data de nascimento,
     * tipo sanguíneo do doador e a quantidade de sangue doada.
     *
     * @return Uma representação de string da doação no formato CSV.
     */
    public String toCsvString() {
        StringBuilder sb = new StringBuilder();
        sb.append(id).append(",");
        sb.append(donor.getName()).append(",");
        sb.append(donor.getDocumentNumber()).append(",");
        sb.append(donor.getBirthdayDate()).append(",");
        sb.append(donor.getBloodType()).append(",");
        sb.append(bloodAmount);
        return sb.toString();
    }
}