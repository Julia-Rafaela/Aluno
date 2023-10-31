package aluno;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Aluno {
	private String id;
	private String ra;
	private String nome;
        private LocalDate nasc;
    
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getRa() {
        return ra;
    }
    public void setRa(String ra) {
        this.ra = ra;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getNasc() {
        return nasc;
    }
    public void setNasc(LocalDate nasc) {
            this.nasc = nasc;
    }
    public void setNasc(String data) {
        LocalDate nasc = LocalDate.parse( data, dtf );
        setNasc(nasc);
    }

    @Override
    public String toString() { 
    	
        return this.id +" - "+this.ra +" - " +this.nome + " - " +this.nasc;
    }

}
