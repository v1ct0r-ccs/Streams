import java.util.List;
import java.util.stream.Stream;

public class Limit {
    public static void main(String[] args) {
        List<Pessoa> lista = new Pessoa().popularPessoa();

        Stream<Pessoa> stream = lista.stream().limit(2);
    }
}
