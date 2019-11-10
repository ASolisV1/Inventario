package Inventario;

public class ClsInventario {
    private int codinv;
    private int codprod;
    private String proNom;
    private int proCatCod;
    private String proCatNom;
    private int proMarCod;
    private String proMarNom;
    private int proForCod;
    private String proForNom;
    private int proTipCod;
    private String proTipNom;
    private double proPreVen;
    private int stock;

    public ClsInventario(){}
    
    public ClsInventario(int codinv, int codprod, String proNom, int proCatCod, String proCatNom, int proMarCod, String proMarNom, int proForCod, String proForNom, int proTipCod, String proTipNom, double proPreVen, int stock) {
        this.codinv = codinv;
        this.codprod = codprod;
        this.proNom = proNom;
        this.proCatCod = proCatCod;
        this.proCatNom = proCatNom;
        this.proMarCod = proMarCod;
        this.proMarNom = proMarNom;
        this.proForCod = proForCod;
        this.proForNom = proForNom;
        this.proTipCod = proTipCod;
        this.proTipNom = proTipNom;
        this.proPreVen = proPreVen;
        this.stock = stock;
    }


    public int getCodinv() {
        return codinv;
    }

    public void setCodinv(int codinv) {
        this.codinv = codinv;
    }

    public int getCodprod() {
        return codprod;
    }

    public void setCodprod(int codprod) {
        this.codprod = codprod;
    }

    public String getProNom() {
        return proNom;
    }

    public void setProNom(String proNom) {
        this.proNom = proNom;
    }

    public int getProCatCod() {
        return proCatCod;
    }

    public void setProCatCod(int proCatCod) {
        this.proCatCod = proCatCod;
    }

    public String getProCatNom() {
        return proCatNom;
    }

    public void setProCatNom(String proCatNom) {
        this.proCatNom = proCatNom;
    }

    public int getProMarCod() {
        return proMarCod;
    }

    public void setProMarCod(int proMarCod) {
        this.proMarCod = proMarCod;
    }

    public String getProMarNom() {
        return proMarNom;
    }

    public void setProMarNom(String proMarNom) {
        this.proMarNom = proMarNom;
    }

    public int getProForCod() {
        return proForCod;
    }

    public void setProForCod(int proForCod) {
        this.proForCod = proForCod;
    }

    public String getProForNom() {
        return proForNom;
    }

    public void setProForNom(String proForNom) {
        this.proForNom = proForNom;
    }

    public int getProTipCod() {
        return proTipCod;
    }

    public void setProTipCod(int proTipCod) {
        this.proTipCod = proTipCod;
    }

    public String getProTipNom() {
        return proTipNom;
    }

    public void setProTipNom(String proTipNom) {
        this.proTipNom = proTipNom;
    }

    public double getProPreVen() {
        return proPreVen;
    }

    public void setProPreVen(double proPreVen) {
        this.proPreVen = proPreVen;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
    
    
    
}
