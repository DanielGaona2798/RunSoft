package struct;

import java.util.Comparator;


public class MyList <T>{

	private Node<T> head;
	private Comparator<T> comparator;

	public MyList(Comparator<T> comparator) {
		this.comparator = comparator;
	}

	public MyList() {
	}

	public void enqueue(Node<T> node){
		if (head != null) {
			Node<T> actual = head;
			while (actual.getNext() != null) {
				actual = actual.getNext();
			}
			actual.setNext(node);
		}else{
			head = node;
		}
	}

	public void add(T node){
		if (head != null) {
			Node<T> actual = head;
			while (actual.getNext() != null) {
				actual = actual.getNext();
			}
			actual.setNext(new Node<T>(node));
		}else{
			head = new Node<T>(node);
		}
	}

	public void push(Node<T> node) {
		if(head != null) {
			node.setNext(head);
			head = node;
		}else {
			head = node;
		}
	}


	public Node<T> search(T id){
		Node<T> actual = head;
		if (head.getInformation() != id) {
			while (actual.getNext() != null) {
				if (actual.getInformation() != id) {
					actual = actual.getNext();
				}else{
					return actual;
				}
			}
		}
		return actual;
		
	}
	public Node<T> pop() {
		Node<T> popNode = head;
		head = head.getNext();
		popNode.setNext(null);
		return popNode;
	}

	public void addPriorityQueue(Node<T> node){
		
	}

	public void strainBefore(T info, Node<T> node) {
		Node<T> reference ;
		Node<T> current = head;
		if(head != null) {
			if(info.equals(head.getInformation())) {
				node.setNext(head);
				head = node;
			}else {
				while (current.getNext().getInformation() != info) {
					current = current.getNext();
				}
				reference = current.getNext();
				current.setNext(node);
				node.setNext(reference);

			}
		}else {
			head = node;
		}
	}

	public void strainAfter(T info, Node<T> node) {
		Node<T> reference ;
		Node<T> current = head;
		if(head != null) {
			if(info.equals(head.getInformation())) {
				reference = head;
				node.setNext(head.getNext());
				reference.setNext(node);
				head = reference;
			}else {
				while (current.getInformation() != info) {
					current = current.getNext();
				}
				reference = current.getNext();
				current.setNext(node);
				node.setNext(reference);
			}
		}else {
			head = node;
		}
	}

	public Node<T> getMaxElement(){
		Node<T> actual = head;
		Node<T> max = head;
		while (actual.getNext() != null) {
			if (comparator.compare(max.getInformation(), actual.getInformation()) < 0) {
				max = actual;
			}
			actual = actual.getNext();
		}
		return max;
	}

	public Node<T> getHead() {
		return head;
	}

	public Node<T> dequeue(){
		Node<T> reference = head;
		Node<T> last = null;
		while (reference.getNext() != null) {
			last = reference;
			reference = reference.getNext();
		}
		last.setNext(null);
		return reference;
	}

	public void print() {
		Node<T> current = head;
		while (current != null) {
			System.out.println(current.getInformation());
			current = current.getNext();
		}
	}

	public void priorityEnqueue(Node<T> node) {

	}
	//	publi static void main(String[] args) {
	//		MyList<Card> deck = new MyList<>(new ComparatorCard());
	//		for (int i = 0; i < 10; i++) {			
	//			deck.add(new Node<Card>(new Card()));
	//		}
	//		
	//		CardIterator card = new CardIterator(deck.getHead());
	//		while (card.hasNext()) {
	//			Card actual = card.next();
	//			System.out.println(actual);
	//		}
	//		System.out.println("--------------");
	//		System.out.println(deck.getMaxElement());
	//	}

	//	public static void main(String[] args) {
	//		MyList<Integer> list = new MyList<>(new Comparator<Integer>() {
	//			@Override
	//			public int compare(Integer o1, Integer o2) {
	//				return o1 - o2;
	//			}
	//		});
	//		for (int i = 0; i < 10; i++) {
	//			list.enqueue(new Node<Integer>(i));
	//		}
	//
	//		list.print();
	//		System.out.println("-------------------------");
	//		System.out.println(list.dequeue().getInformation() + "nodo en cola..");
	//		System.out.println(list.dequeue().getInformation() + "nodo en cola..");
	//		System.out.println(list.dequeue().getInformation() + "nodo en cola..");
	//		System.out.println(list.dequeue().getInformation() + "nodo en cola..");
	//		System.out.println("-------------------------");
	//		list.print();
	//	}
}