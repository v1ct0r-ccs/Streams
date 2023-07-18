import java.util.List;

public class Count {
    public static void main(String[] args) {
        List<Pessoa> lista = new Pessoa().popularPessoa();

        long count = lista.stream()
                .filter(pessoa -> pessoa.getNome().startsWith("M"))
                .count();

        System.out.println(count);
    }
}
