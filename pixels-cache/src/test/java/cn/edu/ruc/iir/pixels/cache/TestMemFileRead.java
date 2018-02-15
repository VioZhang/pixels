package cn.edu.ruc.iir.pixels.cache;

import org.junit.Test;

import java.util.Random;

public class TestMemFileRead
{
    @Test
    public void test () throws Exception
    {
        long start = System.nanoTime();
        /*
        RandomAccessFile raf = new RandomAccessFile("/dev/shm/test1", "rw");
        FileChannel fc = raf.getChannel();
        MappedByteBuffer mbb = fc.map(FileChannel.MapMode.READ_WRITE, 0, 1024*1024*128);
        System.out.println((System.nanoTime()-start)/1000000.0);

        start = System.nanoTime();
        for (int i = 0; i < 1024*1024*16; ++i)
        {
            long a = mbb.getLong();
        }
        System.out.println((System.nanoTime()-start)/1024.0/1024/16);
        */
        MemoryMappedFile mem = new MemoryMappedFile("/dev/shm/test", 1024L*1024L*4096L);
        System.out.println((System.nanoTime()-start)/1000000.0);
        Random random = new Random(System.nanoTime());
        start = System.nanoTime();
        for (long i = 0; i < 1024*1024*512L; ++i)
        {
            //long pos = random.nextInt(1024*1024*16);
            //System.out.println(pos);
            long a = mem.getLong(i*8);
            //System.out.println(a);
        }
        System.out.println((System.nanoTime()-start)/1024.0/1024/512);

    }
}