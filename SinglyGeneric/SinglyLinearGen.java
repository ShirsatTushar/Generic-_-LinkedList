import java.util.*;

class Node<T>
{
    public T data;
    public Node<T> next;
}

class SinglyLinear<T>
{
    private Node<T> first;
    private int iCount;

    public SinglyLinear()
    {
        first = null;
        iCount = 0;
    }

    public void Display()
    {
        Node<T> temp = first;

        while (temp != null)
        {
            System.out.print("| " + temp.data + " | -> ");
            temp = temp.next;
        }

        System.out.println();
    }

    public int Count()
    {
        return iCount;
    }

    public void InsertFirst(T no)
    {
        Node<T> newn = new Node<T>();
        newn.data = no;
        newn.next = null;

        if (first == null)
        {
            first = newn;
        }
        else
        {
            newn.next = first;
            first = newn;
        }

        iCount++;
    }

    public void InsertLast(T no)
    {
        Node<T> newn = new Node<T>();
        newn.data = no;
        newn.next = null;

        if (first == null)
        {
            first = newn;
        }
        else
        {
            Node<T> temp = first;

            while (temp.next != null)
            {
                temp = temp.next;
            }

            temp.next = newn;
        }

        iCount++;
    }

    public void InsertAtPos(T no, int pos)
    {
        if (pos < 1 || pos > iCount + 1)
        {
            System.out.println("Invalid Position");
            return;
        }

        if (pos == 1)
        {
            InsertFirst(no);
        }
        else if (pos == iCount + 1)
        {
            InsertLast(no);
        }
        else
        {
            Node<T> temp = first;

            for (int i = 1; i < pos - 1; i++)
            {
                temp = temp.next;
            }

            Node<T> newn = new Node<T>();
            newn.data = no;
            newn.next = temp.next;
            temp.next = newn;

            iCount++;
        }
    }

    public void DeleteFirst()
    {
        if (first == null)
        {
            return;
        }

        first = first.next;

        iCount--;
    }

    public void DeleteLast()
    {
        if (first == null)
        {
            return;
        }

        if (first.next == null)
        {
            first = null;
        }
        else
        {
            Node<T> temp = first;

            while (temp.next.next != null)
            {
                temp = temp.next;
            }

            temp.next = null;
        }

        iCount--;
    }

    public void DeleteAtPos(int pos)
    {
        if (pos < 1 || pos > iCount)
        {
            System.out.println("Invalid Position");
            return;
        }

        if (pos == 1)
        {
            DeleteFirst();
        }
        else if (pos == iCount)
        {
            DeleteLast();
        }
        else
        {
            Node<T> temp = first;

            for (int i = 1; i < pos - 1; i++)
            {
                temp = temp.next;
            }

            temp.next = temp.next.next;

            iCount--;
        }
    }
}

public class SinglyLinearGen
{
    public static void main(String[] args)
    {
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

        if (datatype == 1)
        {
            SinglyLinear<Integer> obj = new SinglyLinear<Integer>();

            while (choice != 0)
            {
                showMenu();
                choice = sobj.nextInt();

                switch (choice)
                {
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
        else if (datatype == 2)
        {
            SinglyLinear<Character> obj = new SinglyLinear<Character>();

            while (choice != 0)
            {
                showMenu();
                choice = sobj.nextInt();

                switch (choice)
                {
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
        else if (datatype == 3)
        {
            SinglyLinear<Double> obj = new SinglyLinear<Double>();

            while (choice != 0)
            {
                showMenu();
                choice = sobj.nextInt();

                switch (choice)
                {
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
        else if (datatype == 4)
        {
            SinglyLinear<String> obj = new SinglyLinear<String>();

            while (choice != 0)
            {
                showMenu();
                choice = sobj.nextInt();
                sobj.nextLine(); // clear buffer

                switch (choice)
                {
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
        else
        {
            System.out.println("Invalid data type!");
        }
    }

    public static void showMenu()
    {
        System.out.println("---------------------------------------------------------");
        System.out.println("------------------SINGLY-LINEAR-IN-GENERIC---------------");
        System.out.println("---------------------------------------------------------");
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
