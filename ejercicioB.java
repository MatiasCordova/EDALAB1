import java.util.Scanner;
import java.util.*;

public class Lista {

    List head;

    static class List {

        int data;
        List next;

        List(int data, List next) {
            this.data = data;
            this.next = next;
        }

        List(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static public List GrupoAlReves(List head) {
        if (head == null) {
            return null;
        }
        List aux = head;
        int count = 3;
        while (aux != null && count > 0) {
            aux = aux.next;
            count--;
        }
        List last = null;

        if (count > 0) {
            return head;
        } else {
            last = GrupoAlReves(aux);
        }
        count = 3;

        while (head != null && count > 0) {

            List temp = head.next;
            head.next = last;
            last = head;
            head = temp;
            count--;
        }
        return last;
    }

    void push(int data) {
        List aux = new List(data);
        aux.data = data;
        aux.next = head;
        head = aux;
    }

    static void printList(List node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        Lista l1 = new Lista();
        Scanner sc = new Scanner(System.in);
        int n, k;
        System.out.println("Cuantos nodos desea ingresar: ");
        n = sc.nextInt();
        System.out.println("Ingrese los nodos ");
        for (int i = 0; i < n; i++) {
            k = sc.nextInt();
            l1.push(k);
        }
        l1.printList(l1.head);
        l1.head = GrupoAlReves(l1.head);
        System.out.println();

        System.out.println(" Linked list Invertida ");
        printList(l1.head);

    }
}
