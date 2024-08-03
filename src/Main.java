
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyList<Integer> list = new MyList<>(2);
		System.out.println("Kapasite: " + list.getCapacity());
		System.out.println("Eleman Sayısı: " + list.getSize());
		list.add(10);
		list.add(20);
		
		System.out.println("Kapasite: " + list.getCapacity());
		System.out.println("Eleman Sayısı: " + list.getSize());
		
		list.add(30);
		list.add(40);
		list.add(50);
		list.add(60);
		list.printList();
		System.out.println();
		System.out.println("Kapasite: " + list.getCapacity());
		System.out.println("Eleman Sayısı: " + list.getSize());
		
		//System.out.println("İstenilen indexteki değeri: " + list.getByIndex(4));
		list.remove(3);
		System.out.println("Kapasite: " + list.getCapacity());
		System.out.println("Eleman Sayısı: " + list.getSize());
		
		list.printList();
		
		System.out.println("Girilen değerin indexi: " + list.indexOf(40));
		
		list.add(50);
		list.printList();
		System.out.println("Girilen değerin indexi: " + list.indexOf(50));
		System.out.println("Girilen değerin son indexi: " + list.lastIndexOf(50));
		list.add(60);
		list.printList();
		System.out.println("Girilen değerin indexi: " + list.indexOf(60));
		System.out.println("Girilen değerin son indexi: " + list.lastIndexOf(60));
		list.toArray();
		System.out.println();
		list.sublist(2, 4).printList();
		System.out.println(list.contains(30));
	}

}
