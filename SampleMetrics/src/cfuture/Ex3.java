package cfuture;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

public class Ex3 {
	
	public static void main(String[] args) {
		
		Parallizer<String> p = new Parallizer<String>(5);
		
		Reader reader = new Reader(1);
		Unpacker unpacker = new Unpacker(1);
		Preparator preparator = new Preparator(1);
		Processor processor = new Processor(1);

		Instant start = Instant.now();
		
		p.start(reader, Arrays.asList(unpacker, preparator, processor));
		
		Instant stop = Instant.now();
		
		System.out.println("Elapsed " + Duration.between(start, stop));
		
		System.out.println(processor.getDone());

	}

}