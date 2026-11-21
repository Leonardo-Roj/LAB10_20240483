package DAOS;

import DTos.DtoSedes;

import java.sql.*;
import java.util.*;

public class DaoSede extends DaoBase {

    public static List<DtoSedes> listar() throws SQLException {
        List<DtoSedes> sedes = new ArrayList<>();
        String sql = "SELECT id_sede, nombre, ciudad FROM sedes ORDER BY id_sede";
        try (Connection cn = getConnection();
             PreparedStatement ps = cn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                sedes.add(new DtoSedes(rs.getInt("id_sede"), rs.getString("nombre"),
                        rs.getString("sede")));
            }
        }
        return sedes;
    }
}
