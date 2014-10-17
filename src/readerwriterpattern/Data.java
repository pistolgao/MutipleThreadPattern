package readerwriterpattern;

public class Data {
	private final char[] buffer;
	private final ReaderWriterLock lock = new ReaderWriterLock();
	public Data(int size){
		buffer = new char[size];
		for(int i = 0 ;i < size;i++){
			buffer[i] = '*';
		}
	}
	public char[] read() throws InterruptedException{
		lock.readLock();
		try{
			System.out.println(Thread.currentThread().getName() +"sleeping:"+ String.valueOf(this.buffer)+"testing");
			Thread.sleep(10000);//��֤������̶߳�ȡʱ����Ȼ�����ٽ�����try�ڴ��������ǵȴ������̶߳�ȡ��ɿ��к��ٽ���
			return doRead();
		}finally{
			lock.unReadLock();
		}
	}
	public void write(char c) throws InterruptedException{
		lock.writeLock();
		try{
			doWrite(c);
		}finally{
			lock.unWriteLock();
		}
	}
	public char[] doRead(){
		char[] newbuffer = new char[buffer.length];
		java.lang.System.arraycopy(buffer, 0, newbuffer , 0, buffer.length);
		slowly();
		return newbuffer;
	}
	public void doWrite(char c){
		for(int i = 0 ; i < buffer.length ;i++){
			buffer[i] = c;
		}
		slowly();
	}
	private void slowly(){
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
