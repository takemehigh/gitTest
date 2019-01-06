package wg.nio;

import java.io.ObjectInputStream.GetField;
import java.nio.ByteBuffer;

public class NIOTest1 {
	public static void main(String[] args) {
		int a=0;
		System.out.println(a++);
		
		
		ByteBuffer bb=ByteBuffer.allocate(1024);
		ByteBuffer bb1=ByteBuffer.allocateDirect(1024);
		System.out.println(bb.position());
		System.out.println(bb.limit());
		System.out.println(bb.capacity());
		bb.put("aaaa".getBytes());
		System.out.println("-------------------");

		System.out.println(bb.position());
		System.out.println(bb.limit());
		System.out.println(bb.capacity());
		//bb.get(b);
		System.out.println("-------flip------------");

		bb.flip();
		System.out.println(bb.position());
		System.out.println(bb.limit());
		System.out.println(bb.capacity());
		byte[] b=new byte[bb.limit()];

		bb.get(b);
		System.out.println("---------get ----------");

		System.out.println(bb.position());
		System.out.println(bb.limit());
		System.out.println(bb.capacity());
		System.out.println(new String(b,0,b.length));
		bb.flip();
		bb.get(b);

		System.out.println(bb.position());
		System.out.println(bb.limit());
		System.out.println(bb.capacity());
		System.out.println(new String(b,0,b.length));
		bb.clear();
		bb.put("bbbb".getBytes());

		
		System.out.println("--------rewind-----------");

		bb.rewind();
		byte[] b1=new byte[bb.limit()];
		System.out.println(bb.position());
		System.out.println(bb.limit());
		System.out.println(bb.capacity());
		System.out.println("---------get ----------");

		bb.get(b1);
		System.out.println(bb.position());
		System.out.println(bb.limit());
		System.out.println(bb.capacity());
		System.out.println(new String(b1,0,b1.length));
		bb.rewind();

		bb.get(b1);
		System.out.println(bb.position());
		System.out.println(bb.limit());
		System.out.println(bb.capacity());
		System.out.println(new String(b1,0,b1.length));
		
		System.out.println("---------clear----------");
		bb.clear();
		byte[] b2=new byte[bb.limit()];
		System.out.println(bb.position());
		System.out.println(bb.limit());
		System.out.println(bb.capacity());
		bb.get(b2);
		System.out.println(new String(b2,0,b2.length));
	}
}
