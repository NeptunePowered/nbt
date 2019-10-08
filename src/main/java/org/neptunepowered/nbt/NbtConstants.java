/*
 * This file is part of nbt, licensed under the MIT License (MIT).
 *
 * Copyright (c) Jamie Mansfield <https://www.jamiemansfield.me/>
 * Copyright (c) contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package org.neptunepowered.nbt;

/**
 * Constants pertaining to the NBT format.
 *
 * @author Jamie Mansfield
 * @since 0.1.0
 */
public final class NbtConstants {

    public static final byte TAG_END = (byte) 0;
    public static final byte TAG_BYTE = (byte) 1;
    public static final byte TAG_SHORT = (byte) 2;
    public static final byte TAG_INT = (byte) 3;
    public static final byte TAG_LONG = (byte) 4;
    public static final byte TAG_FLOAT = (byte) 5;
    public static final byte TAG_DOUBLE = (byte) 6;
    public static final byte TAG_BYTE_ARRAY = (byte) 7;
    public static final byte TAG_STRING = (byte) 8;
    public static final byte TAG_LIST = (byte) 9;
    public static final byte TAG_COMPOUND = (byte) 10;
    public static final byte TAG_INT_ARRAY = (byte) 11;
    public static final byte TAG_LONG_ARRAY = (byte) 12;

    public static Tag create(final byte type) {
        switch (type) {
            case TAG_END: return new EndTag();
            case TAG_BYTE: return new ByteTag();
            case TAG_SHORT: return new ShortTag();
            case TAG_INT: return new IntTag();
            case TAG_LONG: return new LongTag();
            case TAG_FLOAT: return new FloatTag();
            case TAG_DOUBLE: return new DoubleTag();
            case TAG_BYTE_ARRAY: return new ByteArrayTag();
            case TAG_STRING: return new StringTag();
            case TAG_LIST: return new ListTag();
            case TAG_COMPOUND: return new CompoundTag();
            case TAG_INT_ARRAY: return new IntArrayTag();
            case TAG_LONG_ARRAY: return new LongArrayTag();
        }
        // todo: consider how to use exceptions
        throw new RuntimeException("Unknown Tag type " + type + "!");
    }

    private NbtConstants() {
    }

}
