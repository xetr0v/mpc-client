package client;

import java.math.BigInteger;
import java.util.zip.CRC32;

public class DataEncryption {

    private DataEncryption() {
    }

    public DataEncryption(byte arg0[]) {
        data = arg0;
        offset = 0;
    }

    public void addByte(int arg0) {
        data[offset++] = (byte) arg0;
    }

    public void addInt(int arg0) {
        data[offset++] = (byte) (arg0 >> 24);
        data[offset++] = (byte) (arg0 >> 16);
        data[offset++] = (byte) (arg0 >> 8);
        data[offset++] = (byte) arg0;
    }

    public void addString(String arg0) {
        arg0.getBytes(0, arg0.length(), data, offset);
        offset += arg0.length();
        data[offset++] = 10;
    }

    public void dbc(byte arg0[], int arg1, int arg2) {
        for (int i = arg1; i < arg1 + arg2; i++)
            data[offset++] = arg0[i];

    }

    public int getByte() {
        return data[offset++] & 0xff;
    }

    public int getShort() {
        offset += 2;
        return ((data[offset - 2] & 0xff) << 8) + (data[offset - 1] & 0xff);
    }

    public int getInt() {
        offset += 4;
        return ((data[offset - 4] & 0xff) << 24) + ((data[offset - 3] & 0xff) << 16) + ((data[offset - 2] & 0xff) << 8) + (data[offset - 1] & 0xff);
    }

    public void getBytes(byte arg0[], int arg1, int arg2) {
        for (int i = arg1; i < arg1 + arg2; i++)
            arg0[i] = data[offset++];

    }

    public byte data[];
    public int offset;
    static CRC32 dal = new CRC32();
    private static final int dam[] = {
            0, 1, 3, 7, 15, 31, 63, 127, 255, 511,
            1023, 2047, 4095, 8191, 16383, 32767, 65535, 0x1ffff, 0x3ffff, 0x7ffff,
            0xfffff, 0x1fffff, 0x3fffff, 0x7fffff, 0xffffff, 0x1ffffff, 0x3ffffff, 0x7ffffff, 0xfffffff, 0x1fffffff,
            0x3fffffff, 0x7fffffff, -1
    };

}