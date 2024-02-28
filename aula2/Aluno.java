import java.util.HashMap;
import java.util.Map;

public class Aluno {
    private String nome;
    private String num;
    private Map<String, Integer> notas;

    public Aluno() {
        this.nome = "";
        this.num = "";
        this.notas = new HashMap<>();
    }

    public Aluno(String nome, String num){
        this.nome= nome;
        this.num= num;
        this.notas= new HashMap<>();
    }

    public void setNome(String nome) {
        this.nome= nome;
    }

    public String getNome() { return this.nome; }

    public void setnum(String num) { this.num= num; }
    public String getNumero() { return this.num; }

    public void setNota(String cadeira, int nota) throws  NotaInvalidaException
    {
        if (nota<0 || nota> 20)
        {
            throw new NotaInvalidaException();
        }
        else
        {
            this.notas.put(cadeira, nota);
        }
    }

    public void incrementaNota(String cadeira, int inc) throws NotaInvalidaException
    {
        int nota= this.notas.get(cadeira);
        nota+= inc;
        if (nota<0 || nota> 20) {
            throw new NotaInvalidaException();
        }
        else {
            this.notas.put(cadeira, nota);
        }
    }

    public boolean equals (Object o)
    {
        if (this!= o)
            return false;

        Aluno a= (Aluno) o;
        if (this.num!= a.num)
            return false;

        return true;
    }

    public Aluno clone ()
    {
        Aluno n_aluno= new Aluno(this.nome, this.num);
        n_aluno.notas= new HashMap<>(this.notas);

        return n_aluno;
    }
}
