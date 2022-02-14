/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.dao.MedicoDao;
import modelo.entidad.Medico;


/**
 *
 * @author elcon
 */
@ManagedBean
@ViewScoped
public class MedicoControl {

    /**
     * Creates a new instance of MedicoControl
     */
    private List<Medico> listaMedicos;
    private Medico medico;

    public MedicoControl() {
        medico = new Medico();
    }

    public List<Medico> getListaMedicos() {
        MedicoDao ad = new MedicoDao();
        listaMedicos = ad.listarMedicos();
        return listaMedicos;
    }

    public void setListaMedicos(List<Medico> listaMedicos) {
        this.listaMedicos = listaMedicos;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public void limpiarMedico() {
        medico = new Medico();
    }

    public void agregarMedico() {
        MedicoDao ad = new MedicoDao();
        ad.agregar(medico);
    }

    public void modificarMedico() {
        MedicoDao ad = new MedicoDao();
        ad.modificar(medico);
        limpiarMedico();
    }

    public void eliminarMedico() {
        MedicoDao ad = new MedicoDao();
        ad.eliminar(medico);
        limpiarMedico();
    }
}