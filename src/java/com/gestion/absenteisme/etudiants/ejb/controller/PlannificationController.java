package com.gestion.absenteisme.etudiants.ejb.controller;

import com.gestion.absenteisme.etudiants.ejb.entity.Plannification;
import com.gestion.absenteisme.etudiants.ejb.controller.util.JsfUtil;
import com.gestion.absenteisme.etudiants.ejb.controller.util.JsfUtil.PersistAction;
import com.gestion.absenteisme.etudiants.ejb.service.PlannificationFacade;

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

@Named("plannificationController")
@SessionScoped
public class PlannificationController implements Serializable {

    @EJB
    private com.gestion.absenteisme.etudiants.ejb.service.PlannificationFacade ejbFacade;
    private List<Plannification> items = null;
    private Plannification selected;

    public PlannificationController() {
    }

    public Plannification getSelected() {
        return selected;
    }

    public void setSelected(Plannification selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
        selected.setPk(new com.gestion.absenteisme.etudiants.ejb.entity.PlannificationId());
    }

    private PlannificationFacade getFacade() {
        return ejbFacade;
    }

    public Plannification prepareCreate() {
        selected = new Plannification();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("PlannificationCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("PlannificationUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("PlannificationDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Plannification> getItems() {
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

    public Plannification getPlannification(com.gestion.absenteisme.etudiants.ejb.entity.PlannificationId id) {
        return getFacade().find(id);
    }

    public List<Plannification> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Plannification> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Plannification.class)
    public static class PlannificationControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            PlannificationController controller = (PlannificationController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "plannificationController");
            return controller.getPlannification(getKey(value));
        }

        com.gestion.absenteisme.etudiants.ejb.entity.PlannificationId getKey(String value) {
            com.gestion.absenteisme.etudiants.ejb.entity.PlannificationId key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new com.gestion.absenteisme.etudiants.ejb.entity.PlannificationId();
//            key.setAnnuniv(values[0]);
//            key.setSemestre(values[1]);
            return key;
        }

        String getStringKey(com.gestion.absenteisme.etudiants.ejb.entity.PlannificationId value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getAnnuniv());
            sb.append(SEPARATOR);
            sb.append(value.getSemestre());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Plannification) {
                Plannification o = (Plannification) object;
                return getStringKey(o.getPk());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Plannification.class.getName()});
                return null;
            }
        }

    }

}
