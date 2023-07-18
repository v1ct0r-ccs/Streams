import java.util.*;
import java.util.Map;
import java.util.stream.Collectors;

public class Collect {
    public static void main(String[] args) {
        System.out.println("**** List ****");
        List<Pessoa> lista = new Pessoa().popularPessoa();

        List<Pessoa> listaB = lista.stream()
                .filter(pessoa -> pessoa.getNacionalidade().equals("Brasil"))
                .collect(Collectors.toList());
        listaB.forEach(System.out::println);

        System.out.println("**** List direto ****");

        lista.stream()
                .filter(pessoa -> pessoa.getNacionalidade().equals("Brasil"))
                .collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println("**** Set ****");

        Set<Pessoa> set = lista.stream()
                .filter(pessoa -> pessoa.getNacionalidade().equals("Inglaterra"))
                .collect(Collectors.toSet());
        set.forEach(System.out::println);

        /*System.out.println("**** TreeSet ****");

        TreeSet<Pessoa> tree = lista.stream()
                .filter(pessoa -> pessoa.getNacionalidade().equals("Holanda"))
                        .collect(Collectors.toCollection(TreeSet::new));
        tree.forEach(System.out::println);*/

        System.out.println("**** ArrayList ****");

        ArrayList<Pessoa> arrayList = lista.stream()
                .filter(pessoa -> pessoa.getNacionalidade().equals("Holanda"))
                .collect(Collectors.toCollection(ArrayList::new));
        arrayList.forEach(System.out::println);


        System.out.println("**** Map ****");

        Map<Integer, Pessoa> map = lista.stream()
                .filter(pessoa -> pessoa.getNacionalidade().equals("Espanha"))
                .collect(Collectors.toMap(Pessoa::getIdade, Pessoa::new));
        map.forEach((k, v) -> System.out.println(k + " / " + v));

        System.out.println("**** GrupingBy ****");

        Map<Integer, List<Pessoa>> agrupaPorIdade = lista.stream()
                //.filter(pessoa -> pessoa.getNacionalidade().equals("Espanha"))
                .collect(Collectors.groupingBy(Pessoa::getIdade));
        agrupaPorIdade.forEach((k, v) -> System.out.println(k + " / " + v));


    }
}
