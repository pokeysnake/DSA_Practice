import java.util.Stack;

public class Stacks_Queues {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);                                      //adds to stack LIFO
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println("Current stack: " + stack);
        
        System.out.println(stack.pop());                        //stack.pop() returns the topmost element 
        System.out.println("updated stack: " + stack);
        System.out.println("Using peek() : " + stack.peek());   //stack.peek() returns the topmost element / most recently pushed element
        System.out.println(stack.isEmpty());                    //wtf u think this shit do bruh lets be real 
    }
}

class myStack
{
    private int[] arr;                                          //Array to store elements 
    private int top;                                            //Index of the top element
    private int capacity;                                       //Max stack size (array implementation has fixed size)

    public myStack(int size)
    {
        arr = new int[size];                                    //creates new array given a size
        top = -1;                                               //-1 means stack is empty
        capacity = size;
    }

    public void push(int x)
    {
        if(top == capacity - 1)
        {
            System.err.println("Stack Overflow");
            return;
        }
        arr[++top] = x;                                         //++top, incrememnts the top then returns it 
    }


    public int pop()
    {
        if(isEmpty())
        {
            System.out.println("Stack Underflow");
            return -1;
        }
        return arr[top--];                                     //return and then decrement top
    }


    public int peek()                                          //look at the top element without removing
    {
        if(isEmpty()) return -1;
        return arr[top];
    }

    public boolean isEmpty()
    {
        return top == -1;                                      //intialize top of stack to -1 so if it is empty the top is -1
    }

    public int size()
    {
        return top+1;
    }

    public void printStack()                                   //print array
    {
        if(isEmpty())
        {
            System.out.println("Stack is empty");
            return;
        }

        for(int i = top; i>=0; i--)
        {
            System.out.println(arr[i]);
        }
    }


    class myQueue<T>{
        private static class Node<T>
        {
            T data;
            Node<T> next;

            Node(T data)
            {
                this.data = data;
            }
        }


        private Node<T> front;      //points to front of queue
        private Node<T> rear;       //points to end of queue

        //ENQUEUE ADD TO END
        public void offer(T value)
        {
            Node<T> newNode = new Node<>(value);
            if(rear != null)
            {
                rear.next = newNode;
            }

            if(front == null)
            {
                front = rear;
            }
        }

        //DEQUEUE: REMOVE FROM FRONT
        public T poll()
        {
            if(front == null) return null;
            T value = front.data;
            front = front.next;                 //updating next front of queue
            if(front == null) rear = null;      //queue is now empty
            return value;
        }

        //PEEK: SEE FRONT ELEMENT
        public T peek()
        {
            return (front != null) ? front.data : null;     //if front!= null return front.data else return null
        }

        //CHECK IF EMPTY
        public boolean isEmpty()
        {
            return front == null;
        }

    }
}