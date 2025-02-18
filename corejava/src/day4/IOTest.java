package day4;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.OutputStream;
import java.io.FileOutputStream;
import org.junit.jupiter.api.Test;
import java.io.FileReader;
import java.io.Reader;
import java.io.FileWriter;
import java.io.Writer;
import java.io.BufferedReader;

class IOTest {
	
	@Test
	public void testBufferReader() {
		try(BufferedReader br=new BufferedReader(new FileReader(new File("data.txt")))){
			System.out.println(br.readLine());
			System.out.println(br.readLine());
			System.out.println(br.readLine());
			System.out.println(br.readLine());
		}catch(Exception ex) {
			
		}
	}
	
	@Test
	public void testReaders() {
		try(Reader reader=new FileReader(new File("data.txt"))){
			
			try(Writer writer=new FileWriter(new File("dataOut.txt"))){
				char[] buff=new char[4];
				int i=-1;
				while((i=reader.read(buff))!=-1) {
					writer.write(buff,0,i);
				}
				writer.flush();
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	@Test
	public void testChainingStreams() {
		try (InputStream inputStream=new BufferedInputStream(new FileInputStream(new File("data.txt")))){
			try(OutputStream os=new FileOutputStream("dataCopy.txt")){
			byte buff[]=new byte[4];
			int i=0;
			while((i=inputStream.read(buff))!=-1) {
				System.out.println(new String(buff,0,i));
				os.write(buff,0,i);
				
			}
			os.flush();
		}}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testRead()  {
		InputStream inputStream=null;
		try {
			inputStream = new FileInputStream(new File("data.txt"));
			assertEquals('H',(byte)inputStream.read());
			assertEquals('e',(byte)inputStream.read());
			assertEquals('l',(byte)inputStream.read());
			assertEquals('l',(byte)inputStream.read());
			assertEquals('o',(byte)inputStream.read());
			inputStream.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				inputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	@Test
	public void testTryWithResources() {
		
		try(InputStream inputStream=new FileInputStream(new File("data.txt"))){
			
			assertEquals('H',(byte)inputStream.read());
			assertEquals('e',(byte)inputStream.read());
			assertEquals('l',(byte)inputStream.read());
			assertEquals('l',(byte)inputStream.read());
			assertEquals('o',(byte)inputStream.read());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	@Test
	public void testSecondTryWithResources() {
		
		try(InputStream inputStream=new FileInputStream(new File("data.txt"))){
			try(OutputStream os=new FileOutputStream("dataCopy.txt")){
			byte buff[]=new byte[4];
			int i=0;
			while((i=inputStream.read(buff))!=-1) {
				System.out.println(new String(buff,0,i));
				os.write(buff,0,i);
				
			}
			os.flush();
			
		} }catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

}
