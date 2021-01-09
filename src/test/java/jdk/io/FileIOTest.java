package jdk.io;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.charset.Charset;
import java.nio.file.AccessDeniedException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.FileStore;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.nio.file.attribute.UserPrincipal;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileIOTest {
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(FileIOTest.class);

//	@Test
	public void testPath() {		// Path 인스턴스 생성
		Path p1 = Paths.get("C:/dev/test-files/input.txt"); // \\(역슬래시 2개)를 /(슬래시)로 변경해도 인식한다. 
		Path p2 = FileSystems.getDefault().getPath("C:\\dev\\test-files\\input.txt"); // 위 인스턴스 생성은 실제로는 이렇게 하는 것과 같다. 

		// 상대경로 
		Path p3 = Paths.get("README.md");
		
		// Path 검색
		logger.debug("toString: {}", p1.toString()); // C:\dev\test-files\input.txt
		logger.debug("getFileName: {}", p1.getFileName()); // iput.txt
		logger.debug("getName(0) : {}", p1.getName(0)); // dev
		logger.debug("getNameCount: {}", p1.getNameCount()); // 3
		logger.debug("subpath(0,2): {}", p1.subpath(0,2)); // dev\test files
		logger.debug("getParent: {}", p1.getParent()); // C:\dev\test files
		logger.debug("getRoot: {}", p1.getRoot()); // C:\
	}
//	@ Test
	public void testPathConverting() throws IOException {
		Path p1 = Paths.get("kakao.com");
		Path p2 = Paths.get("C:/dev/test-files/input.txt");
		// 경로 변환
		logger.debug("{}", p1.toUri()); // file:///C:/dev/git/labs/kakao.com 
		logger.debug("{}", p1.toAbsolutePath()); // C:\dev\git\labs\kakao.com - C:/dev/git/labs 현재 내 위치가 알아서 덧붙여진다. 
		//logger.debug("{}", p1.toRealPath()); // 없는 파일인 경우 java.nio.file.NoSuchFileException
		logger.debug("{}", p2.toRealPath());
	}
	
//	@ Test
	public void testPathJoining() {
		
		// 경로 조함
		Path p1 = Paths.get("C:/dev/test-files");
		logger.debug("{}", p1.resolve("input.txt")); // C:\dev\test-files\input.txt
		logger.debug("{}", p1.resolveSibling("input.txt")); // C:\dev\input.txt - 자식이 아닌 형제위치로 조합
		
		Path p2 = Paths.get("input.txt");
		logger.debug("{}", p2.resolve("C:/dev/test-files")); // C:\dev\test-files - 절대 경로를 전달하면 전달된 경로만 리턴
	}
	
//	@Test
	public void testRelativizePath() {
		// 상대 경로 만들기 
		Path p1 = Paths.get("home");
		Path p3 = Paths.get("home/sally/bar");
		logger.debug("{}", p1.relativize(p3)); // sally\bar -> home에서 home/sally/bar를 가기 위해서
		logger.debug("{}", p3.relativize(p1)); // ..\.. -> 부모(sally)를 찾기 위해 `..` -> 또 그 위 부모(home)을 찾기 위해 `..`
	}
	
//	@Test
	public void testComparingPath() {
		// 경로 비교
		Path p = Paths.get("C:/dev/test-files/input.txt");
		Path p1 = Paths.get("C:/dev/test-files/input.txt");
		Path b = Paths.get("C:/");
		Path e = Paths.get("input.txt");
		
		Assert.assertTrue(p.equals(p1));
		Assert.assertTrue(p.startsWith(b));
		Assert.assertTrue(p.endsWith(e));
	}
	
//	@Test
	public void testIteratorPath() {
		// 반복
		Path p = Paths.get("C:/dev/test-files/input.txt");
		for (Path name : p) {
			logger.debug("{}", name); // 루트를 제외한 요소(디렉토리, 파일명)을 반복해서 리턴
		}
	}
	
	
//	@Test
	public void testCompareToPath() {
		Path p = Paths.get("C:/a");
		Path p1 = Paths.get("C:/b");
		
		logger.debug("{}", p.compareTo(p1)); // -1 : p가 사전순으로 더 앞
		logger.debug("{}", p1.compareTo(p)); // 1 : p1이 사전순으로 더 뒤 
	}
	
	
//	@Test
	public void testVerifiyingFile() {
		Path path = Paths.get("C:/dev/test-files/input.txt");
		Path path1 = Paths.get("C:/kakao.com");
		Assert.assertTrue(Files.exists(path));
		Assert.assertFalse(Files.exists(path1));
		Assert.assertFalse(Files.notExists(path));
		Assert.assertTrue(Files.notExists(path1));
	}
	
//	@Test
	public void testAccessFile() {
		Path path = Paths.get("C:/dev/test-files/input.txt");
		Path path1 = Paths.get("C:/kakao.com");
		Assert.assertTrue(Files.isReadable(path));
		Assert.assertTrue(Files.isWritable(path));
		Assert.assertTrue(Files.isExecutable(path));
		Assert.assertFalse(Files.isReadable(path1));
		Assert.assertFalse(Files.isWritable(path1));
		Assert.assertFalse(Files.isExecutable(path1));
	}
	
//	@Test
	public void testDeleteFile() {
		Path path = Paths.get("C:/dev/test-files/input.txt");
		Path path1 = Paths.get("C:/kakao.com");
		
		try {
			// Files.delete(path);
		    Files.deleteIfExists(path1);
		} catch (NoSuchFileException x) {
		    logger.error("{} : no such file or directory", path1);
		} catch (DirectoryNotEmptyException x) {
		    logger.error("{} : not empty", path1);
		} catch (IOException x) {
		    // File permission problems are caught here.
		    logger.error("{} : not empty", x);
		}
	}
	
//	@Test
	public void testCopyFile() {
		// 이미 파일이 있는 경우 
		Path source = Paths.get("C:/dev/test-files/input.txt");
		Path target = Paths.get("C:/dev/test-files");
		
		try {
			Files.copy(source, target);
		} catch(FileAlreadyExistsException e) {
			logger.debug("{}가 복사할 곳에 이미 존재함", source); // 예외 발생
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		// 복사대상의 디렉토리가 비어 있지 않은 경우 
		Path source1 = Paths.get("C:/dev/test-files/input.txt");
		Path target1 = Paths.get("C:/dev/test-files/");
		
		try {
			Files.copy(source1, target1, REPLACE_EXISTING);
		} catch(DirectoryNotEmptyException e) {
			logger.error("{}에 복사불가: 복사할 곳의 디렉토리가 비어있지 않음 ", target1); // REPLACE_EXISTING 옵션으로 동일 파일이 있어도 복사가 되지만 이번엔 디렉토리가 비어있지 않아 파일복사를 할 수 없다.
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// 디렉토리 복사는 내부 파일까지는 복사가 안된다. 아래는 마치 새 디렉토리를 만드는것과 다름 없다. 
		Path source2 = Paths.get("C:/dev/test-files/");
		Path target2 = Paths.get("C:/dev/test-files-new/"); // 현재는 존재하지 않으나 copy를 통해 생성된다. 
		
		try {
			Files.copy(source2, target2);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		// 비어 있는 디렉토리에 파일 복사
		Path source3 = Paths.get("C:/dev/test-files/input.txt");
		Path target3 = Paths.get("C:/dev/test-files-new/input.txt");
		
		try {
			Files.copy(source3, target3); // 복사됨.
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
//	@Test
	public void testMoveFile() {
		
		// 대상에도 동리 파일이 존재할 때 
		Path source = Paths.get("C:/dev/test-files/input.txt");
		Path target = Paths.get("C:/dev/test-files-new/input.txt");
		
		try {
			Files.move(source, target);
		} catch(FileAlreadyExistsException e) {
			logger.debug("{}에 이미 파일이 존재해 이동할 수 없다. ", target);
		} catch(NoSuchFileException e) {
			logger.debug("{}은 없는 파일이다 ", source);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// 대상에도 동일 파일이 존재할 때 
		Path source1 = Paths.get("C:/dev/test-files/input.txt");
		Path target1 = Paths.get("C:/dev/test-files-new/input.txt");
		
		try {
			Files.move(source1, target1, REPLACE_EXISTING); // 대상에 이미 같은 파일이 있더라도 이동한다. source1은 삭제된다. 
		} catch(NoSuchFileException e) {
			logger.debug("{}은 없는 파일이다 ", source1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// 파일 있는 디렉토리를 옮길 때 
		Path source2 = Paths.get("C:/dev/test-files-new");
		Path target2 = Paths.get("C:/dev/test-files-new1"); 
				
		try {
			Files.move(source2, target2);  // 새로운 디렉토리 target2 를 만들어서 위 source2 경로의 모든 파일이 이동된다.  source2는 삭제된다. 옵션이 없어도 되는데;;;
		} catch(AccessDeniedException e) {
			logger.debug("{}와 {}는 접근 불가", source2, target2);
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		// 비어있는 디렉토리를 옮길 때 
		Path source3 = Paths.get("C:/dev/test-files-empty");
		Path target3 = Paths.get("C:/dev/test-files-new2"); 
				
		try {
			Files.move(source3, target3); // source3 삭제되고 target3이 생성된다. 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
//	@Test
	public void testGetMetaData() {
		Path path = Paths.get("C:/dev/test-files/input.txt");
		try {
			BasicFileAttributes attr = Files.readAttributes(path, BasicFileAttributes.class);
			
			logger.debug("{}", attr.lastModifiedTime()); // 2021-01-09T10:47:32.9575655Z
			logger.debug("{}", attr.creationTime()); // 2021-01-09T12:28:10.3865468Z
			logger.debug("{}", attr.isRegularFile()); // true
			logger.debug("{}", attr.isDirectory()); // false
			logger.debug("{}", attr.isSymbolicLink()); // false
			logger.debug("{}", attr.isOther()); // false
			logger.debug("{}", attr.size()); // 69
			logger.debug("{}", attr.fileKey()); // null
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		/// TODO 어떻게 쓰는지 모르겠음 
		try {
			UserPrincipal owner_org = Files.getOwner(path); // DESKTOP-GBAN41G\masca (User)
			logger.debug("{}", owner_org);
			
			UserPrincipal owner = path.getFileSystem().getUserPrincipalLookupService().lookupPrincipalByName("mascaradee");
			Files.setOwner(path, owner);
			
			UserPrincipal new_owner = Files.getOwner(path); 
			logger.debug("{}", new_owner);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	@Test
	public void testCustomAttribute() {
		// 사용자 정의 속성 세팅
		Path path = Paths.get("C:/dev/test-files/input.txt");
		
		try {
			UserDefinedFileAttributeView view = Files.getFileAttributeView(path, UserDefinedFileAttributeView.class);
			view.write("user.mimetype", Charset.defaultCharset().encode("text/html"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		// 사용자 정의 속성 읽기 
		try {
			UserDefinedFileAttributeView view = Files.getFileAttributeView(path,UserDefinedFileAttributeView.class);
			String name = "user.mimetype";
			ByteBuffer buf = ByteBuffer.allocate(view.size(name));
			
			view.read(name, buf);
			buf.flip();
			String value = Charset.defaultCharset().decode(buf).toString();
			
			logger.debug("{}", value); // text/html
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	@Test
	public void testFileStoreAttribute() {
		Path file = Paths.get("C:/dev/test-files/input.txt");
		
		try {
			FileStore store = Files.getFileStore(file);
			long total = store.getTotalSpace() / 1024;
			long used = (store.getTotalSpace() - store.getUnallocatedSpace()) / 1024;
			long avail = store.getUsableSpace() / 1024;
			
			logger.debug("전체: {}, 사용함: {}, 사용가능함: {}", total, used, avail); // 전체: 498720724, 사용함: 202154312, 사용가능함: 296566412
			logger.debug("{}", store.getUnallocatedSpace() == store.getUsableSpace());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
//	@Test
	public void testReadAllBytes() {
		
		
		try {
			Path file = Paths.get("C:/dev/test-files/input.txt");
			byte[] fileArray = Files.readAllBytes(file); // 한 자씩 아스키 코드로 읽어들임
			
			for (byte b : fileArray) {
				logger.debug("{}",  b); 
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	@Test
	public void testNewBufferedReader() {
		
		Path file = Paths.get("C:/dev/test-files/input.txt");
		Charset charset = Charset.forName("US-ASCII");
		try (BufferedReader reader = Files.newBufferedReader(file, charset)) {
			String line = null;
			while ((line = reader.readLine()) != null) { // 파일을 한 줄씩 읽는다.
				System.out.println(line); 
			}
		} catch (IOException x) {
			System.err.format("IOException: %s%n", x);
		}
	}
	
	
//	@Test
	public void testNewBufferedWriter() {
		
		Path file = Paths.get("C:/dev/test-files/input.txt");
		Charset charset = Charset.forName("US-ASCII");
		String s = "This is Earth.";
		try  { 
			BufferedWriter writer = Files.newBufferedWriter(file, charset, APPEND); // APPEND 옵션이 없으면 이전 파일 내용은 모두 삭제하고 신규 내용이 추가된다.
			writer.write(s, 0, s.length());
		} catch (IOException x) {
			System.err.format("IOException: %s%n", x);
		}
	}
	
	
	
//	@Test
	public void testNewInputStream() {
		
		Path file = Paths.get("C:/dev/test-files/input.txt");
		try {
			InputStream in = Files.newInputStream(file);
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			String line = null;
			while ((line = reader.readLine()) != null) { // 파일을 한 줄씩 읽는다.
				System.out.println(line);
			}
		} catch (IOException x) {
			System.err.println(x);
		}
	}
	
	
//	@Test
	public void testNewOutputStream() {
		try {
			// Convert the string to a byte array.
			String s = "Hello World! ";
			byte data[] = s.getBytes();
			Path p = Paths.get("C:/dev/test-files/logfile.txt");
			OutputStream out = new BufferedOutputStream(Files.newOutputStream(p, CREATE, APPEND));
			out.write(data, 0, data.length); // close를 해 주지 않으면 안 써진다. 
			out.close();
		} catch (IOException x) {
			System.err.println(x);
		} 
		
	}
	
//	@Test
	public void testNewByteChannel() {
		
		try {
			Path file = Paths.get("C:/dev/test-files/logfile.txt");
			
			SeekableByteChannel sbc = Files.newByteChannel(file);
		    ByteBuffer buf = ByteBuffer.allocate(13); // 버퍼 크기 할당

		    // Read the bytes with the proper encoding for this platform. 
		    String encoding = System.getProperty("file.encoding");
		    logger.debug("{}", encoding); // UTF-8
		    
		    while (sbc.read(buf) > 0) {
		        buf.rewind();
		        System.out.print(Charset.forName(encoding).decode(buf)); // Hello World! 
		        buf.flip();
		    }
		} catch (IOException x) {
		    System.out.println("caught exception: " + x);
		}
	}
//	@Test
	public void testCreateTempFile() {
		try {
			Path tempFile = Files.createTempFile(null, ".myapp");
			System.out.format("The temporary file has been created: %s%n", tempFile); // The temporary file has been created: C:\Users\masca\AppData\Local\Temp\13677961192636449491.myapp
		} catch (IOException x) {
			System.err.format("IOException: %s%n", x);
		}
	}
	
	
//	@Test
	public void testGetRootDirectories() {
		Iterable<Path> dirs = FileSystems.getDefault().getRootDirectories();
		for (Path name: dirs) {
		    System.out.println(name);
		    /*
		     C:\
		     D:\
		     E:\
		     */
		}
	}
	
//	@Test
	public void testCreateDirectory() {
		
		Path dir = Paths.get("C:/dev/test-files-dir/");
		try {
			Files.createDirectory(dir);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testCreateDirectories() {
		
		Path dir = Paths.get("C:/dev/test/newDir/newSubDir");
		try {
			Files.createDirectories(dir);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testNewDirectoryStream() {
		
		Path dir = Paths.get("C:/dev/test-files");
		try {
			DirectoryStream<Path> stream = Files.newDirectoryStream(dir);
			for (Path file: stream) {
				System.out.println(file.getFileName()); // 해당 폴더의 모든 파일명이 반복되면서 나온다. 
			}
		} catch (IOException | DirectoryIteratorException x) {
			// IOException can never be thrown by the iteration.
			// In this snippet, it can only be thrown by newDirectoryStream.
			System.err.println(x);
		}
		
	}
	
}

