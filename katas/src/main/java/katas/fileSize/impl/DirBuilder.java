package katas.fileSize.impl;

import java.io.File;

import katas.fileSize.FileSystem;

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
                return new StandarFile(new byte[(int) f.length()]);
            }
        } else
            return new StandarFile();
    }

    @Override
    public long getSize() {
        return src.getSize();
    }

}
