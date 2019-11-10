package MantProductos;

public class ClsProductos {
    private int proCod;
    private String proNom;
    private int proCatNom;
    private String proCatNom2;
    private int proMarNom;
    private String proMarNom2;
    private int proForNom;
    private String proForNom2;
    private int proTipNom;
    private String proTipNom2;
    private double proPreVen;
    
    public ClsProductos() {
        proCod=0;
        proNom="";
        proCatNom=0;
        proCatNom2="";
        proForNom=0;
        proForNom2="";
        proTipNom=0;
        proTipNom2="";
        proPreVen=0;
    }

    public ClsProductos(int proCod, String proNom, int proCatNom, int proMarNom, int proForNom, int proTipNom, double proPreVen) {
        this.proCod = proCod;
        this.proNom = proNom;
        this.proCatNom = proCatNom;
        this.proMarNom = proMarNom;
        this.proForNom = proForNom;
        this.proTipNom = proTipNom;
        this.proPreVen = proPreVen;
    }
    
    public int getProCod() {
        return proCod;
    }

    public void setProCod(int proCod) {
        this.proCod = proCod;
    }

    public String getProNom() {
        return proNom;
    }

    public void setProNom(String proNom) {
        this.proNom = proNom;
    }

    public int getProCatNom() {
        return proCatNom;
    }

    public void setProCatNom(int proCatNom) {
        this.proCatNom = proCatNom;
    }

    public int getProMarNom() {
        return proMarNom;
    }

    public void setProMarNom(int proMarNom) {
        this.proMarNom = proMarNom;
    }

    public int getProForNom() {
        return proForNom;
    }

    public void setProForNom(int proForNom) {
        this.proForNom = proForNom;
    }

    public int getProTipNom() {
        return proTipNom;
    }

    public void setProTipNom(int proTipNom) {
        this.proTipNom = proTipNom;
    }

    public double getProPreVen() {
        return proPreVen;
    }

    public void setProPreVen(double proPreVen) {
        this.proPreVen = proPreVen;
    }

    public String getProCatNom2() {
        return proCatNom2;
    }

    public void setProCatNom2(String proCatNom2) {
        this.proCatNom2 = proCatNom2;
    }

    public String getProMarNom2() {
        return proMarNom2;
    }

    public void setProMarNom2(String proMarNom2) {
        this.proMarNom2 = proMarNom2;
    }

    public String getProForNom2() {
        return proForNom2;
    }

    public void setProForNom2(String proForNom2) {
        this.proForNom2 = proForNom2;
    }

    public String getProTipNom2() {
        return proTipNom2;
    }

    public void setProTipNom2(String proTipNom2) {
        this.proTipNom2 = proTipNom2;
    }

    
    
    
}
