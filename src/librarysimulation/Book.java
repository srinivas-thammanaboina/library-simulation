package librarysimulation;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Book {

	private int id;
	
	private Lock lock;
	
	public Book(int id) {

		this.id = id;
		
		lock = new ReentrantLock();
	}
	
	public void read(Student student){
		
		try {
			if(lock.tryLock(10,TimeUnit.MILLISECONDS)){
				System.out.println(student +" is reading "+this);
				Thread.sleep(2000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			lock.unlock();
		}
		System.out.println(student +" finished reading "+this);
	}
	
	@Override
	public String toString() {
		return "Book #"+id;
	}
}
