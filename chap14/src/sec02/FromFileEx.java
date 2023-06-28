package sec02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FromFileEx {

	public static void main(String[] args) throws IOException {

		Path path = Paths.get("C:/Temp/test7.txt");
		Stream<String> stream = Files.lines(path, Charset.defaultCharset());
//		밑 문장이랑 똑같음
//		stream.forEach(System.out::println);
		stream.forEach(s->System.out.println(s));
		
		File file = path.toFile(); // 파일 객체로 변환
		FileReader fileReader = new FileReader(file);
		BufferedReader br = new BufferedReader(fileReader);
		stream = br.lines();
		stream.forEach(s->System.out.println(s));
		
		Path path2 = Paths.get("C:/Temp");
		try (Stream<Path> stream2 = Files.list(path2)) {
			stream2.forEach(p->{
				System.out.println(p.getFileName());
			});
		}
	}

}
