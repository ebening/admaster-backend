package com.adinfi.admaster.repository.sp;

import com.adinfi.admaster.domain.sp.IndicadoresMediosEspacios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.ServletException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jdominguez on 3/1/17.
 */
@Repository
public class SPIndicadoresMediosEspaciosDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public IndicadoresMediosEspacios getIndicadores(Long eventosId, Long usuariosId) throws ServletException{
        final String procedureCall = "{ call udp_IndicadoresMediosOferta_sel_MERZA (?,?) }";
        Connection connection = null;
        IndicadoresMediosEspacios indicadores = new IndicadoresMediosEspacios();
        try{
            connection = jdbcTemplate.getDataSource().getConnection();
            CallableStatement statement = connection.prepareCall(procedureCall);
            statement.setLong(1,eventosId);
            statement.setLong(2,usuariosId);
            boolean results = statement.execute();
            int count = 1;
            while (results){
                ResultSet rs = statement.getResultSet();
                while(rs.next()){
                    switch (count){
                        case 1:indicadores.getTotales().add(getTotales(rs, indicadores));break;
                        case 2:indicadores.getTipoMedio().add(getTipoMedio(rs, indicadores));break;
                        case 3:indicadores.getEspacios().add(getEspacios(rs, indicadores));break;
                    }
                }
                count++;
                results = statement.getMoreResults();
            }
            return indicadores;
        }catch (SQLException ex){
            System.out.println(ex);
            throw new ServletException(ex.getMessage());
        }
    }

    private IndicadoresMediosEspacios.InnerEspacio getEspacios(ResultSet rs, IndicadoresMediosEspacios indicadores)throws SQLException{
        IndicadoresMediosEspacios.InnerEspacio espacio = indicadores.new InnerEspacio();
        espacio.setEspaciosUbicacionesId(rs.getInt("EspaciosUbicacionesId"));
        espacio.setEspaciosPromocionales(rs.getString("EspaciosPromocionales"));
        espacio.setCantidad(rs.getInt("Cantidad"));
        return espacio;
    }

    private IndicadoresMediosEspacios.InnerTipoMedio getTipoMedio(ResultSet rs, IndicadoresMediosEspacios indicadores)throws SQLException{
        IndicadoresMediosEspacios.InnerTipoMedio tipoMedio = indicadores.new InnerTipoMedio();
        tipoMedio.setTipoMediosId(rs.getInt("TipoMediosId"));
        tipoMedio.setMedios(rs.getString("Medios"));
        tipoMedio.setOfertas(rs.getInt("Ofertas"));
        return tipoMedio;
    }

    private IndicadoresMediosEspacios.InnerTotales getTotales (ResultSet rs, IndicadoresMediosEspacios indicadores) throws SQLException {
        IndicadoresMediosEspacios.InnerTotales totales = indicadores.new InnerTotales();
        totales.setTotal(rs.getInt("Total"));
        totales.setAsignados(rs.getInt("Asignado"));
        return totales;
    }
}
