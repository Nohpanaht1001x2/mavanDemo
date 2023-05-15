package com.Boonprakob.Thanaphon.dataStructure;

class Node <T>
{
    T data;
    Node <T> nextNode;

    public Node(T data)
    {
        this.data = data;
        nextNode  = null;
    }
}

class Linklist<T>
{
    //instance variable headNode
    Node<T> headNode;
    public Linklist()
    {

    }
    void push(T data)
    {
        Node<T> newNode = new Node<T>(data);
        newNode.nextNode = headNode;
        headNode = newNode;
    }

    @Override
    public String toString()
    {
        try
        {
            return "{" + headNode.data.toString() + " , " + toString(headNode.nextNode);
        }
        catch (NullPointerException e)
        {
            return "{" + headNode.data.toString() + "}";
        }
    }
    public String toString(Node n)
    {
        if (n.nextNode == null)
            return n.data.toString() + "}";
        return n.data.toString() +" , "+ toString(n.nextNode);
    }

    void append(T data)
    {
        Node <T>iter = headNode;
        if (headNode == null)   //in case of using append to add the first element
        {
            headNode = new Node<>(data);
            return; //terminated the method
        }
        while (iter.nextNode != null)
        {
            iter = iter.nextNode;
        }
        //iter.nextNode <T>= null --> iter.nexNode <T>= new Node(data)
        iter.nextNode = new Node(data);
    }

    int lenght()
    {
        int count = 0;
        Node<T> iter = headNode;
        while (iter != null)
        {
            iter = iter.nextNode;
            count++;
        }
        return count;
    }

    void reverse()
    {
        Node <T>prev,curr,next;
        prev = null;
        curr = headNode;
        next = null;
        while (curr != null)
        {
            next = curr.nextNode;
            curr.nextNode = prev;
            prev = curr;
            curr = next;
        }
        headNode = prev;
    }
    void deleteNode(T key)
    {
        Node <T>iter = headNode;
        while (iter != null)
        {
            if (key == (iter.nextNode).data)
            {
                //iter.nextNode <T>is the Node <T>that we want to remove
                //because key and value are matching
                //then we gonna skip it
                iter.nextNode = (iter.nextNode).nextNode;
                break;  //important!!!
            }
            iter = iter.nextNode;
        }
    }

    boolean search(Node <T>iter, T value)
    {
        while (iter != null)
        {
            if (value == iter.data||value.equals(iter.data))
            {
//                System.out.print(value == head.data?"Yes\n":"");
                return true;
            }
            iter = iter.nextNode;
            //just change local reference variable "head", not edit any instance variable
            //so it safe to use and set new reference to "head" directly
            //i think so ...
        }
        ;
        return false;
    }

    boolean search(T value)
    {
        return this.search(this.headNode, value);
    }

    void insertAfterNode(Node <T>head, T key, T data)
    {
        while (head != null)
        {
            if (key == head.data)
            {
                Node <T>tempNode = head.nextNode;
                Node <T>insertNode = new Node(data);
                insertNode.nextNode = tempNode;
                head.nextNode = insertNode;
                break;  //important!!!
            }
            head = head.nextNode;
        }
    }

    void insertAfterNode(T key, T data)
    {
        this.insertAfterNode(headNode, key, data);
    }

    void insertBeforeNode(Node <T>head, T key, T data)
    {
        while (head != null)
        {
            if (key == head.nextNode.data)
            {
                Node <T>tempNode = head.nextNode;
                Node <T>insertNode = new Node(data);
                insertNode.nextNode = tempNode;
                head.nextNode = insertNode;
                break;  //important!!!
            }
            head = head.nextNode;
        }
    }

    void insertBeforeNode(T key, T data)
    {
        this.insertBeforeNode(headNode, key, data);
    }
}
