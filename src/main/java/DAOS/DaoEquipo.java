package DAOS;

import DTos.DtoEquipos;
import DTos.DtoSedes;

import java.sql.*;

public class DaoEquipo extends DaoBase {
    public DtoEquipos registrar(DtoEquipos equipos_red) throws SQLException {
        try (Connection cn = getConnection()) {
            cn.setAutoCommit(false);
            try {
                int id = insertar(cn, equipos_red);
                DtoEquipos registrado = buscar(cn, id);
                cn.commit();
                return registrado;
            } catch (SQLException e) {
                cn.rollback();
                throw e;
            }
        }
    }
    private int insertar(Connection cn,  DtoEquipos equipo) throws SQLException {
        String sql = "INSERT INTO equipo (id_equipo, hostname, tipo, ip_gestion,estado,fecha_alta,id_sede) VALUES (?,?,?,?, ?, ?, ?)";
        try (PreparedStatement ps = cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, DtoEquipos.getIdEquipo());
            ps.setString(2, DtoEquipos.getHostname());
            ps.setString(3, DtoEquipos.getTipo());
            ps.setString(4, DtoEquipos.getIpGestion());
            ps.setString(5, DtoEquipos.getEstado());
            ps.setString(6, DtoEquipos.getFechaAlta());
            ps.setInt(7, DtoEquipos.getSede().getIdSede());

            ps.executeUpdate();
            try (ResultSet claves = ps.getGeneratedKeys()) {
                if (claves.next()) return claves.getInt(1);
                throw new SQLException("No se obtuvo el ID generado");
            }
        }
    }
    private DtoEquipos buscar(Connection cn, int id) throws SQLException {
        String sql = """
SELECT e.id_equipo, e.hostname, e.tipo, e.ip_gestion,
s.id_sede, s.nombre AS sede, s.ciudad
FROM equipos_red e JOIN sedes s ON s.id_sede = e.id_sede
WHERE e.id_equipo = ?
""";
        try (PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.next()) throw new SQLException("Equipo no registrado");
                DtoSedes sedes = new DtoSedes(rs.getInt("id_sede"),
                        rs.getString("nombre"), rs.getString("ciudad"));
                return new DtoEquipos();
            }
        }
    }
}


