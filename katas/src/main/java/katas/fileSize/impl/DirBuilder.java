package katas.fileSize.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import katas.fileSize.FileSystem;
import katas.fileSize.FileSystemCounterVisitor;

public class DirBuilder implements FileSystem {

    private FileSystem src;

    public DirBuilder(File src) {
        this.src = build(src);
    }

    private FileSystem build(File f) {
        if (f.exists()) {
            if (f.isDirectory()) {
                Dir d = new Dir();
                for (File child : f.listFiles()) {
                    d.append(build(child));
                }
                return d;
            } else {
                return new StandarFile(getFile(f));
            }
        } else
            return new StandarFile();
    }

    private byte[] getFile(File f) {
        try {
            return Files.readAllBytes(f.toPath());
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public long getSize() {
        return src.getSize();
    }

    @Override
    public int accept(FileSystemCounterVisitor c) {
        return src.accept(c);
    }

}
