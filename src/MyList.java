import java.util.Arrays;

public class MyList <T>{
	
	private int size;
	private T[] arr;

	@SuppressWarnings("unchecked")
	public MyList(int capacity) {
		this.arr = (T[]) new Object[capacity];
	}
	
	@SuppressWarnings("unchecked")
	public MyList() {
		this.arr = (T[]) new Object[10];
	}

	//listenin duruma göre iki katına çıktığı kapasite değerini döndüren metot
	public int getCapacity() {
		return this.arr.length;
	}
	
	//listenin kapasite değerinden bağımsız olan, kaç elemanı olduğunu döndüren metot
	public int getSize() {
		return this.size;
	}
	
	//listeye eleman eklenen metot
	public void add(T data) {
		//liste boyutunun dolup dolmadığına bakılır, dolduysa iki katına çıkarılır
		if(this.size == this.getCapacity()) {
			T[] newArr;
			newArr = Arrays.copyOf(this.arr,  this.getCapacity() * 2);
			this.arr = newArr;
		}
		//listeye eleman ekleme işlemi, en sonunda listenin eleman sayısı olan değer 1 artırılır
		for(int i = 0; i < this.arr.length; i++) {
			if(this.arr[i] == null) {
				this.arr[i] = data;
				this.size++;
				break;
			}
		}
	}
	
	
	//parametre olarak aldığı indexin listede tuttuğu değeri döndürür
	public T getByIndex(int index) {
		if(index >= this.getCapacity()) {
			System.out.println("Geçersiz index!");
			return null;
		}
		if(this.arr[index] == null) {
			System.out.println("Girdiğiniz değer null!");
			return null;
		}
		return this.arr[index];
	}
	
	//listeden index değeri ile eleman siler
	public void remove(int index) { 
		if(index >= this.getCapacity() || index < 0) {
			System.out.println("Geçersiz index!");
		} else if(this.arr[index] == null) {
			System.out.println("Girdiğiniz indexte zaten bir eleman yok!");
		} else {
			this.arr[index] = null;
			T tempData;
			for(int i = index + 1; i < this.size; i++) {
				tempData = this.arr[i];
				this.arr[i] = null;
				this.arr[i - 1] = tempData;
				tempData = null;
			}
			this.size--;
		}
	}
	
	//listenin girilen indexteki değerini data ile değiştirir
	public void setByIndex(int index,T data) {
		if(index >= this.getCapacity() || index < 0) {
			System.out.println("Geçersiz index!");
		} else {
			this.arr[index] = data;
			System.out.println("Değiştirildi!");
		}
	}
	//listeyi ekrana yazdırır
	public void printList() {
		for(int i = 0; i < this.size; i++) {
			System.out.print(this.arr[i] + " ");
		}
	}
	//girilen değerin listenin hangi indexinde olduğunu döndürür, eğer yoksa -1 döndürür
	public int indexOf(T data) {
		for(int i = 0; i < this.size; i++) {
			if(this.arr[i] == data) {
				return i;
			}
		}
		return -1;
	}
	
	//eğer birden fazla aynı değer varsa o değerin son indexini verir
	public int lastIndexOf(T data) {
		int index = -1;
		for(int i = 0; i < this.size; i++) {
			if(this.arr[i] == data) {
				index = i;
			}
		}
		return index;
	}
	//listenin dolu veya boş olduğunu kontrol eder
	public boolean isEmtpty() {
		if(this.size == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	//listeyi bir array'e dönüştürür
	@SuppressWarnings("unchecked")
	public T[] toArray() {
		T[] newArray = (T[]) new Object[this.size];
		for(int i = 0; i < this.size; i++) {
			newArray[i] = this.arr[i];
			System.out.print(newArray[i] +" ");
		}
		return newArray;
	}
	
	//listeyi temizler
	public void clear() {
		for(int i = 0; i < this.size; i++) {
			this.arr[i] = null;
		}
		this.size = 0;
		System.out.println("Liste başarıyla temizlendi!");
	}
	
	//başlangıç ve bitiş olarak iki parametre alır ve o değer aralığındaki değerleri döndürür
	@SuppressWarnings("unchecked")
	public MyList<T> sublist(int start,int finish){
		MyList<T> subArray = new MyList<>(finish-start+1);
		for(int i = start; i <= finish; i++) {
			subArray.add((T) this.getByIndex(i));
		}
		return subArray;
	}
	
	//parametre olarak gönderilen datanın listede dahil olup olmadığına bakar
	public boolean contains(T data) {
		for(int i = 0; i < this.size; i++) {
			if(this.arr[i] == data) {
				return true;
			}
		}
		return false;
	}
	
	
	
}
