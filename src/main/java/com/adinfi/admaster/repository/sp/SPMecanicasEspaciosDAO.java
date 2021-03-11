package com.adinfi.admaster.repository.sp;

import com.adinfi.admaster.domain.sp.UdpMediosUpsMerza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.servlet.ServletException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by jdominguez on 3/2/17.
 */
@Repository
public class SPMecanicasEspaciosDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public SPMecanicasEspaciosDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void udpEspaciosMecanicasDel (Long mediosId, Long subCategoId) throws ServletException {
        final String procedureCall = "{ call EspaciosMecanicas_del_MERZA (?,?) }";
        executeSPSimple(procedureCall, mediosId, subCategoId);
    }

    public void udpMediosEspaciosUbicacionesUps (Long mediosId, Long espaciosUbicacionesId) throws ServletException {
        final String procedureCall = "{ call udp_MediosEspaciosUbicaciones_ups_MERZA (?,?) }";
        executeSPSimple(procedureCall, mediosId, espaciosUbicacionesId);
    }

    public void udpEspaciosMecanicasUps (Long mediosId, Long subCategoId, Long mecanicasId) throws ServletException {
        final String procedureCall = "{ call udp_EspaciosMecanicas_ups_MERZA (?,?,?) }";
        Connection connection = null;
        try{
            connection = jdbcTemplate.getDataSource().getConnection();
            CallableStatement statement = connection.prepareCall(procedureCall);
            statement.setLong(1, mediosId);
            statement.setLong(2, subCategoId);
            statement.setLong(3, mecanicasId);
            statement.execute();
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

    public Long udpMediosUps (UdpMediosUpsMerza data) throws ServletException {
        final String procedureCall = "{ call udp_EspaciosMecanicas_ini_MERZA (?,?,?,?,?,?,?,?,?) }";
        Connection connection = null;
        try{
            connection = jdbcTemplate.getDataSource().getConnection();
            CallableStatement statement = connection.prepareCall(procedureCall);
            statement.setString(1, data.getDescripcion());
            statement.setLong(2, data.getEventosId());
            statement.setInt(3, data.getTipoMediosId());
            statement.setInt(4, data.getNumeroPartes());
            statement.setInt(5, data.getNumeroSecciones());
            statement.setDate(6, data.getFechaInicial());
            statement.setDate(7, data.getFechaFinal());
            statement.setLong(8, data.getUsuariosId());
            statement.setLong(9, data.getMediosId());
            boolean results = statement.execute();
            return 1L;
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

    public void udpEspaciosMecanicasIni (Long mecanicasId, Long mediosId) throws ServletException{
        final String procedureCall = "{ call udp_EspaciosMecanicas_ini_MERZA (?,?) }";
        executeSPSimple(procedureCall, mecanicasId, mediosId);
    }

    private void executeSPSimple(final String procedureCall, Long param1, Long param2) throws ServletException {
        Connection connection = null;
        try{
            connection = jdbcTemplate.getDataSource().getConnection();
            CallableStatement statement = connection.prepareCall(procedureCall);
            statement.setLong(1,param1);
            statement.setLong(2,param2);
            statement.execute();
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
