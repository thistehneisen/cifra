package io.intercom.okhttp3.internal.io;

import e.a.b.A;
import e.a.b.B;
import e.a.b.t;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public interface FileSystem {
    public static final FileSystem SYSTEM = new FileSystem() {
        public A appendingSink(File file) throws FileNotFoundException {
            try {
                return t.a(file);
            } catch (FileNotFoundException unused) {
                file.getParentFile().mkdirs();
                return t.a(file);
            }
        }

        public void delete(File file) throws IOException {
            if (!file.delete() && file.exists()) {
                StringBuilder sb = new StringBuilder();
                sb.append("failed to delete ");
                sb.append(file);
                throw new IOException(sb.toString());
            }
        }

        public void deleteContents(File file) throws IOException {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                int length = listFiles.length;
                int i2 = 0;
                while (i2 < length) {
                    File file2 = listFiles[i2];
                    if (file2.isDirectory()) {
                        deleteContents(file2);
                    }
                    if (file2.delete()) {
                        i2++;
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append("failed to delete ");
                        sb.append(file2);
                        throw new IOException(sb.toString());
                    }
                }
                return;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("not a readable directory: ");
            sb2.append(file);
            throw new IOException(sb2.toString());
        }

        public boolean exists(File file) {
            return file.exists();
        }

        public void rename(File file, File file2) throws IOException {
            delete(file2);
            if (!file.renameTo(file2)) {
                StringBuilder sb = new StringBuilder();
                sb.append("failed to rename ");
                sb.append(file);
                sb.append(" to ");
                sb.append(file2);
                throw new IOException(sb.toString());
            }
        }

        public A sink(File file) throws FileNotFoundException {
            try {
                return t.b(file);
            } catch (FileNotFoundException unused) {
                file.getParentFile().mkdirs();
                return t.b(file);
            }
        }

        public long size(File file) {
            return file.length();
        }

        public B source(File file) throws FileNotFoundException {
            return t.c(file);
        }
    };

    A appendingSink(File file) throws FileNotFoundException;

    void delete(File file) throws IOException;

    void deleteContents(File file) throws IOException;

    boolean exists(File file);

    void rename(File file, File file2) throws IOException;

    A sink(File file) throws FileNotFoundException;

    long size(File file);

    B source(File file) throws FileNotFoundException;
}
