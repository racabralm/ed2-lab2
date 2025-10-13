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
//                              INSERÇÃO 
// ===================================================================

    @Override
    public void insert(int data) {
        // chama a insercao recursiva e atualiza a raiz
        this.root = insert(this.root, data);
    }

    private Node insert(Node node, int data) {
        // se chega em um ponto nulo, insere o novo no
        if (node == null) {
            return new Node(data);
        }

        // navega para a esquerda ou direita
        if (data < node.getData()) {
            Node leftChild = insert(node.getLeft(), data);
            node.setLeft(leftChild);
            leftChild.setParent(node);
        } else if (data > node.getData()) {
            Node rightChild = insert(node.getRight(), data);
            node.setRight(rightChild);
            rightChild.setParent(node);
        } else {
            // chave duplicada, retorna o no sem alteracao
            return node; 
        }

        // apos inserir, balanceia o no no caminho de volta
        return balance(node);
    }

    private Node balance(Node node) {
        // se o no e nulo, nao ha o que balancear
        if (node == null) return null;

        // calcula o fator de balanceamento
        int balanceFactor = node.getBalanceFactor();

        // arvore pesada para a direita (fator > 1)
        if (balanceFactor > 1) {
            // se o filho direito tambem pende para a direita, e rotacao simples
            if (node.getRight() != null && node.getRight().getBalanceFactor() >= 0) {
                return rotateLeft(node);
            // senao, e rotacao dupla
            } else {
                return rotateRightLeft(node);
            }
        }

        // arvore pesada para a esquerda (fator < -1)
        if (balanceFactor < -1) {
            // se o filho esquerdo tambem pende para a esquerda, e rotacao simples
            if (node.getLeft() != null && node.getLeft().getBalanceFactor() <= 0) {
                return rotateRight(node);
            // senao, e rotacao dupla
            } else {
                return rotateLeftRight(node);
            }
        }
        
        // se ja esta balanceado, retorna o proprio no
        return node;
    }
    
// ===================================================================
//                              REMOÇÃO 
// ===================================================================

    public void remove(int data) {
        // chama a remocao recursiva e atualiza a raiz
        this.root = remove(this.root, data);
    }

    private Node remove(Node node, int data) {
        // nao encontrou o no para remover
        if (node == null) {
            return null;
        }

        // busca o no recursivamente
        if (data < node.getData()) {
            node.setLeft(remove(node.getLeft(), data));
        } else if (data > node.getData()) {
            node.setRight(remove(node.getRight(), data));
        } else {
            // encontrou o no a ser removido
            // caso com 0 ou 1 filho
            if (node.getLeft() == null) {
                return node.getRight();
            } else if (node.getRight() == null) {
                return node.getLeft();
            }

            // caso com 2 filhos
            // encontra o sucessor (menor no da subarvore direita)
            Node successor = findMin(node.getRight());
            // copia o valor do sucessor para o no atual
            node.setData(successor.getData());
            // remove o sucessor da sua posicao original
            node.setRight(remove(node.getRight(), successor.getData()));
        }
        
        // balanceia o no no caminho de volta da recursao
        return balance(node);
    }
    
    // metodo auxiliar para achar o menor valor a partir de um no
    private Node findMin(Node node) {
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        return node;
    }

    // rotaciona para a esquerda (caso RR)
    private Node rotateLeft(Node node) { 
        Node newRoot = node.getRight();
        Node leftOfNewRoot = newRoot.getLeft();

        // executa a rotacao
        newRoot.setLeft(node);
        node.setRight(leftOfNewRoot);

        // atualiza as referencias de pai
        newRoot.setParent(node.getParent());
        node.setParent(newRoot);
        if (leftOfNewRoot != null) {
            leftOfNewRoot.setParent(node);
        }

        return newRoot;
    }

    // rotaciona para a direita (caso LL)
    private Node rotateRight(Node node) { 
        Node newRoot = node.getLeft();
        Node rightOfNewRoot = newRoot.getRight();

        // executa a rotacao
        newRoot.setRight(node);
        node.setLeft(rightOfNewRoot);

        // atualiza as referencias de pai
        newRoot.setParent(node.getParent());
        node.setParent(newRoot);
        if (rightOfNewRoot != null) {
            rightOfNewRoot.setParent(node);
        }

        return newRoot;
    }

    // rotacao dupla (caso LR)
    private Node rotateLeftRight(Node node) { 
        // primeiro rotaciona o filho a esquerda
        node.setLeft(rotateLeft(node.getLeft()));
        // depois rotaciona o proprio no a direita
        return rotateRight(node);
    }

    // rotacao dupla (caso RL)
    private Node rotateRightLeft(Node node) {
        // primeiro rotaciona o filho a direita
        node.setRight(rotateRight(node.getRight()));
        // depois rotaciona o proprio no a esquerda
        return rotateLeft(node);
    }
}
