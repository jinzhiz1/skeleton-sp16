public class playDaemon implements Runnable {
	@Override
	public void run() {
		StdAudio.play("./audio/mayday.wav");
		System.out.println("1");
		// try {
		// 	Thread.sleep(30000);
		// } catch (InterruptedException e)
		// {

		// }

		System.out.println("2");
	}
}