package Modelo;
public class ClsArticulos {
    private int articuloid;//check
    private String articulonom;//cehck
    private int articulocod;//check
    private String articulodes;
    private int articulocosto;
        
    public ClsArticulos() {
    }

    public ClsArticulos(int articuloid, String articulonom, int articulocod, String articulodes, int articulocosto) {
        this.articuloid = articuloid;
        this.articulonom = articulonom;
        this.articulocod = articulocod;
        this.articulodes = articulodes;
        this.articulocosto = articulocosto;
    }

    public int getArticuloid() {
        return articuloid;
    }

    public void setArticuloid(int articuloid) {
        this.articuloid = articuloid;
    }

    public String getArticulonom() {
        return articulonom;
    }

    public void setArticulonom(String articulonom) {
        this.articulonom = articulonom;
    }

    public int getArticulocod() {
        return articulocod;
    }

    public void setArticulocod(int articulocod) {
        this.articulocod = articulocod;
    }

    public String getArticulodes() {
        return articulodes;
    }

    public void setArticulodes(String articulodes) {
        this.articulodes = articulodes;
    }

    public int getArticulocosto() {
        return articulocosto;
    }

    public void setArticulocosto(int articulocosto) {
        this.articulocosto = articulocosto;
    }

    

}
