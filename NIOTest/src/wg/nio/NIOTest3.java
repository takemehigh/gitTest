package wg.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIOTest3 {
	
	public static void main(String[] args) throws IOException {
		//分散读取，聚集写入
		test1();
	}

	private static void test1() throws IOException {
		// TODO Auto-generated method stub
		RandomAccessFile raf=new RandomAccessFile("test1", "rw");
		RandomAccessFile raf2=new RandomAccessFile("test2", "rw");

		FileChannel inchannel=raf.getChannel();
		FileChannel outchannel=raf2.getChannel();

		ByteBuffer b1=ByteBuffer.allocate(3);
		ByteBuffer b2=ByteBuffer.allocate(3);
		ByteBuffer[] bb= {b1,b2};
		long i=0;

		while((i=inchannel.read(bb))!=-1) {
			//outchannel.write(bb);
			
			System.out.println(new String(bb[0].array(),0,bb[0].limit()));
			System.out.println(new String(bb[1].array(),0,bb[1].limit()));

			//outchannel.write(bb);
			for(ByteBuffer b:bb) {
				b.flip();
			}
			long outlength =0;
			while((outlength=outchannel.write(bb)) != 0){
				System.out.println("读，"+i+"写,"+outlength);
			}
			for(ByteBuffer b:bb) {
				b.clear();
			}

		}

	}
	
}
