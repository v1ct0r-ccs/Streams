import java.util.List;

public class ForEach {
    public static void main(String[] args) {
        List<Pessoa> lista = new Pessoa().popularPessoa();

        System.out.println("**** lista de nomes ****");
        lista.stream().forEach(pessoa -> System.out.println(pessoa.getNome()));
        System.out.println();

        System.out.println("**** filtro de nacionalidade ****");
        lista.stream()
                .filter(pessoa -> pessoa.getNacionalidade().equals("Brasil"))
                .forEach(p -> System.out.println(p.getNome()));
        System.out.println();

        /**
         * Outra maneira de fazer esse mesmo código (menos comum)
         *
         * Strem<Pessoa> stream = lista.stream()
         *         .filter(pessoa -> pessoa.getNacionalidade().equals("Brasil"))
         * stream.forEach(p -> System.out.println(p.getNome()));
         */

        System.out.println("**** filtro de nacionalidade imprimindo a idade ****");
        lista.stream()
                .filter(pessoa -> pessoa.getNacionalidade().equals("Brasil"))
                .map(Pessoa::getIdade)
                .forEach(p -> System.out.println(p));
    }
}
