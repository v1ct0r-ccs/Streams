# Streams

É um recurso que ajuda a manipular coleções de uma maneira simples e eficiente seguindo os princípios da programação funcional. Isso é interessante, pois o controle de fluxo e o loop ficam por conta da *API* onde temos que nos preocupar somente com a refra do negócio.

#### Vantagens

A proposta em torno da *Streams API* é redureduzida a preocupação do desenvolvedor com a forma de implementar controle de fluxo ao lidar com coleções, deixando isso a cargo da *API*. A ideia é iterar sobre essas coleções de objetos e, a cada elemento, realizar alguma ação, seja ela de filtragem, mapeamento, transformação, etc. Caberá ao desenvolvedor apenas definir qual ação seá realizada sobre o objeto.

Todas as classes novas da *API Streams* ficam no pacote:
```
java.util.stream
```

## Como criar Streams

O primeiro passo para se trabalhar com streams é saber como criá-las. A forma mais comum é através de uma coleção de dados.

```
public static void main(String[] args) {
    List<String> lista = List.of("Victor", "Bruno");
    Stream<String> streamList = lista.stream();
    
    Set<String> set = Set.of("Victor", "Bruno");
    Stream<String> streamSet = set.stream();
    
    Map<String, String> map = Map.of("Victor", "Bruno");
    Stream<String> stramMapValues = map.values().stream();
    Stream<String> streamMapKeys = map.keySet().stream();
}
```

```
Stream numbersFromValues = Stream.of(1, 2, 3, 4, 5);
IntStream numbersFromArray = Arrays.Stream(new int[] {1, 2, 3, 4, 5});
```

## Operações Intermediárias

Após conhecer alguns dos diferentes modos para criar e obter streams, o foco agora será em como processá-las. Para isso, será mostrado nos proxímos tópicos a transformação e o processamento de strems usando diferentes operações da interface Stream.

Algumas das operações intermediárias mais utilizadas são: `filter()`, `map()`, `sorted()`, `limit()` e `distinct()`.

### Filter

O método `filter()` é usado para filtrar elementos de uma stream de acordo com uma condição (predicado). Para isso, ele recebe como parâmetro um objetivo que implementa a interface `Predicate<T>` e retorna uma nova stream contendo apenas os elemntos que satisfazem à condição.

Primeiramente é criada uma lista com alguns objetos do tipo **Pessoa**. Em Seguida, com a chamada ao método `stream()` é criada a stream. Logo após, o método `filter()` recebe como parâmetro uma condição, representada por uma expressão *Lambda*, cujo objetivo é buscar todas as pessoas que nasceram no Brasil.

```
private static void filter() {
    List<Pessoa> pessoas = new Pessoa().popularPessoas();
    
    Stream stream = pessoas.stream().filter(pessoa -> pessoas.getNacionalidade().equals("Brasil"));
    
    Predicate<Pessoa> predi1 = new Predicate<Pessoa>() {
        @Override
        public boolean test (Pessoa pessoa) {
            return pessoa.getNacionalidade().equals("Brasil");
        }
    };
    Stream stream2 = pessoas.stream().filter(predi1);
}
```

### Map

Algumas situações se faz necessário realizar transformações numa lista de dados. O método `map()` permite realizar essas mudanças sem a necessidade de variáveis intermediárias, apenas utilizando como argumento uma função do tipo `java.util.function.Function`, que, assim como `Predicate<T>`, também é uma interface funcional. Essa função toma cada elemento de uma stream como parâmetro e retorna o elemento processado como resposta. O resultado será uma nova stream contendo os elementos mapeados a partir da stream original.

```
IntStream stream2 = lista.stream()
                .filter(pessoa -> pessoa.getNacionalidade().equals("Holanda"))
                .mapToInt(Pessoa::getIdade);
```

Nesse trecho de código pode-se ter um problema com a utilização do método `map()`, haja vista que o seu retorno é do tipo `Stream<Interger>`. Esse fato gera o boxing dos valores inteiros, isto é a necessidade de correspondente do objeto wrapper.

Pensando nisso, a *Streams API* oferece implementações para os principais tipos primitivos:
`IntStream`, `DoubleStream`, `LongStream`. Nesse exemplo, portanto, pode-se usar o **IntStream** para evitar o autoboxing e chamar o método `mapToInt()` ao invés do `map()`.

### Sorted

A ordenação de elementos em coleções é uma tarefa recorrente no dia a dia de todo desenvolvedor. No Java 8, felizmente, isso foi bastente facilitado, eliminando a necessidade de implementar o verboso Comparador, assim como as classes internas anônimas, proporcionando ao código clareza e simlicidade. Para isso, a *Streams API* oferece a operação `sorted()`. Esse método retorna uma nova stream contendo os elemnetos da stream original ordenado de acordo com algum critério.

```
private static void sorted() {
    System.outprint("sorted");
    List<Pessoa> pessoa = new Pessoa().popularPessoas();
    Stream stream = pessoas.stream()
        .filter(pessoa -> pessoa.getNacionalidade().equals("Brasil"))
        .sorted(Comparator.comparing(Pessoa::getNome));
        
    Stream stream1 = pessoas.stream()
        .filter(pessoa -> pessoa.getNacionalidade().equals("Brasil"))
        .sorted(Comparator.comparing(Pessoa::getIdade));
        
    stream1.forEach(i -> System.out.println(i));
    
    Stream stream2 = pessoas.stream()
        .filter(pessoa -> pessoa.getNacionalidade().equals("Brasil"))
        .sorted((p1, p2) -> Integer.compare(p2.getIdade(), p1.getIdade()));
        
    stream2.forEach(i -> System.out.println(i));
}
```

### Distinct

