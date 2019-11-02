package Modelo;
public class ClsTipoEquipo {
    private int tipequiid;
    private String tipequinom;
    
    public ClsTipoEquipo() {
    }

    public ClsTipoEquipo(int tipequiid, String tipequinom) {
        this.tipequiid = tipequiid;
        this.tipequinom = tipequinom;
    }

    public int getTipequiid() {
        return tipequiid;
    }

    public void setTipequiid(int tipequiid) {
        this.tipequiid = tipequiid;
    }

    public String getTipequinom() {
        return tipequinom;
    }

    public void setTipequinom(String tipequinom) {
        this.tipequinom = tipequinom;
    }
    public String toString() {
	return this.tipequinom;
}
}
