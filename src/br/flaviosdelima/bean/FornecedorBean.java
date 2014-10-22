package br.flaviosdelima.bean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

import br.flaviosdelima.entidade.*;

@ManagedBean(name = "forBean")
@SessionScoped
public class FornecedorBean {

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	private Fornecedor fornecedor = new Fornecedor();
	
	public String addFornecedor() {

		String retorno = "erro";

		try {
			FornecedorDao dao = new FornecedorDao();
			dao.Salvar(fornecedor);
			retorno = "listar";
		} catch (Exception ex) {
			System.out.println("ERRO + " + ex.getMessage());
		}

		return retorno;
	}
}
