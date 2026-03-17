
public class Main {
    public static void main(String[] args) {
        // Criando um grafo
        Grafo grafo = new Grafo();

        // Adicionando vértices
        grafo.adicionarVertice("A");
        grafo.adicionarVertice("B");
        grafo.adicionarVertice("C");
        grafo.adicionarVertice("D");

        // Adicionando arestas
        grafo.adicionarAresta("A", "B");
        grafo.adicionarAresta("A", "C");
        grafo.adicionarAresta("B", "D");
        grafo.adicionarAresta("C", "D");

        // Exibindo o grafo
        System.out.println(grafo);
    }
}
