#include<iostream>
using namespace std;



template<class T>
struct node 
{
    T data;
    struct node<T> *next;
    struct node<T> *prev;
};

template<class T>
class DoublyLGen
{
    private :
        struct node<T> * first;
        int iCount;

    public:
        DoublyLGen();

        void InsertFirst(T);
        void InsertLast(T);
        void InsertAtPos(T, int);

        void DeleteFirst();
        void DeleteLast();
        void DeleteAtPos(int);

        void Display();
        int Count();
};


template<class T>
DoublyLGen<T> ::DoublyLGen()
{
    first = NULL;
    iCount =0;
}


template<class T>
void DoublyLGen<T> :: InsertFirst(T No)
{
    struct node<T> *newn = NULL;
    newn = new node<T>;
    newn->data = No;
    newn->next = NULL;
    newn->prev = NULL;

    if(first == NULL)
    {
        first = newn;
    }
    else
    {
        newn->next = first;
        first->prev = newn;
        first = newn;
    }
    iCount++;

}

template<class T>
void DoublyLGen<T> :: InsertLast(T No)
{

    struct node<T> *newn = NULL;
    newn = new node<T>;
    newn->data = No;
    newn->next = NULL;
    newn->prev = NULL;

    if(first == NULL)
    {
        first = newn;
    }
    else
    {
        struct node<T> *temp = first;
        while(temp ->next != NULL)
        {
            temp = temp ->next;
        }
        temp->next = newn;
        newn->prev = temp;
        
    }
    iCount++;

}

template<class T>
void DoublyLGen<T> :: InsertAtPos(T No, int Pos)
{
    if(Pos < 1 || Pos > iCount+1)
    {
        cout<<"Invalid Position....\n";
        return ;
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
        struct node<T> *temp = first;
        struct node<T> *newn = NULL;
        newn = new node<T>;
        newn->data = No;
        newn->next = NULL;
        newn->prev = NULL;

        for(int iCnt = 1 ; iCnt < Pos -1 ; iCnt++)
        {
            temp = temp ->next;
        }
        newn->next = temp->next;
        newn->prev = temp;
        temp->next->prev = newn;
        temp->next = newn;
        iCount++;


    }
}


template<class T>
void DoublyLGen<T> :: DeleteFirst()
{
    if(first == NULL)
    {
        return;
    }
    if(first->next == NULL)
    {
        delete first;
        first = NULL;
    }
    else
    {
        struct node<T> *temp = first;

        first = first->next;
        first->prev = NULL;
        delete temp;
    }
    iCount--;
}


template<class T>
void DoublyLGen<T> :: DeleteLast()
{
    if(first == NULL)
    {
        return;
    }
    if(first->next == NULL)
    {
        delete first;
        first = NULL;
    }
    else
    {
        struct node<T> *temp = first;

        while(temp->next != NULL)
        {
            temp = temp ->next;
        }
        temp->prev->next = NULL;
        delete temp;
    }
    iCount--;
    
}


template<class T>
void DoublyLGen<T> :: DeleteAtPos(int Pos)
{
    if(Pos < 1 || Pos > iCount)
    {
        cout<<"Invalid Position....\n";
        return ;
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
        struct node<T> *temp = first;
        struct node<T> *target = NULL;

        for(int iCnt = 1 ; iCnt < Pos -1 ; iCnt++)
        {
            temp = temp ->next;
        }
        target = temp->next;
        temp->next = target->next;
        if(target->next != NULL)
        {
            target->next->prev = temp;
        }

        delete target;
        iCount--;
    }
}


template<class T>
void DoublyLGen<T> :: Display()
{
    struct node<T> * temp = first;
    cout << "NULL <=> ";
    while (temp != NULL)
    {
        cout << "| " << temp->data << " | <=> ";
        temp = temp->next;
    }
    cout << "NULL\n";
}

template<class T>
int DoublyLGen<T> :: Count()
{
    return iCount;
}

