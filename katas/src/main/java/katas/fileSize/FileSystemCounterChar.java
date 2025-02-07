package katas.fileSize;

import java.util.Objects;

import katas.fileSize.impl.Dir;
import katas.fileSize.impl.StandarFile;


public class FileSystemCounterChar implements FileSystemCounterVisitor {

    @Override
    public int visit(Dir fs) {
        return fs.getContent().stream().filter(Objects::nonNull).mapToInt(f -> f.accept(this)).sum();
    }

    @Override
    public int visit(StandarFile fs) {
        return fs.getContent() == null ? 0 : new String(fs.getContent()).length();
    }

}
