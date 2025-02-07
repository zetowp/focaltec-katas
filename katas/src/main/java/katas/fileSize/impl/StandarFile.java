package katas.fileSize.impl;

import katas.fileSize.FileSystemCounterVisitor;
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
    public int accept(FileSystemCounterVisitor c) {
        return c.visit(this);
    }

}
