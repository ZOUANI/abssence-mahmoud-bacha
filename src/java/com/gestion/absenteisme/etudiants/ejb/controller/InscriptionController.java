package com.gestion.absenteisme.etudiants.ejb.controller;

import com.gestion.absenteisme.etudiants.ejb.entity.Inscription;
import com.gestion.absenteisme.etudiants.ejb.controller.util.JsfUtil;
import com.gestion.absenteisme.etudiants.ejb.controller.util.JsfUtil.PersistAction;
import com.gestion.absenteisme.etudiants.ejb.service.InscriptionFacade;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("inscriptionController")
@SessionScoped
public class InscriptionController implements Serializable {

    @EJB
    private com.gestion.absenteisme.etudiants.ejb.service.InscriptionFacade ejbFacade;
    private List<Inscription> items = null;
    private Inscription selected;

    public InscriptionController() {
    }

    public Inscription getSelected() {
        return selected;
    }

    public void setSelected(Inscription selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
        selected.setPk(new com.gestion.absenteisme.etudiants.ejb.entity.InscriptionId());
    }

    private InscriptionFacade getFacade() {
        return ejbFacade;
    }

    public Inscription prepareCreate() {
        selected = new Inscription();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("InscriptionCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("InscriptionUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("InscriptionDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Inscription> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public Inscription getInscription(com.gestion.absenteisme.etudiants.ejb.entity.InscriptionId id) {
        return getFacade().find(id);
    }

    public List<Inscription> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Inscription> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Inscription.class)
    public static class InscriptionControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            InscriptionController controller = (InscriptionController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "inscriptionController");
            return controller.getInscription(getKey(value));
        }

        com.gestion.absenteisme.etudiants.ejb.entity.InscriptionId getKey(String value) {
            com.gestion.absenteisme.etudiants.ejb.entity.InscriptionId key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new com.gestion.absenteisme.etudiants.ejb.entity.InscriptionId();
//            key.setAnnuniv(values[0]);
//            key.setFiliere(values[1]);
//            key.setEtudiant(values[2]);
            return key;
        }

        String getStringKey(com.gestion.absenteisme.etudiants.ejb.entity.InscriptionId value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getAnnuniv());
            sb.append(SEPARATOR);
            sb.append(value.getFiliere());
            sb.append(SEPARATOR);
            sb.append(value.getEtudiant());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Inscription) {
                Inscription o = (Inscription) object;
                return getStringKey(o.getPk());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Inscription.class.getName()});
                return null;
            }
        }

    }

}
