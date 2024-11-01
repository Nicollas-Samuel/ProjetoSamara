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

                case 2:
                    System.out.print("Digite o valor a ser removido: ");
                    int valueToRemove = scanner.nextInt();
                    linkedList.removeElement(valueToRemove);
                    break;

                case 3:
                    linkedList.reverseList();
                    System.out.println("Lista invertida com sucesso.");
                    break;

                case 4:
                    Node middleNode = linkedList.getMiddleNode();
                    if (middleNode != null) {
                        System.out.println("Nó do meio: " + middleNode.value);
                    } else {
                        System.out.println("A lista está vazia.");
                    }
                    break;

                case 5:
                    linkedList.removeDuplicates();
                    System.out.println("Duplicatas removidas com sucesso.");
                    break;

                case 6:
                    System.out.print("Lista atual: ");
                    linkedList.printList();
                    break;

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