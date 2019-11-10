package Modelo;
public class ClsAntecedentes {
    private int antid;
    private String antnom;
    private String antdes;
    private int equipoid;
    private String antsolucion;

    public ClsAntecedentes() {
    }

    public ClsAntecedentes(int antid, String antnom, String antdes, int equipoid, String antsolucion) {
        this.antid = antid;
        this.antnom = antnom;
        this.antdes = antdes;
        this.equipoid = equipoid;
        this.antsolucion = antsolucion;
    }

    public int getAntid() {
        return antid;
    }

    public void setAntid(int antid) {
        this.antid = antid;
    }

    public String getAntnom() {
        return antnom;
    }

    public void setAntnom(String antnom) {
        this.antnom = antnom;
    }

    public String getAntdes() {
        return antdes;
    }

    public void setAntdes(String antdes) {
        this.antdes = antdes;
    }

    public int getEquipoid() {
        return equipoid;
    }

    public void setEquipoid(int equipoid) {
        this.equipoid = equipoid;
    }

    public String getAntsolucion() {
        return antsolucion;
    }

    public void setAntsolucion(String antsolucion) {
        this.antsolucion = antsolucion;
    }
   
}
