import java.util.*;

class node<T>
{
    public T data;
    public node<T> next;
};

class SinglyCircular<T>
{
    private node<T> first;
    private node<T> last;

    private int iCount;

    public SinglyCircular()
    {
        first = null;
        last = null;
        iCount = 0;
    }
    public void Display()
    {   
        if(first == null && last == null)
        {
            return;
        }
        System.out.print("->");
        node<T> temp = first;
        do 
        {
            System.out.print("| "+temp.data+" | -> ");
            temp = temp.next;
        }while(temp != first);
        System.out.println();

    }

    public int Count()
    {
        return iCount;
    }

    public void InsertFirst(T No)
    {
        node<T> newn = null;
        newn = new node<T>();
        newn.data = No;
        newn.next = null;

        if(first == null && last == null)
        {
            first = newn;
            last = newn;
            last.next = newn;
        }
        else 
        {
            newn.next = first;
            first = newn;
            last.next = first;
        }
        iCount++;
    }

    public void InsertLast(T No)
    {
        node<T> newn = null;
        newn = new node<T>();
        newn.data = No;
        newn.next = null;

        if(first == null && last == null)
        {
            first = newn;
            last = newn;
            last.next = newn;
        }
        else 
        {
            last.next = newn;
            last = newn;
            last.next = first;
        }
        iCount++;
    }

    public void InsertAtPos(T No, int Pos)
    {
        if(Pos < 1 || Pos > iCount+1 )
        {
            System.out.println("Invalid Position....\n");
            return;
        }

        if(Pos == 1)
        {
            InsertFirst(No);
        }
        else if(Pos == iCount+1)
        {
            InsertLast(No);
        }
        else
        {
            node<T> temp = null;
            temp = first;
            node<T> newn = new node<T>();
            newn.data = No;
            newn.next = null;

            for(int iCnt = 1 ; iCnt < Pos -1 ; iCnt++)
            {
                temp = temp.next;
            }
            newn.next = temp.next;
            temp.next = newn;
            iCount++;

        }
    }

    public void DeleteFirst()
    {
        if(first == null && last == null)
        {
            return;

        }
        if(first == last)
        {
            first = null;
            last = null;
        }
        else
        {
            first = first.next;
            last.next = first;
        }
        iCount--;
    }

    public void DeleteLast()
    {
        node<T> temp = null;
        temp = first;

        if(first == null && last == null)
        {
            return;

        }
        if(first == last)
        {
            first = null;
            last = null;
        }
        else
        {
            while(temp.next != last)
            {
                temp = temp.next;
            }
            last = temp;
            last.next = first;
        }
        iCount--;
    }

    public void DeleteAtPos(int Pos)
    {
        if(Pos < 1 || Pos > iCount)
        {
            System.out.println("Invalid Position....\n");
            return;
        }

        if(Pos == 1)
        {
            DeleteFirst();
        }
        else if(Pos == iCount)
        {
            DeleteLast();
        }
        else
        {
            node<T> temp = null;
            temp = first;
            node<T> target = null;

            for(int iCnt = 1 ; iCnt < Pos -1 ; iCnt++)
            {
                temp = temp.next;
            }
            target = temp.next;
            temp.next = target.next;
            target = null;
            iCount--;

        }
    }


}



