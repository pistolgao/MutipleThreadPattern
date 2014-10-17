package readerwriterpattern;

public class ReaderThread extends Thread {
	private final Data data;
	
	public ReaderThread(Data data){
		this.data = data;
	}
	@Override
	public void run(){
		try {
			while(true){
				char[] buffer = data.read();
				System.out.println(Thread.currentThread().getName()+"data:"+String.valueOf(buffer));
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
