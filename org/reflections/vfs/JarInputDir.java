package org.reflections.vfs;

import java.net.*;
import java.util.jar.*;
import java.util.*;
import com.google.common.collect.*;
import org.reflections.*;
import java.util.zip.*;
import org.reflections.util.*;
import java.io.*;

public class JarInputDir implements Vfs.Dir
{
    private final URL url;
    JarInputStream jarInputStream;
    long cursor;
    long nextCursor;
    
    public JarInputDir(final URL a1) {
        super();
        this.cursor = 0L;
        this.nextCursor = 0L;
        this.url = a1;
    }
    
    @Override
    public String getPath() {
        return this.url.getPath();
    }
    
    @Override
    public Iterable<Vfs.File> getFiles() {
        return new Iterable<Vfs.File>() {
            final /* synthetic */ JarInputDir this$0;
            
            JarInputDir$1() {
                this.this$0 = a1;
                super();
            }
            
            @Override
            public Iterator<Vfs.File> iterator() {
                return new AbstractIterator<Vfs.File>() {
                    final /* synthetic */ JarInputDir$1 this$1;
                    
                    JarInputDir$1$1() throws Error {
                        this.this$1 = v2;
                        super();
                    }
                    
                    {
                        try {
                            this.this$1.this$0.jarInputStream = new JarInputStream(this.this$1.this$0.url.openConnection().getInputStream());
                        }
                        catch (Exception a1) {
                            throw new ReflectionsException("Could not open url connection", a1);
                        }
                    }
                    
                    @Override
                    protected Vfs.File computeNext() {
                        try {
                            while (true) {
                                final ZipEntry v1 = this.this$1.this$0.jarInputStream.getNextJarEntry();
                                if (v1 == null) {
                                    return this.endOfData();
                                }
                                long v2 = v1.getSize();
                                if (v2 < 0L) {
                                    v2 += 4294967295L;
                                }
                                final JarInputDir this$0 = this.this$1.this$0;
                                this$0.nextCursor += v2;
                                if (!v1.isDirectory()) {
                                    return new JarInputFile(v1, this.this$1.this$0, this.this$1.this$0.cursor, this.this$1.this$0.nextCursor);
                                }
                            }
                        }
                        catch (IOException v3) {
                            throw new ReflectionsException("could not get next zip entry", v3);
                        }
                    }
                    
                    @Override
                    protected /* bridge */ Object computeNext() {
                        return this.computeNext();
                    }
                };
            }
        };
    }
    
    @Override
    public void close() {
        Utils.close(this.jarInputStream);
    }
    
    static /* synthetic */ URL access$000(final JarInputDir a1) {
        return a1.url;
    }
}
