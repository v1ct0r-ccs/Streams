import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Filter {
    public static void main(String[] args) {
        List<Pessoa> lista = new Pessoa().popularPessoa();
        Stream<Pessoa> streamList = lista.stream().
                filter(pessoa -> pessoa.getNacionalidade().equals("Brasil"));

        Predicate<Pessoa> pred = pessoa -> pessoa.getNacionalidade().equals("Brasil");
        Stream<Pessoa> streamPred = lista.stream().filter(pred);

        Predicate<Pessoa> pred2 = new Predicate<Pessoa>() {
            @Override
            public boolean test(Pessoa pessoa) {
                return pessoa.getNacionalidade().equals("Brasil");
            }
        };

        Stream<Pessoa> stream2 = lista.stream().filter(pred2);

        Stream<Pessoa> stream3 = lista.stream().filter(new Predicate<Pessoa>() {
            @Override
            public boolean test(Pessoa pessoa) {
                return pessoa.getNacionalidade().equals("Brasil");
            }
        });
    }
}
