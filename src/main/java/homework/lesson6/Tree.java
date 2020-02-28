package homework.lesson6;

public class Tree<T extends Comparable<T>> {
    private Node<T> root;

    public Node<T> min() {
        Node<T> current, last = null;
        current = root;
        while (current != null) {
            last = current;
            current = current.leftChild;
        }

        return last;
    }

    public Node<T> max() {
        Node<T> current, last = null;
        current = root;
        while (current != null) {
            last = current;
            current = current.rightChild;
        }
        return last;
    }

    public Node<T> find(T key){
        Node<T> current = root;
        while (current.value != key) {
            if (key.compareTo(current.value) < 0){
                current = current.leftChild;
            } else {
                current = current.rightChild;
            }

            if (current == null){
                return null;
            }
        }
        return current;
    }

    public void insert(T value){
        Node<T> node = new Node();
        node.value = value;
        if (root == null){
            root = node;
            root.level = 0;
        } else {
            Node<T> current = root;
            Node<T> parent;
            while (true) {
                parent = current;
                if (value.compareTo(current.value) < 0){
                    current = current.leftChild;
                    if (current == null){
                        parent.leftChild = node;
                        parent.leftChild.level = parent.level + 1;
                        return;
                    }
                } else {
                    current = current.rightChild;
                    if (current == null){
                        parent.rightChild = node;
                        parent.rightChild.level = parent.level + 1;
                        return;
                    }
                }
            }
        }
    }

    public boolean delete(T id){
        Node<T> current = root;
        Node<T> parent = root;
        boolean isLeftChild = true;

        while (current.value != id) {
            parent = current;
            if (id.compareTo(current.value) < 0){
                isLeftChild = true;
                current = current.leftChild;
            } else {
                isLeftChild = false;
                current = current.rightChild;
            }
            if (current == null){
                return false;
            }
        }

        // Если узел не имеет потомков

        if (current.leftChild == null && current.rightChild == null){
            if (current == null){
                root = null;
            } else if(isLeftChild){
                parent.leftChild = null;
            }else{
                parent.rightChild = null;
            }
        }
        // Если нет правого потомка
        else if(current.rightChild == null){
            if (current == null){
                root = current.leftChild;
            } else if(isLeftChild){
                parent.leftChild = current.leftChild;
            }else{
                parent.rightChild = current.leftChild;
            }
        }
        // Если нет левого потомка
        else if(current.leftChild == null){
            if (current == null){
                root = current.rightChild;
            } else if(isLeftChild){
                parent.leftChild = current.rightChild;
            } else {
                parent.rightChild = current.rightChild;
            }
        } else {
            Node<T> successor = getSuccesor(current);
            if (current == root){
                root = successor;
            }else if(isLeftChild){
                parent.leftChild = successor;
            }else {
                parent.rightChild = successor;
            }
            successor.leftChild = current.leftChild;
        }
        return true;
    }

    public Node<T> getSuccesor(Node<T> node){
        Node<T> successorParent = node;
        Node<T> successor = node;
        Node<T> current = node.rightChild;

        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }
        if (successor != node.rightChild){
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = node.rightChild;
        }

        return successor;
    }

    public void traverse(int traverseType){
        switch(traverseType){
            case 1:System.out.println("Preorder traversal");
                preOrder(root);
                break;
        }
    }

    private void preOrder(Node<T> rootNode){
        if(rootNode != null){
            rootNode.display();
            preOrder(rootNode.leftChild);
            preOrder(rootNode.rightChild);
        }
    }

    private void postOrder(Node<T> rootNode){
        if(rootNode != null){
            postOrder(rootNode.leftChild);
            postOrder(rootNode.rightChild);
            rootNode.display();
        }
    }

    private void inOrder(Node<T> rootNode){
        if(rootNode != null){
            inOrder(rootNode.leftChild);
            rootNode.display();
            inOrder(rootNode.rightChild);
        }
    }



    public void displayTree(){
        Stack stack = new Stack(9999);
        stack.push(root);
        int nBlanks = 32;
        boolean isRowEmpty = false;

        while (!isRowEmpty) {
            Stack localStack = new Stack(9999);
            isRowEmpty = true;
            for(int i=0;i<nBlanks;i++){
                System.out.print(" ");
            }
            while (!stack.isEmpty()) {
                Node<T> temp = stack.pop();
                if (temp != null){
                    temp.display();
                    localStack.push(temp.leftChild);
                    localStack.push(temp.rightChild);
                    if(temp.leftChild != null || temp.rightChild != null){
                        isRowEmpty = false;
                    }
                }else{
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for(int j=0; j < nBlanks * 2 - 2; j++)
                    System.out.print(' ');
            }
            System.out.println(" ");
            nBlanks = nBlanks / 2;
            while (!localStack.isEmpty()) {
                stack.push(localStack.pop());
            }
            System.out.println("..........................................");
        }
    }

    public Node<T> getRoot() {
        return root;
    }

    public boolean isBalanced(Node<T> node) {
        int left = 0, right = 0;
        if (node == null) {
            return true;
        }
        if (node.leftChild != null){left = node.leftChild.level;}
        if (node.rightChild != null){right = node.rightChild.level;}
        if (Math.abs(left - right) <= 1
                && isBalanced(node.leftChild)
                && isBalanced(node.rightChild)) {
            return true;
        }
        return false;
    }

}
