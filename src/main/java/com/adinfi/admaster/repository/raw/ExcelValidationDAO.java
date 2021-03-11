package com.adinfi.admaster.repository.raw;

import com.adinfi.admaster.domain.sp.MediosEspacios;
import com.adinfi.admaster.domain.sp.UdpEspaciosCategoriaSel;
import com.adinfi.admaster.domain.sp.UdpEspaciosProductosSel;
import com.adinfi.admaster.domain.sp.UdpMediosEspaciosSel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.servlet.ServletException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jGonzalez
 */
@Repository
public class ExcelValidationDAO{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Integer executeQueryValidation(String query){
    	Connection connection = null;
    	Statement s = null;
    	Integer res = 0;
    	try{
    		connection = jdbcTemplate.getDataSource().getConnection();
    		s = connection.createStatement();
    		ResultSet r = s.executeQuery(query);
    		
    		while(r.next()){
    			res = r.getInt("TOTAL");
    		}
    	}catch(Exception ex){
    		ex.printStackTrace();
    	}finally{
    		try{
	    		if(s != null){
	    			s.close();
	    		}
    			if(connection != null){
	    			connection.close();
	    		}
    		}catch(Exception e2){
    			e2.printStackTrace();
    		}
    	}
		return res;
    }
    
    public void callUdpEspaciosMecanicasUps (Long mediosId, Long subCategoriaId, Long mecanicaId) throws ServletException{
        final String procedureCall = "{ call udp_EspaciosMecanicas_ups (?,?,?) }";
        Connection connection = null;
        try{
            connection = jdbcTemplate.getDataSource().getConnection();
            CallableStatement statement = connection.prepareCall(procedureCall);
            statement.setLong(1,mediosId);
            statement.setLong(2,subCategoriaId);
            statement.setLong(3, mecanicaId);
            boolean results = statement.execute();
            if (!results){
               // throw new ServletException("Error al guardar informacion");
            }
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

    public void callUdpEspaciosMecanicaIniDel (Long mediosId, Long subCategoriaId, boolean spDel) throws ServletException {

        String sp = "udp_EspaciosMecanicas_ini";
        if (spDel){
           sp = "udp_EspaciosMecanicas_del";
        }
        final String procedureCall = "{ call "+ sp +" (?,?) }";
        Connection connection = null;
        try{
            connection = jdbcTemplate.getDataSource().getConnection();
            CallableStatement statement = connection.prepareCall(procedureCall);
            statement.setLong(1,mediosId);
            statement.setLong(2,subCategoriaId);
            boolean results = statement.execute();
            if (!results){
              //  throw new ServletException("Error al inicializar informacion");
            }
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

    public List<UdpEspaciosProductosSel> callUdpEspaciosProductosSel (Long mediosId, int subCategoriaId, Long userId) throws ServletException {
        final String procedureCall = "{ call udp_EspaciosProductos_sel (?,?,?) }";
        Connection connection = null;
        List<UdpEspaciosProductosSel> forReturn = new ArrayList<>();
        try{
            connection = jdbcTemplate.getDataSource().getConnection();
            CallableStatement statement = connection.prepareCall(procedureCall);
            statement.setLong(1,mediosId);
            statement.setInt(2,subCategoriaId);
            statement.setLong(3, userId);
            boolean results = statement.execute();
            if (results){
                ResultSet rs = statement.getResultSet();
                int row = 1;
                while (rs.next()){
                   UdpEspaciosProductosSel p = new UdpEspaciosProductosSel();
                   p.setRow(row);
                   p.setSeleccionado(rs.getBoolean("Seleccionado"));
                   p.setCombo(rs.getString("Combo"));
                   p.setComponente(rs.getInt("Compponente"));
                   p.setProducto(rs.getString("Producto"));
                   p.setPreciazoClub(rs.getDouble("PreciazoClub"));
                   p.setProductosId(rs.getString("ProductosId"));
                   p.setSubCategoriaId(rs.getInt("SubCategoriaId"));
                   p.setMecanicasId(rs.getInt("MecanicasId"));
                   p.setPreciosOferta(rs.getDouble("PreciosOferta"));
                   p.setCanonazo(rs.getBoolean("Cañonazo"));
                   forReturn.add(p);
                   row++;
                }
            }
            return forReturn;
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

    public void callUdpCopyMediosMecanicasUps (Long sourceId, Long targetId, Long userId) throws ServletException {
        final String procedureCall = "{ call udp_CopyMediosMecanicas_ups (?,?,?) }";
        Connection connection = null;
        try {
            connection = jdbcTemplate.getDataSource().getConnection();
            CallableStatement statement = connection.prepareCall(procedureCall);
            statement.setLong(1,sourceId);
            statement.setLong(2,targetId);
            statement.setLong(3, userId);
            boolean results = statement.execute();
            if (!results){
                throw new ServletException("Error al copiar");
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
            throw new ServletException(e.getMessage());
        } finally {
            if (connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public Map<String, Integer> callUdpCopyMediosMecanicasVal(Long sourceId, Long targetId, Long userId) throws ServletException{
        final String procedureCall = "{ call udp_CopyMediosMecanicas_Val (?,?,?) }";
        Connection connection = null;
        Map<String, Integer> result = new HashMap<>();
        try{
            connection = jdbcTemplate.getDataSource().getConnection();
            CallableStatement statement = connection.prepareCall(procedureCall);
            statement.setLong(1,sourceId);
            statement.setLong(2,targetId);
            statement.setLong(3, userId);
            boolean results = statement.execute();
            while (results){
                ResultSet rs = statement.getResultSet();
                while (rs.next()){
                    result.put("sourceNumber", rs.getInt("MecanicasCopiar"));
                    result.put("targetNumber", rs.getInt("MecanicasExistentes"));
                }
                results = statement.getMoreResults();
            }
            return result;
        }catch (SQLException e){
            System.out.println(e.getMessage());
            throw new ServletException(e.getMessage());
        } finally {
            if (connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return result;
        }
    }

    public List<UdpEspaciosCategoriaSel> callUdpEspaciosCategoriasSel(Long mediosId, boolean activo, int statusId, Long usuariosId){
        final String procedureCall = "{ call udp_EspaciosCategoria_sel (?,?,?,?) }";
        Connection connection = null;
        List<UdpEspaciosCategoriaSel> udpList = new ArrayList<>();
        try{
            connection = jdbcTemplate.getDataSource().getConnection();
            CallableStatement statement = connection.prepareCall(procedureCall);
            statement.setLong(1,mediosId);
            statement.setBoolean(2,activo);
            statement.setInt(3, statusId);
            statement.setLong(4, usuariosId);
            boolean results = statement.execute();
            while (results){
                ResultSet rs = statement.getResultSet();
                while (rs.next()){
                    UdpEspaciosCategoriaSel udp = new UdpEspaciosCategoriaSel();
                    udp.setMediosId(rs.getLong("MediosId"));
                    udp.setCategoriasId(rs.getLong("CategoriasId"));
                    udp.setSubcategoriasId(rs.getLong("SubCategoriasId"));
                    udp.setDesCategoria(rs.getString("Categorias"));
                    udp.setDesSubCategoria(rs.getString("SubCategoria"));
                    udp.setPendientes(rs.getInt("Pendientes"));
                    udp.setTotal(rs.getInt("Total"));
                    udp.setSelected(false);
                    udpList.add(udp);
                }
                results = statement.getMoreResults();
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        } finally {
            if (connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return udpList;
        }
    }

    public UdpMediosEspaciosSel callUdpMediosEspaciosSel(Long eventosId, Long usuariosId){
        final String procedureCall = "{ call udp_MediosEspacios_sel (?,?) }";
        Connection connection = null;
        UdpMediosEspaciosSel udp = new UdpMediosEspaciosSel();
        try{
            connection = jdbcTemplate.getDataSource().getConnection();
            CallableStatement callSts = connection.prepareCall(procedureCall);
            callSts.setLong(1, eventosId);
            callSts.setLong(2, usuariosId);
            boolean results = callSts.execute();
            int count = 1;
            while (results){
                ResultSet rs = callSts.getResultSet();
                ResultSetMetaData rsmd = rs.getMetaData();
                if (count == 1){
                    udp.setMediosEspaciosList(getMediosEspaciosList(rs));
                }else {
                    if (rs.next()){
                        udp.setTotal(rs.getInt("Total"));
                        udp.setAsignados(rs.getInt("Asignados"));
                    }
                }
                rs.close();
                count++;
                results = callSts.getMoreResults();
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        } finally {
            if (connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return udp;
        }
    }

    private List<MediosEspacios> getMediosEspaciosList (ResultSet rs) throws SQLException {
        List<MediosEspacios> mds = new ArrayList<>();
        while (rs.next()){
            MediosEspacios me = new MediosEspacios();
            me.setDescripcion(rs.getString("Descripcion"));
            me.setMediosId(rs.getLong("MediosId"));
            me.setAsignados(rs.getInt("Asignados"));
            me.setTotal(rs.getInt("Total"));
            mds.add(me);
        }
        return mds;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
