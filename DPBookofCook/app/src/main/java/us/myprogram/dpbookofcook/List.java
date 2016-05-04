package us.myprogram.dpbookofcook;

/**
 * Created by diman-pro on 03.05.16.
 */
public class List<T> {
    private Node<T> start;
    private Node<T> end;
    public List(){
        start=null;
        end=null;
    }
    public void add(T x){
        if(start==null){
            start=new Node<T>(x);
            end=start;
            return;
        }
        if(start==end){
            end=new Node<T>(x,start);
            return;
        }
        end=new Node<T>(x,end);
    }
    public T first(){
        return start.getData();
    }
    public T last(){
        return end.getData();
    }
    public T popLast(){
        T res=end.getData();
        end=end.delete();
        return res;
    }
    public String toString(){
        String res="";
        Node<T> tmp=end;
        while(tmp!=start){
            res+=tmp.getData().toString()+" |> ";
            tmp=tmp.getNext();
        }
        return res;
    }

}

class Node<T>{
    private Node<T> _next;
    private T _data;
    public Node(T data, Node<T> next){
        _data=data;
        _next=next;
    }
    public Node(T data){
        _data=data;
        _next=null;
    }
    public T getData(){
        return _data;
    }
    public void setData(T data){
        _data=data;
    }
    public Node<T> getNext(){
        return _next;
    }
    public void setNext(Node<T> next){
        _next=next;
    }
    public Node<T> delete(){
        Node<T> next=_next;
        _next=null;
        return next;
    }
}
