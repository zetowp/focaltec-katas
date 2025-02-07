package katas.fileSize;

import katas.fileSize.impl.Dir;
import katas.fileSize.impl.StandarFile;

public interface FileSystemCounter {

    int count(Dir fs);

    int count(StandarFile fs);
}
