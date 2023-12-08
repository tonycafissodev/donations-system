package model.entites;

import java.util.Date;
/**
 * Representa um doador de sangue.
 */
public class Donor {
    private String name;
    private String documentNumber;
    private String birthdayDate;
    private String bloodType;

    public Donor(){

    }
    /**
     * Construtor que inicializa um doador com nome, número do documento, data de nascimento e tipo sanguíneo.
     *
     * @param name           O nome do doador.
     * @param documentNumber O número do documento do doador.
     * @param birthdayDate   A data de nascimento do doador (no formato de string).
     * @param bloodType      O tipo sanguíneo do doador.
     */
    public Donor(String name, String documentNumber, String birthdayDate, String bloodType) {
        this.name = name;
        this.documentNumber = documentNumber;
        this.birthdayDate = birthdayDate;
        this.bloodType = bloodType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getBirthdayDate() {
        return birthdayDate;
    }

    public void setBirthdayDate(String birthdayDate) {
        this.birthdayDate = birthdayDate;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    /**
     * Retorna uma representação de string do doador, incluindo seu nome, número do documento,
     * data de nascimento e tipo sanguíneo.
     *
     * @return Uma representação de string do doador.
     */
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(" Name:" + getName());
        sb.append(" CPF:" + getDocumentNumber());
        sb.append(" Birthday Date:" + getBirthdayDate());
        sb.append(" Blood Type:" + getBloodType());
        return sb.toString();
    }

}
