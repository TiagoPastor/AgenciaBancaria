package br.com.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

@ManagedBean
@ViewScoped
public class UploadBeans {

	
	public void upload(FileUploadEvent event){
		UploadedFile file = event.getFile();
	}
}
