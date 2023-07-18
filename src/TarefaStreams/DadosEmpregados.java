package TarefaStreams;

import java.util.List;
import java.util.stream.Collectors;

public class DadosEmpregados {
    public static void main(String[] args) {
        loja();
    }

    private static void loja() {

        List<Empregados> funcionario = new Empregados().FichaEmpregado();

        System.out.println("**** Lista de funcionarios ****");
        funcionario.forEach(empregados -> System.out.println(empregados.getNome() + ", " + empregados.getGenero()));
        System.out.println();

        System.out.println("**** Lista de funiconarias mulheres ****");
        funcionario.stream()
                .filter(empregados -> empregados.getGenero().equalsIgnoreCase("Feminino"))
                .collect(Collectors.toList())
                .forEach(System.out::println);

    }
}
