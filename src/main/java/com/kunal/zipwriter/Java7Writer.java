package com.kunal.zipwriter;

import java.io.IOException;
import java.io.Writer;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.Map;

public class Java7Writer {

	public static void main(String[] args) throws IOException {
		Map<String, String> env = new HashMap<>();
		env.put("create", "true");
		Path path = Paths.get("new.zip");
		URI uri = URI.create("jar:" + path.toUri());

		try (FileSystem fs = FileSystems.newFileSystem(uri, env)) {
			final Path root = fs.getPath("/");
			Path externalTxtFile = Paths.get("new1.txt");
			Path dest = fs.getPath(root.toString(), externalTxtFile.toString());
			// copy a file into the zip file
			Files.copy(externalTxtFile, dest,
					StandardCopyOption.REPLACE_EXISTING);

			Path nf = fs.getPath("new.txt");
			try (Writer writer = Files.newBufferedWriter(nf,
					StandardCharsets.UTF_8, StandardOpenOption.CREATE)) {
				writer.write("hello world");
			}
		}

	}
}
