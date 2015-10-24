package br.com.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.dao.ClienteDao;
import br.com.model.Cliente;

@FacesConverter(forClass=Cliente.class)
public class ClienteConverter implements Converter {
	
	private ClienteDao dao;
	
	 public ClienteConverter() {
		this.dao = new ClienteDao();
	 }

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Cliente retorno = null;
		 
		if(value != null){
			retorno = this.dao.buscarPorId(new Long(value));
		}
		
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value != null){
			return ((Cliente) value).getId().toString();
		}
		return "";
	}

}
