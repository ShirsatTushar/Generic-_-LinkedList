import java.util.*;

// Node class
class node<T> {
    public T data;
    public node<T> next;
    public node<T> prev;
}

// Doubly Circular Linked List class
class DoublyCircular<T> {
    private node<T> first;
    private node<T> last;
    private int iCount;

    public DoublyCircular() {
        first = null;
        last = null;
        iCount = 0;
    }

    public void InsertFirst(T No) {
        node<T> newn = new node<T>();
        newn.data = No;

        if (first == null) {
            first = newn;
            last = newn;
        } else {
            newn.next = first;
            first.prev = newn;
            first = newn;
        }

        first.prev = last;
        last.next = first;
        iCount++;
    }

    public void InsertLast(T No) {
        node<T> newn = new node<T>();
        newn.data = No;

        if (first == null) {
            first = newn;
            last = newn;
        } else {
            last.next = newn;
            newn.prev = last;
            last = newn;
        }

        first.prev = last;
        last.next = first;
        iCount++;
    }

    public void InsertAtPos(T No, int Pos) {
        if (Pos < 1 || Pos > iCount + 1) {
            System.out.println("Invalid Position...");
            return;
        }

        if (Pos == 1) {
            InsertFirst(No);
        } else if (Pos == iCount + 1) {
            InsertLast(No);
        } else {
            node<T> newn = new node<T>();
            newn.data = No;

            node<T> temp = first;
            for (int iCnt = 1; iCnt < Pos - 1; iCnt++) {
                temp = temp.next;
            }

            newn.next = temp.next;
            newn.prev = temp;
            temp.next.prev = newn;
            temp.next = newn;

            iCount++;
        }
    }

    public void DeleteFirst() {
        if (first == null) {
            return;
        }

        if (first == last) {
            first = null;
            last = null;
        } else {
            first = first.next;
            first.prev = last;
            last.next = first;
        }

        iCount--;
    }

    public void DeleteLast() {
        if (first == null) {
            return;
        }

        if (first == last) {
            first = null;
            last = null;
        } else {
            last = last.prev;
            last.next = first;
            first.prev = last;
        }

        iCount--;
    }

    public void DeleteAtPos(int Pos) {
        if (Pos < 1 || Pos > iCount) {
            System.out.println("Invalid Position...");
            return;
        }

        if (Pos == 1) {
            DeleteFirst();
        } else if (Pos == iCount) {
            DeleteLast();
        } else {
            node<T> temp = first;

            for (int iCnt = 1; iCnt < Pos - 1; iCnt++) {
                temp = temp.next;
            }

            node<T> target = temp.next;
            temp.next = target.next;
            target.next.prev = temp;

            iCount--;
        }
    }

    public void Display() {
        if (first == null) {
            System.out.println("List is empty");
            return;
        }

        node<T> temp = first;

        System.out.println("Elements of linked list are:");
        do {
            System.out.print("<=> | " + temp.data + " | ");
            temp = temp.next;
        } while (temp != first);

        System.out.println("<=>\n");
    }

    public int Count() {
        return iCount;
    }
}

