package readerwriterpattern;

import java.util.Random;

public class WriterThread extends Thread {
	private static final Random random = new Random();
	private final Data data;
	private String filter;
	private int index;
	public WriterThread(Data data,String filter){
		this.data = data;
		this.filter = filter;
	}
	@Override
	public void run(){
		while(true){
			char c = nextChar();
			try {
				data.write(c);
				Thread.sleep(random.nextInt(3000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	private char nextChar() {
		char c = filter.charAt(index);
		index++;
		if(index>=filter.length())index=0;
		return c;
	}
}
