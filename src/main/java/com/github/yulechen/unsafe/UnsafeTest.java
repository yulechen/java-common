package com.github.yulechen.unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class UnsafeTest {

    private volatile int a=10;
    private volatile int b=14;

    public static void main(String[] args) {
        System.out.println(aOffset);
        System.out.println(bOffset);
        UnsafeTest s = new UnsafeTest();
        System.out.println(UNSAFE.getInt(s, aOffset));
        System.out.println(UNSAFE.getInt(s, bOffset));
    }

    // Unsafe mechanics
    private static final sun.misc.Unsafe UNSAFE;
    private static final long aOffset;
    private static final long bOffset;

    private static Unsafe getUnsafeInstance() throws SecurityException,
            NoSuchFieldException, IllegalArgumentException,
            IllegalAccessException {
        Field theUnsafeInstance = Unsafe.class.getDeclaredField("theUnsafe");
        theUnsafeInstance.setAccessible(true);
        return (Unsafe) theUnsafeInstance.get(Unsafe.class);
    }
    static {
        try {
            UNSAFE = getUnsafeInstance();
            Class<?> k = UnsafeTest.class;
            // 获取该字段在内存中的偏移量
            aOffset = UNSAFE.objectFieldOffset
                    (k.getDeclaredField("a"));
            bOffset = UNSAFE.objectFieldOffset
                    (k.getDeclaredField("b"));
        } catch (Exception e) {
            throw new Error(e);
        }
    }
}
