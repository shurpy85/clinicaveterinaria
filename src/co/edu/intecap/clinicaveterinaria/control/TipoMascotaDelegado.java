/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.intecap.clinicaveterinaria.control;

import co.edu.intecap.clinicaveterinaria.modelo.dao.TipoMascotaDao;
import co.edu.intecap.clinicaveterinaria.modelo.vo.TipoMascotaVo;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author CamiloAlejandro
 */
public class TipoMascotaDelegado {

    private final JFrame contenedor;
    private final TipoMascotaDao tipoMascotaDao;

    public TipoMascotaDelegado(JFrame contenedor) {
        this.contenedor = contenedor;
        this.tipoMascotaDao = new TipoMascotaDao();
    }
    

    public void insertarTipoMascota(TipoMascotaVo tipoMascotaVo) {
        try {
            this.tipoMascotaDao.insertar(tipoMascotaVo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(contenedor, e.getMessage(), "Error en insersion", JOptionPane.ERROR_MESSAGE);

        }

    }

    public void editarTipoMascota(TipoMascotaVo tipoMascotaVo) {
        try {
            this.tipoMascotaDao.editar(tipoMascotaVo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(contenedor, e.getMessage(), "Error en insersion", JOptionPane.ERROR_MESSAGE);

        }
    }

    public List<TipoMascotaVo> consultarTipoMascota() {
        List<TipoMascotaVo> listaTipoMascota;
        try {
            listaTipoMascota = this.tipoMascotaDao.consultar();
        } catch (Exception e) {
            listaTipoMascota = new ArrayList<>();
            JOptionPane.showMessageDialog(contenedor, e.getMessage(), "Error en insersion", JOptionPane.ERROR_MESSAGE);

        }
        return listaTipoMascota;
    }

    public TipoMascotaVo consultarTipoMascotaVo(int id) {
        TipoMascotaVo tipoMascotaVo;
        try {
            tipoMascotaVo = this.tipoMascotaDao.consultar(id);
        } catch (Exception e) {
            tipoMascotaVo = new TipoMascotaVo();
            JOptionPane.showMessageDialog(contenedor, e.getMessage(), "Error en insersion", JOptionPane.ERROR_MESSAGE);

        }
        return tipoMascotaVo;
    }
}
