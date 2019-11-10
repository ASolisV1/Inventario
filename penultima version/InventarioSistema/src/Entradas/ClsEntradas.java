package Entradas;

public class ClsEntradas {
    private int entcod;
    private String entdoc;
    private int entprodcod;
    private String entprodnom;
    private int entcant;
    private int entdia;
    private int entmes;
    private int entanio;

    public ClsEntradas(){
        
    }
    
    public ClsEntradas(int entcod, String entdoc, int entprodcod, String entprodnom, int entcant, int entdia, int entmes, int entanio) {
        this.entcod = entcod;
        this.entdoc = entdoc;
        this.entprodcod = entprodcod;
        this.entprodnom = entprodnom;
        this.entcant = entcant;
        this.entdia = entdia;
        this.entmes = entmes;
        this.entanio = entanio;
    }

    public int getEntcod() {
        return entcod;
    }

    public void setEntcod(int entcod) {
        this.entcod = entcod;
    }

    public String getEntdoc() {
        return entdoc;
    }

    public void setEntdoc(String entdoc) {
        this.entdoc = entdoc;
    }

    public int getEntprodcod() {
        return entprodcod;
    }

    public void setEntprodcod(int entprodcod) {
        this.entprodcod = entprodcod;
    }

    public String getEntprodnom() {
        return entprodnom;
    }

    public void setEntprodnom(String entprodnom) {
        this.entprodnom = entprodnom;
    }

    public int getEntcant() {
        return entcant;
    }

    public void setEntcant(int entcant) {
        this.entcant = entcant;
    }

    public int getEntdia() {
        return entdia;
    }

    public void setEntdia(int entdia) {
        this.entdia = entdia;
    }

    public int getEntmes() {
        return entmes;
    }

    public void setEntmes(int entmes) {
        this.entmes = entmes;
    }

    public int getEntanio() {
        return entanio;
    }

    public void setEntanio(int entanio) {
        this.entanio = entanio;
    }
    
}
