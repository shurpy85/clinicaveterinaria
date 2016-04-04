/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.intecap.clinicaveterinaria.control;

import co.edu.intecap.clinicaveterinaria.modelo.dao.MedicoDao;
import co.edu.intecap.clinicaveterinaria.modelo.vo.MedicoVo;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author CamiloAlejandro
 */
public class MedicoDelegado {

    private final JFrame contenedor;
    private final MedicoDao medicoDao;

    public MedicoDelegado(JFrame contenedor) {
        this.contenedor = contenedor;
        this.medicoDao = new MedicoDao();

    }

    public void insertarMedico(MedicoVo medicoVo) {
        try {
            this.medicoDao.insertar(medicoVo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(contenedor, e.getMessage(), "Error en insersion", JOptionPane.ERROR_MESSAGE);

        }

    }

    public void editarMedico(MedicoVo medicoVo) {
        try {
            this.medicoDao.editar(medicoVo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(contenedor, e.getMessage(), "Error en insersion", JOptionPane.ERROR_MESSAGE);

        }
    }

    public List<MedicoVo> consultarMedico() {
        List<MedicoVo> listaMedico;
        try {
            listaMedico = this.medicoDao.consultar();
        } catch (Exception e) {
            listaMedico = new ArrayList<>();
            JOptionPane.showMessageDialog(contenedor, e.getMessage(), "Error en insersion", JOptionPane.ERROR_MESSAGE);

        }
        return listaMedico;
    }

    public MedicoVo consultarMedicoVo(int id) {
        MedicoVo medicoVo;
        try {
            medicoVo = this.medicoDao.consultar(id);
        } catch (Exception e) {
            medicoVo = new MedicoVo();
            JOptionPane.showMessageDialog(contenedor, e.getMessage(), "Error en insersion", JOptionPane.ERROR_MESSAGE);

        }
        return medicoVo;
    }

}
