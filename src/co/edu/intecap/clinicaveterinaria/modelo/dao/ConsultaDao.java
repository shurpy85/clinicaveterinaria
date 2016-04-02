/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.intecap.clinicaveterinaria.modelo.dao;

import co.edu.intecap.clinicaveterinaria.modelo.conexion.Conexion;
import co.edu.intecap.clinicaveterinaria.modelo.vo.ConsultaVo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author capacitaciones
 */
public class ConsultaDao extends Conexion implements GenericoDao<ConsultaVo> {

    @Override
    public void insertar(ConsultaVo object) {
        PreparedStatement sentencia;
        try {
            conectar();
            String sql = "insert into consulta( fecha, motivo, descripcion, estado, id_medico, id_historia) values (?,?,?,?,?,?)";
            sentencia = cnn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            sentencia.setDate(1, object.getFecha());
            sentencia.setString(2, object.getMotivo());
            sentencia.setString(3, object.getDescripcion());
            sentencia.setString(4, object.getEstado());
            sentencia.setInt(5, object.getIdMedico());
            sentencia.setInt(6, object.getIdHistoria());
            sentencia.executeUpdate();
            ResultSet rs = sentencia.getGeneratedKeys();
            
            
            
            
                    
            
            
            
        } catch (Exception e) {
        }
    }

    @Override
    public void editar(ConsultaVo object) {
    }

    @Override
    public List<ConsultaVo> consultar() {
    }

    @Override
    public ConsultaVo consultar(int id) {
    }

}