A operação `distinct()` retorna uma stream contendo apenas elementos que são exclusivos, isto é, que não se repetem, conforme a implementação do método `equals()`.

### Limit

O método `limit()` é utilizado para limitar os números de elementos em uma stream. É uma operação conhecidada como curto-circuito devido ao fato de não precisar processar todos os elementos. Como exemplo, o códiigo a seguir demonstra como retornar uma stream com apenas os dois primeiros elementos:

```
private static voi limit() {
    System.out.println("limit");
    List<Pessoa> stream = pessoas.Stream().limit(2);
}
```

## Operações Terminais

Esse tipo de operação pode ser identificada pelo tipo de retorno do método, uma vez que uma operação terminal nunca retorna uma interface Stream, mas sim um resultado *(List, String, Long, Integer, etc.) ou void*.

Algumas das operações terminais mais utilizadas são:
`ForEach`, `Collect`, `Count`, `anyMatch` e `allMatch`.

### ForEach

Através do método forEach() é possivel realizar um loop sobre todos os elementos de uma stream e executar algum tipo de processamento. No exemplo a seguir, o parâmetro que o método `forEach()` recebe uma expressão *Lambda* que invoca o método `getNome()` do objeto pessoa e imprime o seu retorno no console. Assim, serão exibidos os nomes de todas as pessoas presentes na coleção.

```
private static void forEach() {
    System.out.println("**** forEach ****");
    List<Pessoa> pessoas = new Pessoa().popularPessoas();
    pessoas.stream().forEach(pessoa -> System.out.println(pessoa.getNome()));
    pessoas.forEach(pessoa -> System.out.println(pessoa.getNome()));
}
```

### Count

O método `count()` retorna a quantidade de elementos presentes em uma stream. Ela é classificada como uma operação de redução *(reduction)*. Como exemplo, o trecho de código a seguir mostra como obter o número de pessoas numa lista cujo nome começa com a letra "M":

```
private static void count() {
    System.out.println("*** Count ***");
    List<Pessoas> pessoas = new Pessoa().popularPessoas();
    long count = pessoas.stream()
        .filter(pessoa -> pessoa.getNome().startsWith("M"))
        .count();
}
```

### AllMatch

Um padrão de processamento comum em aplicações consiste em verificar se os elementos de uma coleção correspondem a um determinado predicado, isto é, a uma caracteristica ou propriedade do objeto.
O método `allMatch()` verifica se todos os elementos de uma stream atendem a um critério passado como parâmetro, por um *Predicate*, e retorna um valor *booleano*.

No exemplo a seguir, cada elemento da stream é submetido a uma condição, que nesse caso é verificar se a pessoa nasceu no México. Se todos os elementos obedecem a essa condição, será retornado `true`. Caso algum dos elementos não satisfaça ao predicado, será retornado `false`.

```
public static void main(String[] args) {
        List<Pessoa> lista = new Pessoa().popularPessoa();        
        boolean result = lista.stream()
                .allMatch(pessoa -> pessoa.getNacionalidade().equals("México"));
        System.out.println(result);
    }
```

### Collect

O método `collect()` possibilita coletar os elemntos de uma stream na forma de coleções, convertendo uma stream para os tipos *List, Set ou Map*.

```
private static void collect() {
Lista<Pessoa> pessoas = new Pessoa().popularPessoas();
Lista<Pessoa> pessoasComM = pessoas.stream()
    .filter(pessoa -> pessoa.getNome().startsWith("M"))
    .collect(Collectors.toList());
pessoasComM.forEach(pessoa -> System.out.println(pessoa));
}
```

```
Set<Pessoa> treeSet = pessoas.stream()
        .filter(pessoa -> pessoa.getNome().startsWith("M"))
        .collect(Collectors.toSet());
        
ArrayList<Pessoa> list = pesoas.stream()
        .filter(pessoa -> pessoa.getNome().startsWith("M"))
        .collect(Collectors.toCollection(ArrayList::new));
        
TreeSet<Pessoa> treeSet = pessoas.stream()
        .filter(pessoa -> pessoa.getNome().startsWith("M"))
        .collect(Collectors.toCollection(TreeSet::new));
```

```
Map<Integer, Pessoa> map = pessoas.stream()
    .collect(Collectors.toMap(Pessoa::getIdade, Pessoa::new));
    
Map<Integer, List<Pessoa>> grupoPorIdade = pessoas.stream()
    .collect(Collectors.groupingBy(Pessoa::getIdade));
    
Map<String, List<Pessoa>> grupoPorNacionalidade = pessoas.stream()
    .collect(Collectors.groupingBy(Pessoas::getNacionalidade;
    
Map<String, Integer> grupoPorNacionalidadeSomadosIdades = Pessoas.stream()
    .collect(Collectors.groupingBy(Pessoas::getNacionalidade,
        Collectors.summingInt(Pessoas::getIdade));
```

## Valores Opcionais

Optionals surgiram para evitar **nullPointerExceptions** e antes de tentar obter algo, podemos validar se realmente existe.
```
private static void optional() {
    System.out.println("*** optional ***");
    List<Pessoa> pessoa = newPessoa().populaPessoas();
    
    Optional<Pessoa> max = pessoas.stream()
        .max(Comparator.comapring(Pessoa::getIdade));
    if (maxIsPresent()) {
        System.out.println(max.get());
    }
    
    max.isPresent(System.out::println;
```
```
Optional<Pessoa> min = lista.stream()
    .min(Comparator.comparing(Pessoa::getIdade));

min.ifPresentOrElse(System.out::println, new Runnable() {
    @Override
    public void run() {
        //Buscar outra vez em algum lugar
    }
});

Pessoa value = min.orElseThrow();
```