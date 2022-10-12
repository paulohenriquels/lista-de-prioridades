package app;

import java.util.ArrayList;
import java.util.List;

import heap.MaxHeap;

public class TesteMaxHeap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Integer> lista = new ArrayList<>();
		
		lista.add(60);
		lista.add(70);
		lista.add(33);
		lista.add(95);
		lista.add(28);
		
		MaxHeap heap = new MaxHeap(lista);
		
		heap.imprimir();
		
		heap.construirHeap();
		
		System.out.println("Após a construção do MaxHeap: ");
		
		heap.imprimir();

		heap.inserir(66);
		
		heap.imprimir();
		
		heap.inserir(78);
		
		heap.inserir(39);
		
		heap.imprimir();
		
		System.out.println("\n" + heap.remover() + " foi retirado...");
		
		heap.imprimir();
	}

}
