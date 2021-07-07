package io.duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashSet;
import java.util.Set;

class DuplicatesVisitor extends SimpleFileVisitor<Path> {

    private Set<FileProperty> properties = new HashSet<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
            throws IOException, IOException {
        if (!properties.add(
                new FileProperty(file.toFile().length(), file.toFile().getName()))) {
            System.out.println(file.toAbsolutePath());
        }
        return super.visitFile(file, attrs);
    }
}