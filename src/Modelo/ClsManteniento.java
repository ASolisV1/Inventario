package Modelo;
public class ClsManteniento {
    private int equipoid;
    private String equiponom;
    private int clienteid;//foraneo LISTO
    private int equipotipo;//foraneo LISTO
    private int equipocod;
    private String equipodes;
    private int mantenimientoId;//foraneo 
// Getters y Stters

    public ClsManteniento() {
    }

    public ClsManteniento(int equipoid, String equiponom, int clienteid, int equipotipo, int equipocod, String equipodes, int mantenimientoId) {
        this.equipoid = equipoid;
        this.equiponom = equiponom;
        this.clienteid = clienteid;
        this.equipotipo = equipotipo;
        this.equipocod = equipocod;
        this.equipodes = equipodes;
        this.mantenimientoId = mantenimientoId;
    }

    public int getEquipoid() {
        return equipoid;
    }

    public void setEquipoid(int equipoid) {
        this.equipoid = equipoid;
    }

    public String getEquiponom() {
        return equiponom;
    }

    public void setEquiponom(String equiponom) {
        this.equiponom = equiponom;
    }

    public int getClienteid() {
        return clienteid;
    }

    public void setClienteid(int clienteid) {
        this.clienteid = clienteid;
    }

    public int getEquipotipo() {
        return equipotipo;
    }

    public void setEquipotipo(int equipotipo) {
        this.equipotipo = equipotipo;
    }

    public int getEquipocod() {
        return equipocod;
    }

    public void setEquipocod(int equipocod) {
        this.equipocod = equipocod;
    }

    public String getEquipodes() {
        return equipodes;
    }

    public void setEquipodes(String equipodes) {
        this.equipodes = equipodes;
    }

    public int getMantenimientoId() {
        return mantenimientoId;
    }

    public void setMantenimientoId(int mantenimientoId) {
        this.mantenimientoId = mantenimientoId;
    }

    
}
