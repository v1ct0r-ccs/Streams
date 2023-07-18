import java.util.List;

public class AllMatch {
    public static void main(String[] args) {
        List<Pessoa> lista = new Pessoa().popularPessoa();

        boolean result = lista.stream()
                .allMatch(pessoa -> pessoa.getNacionalidade().equals("Inglaterra"));
        System.out.println(result);


        Boolean re = true;
        for (Pessoa p : lista) {
            if (!p.getNacionalidade().equals("Inglaterra")) {
                re = false;
                break;
            }
        }
    }
}
