package heap;

import java.util.List;

public class MaxHeap {
	
	List<Integer> heap;
	
	public MaxHeap() { }
	
	public MaxHeap(List<Integer> lista) {
		this.heap = lista;
	}
	
	// método auxiliar que retorna o piso de um número
	
	private int piso(double numero) {
		return (int) numero;
	}
	
	
	// métodos para subir e descer
	
	private void subir(int i, List<Integer> h) {
		
		int j; // pai de i
		int temp; // usado na troca de posição dos elementos
		
		j = piso((i - 1) / 2);
		
		if (j >= 0 && h.get(i) > h.get(j)) {
			
			temp = h.get(i); // temp = h[i]
			h.set(i, h.get(j)); // h[i] = h[j]
			h.set(j, temp); // h[j] = temp;
			
			subir(j, h);
			
		}
		
	}
	
	private void descer(int i, List<Integer> h, int tamHeap) {
		
		int j; // filho de i
		int temp; // usado na troca
		
		j = 2 * i + 1;
		
		// verificar se o índice é válido
		if(j < tamHeap) {
			
			// verificar se existem índices a frente dele
			if(j < tamHeap - 1) {
				
				if(h.get(j) < h.get(j + 1))
					j++;
				
			}
			
			/* 
			 * caso o valor do maior filho seja maior que o do pai, 
			 * trocar suas posições.
			 */
			if(h.get(j) > h.get(i)) {
				
				temp = h.get(i);
				h.set(i, h.get(j));
				h.set(j, temp);
				
				// verificar se o j recém gerado desce (recursivamente)
				descer(j, h, tamHeap);
			}
			
		}
		
		
	}
	
	
	public void construirHeap() {
		
		int i;
		int tamHeap = this.heap.size();
		
		for(i = piso((tamHeap - 1) / 2); i >= 0; i--) {
			
			descer(i, this.heap, tamHeap);
			
		}
		
	}
	
	// métodos para inserir e remover
	
	public void inserir(int novo) {
		
		if(this.heap.size() == 0) {
			
			this.heap.add(novo);
			
		}else {
			
			this.heap.add(novo);
			
			subir(this.heap.size() - 1, heap);
		}
		
	}
	
	public Integer remover() {
		
		int retirado;
		
		if(this.heap.size() != 0) {
			
			retirado = this.heap.get(0);
			
			this.heap.set(0, this.heap.get(this.heap.size() - 1));
			this.heap.remove(this.heap.size() - 1);
			
			descer(0, this.heap, this.heap.size());
			
			return retirado;
			
		}else {
			
			return -1;
			
		}
		
	}
	
	public void imprimir() {
		
		System.out.println();
		
		for(int i = 0; i < this.heap.size(); i++) {
			
			System.out.print("[" + i + "] " + this.heap.get(i) + " ");
			
		}
		
		System.out.println();
	}

}