public class SinglyCircularGen 
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
        sobj.nextLine(); // Consume leftover newline

        int choice = 1;

        if (datatype == 1)
        {
            SinglyCircular<Integer> obj = new SinglyCircular<>();

            while (choice != 0)
            {
                showMenu();
                choice = sobj.nextInt();

                switch (choice)
                {
                    case 1:
                    {
                        System.out.print("Enter Integer: ");
                        obj.InsertFirst(sobj.nextInt());
                        break;
                    }
                    case 2:
                    {
                        System.out.print("Enter Integer: ");
                        obj.InsertLast(sobj.nextInt());
                        break;
                    }
                    case 3:
                    {
                        System.out.print("Enter Integer: ");
                        int value = sobj.nextInt();
                        System.out.print("Enter position: ");
                        int pos = sobj.nextInt();
                        obj.InsertAtPos(value, pos);
                        break;
                    }
                    case 4:
                    {
                        obj.DeleteFirst();
                        break;
                    }
                    case 5:
                    {
                        obj.DeleteLast();
                        break;
                    }
                    case 6:
                    {
                        System.out.print("Enter position: ");
                        int pos = sobj.nextInt();
                        obj.DeleteAtPos(pos);
                        break;
                    }
                    case 7:
                    {
                        obj.Display();
                        break;
                    }
                    case 8:
                    {
                        System.out.println("Count: " + obj.Count());
                        break;
                    }
                    case 0:
                    {
                        System.out.println("Thank you!");
                        break;
                    }
                    default:
                    {
                        System.out.println("Invalid choice!");
                        break;
                    }
                }
            }
        }
        else if (datatype == 2)
        {
            SinglyCircular<Character> obj = new SinglyCircular<>();

            while (choice != 0)
            {
                showMenu();
                choice = sobj.nextInt();

                switch (choice)
                {
                    case 1:
                    {
                        System.out.print("Enter char: ");
                        obj.InsertFirst(sobj.next().charAt(0));
                        break;
                    }
                    case 2:
                    {
                        System.out.print("Enter char: ");
                        obj.InsertLast(sobj.next().charAt(0));
                        break;
                    }
                    case 3:
                    {
                        System.out.print("Enter char: ");
                        char value = sobj.next().charAt(0);
                        System.out.print("Enter position: ");
                        int pos = sobj.nextInt();
                        obj.InsertAtPos(value, pos);
                        break;
                    }
                    case 4:
                    {
                        obj.DeleteFirst();
                        break;
                    }
                    case 5:
                    {
                        obj.DeleteLast();
                        break;
                    }
                    case 6:
                    {
                        System.out.print("Enter position: ");
                        int pos = sobj.nextInt();
                        obj.DeleteAtPos(pos);
                        break;
                    }
                    case 7:
                    {
                        obj.Display();
                        break;
                    }
                    case 8:
                    {
                        System.out.println("Count: " + obj.Count());
                        break;
                    }
                    case 0:
                    {
                        System.out.println("Thank you!");
                        break;
                    }
                    default:
                    {
                        System.out.println("Invalid choice!");
                        break;
                    }
                }
            }
        }
        else if (datatype == 3)
        {
            SinglyCircular<Double> obj = new SinglyCircular<>();

            while (choice != 0)
            {
                showMenu();
                choice = sobj.nextInt();

                switch (choice)
                {
                    case 1:
                    {
                        System.out.print("Enter double: ");
                        obj.InsertFirst(sobj.nextDouble());
                        break;
                    }
                    case 2:
                    {
                        System.out.print("Enter double: ");
                        obj.InsertLast(sobj.nextDouble());
                        break;
                    }
                    case 3:
                    {
                        System.out.print("Enter double: ");
                        double value = sobj.nextDouble();
                        System.out.print("Enter position: ");
                        int pos = sobj.nextInt();
                        obj.InsertAtPos(value, pos);
                        break;
                    }
                    case 4:
                    {
                        obj.DeleteFirst();
                        break;
                    }
                    case 5:
                    {
                        obj.DeleteLast();
                        break;
                    }
                    case 6:
                    {
                        System.out.print("Enter position: ");
                        int pos = sobj.nextInt();
                        obj.DeleteAtPos(pos);
                        break;
                    }
                    case 7:
                    {
                        obj.Display();
                        break;
                    }
                    case 8:
                    {
                        System.out.println("Count: " + obj.Count());
                        break;
                    }
                    case 0:
                    {
                        System.out.println("Thank you!");
                        break;
                    }
                    default:
                    {
                        System.out.println("Invalid choice!");
                        break;
                    }
                }
            }
        }
        else if (datatype == 4)
        {
            SinglyCircular<String> obj = new SinglyCircular<>();

            while (choice != 0)
            {
                showMenu();
                choice = sobj.nextInt();
                sobj.nextLine();

                switch (choice)
                {
                    case 1:
                    {
                        System.out.print("Enter string: ");
                        obj.InsertFirst(sobj.nextLine());
                        break;
                    }
                    case 2:
                    {
                        System.out.print("Enter string: ");
                        obj.InsertLast(sobj.nextLine());
                        break;
                    }
                    case 3:
                    {
                        System.out.print("Enter string: ");
                        String value = sobj.nextLine();
                        System.out.print("Enter position: ");
                        int pos = sobj.nextInt();
                        sobj.nextLine();
                        obj.InsertAtPos(value, pos);
                        break;
                    }
                    case 4:
                    {
                        obj.DeleteFirst();
                        break;
                    }
                    case 5:
                    {
                        obj.DeleteLast();
                        break;
                    }
                    case 6:
                    {
                        System.out.print("Enter position: ");
                        int pos = sobj.nextInt();
                        sobj.nextLine();
                        obj.DeleteAtPos(pos);
                        break;
                    }
                    case 7:
                    {
                        obj.Display();
                        break;
                    }
                    case 8:
                    {
                        System.out.println("Count: " + obj.Count());
                        break;
                    }
                    case 0:
                    {
                        System.out.println("Thank you!");
                        break;
                    }
                    default:
                    {
                        System.out.println("Invalid choice!");
                        break;
                    }
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
        System.out.println("----------------SINGLY-CIRCULAR-IN-GENERIC---------------");
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
