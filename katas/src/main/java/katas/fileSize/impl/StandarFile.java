package katas.fileSize.impl;

import katas.fileSize.FileSystemCounter;
import katas.fileSize.PlainFileFileSystem;

public class StandarFile implements PlainFileFileSystem {

    private final byte[] content;

    public StandarFile() {
        this(null);
    }

    public StandarFile(byte[] bs) {
        this.content = bs;

    }

    public byte[] getContent() {
        return content;
    }

    @Override
    public long getSize() {
        return content == null ? 0 : content.length;
    }

    @Override
    public int count(FileSystemCounter c) {
        return c.count(this);
    }

}
