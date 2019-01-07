package wg.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import javax.management.openmbean.OpenMBeanOperationInfo;
import javax.management.openmbean.OpenMBeanOperationInfoSupport;

public class NIOTest2 {
	public static void main(String[] args) throws IOException {
		//非直接缓冲区操作
		//test1();
		test2();
	}

	private static void test2() throws IOException {
		// TODO Auto-generated method stub
		///创建管道
		FileChannel inchannel=FileChannel.open(Paths.get("12.jpg"),StandardOpenOption.READ);
		FileChannel outchannel=FileChannel.open(Paths.get("12(3).jpg"),StandardOpenOption.READ,StandardOpenOption.WRITE,StandardOpenOption.CREATE);
		System.out.println(inchannel.position()+" ");
		//映射文件
		MappedByteBuffer inmap=inchannel.map(MapMode.READ_ONLY, 0, inchannel.size());
		MappedByteBuffer outmap=outchannel.map(MapMode.READ_WRITE, 0, inchannel.size());
		System.out.println(inchannel.position()+" ");

		System.out.println(inmap.position()+" "+inmap.limit()+" "+inmap.capacity());
		
		byte[] array=new byte[inmap.limit()];
		inmap.get(array);
		System.out.println(inchannel.position()+" ");

		System.out.println(inmap.position()+" "+inmap.limit()+" "+inmap.capacity());

		outmap.put(array);
		inchannel.close();
		outchannel.close();
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
