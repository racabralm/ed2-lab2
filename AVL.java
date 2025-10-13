/*
 * Grupo:
 * Bruna Amorim Maia - 10431883
 * Rafael Araujo Cabral Moreira - 10441919
 * Rute Willemann - 10436781
 */

public class AVL extends BST {

    public AVL() {
        super();
    }
    
    // ===================================================================
    // TAREFA DA PESSOA 1: INSERÇÃO COM AUTO-BALANCEAMENTO
    // ===================================================================

    @Override
    public void insert(int data) {
        // TODO Pessoa 1: Chame a versão recursiva e privada do insert,
        // atribuindo o resultado à raiz da árvore ('this.root').
        this.root = insert(this.root, data);
    }

    private Node insert(Node node, int data) {
        // Passo 1: Inserção padrão de uma BST.
        if (node == null) {
            return new Node(data);
        }

        if (data < node.getData()) {
            Node leftChild = insert(node.getLeft(), data);
            node.setLeft(leftChild);
            leftChild.setParent(node);
        } else if (data > node.getData()) {
            Node rightChild = insert(node.getRight(), data);
            node.setRight(rightChild);
            rightChild.setParent(node);
        } else {
            return node; // Chave duplicada não é inserida.
        }

        // Passo 2: Balancear o nó atual (no caminho de volta da recursão).
        // TODO Pessoa 1: Chame o método 'balance(node)' e retorne o resultado.
        return balance(node);
    }

    // TODO Pessoa 1: Implementar o método de balanceamento.
    // Este método verifica o fator de balanceamento e aplica a rotação apropriada.
    private Node balance(Node node) {
        if (node == null) return null;

        int balanceFactor = node.getBalanceFactor();

        // CASO 1: Árvore desbalanceada para a direita (FB > 1)
        if (balanceFactor > 1) {
            // Verifica se é Rotação Simples (RR) ou Dupla (RL)
            if (node.getRight() != null && node.getRight().getBalanceFactor() >= 0) {
                // Rotação Simples à Esquerda (RR)
                return rotateLeft(node);
            } else {
                // Rotação Dupla Direita-Esquerda (RL)
                return rotateRightLeft(node);
            }
        }

        // CASO 2: Árvore desbalanceada para a esquerda (FB < -1)
        if (balanceFactor < -1) {
            // TODO Pessoa 1: Implementar a lógica para o desbalanceamento à esquerda.
            // Verifique se é Rotação Simples (LL) ou Dupla (LR) e chame o método correto.
            if (node.getLeft() != null && node.getLeft().getBalanceFactor() <= 0) {
                // Rotação Simples à Direita (LL)
                return rotateRight(node);
            } else {
                // Rotação Dupla Esquerda-Direita (LR)
                return rotateLeftRight(node);
            }
        }
        
        // Se a árvore já está balanceada, retorna o próprio nó.
        return node;
    }


    // ===================================================================
    // TAREFA DA PESSOA 2: REMOÇÃO COM AUTO-BALANCEAMENTO
    // ===================================================================
    
    public void remove(int data) {
        // TODO Pessoa 2: Chame a versão recursiva e privada do remove,
        // atribuindo o resultado à raiz da árvore ('this.root').
        this.root = remove(this.root, data);
    }

    private Node remove(Node node, int data) {
        // TODO Pessoa 2: Implementar a lógica de remoção de uma BST.
        // Passo 1: Encontre o nó a ser removido.
        if (node == null) return null;

        if (data < node.getData()) {
            node.setLeft(remove(node.getLeft(), data));
        } else if (data > node.getData()) {
            node.setRight(remove(node.getRight(), data));
        } else {
            // Nó encontrado! Trate os 3 casos de remoção:
            // 1. Nó é folha
            // 2. Nó tem um filho
            // 3. Nó tem dois filhos (neste caso, encontre o sucessor)
            if (node.getLeft() == null || node.getRight() == null) {
                Node temp = (node.getLeft() != null) ? node.getLeft() : node.getRight();
                if (temp == null) { // Sem filhos
                    node = null;
                } else { // Um filho
                    node = temp; 
                }
            } else { // Dois filhos
                Node successor = findMin(node.getRight());
                node.setData(successor.getData());
                node.setRight(remove(node.getRight(), successor.getData()));
            }
        }
        
        if (node == null) return null;

        // Passo 2: Balancear o nó atual (no caminho de volta da recursão).
        // TODO Pessoa 2: Chame o método 'balance(node)' e retorne o resultado.
        return balance(node);
    }
    
    // Método auxiliar para a remoção (já pode ser usado)
    private Node findMin(Node node) {
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        return node;
    }


    // ===================================================================
    // MÉTODOS DE ROTAÇÃO (JÁ PRONTOS DO LAB2A)
    // ===================================================================
    private Node rotateLeft(Node node) { 
        Node newRoot = node.getRight();
        node.setRight(newRoot.getLeft());
        if (newRoot.getLeft() != null) {
            newRoot.getLeft().setParent(node);
        }
        newRoot.setLeft(node);
        newRoot.setParent(node.getParent());
        node.setParent(newRoot);
        return newRoot;
    }

    private Node rotateRight(Node node) { 
        Node newRoot = node.getLeft();
        node.setLeft(newRoot.getRight());
        if (newRoot.getRight() != null) {
            newRoot.getRight().setParent(node);
        }
        newRoot.setRight(node);
        newRoot.setParent(node.getParent());
        node.setParent(newRoot);
        return newRoot;
    }

    private Node rotateLeftRight(Node node) { 
        node.setLeft(rotateLeft(node.getLeft()));
        return rotateRight(node);
    }

    private Node rotateRightLeft(Node node) { 
        node.setRight(rotateRight(node.getRight()));
        return rotateLeft(node);
    }
}
