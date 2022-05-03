class dll{
    static class Node{

        int value,size;
        Node head,next,prev;

        Node(){
            this.size = 0;
        }

        Node(int value){
            this.value = value;
        }

        void insertFirst(int value){
            Node node = new Node(value);
            node.next = head;
            if (head != null){
                head.prev = node;
            }
            head = node;
        }

        void insert(int value, int index){
            Node node = new Node(value);
            Node temp = head;
            for (int i = 1; i < index; i++) {
                temp = temp.next;
            }
            temp.next.prev = node;
            node.next = temp.next;
            temp.next = node;
            node.prev = temp;
        }

        void delete(int index){
            Node temp = head;
            for (int i = 1; i <=index; i++) {
                temp = temp.next;
            }
            temp.next.prev = temp.prev;
            temp.prev.next = temp.next;
        }

        void deleteWithValue(int value){
            Node temp = head;
            while (temp != null){
                if (temp.value == value){
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                }
                temp = temp.next;
            }
        }

        void inserLast(int value){
            Node node = new Node(value);
            Node temp = head;
            while (temp.next != null){
                temp = temp.next;
            }
            temp.next = node;
            node.prev = temp;

        }

        void display(){
            Node temp = head;
            Node last = null;
            while (temp != null){
                System.out.print(temp.value + "->");
                last = temp;
                temp = temp.next;
            }
            System.out.println("null");

//            while (last != null){
//                System.out.print(last.value + "->");
//                last = last.prev;
//            }
        }
    }
}

public class test {
    public static void main(String[] args) {
        dll.Node node = new dll.Node();
        node.insertFirst(5);
        node.insertFirst(4);
        node.insertFirst(3);
        node.insertFirst(2);
        node.insertFirst(1);
        node.display();
        System.out.println();

        node.insert(0,3);
        node.display();
        System.out.println();

        node.delete(3);
        node.display();
        System.out.println();

        node.deleteWithValue(3);
        node.display();

        node.inserLast(6);
        node.display();
    }
}