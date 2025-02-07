package katas.fileSize;


public interface FileSystem {

    long getSize();

    int accept(FileSystemCounterVisitor c);

}
