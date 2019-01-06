package wg.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIOTest2 {
	public static void main(String[] args) throws IOException {
		//非直接缓冲区操作
		test1();
		test2();
	}

	private static void test2() {
		// TODO Auto-generated method stub
		
	}

	private static void test1() throws FileNotFoundException, IOException {
		//输入流
		FileInputStream fis=new FileInputStream("12.jpg");
		//输出流
		FileOutputStream fos=new FileOutputStream("12(2).jpg");
		
		FileChannel readChannel=fis.getChannel();
		FileChannel writeChannel=fos.getChannel();
		ByteBuffer bb=ByteBuffer.allocate(1024);
		while(readChannel.read(bb)!=-1) {
			bb.flip();
			writeChannel.write(bb);
			bb.clear();
		}
		System.out.println("读取完毕");
		writeChannel.close();
		readChannel.close();
		fis.close();
		fos.close();
	}
}
