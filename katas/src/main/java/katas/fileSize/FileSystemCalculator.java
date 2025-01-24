package katas.fileSize;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.Test;

import katas.fileSize.impl.Dir;
import katas.fileSize.impl.DirBuilder;
import katas.fileSize.impl.StandarFile;

public class FileSystemCalculator {

    @Test
    public void calculateFileSize() {
        DirectoryFileSystem dir = new Dir();
        assertEquals(0l, dir.getSize());
        dir.append(new StandarFile());
        assertEquals(0l, dir.getSize());
        dir.append(new Dir());
        assertEquals(0l, dir.getSize());
        dir.append(new StandarFile(new byte[100]));
        assertEquals(100l, dir.getSize());
        DirectoryFileSystem toTest = new Dir().append(new Dir().append(new StandarFile(new byte[1])))
                .append(new Dir().append(new StandarFile())).append(new StandarFile(new byte[12]))
                .append(new Dir().append(new Dir().append(new StandarFile(new byte[1])))
                        .append(new Dir().append(new StandarFile())).append(new StandarFile(new byte[12])));
        assertEquals(26l, toTest.getSize());
        assertEquals(26l, new Dir().append(toTest).getSize());
    }

    @Test
    public void calculateRealFileSystem() {
        assertEquals(0l, new DirBuilder(new File("yoNoExisto")).getSize());
        assertEquals(80l, new DirBuilder(new File("src/main/java/katas/fileSize/FileSystem.java")).getSize());
        long length = new DirBuilder(new File(".")).getSize();
        System.out.println(String.format("Total size of kata proyect is %d bytes", length));
    }

}
