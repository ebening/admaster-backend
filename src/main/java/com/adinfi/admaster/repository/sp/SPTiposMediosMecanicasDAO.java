package com.adinfi.admaster.repository.sp;

import com.adinfi.admaster.domain.sp.UdpMediosUbicacionesMecanicas;
import com.adinfi.admaster.domain.sp.UdpTipoMedioMecanicas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.servlet.ServletException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jdominguez on 3/7/17.
 */
@Repository
public class SPTiposMediosMecanicasDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public SPTiposMediosMecanicasDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<UdpMediosUbicacionesMecanicas> getMediosUbicacionesMecanicas (Long eventosId, int mecanicasId) throws ServletException {
        final String procedureCall = "{ call udp_MediosUbicacionesMecanicas_sel_MERZA (?,?) }";
        Connection connection = null;
        List<UdpMediosUbicacionesMecanicas> listReturn = new ArrayList<>();
        try {
            connection = jdbcTemplate.getDataSource().getConnection();
            CallableStatement statement = connection.prepareCall(procedureCall);
            statement.setLong(1,eventosId);
            statement.setInt(2,mecanicasId);
            boolean results = statement.execute();
            if (results){
                ResultSet rs = statement.getResultSet();
                while (rs.next()){
                    UdpMediosUbicacionesMecanicas x = new UdpMediosUbicacionesMecanicas();
                    x.setEspaciosUbicacionesId(rs.getInt("EspaciosUbicacionesId"));
                    x.setEspaciosPromocionales(rs.getString("EspaciosPromocionales"));
                    x.setSeleccionado(rs.getBoolean("Seleccionado"));
                    listReturn.add(x);
                }
            }
            return listReturn;
        }catch (SQLException e){
            System.out.println(e.getMessage());
            throw new ServletException(e.getMessage());
        }finally {
            if (connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public List<UdpTipoMedioMecanicas> getTipoMediosMecanicas (Long eventosId, int mecanicasId, Long subcategoriaId, Long usuariosId) throws ServletException{
        final String procedureCall = "{ call udp_TiposMediosMecanicas_sel_MERZA (?,?,?,?) }";
        Connection connection = null;
        List<UdpTipoMedioMecanicas> listReturn = new ArrayList<>();
        try{
            connection = jdbcTemplate.getDataSource().getConnection();
            CallableStatement statement = connection.prepareCall(procedureCall);
            statement.setLong(1,eventosId);
            statement.setInt(2,mecanicasId);
            statement.setLong(3, subcategoriaId);
            statement.setLong(4, usuariosId);
            boolean results = statement.execute();
            if (results){
                ResultSet rs = statement.getResultSet();
                while (rs.next()){
                    UdpTipoMedioMecanicas x = new UdpTipoMedioMecanicas();
                    x.setSeleccionado(rs.getBoolean("Seleccionado"));
                    x.setTipoMedios(rs.getString("TipoMedios"));
                    x.setTipoMediosId(rs.getLong("TipoMediosId"));
                    x.setNumeroSecciones(rs.getInt("NumeroSecciones"));
                    x.setNumeroPaginas(rs.getInt("NumeroPaginas"));
                    listReturn.add(x);
                }
            }
            return listReturn;
        }catch (SQLException e){
            System.out.println(e.getMessage());
            throw new ServletException(e.getMessage());
        }finally {
            if (connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
