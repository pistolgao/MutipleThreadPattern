package readerwriterpattern;

public class Main {

	public static void main(String[] args) {
		Data data = new Data(10);
		ReaderThread rt = new ReaderThread(data);
		ReaderThread rt1 = new ReaderThread(data);
		ReaderThread rt2 = new ReaderThread(data);
		WriterThread wt = new WriterThread(data, "gaoqingrui");
		WriterThread wt1 = new WriterThread(data, "loving");
		WriterThread wt2 = new WriterThread(data, "zhangchunyan");
		rt.start();
		rt1.start();
		rt2.start();
		wt.start();
		wt1.start();
		wt2.start();
	}

}
