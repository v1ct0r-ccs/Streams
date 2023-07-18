import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class ValoresOpcionais {
    public static void main(String[] args) {
        List<Pessoa> lista = new Pessoa().popularPessoa();

        System.out.println("**** Max ****");
        Optional<Pessoa> opcional = lista.stream()
                .max(Comparator.comparing(Pessoa::getIdade));

        if (opcional.isPresent()) {
            System.out.println(opcional.get());
        }
        opcional.ifPresent(System.out::println);

        System.out.println("**** Min ****");
        Optional<Pessoa> min = lista.stream()
                .min(Comparator.comparing(Pessoa::getIdade));

        min.ifPresentOrElse(System.out::println, new Runnable() {
            @Override
            public void run() {
                //Buscar outra vez em algum lugar
            }
        });

        Pessoa value = min.orElseThrow();
    }
}