int main()
{
    int datatype = 0;

    cout << "Select data type:\n";
    cout << "1. int\n";
    cout << "2. char\n";
    cout << "3. double\n";
    cout << "4. string\n";
    cout << "Enter choice: ";
    cin >> datatype;

    if (datatype == 1)
    {
        DoublyLGen<int> sobj;
        int choice = 1, value = 0, pos = 0;

        while (choice != 0)
        {
            cout << "\n-----------------------------------------------------------\n";
            cout << "\n----------------DOUBLY-LINEAR-IN-GENERIC-------------------\n";
            cout << "\n-----------------------------------------------------------\n";
            cout << "1. Insert First\n";
            cout << "2. Insert Last\n";
            cout << "3. Insert At Position\n";
            cout << "4. Delete First\n";
            cout << "5. Delete Last\n";
            cout << "6. Delete At Position\n";
            cout << "7. Display\n";
            cout << "8. Count\n";
            cout << "0. Exit\n";
            cout << "--------------------------------------\n";
            cout << "Enter your choice: ";
            cin >> choice;

            switch (choice)
            {
            case 1:
                cout << "Enter int: ";
                cin >> value;
                sobj.InsertFirst(value);
                break;
            case 2:
                cout << "Enter int: ";
                cin >> value;
                sobj.InsertLast(value);
                break;
            case 3:
                cout << "Enter int: ";
                cin >> value;
                cout << "Enter position: ";
                cin >> pos;
                sobj.InsertAtPos(value, pos);
                break;
            case 4:
                sobj.DeleteFirst();
                break;
            case 5:
                sobj.DeleteLast();
                break;
            case 6:
                cout << "Enter position: ";
                cin >> pos;
                sobj.DeleteAtPos(pos);
                break;
            case 7:
                sobj.Display();
                break;
            case 8:
                cout << "Count: " << sobj.Count() << endl;
                break;
            case 0:
                cout << "Thank you using Application....!\n";
                break;
            default:
                cout << "Invalid choice!\n";
                break;
            }
        }
    }
    else if (datatype == 2)
    {
        DoublyLGen<char> sobj;
        int choice = 1, pos = 0;
        char value;

        while (choice != 0)
        {
            cout << "\n-----------------------------------------------------------\n";
            cout << "\n----------------DOUBLY-LINEAR-IN-GENERIC-------------------\n";
            cout << "\n-----------------------------------------------------------\n";
            cout << "1. Insert First\n";
            cout << "2. Insert Last\n";
            cout << "3. Insert At Position\n";
            cout << "4. Delete First\n";
            cout << "5. Delete Last\n";
            cout << "6. Delete At Position\n";
            cout << "7. Display\n";
            cout << "8. Count\n";
            cout << "0. Exit\n";
            cout << "--------------------------------------\n";
            cout << "Enter your choice: ";
            cin >> choice;

            switch (choice)
            {
            case 1:
                cout << "Enter char: ";
                cin >> value;
                sobj.InsertFirst(value);
                break;
            case 2:
                cout << "Enter char: ";
                cin >> value;
                sobj.InsertLast(value);
                break;
            case 3:
                cout << "Enter char: ";
                cin >> value;
                cout << "Enter position: ";
                cin >> pos;
                sobj.InsertAtPos(value, pos);
                break;
            case 4:
                sobj.DeleteFirst();
                break;
            case 5:
                sobj.DeleteLast();
                break;
            case 6:
                cout << "Enter position: ";
                cin >> pos;
                sobj.DeleteAtPos(pos);
                break;
            case 7:
                sobj.Display();
                break;
            case 8:
                cout << "Count: " << sobj.Count() << endl;
                break;
            case 0:
                cout << "Thank you!\n";
                break;
            default:
                cout << "Invalid choice!\n";
                break;
            }
        }
    }
    else if (datatype == 3)
    {
        DoublyLGen<double> sobj;
        int choice = 1, pos = 0;
        double value;

        while (choice != 0)
        {
            cout << "\n-----------------------------------------------------------\n";
            cout << "\n----------------DOUBLY-LINEAR-IN-GENERIC-------------------\n";
            cout << "\n-----------------------------------------------------------\n";
            cout << "1. Insert First\n";
            cout << "2. Insert Last\n";
            cout << "3. Insert At Position\n";
            cout << "4. Delete First\n";
            cout << "5. Delete Last\n";
            cout << "6. Delete At Position\n";
            cout << "7. Display\n";
            cout << "8. Count\n";
            cout << "0. Exit\n";
            cout << "--------------------------------------\n";
            cout << "Enter your choice: ";
            cin >> choice;

            switch (choice)
            {
            case 1:
                cout << "Enter double: ";
                cin >> value;
                sobj.InsertFirst(value);
                break;
            case 2:
                cout << "Enter double: ";
                cin >> value;
                sobj.InsertLast(value);
                break;
            case 3:
                cout << "Enter double: ";
                cin >> value;
                cout << "Enter position: ";
                cin >> pos;
                sobj.InsertAtPos(value, pos);
                break;
            case 4:
                sobj.DeleteFirst();
                break;
            case 5:
                sobj.DeleteLast();
                break;
            case 6:
                cout << "Enter position: ";
                cin >> pos;
                sobj.DeleteAtPos(pos);
                break;
            case 7:
                sobj.Display();
                break;
            case 8:
                cout << "Count: " << sobj.Count() << endl;
                break;
            case 0:
                cout << "Thank you using Application....!\n";
                break;
            default:
                cout << "Invalid choice!\n";
                break;
            }
        }
    }
    else if (datatype == 4)
    {
        DoublyLGen<string> sobj;
        int choice = 1, pos = 0;
        string value;

        while (choice != 0)
        {
            cout << "\n-----------------------------------------------------------\n";
            cout << "\n----------------DOUBLY-LINEAR-IN-GENERIC-------------------\n";
            cout << "\n-----------------------------------------------------------\n";
            cout << "1. Insert First\n";
            cout << "2. Insert Last\n";
            cout << "3. Insert At Position\n";
            cout << "4. Delete First\n";
            cout << "5. Delete Last\n";
            cout << "6. Delete At Position\n";
            cout << "7. Display\n";
            cout << "8. Count\n";
            cout << "0. Exit\n";
            cout << "--------------------------------------\n";
            cout << "Enter your choice: ";
            cin >> choice;
            cin.ignore();

            switch (choice)
            {
            case 1:
                cout << "Enter string: ";
                getline(cin, value);
                sobj.InsertFirst(value);
                break;
            case 2:
                cout << "Enter string: ";
                getline(cin, value);
                sobj.InsertLast(value);
                break;
            case 3:
                cout << "Enter string: ";
                getline(cin, value);
                cout << "Enter position: ";
                cin >> pos;
                cin.ignore();
                sobj.InsertAtPos(value, pos);
                break;
            case 4:
                sobj.DeleteFirst();
                break;
            case 5:
                sobj.DeleteLast();
                break;
            case 6:
                cout << "Enter position: ";
                cin >> pos;
                cin.ignore();
                sobj.DeleteAtPos(pos);
                break;
            case 7:
                sobj.Display();
                break;
            case 8:
                cout << "Count: " << sobj.Count() << endl;
                break;
            case 0:
                cout << "Thank you using Application....!\n";
                break;
            default:
                cout << "Invalid choice!\n";
                break;
            }
        }
    }
    else
    {
        cout << "Invalid data type choice!\n";
    }

    return 0;
}
