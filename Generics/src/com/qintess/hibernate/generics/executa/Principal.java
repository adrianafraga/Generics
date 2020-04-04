package com.qintess.hibernate.generics.executa;

import com.qintess.hibernate.generics.dao.GenericDao;
import com.qintess.hibernate.generics.modelo.ItemVenda;
import com.qintess.hibernate.generics.modelo.Produto;
import com.qintess.hibernate.generics.modelo.Venda;

public class Principal {

	//private static GenericDao<ItemVenda> gDaoItVen;
	private static GenericDao<Produto> gDaoProd;
	private static Produto produto;
	//private static ItemVenda itemvenda;

	public static void main(String[] args) {
		
		produto = new Produto();
		//itemvenda = new ItemVenda();
		
		gDaoProd = new GenericDao<Produto>();
		//gDaoItVen = new GenericDao<ItemVenda>();
		
		produto.setNome("Iphone 8");
		produto.setPreco(2600.00);
		
		gDaoProd.saveOrUpdate(produto);
		
		System.out.println("Produto Salvo!!");
		
		
		
		
		
		

	}

}
