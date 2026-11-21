package DTos;

public class DtoEquipos {
    private static int idEquipo;
    private static String hostname;
    private static String tipo;
    private static String ipGestion;
    private static String estado;
    private static String fechaAlta;
    private DtoSedes sede;

    public static int getIdEquipo() {
        return idEquipo;
    }

    public static void setIdEquipo(int idEquipo) {
        DtoEquipos.idEquipo = idEquipo;
    }

    public static String getHostname() {
        return hostname;
    }

    public static void setHostname(String hostname) {
        DtoEquipos.hostname = hostname;
    }

    public static String getTipo() {
        return tipo;
    }

    public static void setTipo(String tipo) {
        DtoEquipos.tipo = tipo;
    }

    public static String getIpGestion() {
        return ipGestion;
    }

    public static void setIpGestion(String ipGestion) {
        DtoEquipos.ipGestion = ipGestion;
    }

    public static String getEstado() {
        return estado;
    }

    public static void setEstado(String estado) {
        DtoEquipos.estado = estado;
    }

    public static String getFechaAlta() {
        return fechaAlta;
    }

    public static void setFechaAlta(String fechaAlta) {
        DtoEquipos.fechaAlta = fechaAlta;
    }

    public static DtoSedes getSede() {
        return sede;
    }

    public void setSede(DtoSedes sede) {
        this.sede = sede;
    }
}
