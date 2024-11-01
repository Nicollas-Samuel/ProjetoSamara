//integrantes do grupo: Nícollas Samuel, Wendel Gomes, Guthyerre Davi e Vitor Gabriel

package Application;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Adicionar elemento");
            System.out.println("2. Remover elemento");
            System.out.println("3. Inverter lista");
            System.out.println("4. Obter nó do meio");
            System.out.println("5. Remover duplicatas");
            System.out.println("6. Imprimir lista");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Digite o valor a ser adicionado: ");
                    int valueToAdd = scanner.nextInt();
                    System.out.print("Digite a posição (0 para início): ");
                    int positionToAdd = scanner.nextInt();
                    try {
                        linkedList.addAtPosition(valueToAdd, positionToAdd);
                        System.out.println("Elemento adicionado com sucesso.");
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                    //Essa função vai pegar o dado que o usuário inserrir, vai pecorrer a lista até a posição indicada,
                    //caso a posição seja invalida o código irá gerar um erro
                    //e caso já tenha um dado no respectivo nó, esse dado vai ir para a posição n + 1

                case 2:
                    System.out.print("Digite o valor a ser removido: ");
                    int valueToRemove = scanner.nextInt();
                    linkedList.removeElement(valueToRemove);
                    break;
                    //Essa função irá remover o elemento indicado pelo scanner

                case 3:
                    linkedList.reverseList();
                    System.out.println("Lista invertida com sucesso.");
                    break;
                    //Essa função irá inverter a lista ajustando os ponteiros de cada nó para que eles apontem para o nó 
                    //anterior e o primeiro nó será considerado o último

                case 4:
                    Node middleNode = linkedList.getMiddleNode();
                    if (middleNode != null) {
                        System.out.println("Nó do meio: " + middleNode.value);
                    } else {
                        System.out.println("A lista está vazia.");
                    }
                    break;
                    //Essa função irá ultilizar dois ponteiros: o ponteiro lento(que irá se mover 1 posição por vez) e o 
                    //ponteiro rápido(que irá se mover 2 posições por vez), esse processo será repetido até que o ponteiro
                    //rápido chegue ao final da lista, que irá resultar no seguinte:
                    //quando o ponteiro rápido chegar no final da lista, o ponteiro lento estará exatamente no meio da lista,
                    //assim essa função irá retornar o ponteiro lento que irá ser o respectivo nó requisitado

                case 5:
                    linkedList.removeDuplicates();
                    System.out.println("Duplicatas removidas com sucesso.");
                    break;
                    //Essa função vai inserir os elementos 1 por 1 dentro do hash e vali comparando cada valor com o próximo,
                    //caso tenha algum número repetido, ele será excluido

                case 6:
                    System.out.print("Lista atual: ");
                    linkedList.printList();
                    break;
                    //Essa função sempre que a quantidade de elementos for maior do que 0, ela vai pegar nó por nó e vai imprimindo no console

                case 0:
                    System.out.println("Programa encerrado");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (choice != 0);

        scanner.close();
    }
}