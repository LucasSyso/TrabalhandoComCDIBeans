package com.lucas.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@SuppressWarnings("serial")
@Named
@RequestScoped
public class LoginBean implements Serializable{
	private String nome;
	private String senha;
	
	/*
	 * M�todo que � executado imediatamente ap�s a cria��o deste bean
	 * */
	@PostConstruct
	public void onCreate() {
		System.out.println("Bean criado!!!");
	}
	
	/*
	 * M�todo que � executado imediatamente antes a destrui��o deste bean
	 * */
	@PreDestroy
	public void onDestroy() {
		System.out.println("Este bean ser� destru�do!!");
	}
	
	public String doLogin() {
		if("LUCAS".toLowerCase().equals(nome.toLowerCase()) && "123456".toLowerCase().equals(senha.toLowerCase())) {
			return "sucess";
		}
		
		//Se eu quiser enviar uma mensagem de erro eu utilizo o FacesMessage e obtenho o FacesContext
		FacesMessage message = new FacesMessage("Login Incorreto");
		
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, message);
		
		return null; //Renderiza a tela atual
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
}
