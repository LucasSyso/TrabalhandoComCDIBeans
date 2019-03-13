package com.lucas.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
//import javax.enterprise.context.RequestScoped;
//import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@SuppressWarnings("serial")
@Named
//@RequestScoped
//@ApplicationScoped
//@SessionScoped //Abas de um mesmo navegador compartilham de uma mesma sessão
@ConversationScoped
public class ListaBean implements Serializable{

	private String item;
	private List<String> itens = new ArrayList<String>();
	
	@Inject
	private Conversation conversation;//Esse tipo de escopo me permite delimitar um inicio e um fim de um objeto, ou de uma sessão.
	
	public String adicionar() {
		if(itens.size() == 0) {
			conversation.begin();
		}
		
		itens.add(item);
		item = null;
		
		return null;
	}
	
	public String removerTudo() {
		if(itens.size() > 0) {
			itens.clear();
			conversation.end();
		}
		
		return null;
	}
	

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}
	

	public List<String> getItens() {
		return itens;
	}

	public void setItens(List<String> itens) {
		this.itens = itens;
	}
	
	
}
