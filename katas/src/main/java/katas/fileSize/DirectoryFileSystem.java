package katas.fileSize;

public interface DirectoryFileSystem extends FileSystem {

    DirectoryFileSystem append(FileSystem standarFile);

}
