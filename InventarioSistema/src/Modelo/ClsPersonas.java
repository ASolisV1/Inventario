package Modelo;
import java.util.Date;
public class ClsPersonas {
    private int id;
    private String ap_paterno;
    private String ap_materno;
    private String nombres;
    private String nro_documento;
    private String fecha_nac;
    private int sexo;
    private int tipo_per;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getAp_paterno() {
        return ap_paterno;
    }
    public void setAp_paterno(String ap_paterno) {
        this.ap_paterno = ap_paterno;
    }
    public String getAp_materno() {
        return ap_materno;
    }
    public void setAp_materno(String ap_materno) {
        this.ap_materno = ap_materno;
    }
    public String getNombres() {
        return nombres;
    }
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    public String getNro_documento() {
        return nro_documento;
    }
    public void setNro_documento(String nro_documento) {
        this.nro_documento = nro_documento;
    }
    public String getFecha_nac() {
        return fecha_nac;
    }
    public void setFecha_nac(String fecha_nac) {
        this.fecha_nac = fecha_nac;
    }
    public int getSexo() {
        return sexo;
    }
    public void setSexo(int sexo) {
        this.sexo = sexo;
    }
    public int getTipo_per() {
        return tipo_per;
    }
    public void setTipo_per(int tipo_per) {
        this.tipo_per = tipo_per;
    }
}
