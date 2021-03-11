package com.adinfi.admaster.repository.sp;

import com.adinfi.admaster.domain.sp.MecanicasProductos;
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
 * Created by jdominguez on 2/11/17.
 */
@Repository
public class SPMecanicasProductosDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<MecanicasProductos> callUdpMecanicasProductosSel (Long usuariosId) throws ServletException{
        final String procedureCall = "{ call udp_MecanicasProductos_sel_MERZA (?) }";
        Connection connection = null;
        List<MecanicasProductos> list = new ArrayList<>();
        try{
            connection = jdbcTemplate.getDataSource().getConnection();
            CallableStatement statement = connection.prepareCall(procedureCall);
            statement.setLong(1,usuariosId);
            boolean results = statement.execute();
            if (results){
                ResultSet rs = statement.getResultSet();
                while (rs.next()){
                    MecanicasProductos mp = new MecanicasProductos();
                    mp.setSeleccionado(rs.getBoolean("Seleccionado"));
                    mp.setCombo(rs.getString("Combo"));
                    mp.setComponente(rs.getInt("Componente"));
                    mp.setCobertura(rs.getString("Cobertura"));
                    mp.setDescripcion(rs.getString("Descripcion"));
                    mp.setPreciosOferta(rs.getDouble("PreciosOferta"));
                    mp.setPorcentajeDescuento(rs.getDouble("PorcentajeDescuento"));
                    mp.setTipoMedios(rs.getString("TipoMedios"));
                    mp.setEspaciosPromocional(rs.getString("EspaciosPromocionales"));
                    mp.setProductosId(rs.getString("ProductosId"));
                    mp.setSubCategoriaId(rs.getLong("SubCategoriaId"));
                    list.add(mp);
                }
            }
            return list;
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



