package Salidas;


public class ClsSalidas {
    private int salcod;
    private String saldoc;
    private int salprodcod;
    private String salprodnom;
    private int salcant;
    private int saldia;
    private int salmes;
    private int salanio;

    public ClsSalidas(){
        
    }
    
    public ClsSalidas(int salcod, String saldoc, int salprodcod, String salprodnom, int salcant, int saldia, int salmes, int salanio) {
        this.salcod = salcod;
        this.saldoc = saldoc;
        this.salprodcod = salprodcod;
        this.salprodnom = salprodnom;
        this.salcant = salcant;
        this.saldia = saldia;
        this.salmes = salmes;
        this.salanio = salanio;
    }

    public int getSalcod() {
        return salcod;
    }

    public void setSalcod(int salcod) {
        this.salcod = salcod;
    }

    public String getSaldoc() {
        return saldoc;
    }

    public void setSaldoc(String saldoc) {
        this.saldoc = saldoc;
    }

    public int getSalprodcod() {
        return salprodcod;
    }

    public void setSalprodcod(int salprodcod) {
        this.salprodcod = salprodcod;
    }

    public String getSalprodnom() {
        return salprodnom;
    }

    public void setSalprodnom(String salprodnom) {
        this.salprodnom = salprodnom;
    }

    public int getSalcant() {
        return salcant;
    }

    public void setSalcant(int salcant) {
        this.salcant = salcant;
    }

    public int getSaldia() {
        return saldia;
    }

    public void setSaldia(int saldia) {
        this.saldia = saldia;
    }

    public int getSalmes() {
        return salmes;
    }

    public void setSalmes(int salmes) {
        this.salmes = salmes;
    }

    public int getSalanio() {
        return salanio;
    }

    public void setSalanio(int salanio) {
        this.salanio = salanio;
    }
    
}
