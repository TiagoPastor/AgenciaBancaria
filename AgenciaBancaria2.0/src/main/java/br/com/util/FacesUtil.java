package br.com.util;

import java.util.Map;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

public class FacesUtil {

	public static String getParam(String nome) {
		
		FacesContext facesContext = FacesContext.getCurrentInstance();
		
		ExternalContext externalcontext = facesContext.getExternalContext();
		Map<String, String> parametros = externalcontext.getRequestParameterMap();
		String valor = parametros.get(nome);
		return valor;
	}

}
