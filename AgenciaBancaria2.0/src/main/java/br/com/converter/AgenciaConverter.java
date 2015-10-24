package br.com.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.dao.AgenciaDao;
import br.com.model.Agencia;

@FacesConverter(forClass=Agencia.class)
public class AgenciaConverter implements Converter {
	
	private AgenciaDao dao;
	
	public AgenciaConverter() {
	this.dao = new AgenciaDao();
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Agencia agencia = null;
		
		if(value != null){
			agencia = this.dao.buscarPorId(new Long(value));
		}
		return agencia;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value != null){
			return ((Agencia) value).getCodigo().toString();
		}
		return "";
	}

}
