package aluno;

import java.util.ArrayList;
import java.util.List;
public class AlunoControl {
	 private List<Aluno> lista = new ArrayList<>();

	    public void adicionar( Aluno a ) { 
	        lista.add(a);
	        System.out.println("Tamanho Lista: " + lista.size());
	    }

	    public Aluno pesquisar( String texto ) { 
	        for (Aluno a : lista) { 
	            if (a.getNome().contains(texto)) { 
	                return a;
	            }
	        }
	        return null;
	    }
	    
}
