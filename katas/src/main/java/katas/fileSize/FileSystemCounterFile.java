package katas.fileSize;

import java.util.Objects;

import katas.fileSize.impl.Dir;
import katas.fileSize.impl.StandarFile;

public class FileSystemCounterFile implements FileSystemCounter {

    @Override
    public int count(Dir fs) {
        return fs.getContent().stream().filter(Objects::nonNull).mapToInt(f -> f.count(this)).sum();
    }

    @Override
    public int count(StandarFile fs) {
        return 1;
    }

}
