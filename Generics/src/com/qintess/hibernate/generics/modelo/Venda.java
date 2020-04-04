 package com.qintess.hibernate.generics.modelo;



	import java.util.ArrayList;
	import java.util.List;

	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.OneToMany;

	@Entity
	public class Venda implements EntidadeBase {

		@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		
		
		//lista de itens
		@OneToMany(mappedBy = "venda")
		private List <ItemVenda> itens = new ArrayList<ItemVenda>();
		
		
		private double total;


		public Long getId() {
			return (long) id;
		}


		public void setId(Long id) {
			this.id = id;
		}


		public List<ItemVenda> getItens() {
			return itens;
		}


		public void setItens(List<ItemVenda> itens) {
			this.itens = itens;
		}


		public double getTotal() {
			return total;
		}


		public void setTotal(double total) {
			this.total = total;
		}
	
	
}
