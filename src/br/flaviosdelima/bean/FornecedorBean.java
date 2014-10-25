package br.flaviosdelima.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import br.flaviosdelima.entidade.Fornecedor;
import br.flaviosdelima.entidade.FornecedorDao;
 

@ManagedBean(name = "forBean")
@SessionScoped
public class FornecedorBean {
	private Fornecedor fornecedor = new Fornecedor();
	private DataModel<Fornecedor>fornecedores;

	public void setFornecedores(DataModel<Fornecedor> fornecedores) {
		this.fornecedores = fornecedores;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public void novoFornecedor() {
		fornecedor = new Fornecedor();
	}
	
	public void selecionarFornecedor(){
		this.fornecedor = fornecedores.getRowData();
	}
	
	public DataModel<Fornecedor>getFornecedores(){
		FornecedorDao dao = new FornecedorDao();
		
		try {
			List<Fornecedor> lista = dao.GetAll();
			fornecedores = new ListDataModel<Fornecedor>(lista);
		} catch (Exception e) {
			
		}
		
		return fornecedores;
	}

	public String deleteFornecedor() {
		this.fornecedor = fornecedores.getRowData();

		String retorno = "erro";

		try {
			FornecedorDao dao = new FornecedorDao();
			dao.delete(fornecedor);
			retorno = "listar";
		} catch (Exception ex) {
			System.out.println("ERRO + " + ex.getMessage());
		}

		return retorno;
	}

	public String updateFornecedor() {

		String retorno = "erro";

		try {
			FornecedorDao dao = new FornecedorDao();
			dao.Update(fornecedor);
			retorno = "listar";
		} catch (Exception ex) {
		}

		return retorno;
	}

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
