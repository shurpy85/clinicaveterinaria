/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.intecap.clinicaveterinaria.control;

import co.edu.intecap.clinicaveterinaria.modelo.dao.HistoriaDao;
import co.edu.intecap.clinicaveterinaria.modelo.vo.HistoriaVo;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author CamiloAlejandro
 */
public class HistoriaDelegado {

    private final JFrame contenedor;
    private final HistoriaDao historiaDao;

    public HistoriaDelegado(JFrame contenedor) {
        this.contenedor = contenedor;
        this.historiaDao = new HistoriaDao();

    }

    public void insertarHistoria(HistoriaVo historiaVo) {
        try {
            this.historiaDao.insertar(historiaVo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(contenedor, e.getMessage(), "Error en insersion", JOptionPane.ERROR_MESSAGE);

        }

    }

    public void editarHistoria(HistoriaVo historiaVo) {
        try {
            this.historiaDao.editar(historiaVo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(contenedor, e.getMessage(), "Error en insersion", JOptionPane.ERROR_MESSAGE);

        }
    }

    public List<HistoriaVo> consultarHistoria() {
        List<HistoriaVo> listaHistoria;
        try {
            listaHistoria = this.historiaDao.consultar();
        } catch (Exception e) {
            listaHistoria = new ArrayList<>();
            JOptionPane.showMessageDialog(contenedor, e.getMessage(), "Error en insersion", JOptionPane.ERROR_MESSAGE);

        }
        return listaHistoria;
    }

    public HistoriaVo consultarHistoriaVo(int id) {
        HistoriaVo historiaVo;
        try {
            historiaVo = this.historiaDao.consultar(id);
        } catch (Exception e) {
            historiaVo = new HistoriaVo();
            JOptionPane.showMessageDialog(contenedor, e.getMessage(), "Error en insersion", JOptionPane.ERROR_MESSAGE);

        }
        return historiaVo;
    }

}
