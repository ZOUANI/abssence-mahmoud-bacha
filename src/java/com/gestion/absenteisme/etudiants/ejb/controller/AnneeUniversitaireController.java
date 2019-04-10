package com.gestion.absenteisme.etudiants.ejb.controller;

import com.gestion.absenteisme.etudiants.ejb.entity.AnneeUniversitaire;
import com.gestion.absenteisme.etudiants.ejb.controller.util.JsfUtil;
import com.gestion.absenteisme.etudiants.ejb.controller.util.JsfUtil.PersistAction;
import com.gestion.absenteisme.etudiants.ejb.service.AnneeUniversitaireFacade;

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

@Named("anneeUniversitaireController")
@SessionScoped
public class AnneeUniversitaireController implements Serializable {

    @EJB
    private com.gestion.absenteisme.etudiants.ejb.service.AnneeUniversitaireFacade ejbFacade;
    private List<AnneeUniversitaire> items = null;
    private AnneeUniversitaire selected;

    public AnneeUniversitaireController() {
    }

    public AnneeUniversitaire getSelected() {
        return selected;
    }

    public void setSelected(AnneeUniversitaire selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private AnneeUniversitaireFacade getFacade() {
        return ejbFacade;
    }

    public AnneeUniversitaire prepareCreate() {
        selected = new AnneeUniversitaire();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("AnneeUniversitaireCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("AnneeUniversitaireUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("AnneeUniversitaireDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<AnneeUniversitaire> getItems() {
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

    public AnneeUniversitaire getAnneeUniversitaire(int id) {
        return getFacade().find(id);
    }

    public List<AnneeUniversitaire> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<AnneeUniversitaire> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = AnneeUniversitaire.class)
    public static class AnneeUniversitaireControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            AnneeUniversitaireController controller = (AnneeUniversitaireController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "anneeUniversitaireController");
            return controller.getAnneeUniversitaire(getKey(value));
        }

        int getKey(String value) {
            int key;
            key = Integer.parseInt(value);
            return key;
        }

        String getStringKey(int value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof AnneeUniversitaire) {
                AnneeUniversitaire o = (AnneeUniversitaire) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), AnneeUniversitaire.class.getName()});
                return null;
            }
        }

    }

}
