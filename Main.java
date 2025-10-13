/*
 * Grupo:
 * Bruna Amorim Maia - 10431883
 * Rafael Araujo Cabral Moreira - 10441919
 * Rute Willemann - 10436781
 
 * * Referências consultadas:
 * 1. [Ex: GeeksForGeeks - AVL Tree Insertion]
 * 2. [Ex: Baeldung - AVL Tree in Java]
 */

public class Main {
    public static void main(String[] args) {

        // ===================================================================
        // TAREFA DA PESSOA 3: TESTES DE INSERÇÃO E REMOÇÃO
        // ===================================================================
        
        System.out.println("--- INÍCIO DOS TESTES DO LAB2B ---");

        // TODO Pessoa 3: Teste (a): Inserir 1, 2, 3 (deve causar rotação RR)
        System.out.println("\n--- Teste (a): Inserindo 1, 2, 3 ---");
        AVL avlA = new AVL();
        avlA.insert(1);
        avlA.insert(2);
        avlA.insert(3);
        printTreeDetails(avlA.getRoot());

        // TODO Pessoa 3: Teste (b): Inserir 3, 2, 1 (deve causar rotação LL)
        System.out.println("\n--- Teste (b): Inserindo 3, 2, 1 ---");
        // Crie uma nova árvore, insira os nós e chame printTreeDetails().
        
        // TODO Pessoa 3: Teste (c): Inserir 3, 1, 2 (deve causar rotação LR)
        System.out.println("\n--- Teste (c): Inserindo 3, 1, 2 ---");
        // Crie uma nova árvore, insira os nós e chame printTreeDetails().

        // TODO Pessoa 3: Teste (d): Inserir 1, 3, 2 (deve causar rotação RL)
        System.out.println("\n--- Teste (d): Inserindo 1, 3, 2 ---");
        // Crie uma nova árvore, insira os nós e chame printTreeDetails().

        System.out.println("\n-------------------------------------------------");
        System.out.println("--- MONTANDO ÁRVORE PARA TESTES DE REMOÇÃO ---");
        
        // TODO Pessoa 3: Teste (e): Montar a árvore base para os testes de remoção.
        System.out.println("\n--- Teste (e): Inserindo 5, 4, 3, 1, 2, 6, 7, 9, 8 ---");
        AVL avlParaRemocao = new AVL();
        int[] chaves = {5, 4, 3, 1, 2, 6, 7, 9, 8};
        for (int chave : chaves) {
            avlParaRemocao.insert(chave);
        }
        System.out.println("Árvore após todas as inserções (item e):");
        printTreeDetails(avlParaRemocao.getRoot());

        // TODO Pessoa 3: Teste (f): Remover o nó 4 da árvore anterior.
        System.out.println("\n--- Teste (f): Removendo o nó 4 ---");
        // Chame o método remove() na árvore 'avlParaRemocao' e depois chame printTreeDetails().
        
        // TODO Pessoa 3: Teste (g): Remover o nó 5 da árvore anterior.
        System.out.println("\n--- Teste (g): Removendo o nó 5 ---");
        // Continue usando a mesma árvore, remova o nó 5 e chame printTreeDetails().

        // TODO Pessoa 3: Teste (h): Remover o nó 1 da árvore anterior.
        System.out.println("\n--- Teste (h): Removendo o nó 1 ---");
        // Continue usando a mesma árvore, remova o nó 1 e chame printTreeDetails().
        
        System.out.println("\n--- FIM DOS TESTES ---");
    }

    // Método auxiliar para exibir a árvore (já pronto).
    public static void printTreeDetails(Node node) {
        if (node == null) return;

        String pai = node.getParent() == null ? "null" : String.valueOf(node.getParent().getData());
        String esq = node.getLeft() == null ? "null" : String.valueOf(node.getLeft().getData());
        String dir = node.getRight() == null ? "null" : String.valueOf(node.getRight().getData());

        System.out.println(
            "Nó: " + String.format("%-2d", node.getData()) +
            " | Pai: " + String.format("%-4s", pai) +
            " | Esq: " + String.format("%-4s", esq) +
            " | Dir: " + String.format("%-4s", dir) +
            " | FB: " + node.getBalanceFactor()
        );

        printTreeDetails(node.getLeft());
        printTreeDetails(node.getRight());
    }
}
