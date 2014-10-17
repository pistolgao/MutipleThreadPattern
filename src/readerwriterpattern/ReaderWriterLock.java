package readerwriterpattern;

public class ReaderWriterLock {

	private int readingReaders;
	private int waitingWriters;
	private int writingWriters;
	
	public synchronized void readLock() throws InterruptedException {
		while(writingWriters>0||readingReaders>0){
			wait();
		}
		readingReaders++;
	}

	public synchronized void unReadLock() {
		readingReaders--;
		notifyAll();
	}

	public synchronized void writeLock() throws InterruptedException {
		waitingWriters++;
		while(writingWriters>0||readingReaders>0){
			try{
				wait();
			}finally{
				waitingWriters--;
			}
		}
		writingWriters++;
	}

	public synchronized void unWriteLock() {
		writingWriters--;
		notifyAll();
	}

}
