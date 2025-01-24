package katas.fileSize.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import katas.fileSize.DirectoryFileSystem;
import katas.fileSize.FileSystem;

public class Dir implements DirectoryFileSystem {

    private final List<FileSystem> content;

    public Dir() {
        this.content = new ArrayList<FileSystem>();
    }

    @Override
    public long getSize() {
        return content.stream().filter(Objects::nonNull).mapToLong(FileSystem::getSize).sum();
    }

    @Override
    public DirectoryFileSystem append(FileSystem fs) {
        content.add(fs);
        return this;
    }

}
