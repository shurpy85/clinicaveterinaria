/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.intecap.clinicaveterinaria.control;

import co.edu.intecap.clinicaveterinaria.modelo.dao.ClienteDao;
import co.edu.intecap.clinicaveterinaria.modelo.vo.ClienteVo;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author CamiloAlejandro
 */
public class ClienteDelegado {

    private final JFrame contenedor;
    private final ClienteDao clienteDao;

    public ClienteDelegado(JFrame contenedor) {
        this.contenedor = contenedor;
        this.clienteDao = new ClienteDao();

    }

    public void insertarCliente(ClienteVo clienteVo) {
        try {
            this.clienteDao.insertar(clienteVo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(contenedor, e.getMessage(), "Error en insersion", JOptionPane.ERROR_MESSAGE);

        }

    }

    public void editarCliente(ClienteVo clienteVo) {
        try {
            this.clienteDao.editar(clienteVo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(contenedor, e.getMessage(), "Error en insersion", JOptionPane.ERROR_MESSAGE);

        }
    }
     public List<ClienteVo> consultarCliente() {
        List<ClienteVo> listaCliente;
        try {
            listaCliente = this.clienteDao.consultar();
        } catch (Exception e) {
            listaCliente = new ArrayList<>();
            JOptionPane.showMessageDialog(contenedor, e.getMessage(), "Error en insersion", JOptionPane.ERROR_MESSAGE);

        }
        return listaCliente;
    }
     
     public ClienteVo consultarClienteVo(int id) {
        ClienteVo clienteVo;
        try {
                clienteVo = this.clienteDao.consultar(id);
        } catch (Exception e) {
            clienteVo = new ClienteVo();
            JOptionPane.showMessageDialog(contenedor, e.getMessage(), "Error en insersion", JOptionPane.ERROR_MESSAGE);

        }
        return clienteVo;
    }
    
    
}
