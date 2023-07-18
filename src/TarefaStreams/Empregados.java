package TarefaStreams;

import java.util.List;

public class Empregados {
    private String nome;
    private String genero;

    public  Empregados(String nome, String genero){
        this.nome = nome;
        this.genero = genero;
    }

    public Empregados() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Funcionário: " + nome +
                " - " + genero;
    }

    List<Empregados>FichaEmpregado(){
        Empregados a = new Empregados("Amanda Teixeira", "Feminino");
        Empregados b = new Empregados("Carlos Bruno", "Masculino");
        Empregados c = new Empregados("Hugo Chaves", "Masculino");
        Empregados d = new Empregados("Daniele Pinho", "Feminino");
        Empregados e = new Empregados("Antonio Vinicios", "Masculino");
        Empregados f = new Empregados("Luana Vargas", "Feminino");
        Empregados g = new Empregados("Bianca Crocetti", "Feminino");
        Empregados h = new Empregados("Cesar Franchi", "Masculino");
        Empregados i = new Empregados("Thainara Prado", "Feminino");
        Empregados j = new Empregados("Angela dos Santos", "Feminino");
        Empregados k = new Empregados("Henrique Araujo", "Masculino");
        Empregados l = new Empregados("Fernanda Neiva", "Feminino");
        Empregados m = new Empregados("Alexandra Amorim", "Feminino");
        Empregados n = new Empregados("Karen Jorgensen", "Feminino");
        Empregados o = new Empregados("Marcio Andre", "Masculino");
        return List.of(a,b,c,d,e,f,g,h,i,j,k,l,m,n,o);
    }
}
