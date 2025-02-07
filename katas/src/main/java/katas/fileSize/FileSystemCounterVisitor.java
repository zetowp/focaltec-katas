package katas.fileSize;

import katas.fileSize.impl.Dir;
import katas.fileSize.impl.StandarFile;

public interface FileSystemCounterVisitor {

    int visit(Dir fs);

    int visit(StandarFile fs);
}