// Main class with menu
public class DoublyCircurlarGen {
    public static void main(String[] args) {
        Scanner sobj = new Scanner(System.in);

        System.out.println("Select data type:");
        System.out.println("1. Integer");
        System.out.println("2. Character");
        System.out.println("3. Double");
        System.out.println("4. String");
        System.out.print("Enter choice: ");
        int datatype = sobj.nextInt();
        sobj.nextLine(); // clear buffer

        int choice = 1;

        if (datatype == 1) {
            DoublyCircular<Integer> obj = new DoublyCircular<>();

            while (choice != 0) {
                showMenu();
                choice = sobj.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter Integer: ");
                        obj.InsertFirst(sobj.nextInt());
                        break;

                    case 2:
                        System.out.print("Enter Integer: ");
                        obj.InsertLast(sobj.nextInt());
                        break;

                    case 3:
                        System.out.print("Enter Integer: ");
                        int val = sobj.nextInt();
                        System.out.print("Enter Position: ");
                        int pos = sobj.nextInt();
                        obj.InsertAtPos(val, pos);
                        break;

                    case 4:
                        obj.DeleteFirst();
                        break;

                    case 5:
                        obj.DeleteLast();
                        break;

                    case 6:
                        System.out.print("Enter Position: ");
                        int delPos = sobj.nextInt();
                        obj.DeleteAtPos(delPos);
                        break;

                    case 7:
                        obj.Display();
                        break;

                    case 8:
                        System.out.println("Count: " + obj.Count());
                        break;

                    case 0:
                        System.out.println("Thank you!");
                        break;

                    default:
                        System.out.println("Invalid choice!");
                        break;
                }
            }
        }
        else if (datatype == 2) {
            DoublyCircular<Character> obj = new DoublyCircular<>();

            while (choice != 0) {
                showMenu();
                choice = sobj.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter Character: ");
                        obj.InsertFirst(sobj.next().charAt(0));
                        break;

                    case 2:
                        System.out.print("Enter Character: ");
                        obj.InsertLast(sobj.next().charAt(0));
                        break;

                    case 3:
                        System.out.print("Enter Character: ");
                        char ch = sobj.next().charAt(0);
                        System.out.print("Enter Position: ");
                        int pos = sobj.nextInt();
                        obj.InsertAtPos(ch, pos);
                        break;

                    case 4:
                        obj.DeleteFirst();
                        break;

                    case 5:
                        obj.DeleteLast();
                        break;

                    case 6:
                        System.out.print("Enter Position: ");
                        int delPos = sobj.nextInt();
                        obj.DeleteAtPos(delPos);
                        break;

                    case 7:
                        obj.Display();
                        break;

                    case 8:
                        System.out.println("Count: " + obj.Count());
                        break;

                    case 0:
                        System.out.println("Thank you!");
                        break;

                    default:
                        System.out.println("Invalid choice!");
                        break;
                }
            }
        }
        else if (datatype == 3) {
            DoublyCircular<Double> obj = new DoublyCircular<>();

            while (choice != 0) {
                showMenu();
                choice = sobj.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter Double: ");
                        obj.InsertFirst(sobj.nextDouble());
                        break;

                    case 2:
                        System.out.print("Enter Double: ");
                        obj.InsertLast(sobj.nextDouble());
                        break;

                    case 3:
                        System.out.print("Enter Double: ");
                        double val = sobj.nextDouble();
                        System.out.print("Enter Position: ");
                        int pos = sobj.nextInt();
                        obj.InsertAtPos(val, pos);
                        break;

                    case 4:
                        obj.DeleteFirst();
                        break;

                    case 5:
                        obj.DeleteLast();
                        break;

                    case 6:
                        System.out.print("Enter Position: ");
                        int delPos = sobj.nextInt();
                        obj.DeleteAtPos(delPos);
                        break;

                    case 7:
                        obj.Display();
                        break;

                    case 8:
                        System.out.println("Count: " + obj.Count());
                        break;

                    case 0:
                        System.out.println("Thank you!");
                        break;

                    default:
                        System.out.println("Invalid choice!");
                        break;
                }
            }
        }
        else if (datatype == 4) {
            DoublyCircular<String> obj = new DoublyCircular<>();

            while (choice != 0) {
                showMenu();
                choice = sobj.nextInt();
                sobj.nextLine(); // clear buffer

                switch (choice) {
                    case 1:
                        System.out.print("Enter String: ");
                        obj.InsertFirst(sobj.nextLine());
                        break;

                    case 2:
                        System.out.print("Enter String: ");
                        obj.InsertLast(sobj.nextLine());
                        break;

                    case 3:
                        System.out.print("Enter String: ");
                        String str = sobj.nextLine();
                        System.out.print("Enter Position: ");
                        int pos = sobj.nextInt();
                        sobj.nextLine(); // clear buffer
                        obj.InsertAtPos(str, pos);
                        break;

                    case 4:
                        obj.DeleteFirst();
                        break;

                    case 5:
                        obj.DeleteLast();
                        break;

                    case 6:
                        System.out.print("Enter Position: ");
                        int delPos = sobj.nextInt();
                        sobj.nextLine(); // clear buffer
                        obj.DeleteAtPos(delPos);
                        break;

                    case 7:
                        obj.Display();
                        break;

                    case 8:
                        System.out.println("Count: " + obj.Count());
                        break;

                    case 0:
                        System.out.println("Thank you!");
                        break;

                    default:
                        System.out.println("Invalid choice!");
                        break;
                }
            }
        }
        else {
            System.out.println("Invalid data type!");
        }
    }

    public static void showMenu() {
        System.out.println("----------------------------------------------");
        System.out.println("----------- DOUBLY CIRCULAR GENERIC ----------");
        System.out.println("----------------------------------------------");
        System.out.println("1. Insert First");
        System.out.println("2. Insert Last");
        System.out.println("3. Insert At Position");
        System.out.println("4. Delete First");
        System.out.println("5. Delete Last");
        System.out.println("6. Delete At Position");
        System.out.println("7. Display");
        System.out.println("8. Count");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }
}
