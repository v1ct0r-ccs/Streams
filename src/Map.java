import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Map {
    public static void main(String[] args) {
        List<Pessoa> lista = new Pessoa().popularPessoa();

        Stream<Integer> stream = lista.stream()
                .filter(pessoa -> pessoa.getNacionalidade().equals("Holanda"))
                .map(Pessoa::getIdade);

        IntStream stream2 = lista.stream()
                .filter(pessoa -> pessoa.getNacionalidade().equals("Holanda"))
                .mapToInt(Pessoa::getIdade);
    }
}
