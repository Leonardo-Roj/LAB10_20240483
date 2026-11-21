package DTos;

public class DtoSedes {
    private int idSede;
    private String nombre;
    private String ciudad;

    public DtoSedes(int idSede, String nombre, String sede) {
    }

    public DtoSedes() {

    }

    public int getIdSede() {
        return idSede;
    }

    public void setIdSede(int idSede) {
        this.idSede = idSede;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
}
