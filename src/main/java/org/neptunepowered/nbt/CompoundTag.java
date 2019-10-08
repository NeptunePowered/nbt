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

import static org.neptunepowered.nbt.NbtConstants.TAG_BYTE;
import static org.neptunepowered.nbt.NbtConstants.TAG_BYTE_ARRAY;
import static org.neptunepowered.nbt.NbtConstants.TAG_COMPOUND;
import static org.neptunepowered.nbt.NbtConstants.TAG_DOUBLE;
import static org.neptunepowered.nbt.NbtConstants.TAG_END;
import static org.neptunepowered.nbt.NbtConstants.TAG_FLOAT;
import static org.neptunepowered.nbt.NbtConstants.TAG_INT;
import static org.neptunepowered.nbt.NbtConstants.TAG_INT_ARRAY;
import static org.neptunepowered.nbt.NbtConstants.TAG_LONG;
import static org.neptunepowered.nbt.NbtConstants.TAG_LONG_ARRAY;
import static org.neptunepowered.nbt.NbtConstants.TAG_SHORT;
import static org.neptunepowered.nbt.NbtConstants.TAG_STRING;
import static org.neptunepowered.nbt.NbtConstants.create;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * A compound tag is essentially a map structure, storing named
 * {@link Tag tags}.
 *
 * @author Jamie Mansfield
 * @since 0.1.0
 */
public class CompoundTag implements Tag {

    private final Map<String, Tag> tags = new HashMap<>();

    /**
     * Gets the tag, should it exist, from the compound.
     *
     * @param name The tag name
     * @return The tag, or {@code null} if it doesn't exist
     */
    public Tag get(final String name) {
        return this.tags.get(name);
    }

    /**
     * Adds a child {@link Tag tag} to the compound.
     *
     * @param name The tag name
     * @param tag The tag
     */
    public void put(final String name, final Tag tag) {
        this.tags.put(name, tag);
    }

    /**
     * Establishes whether this compound tag contains a child {@link Tag tag}
     * of the given name and type.
     *
     * @param name The tag name
     * @param type The tag type
     * @return {@code true} if the tag exists; {@code false} otherwise
     */
    public boolean contains(final String name, final byte type) {
        final Tag tag = this.get(name);
        return tag != null && tag.getId() == type;
    }

    /**
     * Gets the value from the compound.
     *
     * @param name The tag name
     * @return The value
     */
    public byte getByte(final String name) {
        if (!this.contains(name, TAG_BYTE)) {
            return (byte) 0;
        }
        return ((ByteTag) this.get(name)).getValue();
    }

    /**
     * Adds the value to the compound.
     *
     * @param name The tag name
     * @param value The tag value
     */
    public void putByte(final String name, final byte value) {
        this.put(name, new ByteTag(value));
    }

    /**
     * Gets the value from the compound.
     *
     * @param name The tag name
     * @return The value
     */
    public short getShort(final String name) {
        if (!this.contains(name, TAG_SHORT)) {
            return (short) 0;
        }
        return ((ShortTag) this.get(name)).getValue();
    }

    /**
     * Adds the value to the compound.
     *
     * @param name The tag name
     * @param value The tag value
     */
    public void putShort(final String name, final short value) {
        this.put(name, new ShortTag(value));
    }

    /**
     * Gets the value from the compound.
     *
     * @param name The tag name
     * @return The value
     */
    public int getInt(final String name) {
        if (!this.contains(name, TAG_INT)) {
            return 0;
        }
        return ((IntTag) this.get(name)).getValue();
    }

    /**
     * Adds the value to the compound.
     *
     * @param name The tag name
     * @param value The tag value
     */
    public void putInt(final String name, final int value) {
        this.put(name, new IntTag(value));
    }

    /**
     * Gets the value from the compound.
     *
     * @param name The tag name
     * @return The value
     */
    public long getLong(final String name) {
        if (!this.contains(name, TAG_LONG)) {
            return 0;
        }
        return ((LongTag) this.get(name)).getValue();
    }

    /**
     * Adds the value to the compound.
     *
     * @param name The tag name
     * @param value The tag value
     */
    public void putLong(final String name, final long value) {
        this.put(name, new LongTag(value));
    }

    /**
     * Gets the value from the compound.
     *
     * @param name The tag name
     * @return The value
     */
    public float getFloat(final String name) {
        if (!this.contains(name, TAG_FLOAT)) {
            return 0;
        }
        return ((FloatTag) this.get(name)).getValue();
    }

    /**
     * Adds the value to the compound.
     *
     * @param name The tag name
     * @param value The tag value
     */
    public void putFloat(final String name, final float value) {
        this.put(name, new FloatTag(value));
    }

    /**
     * Gets the value from the compound.
     *
     * @param name The tag name
     * @return The value
     */
    public double getDouble(final String name) {
        if (!this.contains(name, TAG_DOUBLE)) {
            return 0;
        }
        return ((DoubleTag) this.get(name)).getValue();
    }

    /**
     * Adds the value to the compound.
     *
     * @param name The tag name
     * @param value The tag value
     */
    public void putDouble(final String name, final double value) {
        this.put(name, new DoubleTag(value));
    }

    /**
     * Gets the value from the compound.
     *
     * @param name The tag name
     * @return The value
     */
    public byte[] getByteArray(final String name) {
        if (!this.contains(name, TAG_BYTE_ARRAY)) {
            return new byte[0];
        }
        return ((ByteArrayTag) this.get(name)).getValue();
    }

    /**
     * Adds the value to the compound.
     *
     * @param name The tag name
     * @param value The tag value
     */
    public void putByteArray(final String name, final byte[] value) {
        this.put(name, new ByteArrayTag(value));
    }

    /**
     * Gets the value from the compound.
     *
     * @param name The tag name
     * @return The value
     */
    public String getString(final String name) {
        if (!this.contains(name, TAG_STRING)) {
            return "";
        }
        return ((StringTag) this.get(name)).getValue();
    }

    /**
     * Adds the value to the compound.
     *
     * @param name The tag name
     * @param value The tag value
     */
    public void putString(final String name, final String value) {
        this.put(name, new StringTag(value));
    }

    /**
     * Gets the value from the compound.
     *
     * @param name The tag name
     * @return The value
     */
    public CompoundTag getCompound(final String name) {
        if (!this.contains(name, TAG_COMPOUND)) {
            return new CompoundTag();
        }
        return (CompoundTag) this.get(name);
    }

    /**
     * Adds the compound tag to the compound.
     *
     * @param name The tag name
     * @param value The tag value
     */
    public void putCompound(final String name, final CompoundTag value) {
        this.put(name, value);
    }

    /**
     * Gets the value from the compound.
     *
     * @param name The tag name
     * @return The value
     */
    public int[] getIntArray(final String name) {
        if (!this.contains(name, TAG_INT_ARRAY)) {
            return new int[0];
        }
        return ((IntArrayTag) this.get(name)).getValue();
    }

    /**
     * Adds the value to the compound.
     *
     * @param name The tag name
     * @param value The tag value
     */
    public void putIntArray(final String name, final int[] value) {
        this.put(name, new IntArrayTag(value));
    }

    /**
     * Gets the value from the compound.
     *
     * @param name The tag name
     * @return The value
     */
    public long[] getLongArray(final String name) {
        if (!this.contains(name, TAG_LONG_ARRAY)) {
            return new long[0];
        }
        return ((LongArrayTag) this.get(name)).getValue();
    }

    /**
     * Adds the value to the compound.
     *
     * @param name The tag name
     * @param value The tag value
     */
    public void putLongArray(final String name, final long[] value) {
        this.put(name, new LongArrayTag(value));
    }

    @Override
    public void read(final DataInput input) throws IOException {
        byte type;
        while ((type = input.readByte()) != TAG_END) {
            final String name = input.readUTF();
            final Tag tag = create(type);
            tag.read(input);
            this.tags.put(name, tag);
        }
    }

    @Override
    public void write(final DataOutput output) throws IOException {
        for (final Map.Entry<String, Tag> tag : this.tags.entrySet()) {
            final byte type = tag.getValue().getId();
            output.writeByte(type);
            if (type != TAG_END) {
                output.writeUTF(tag.getKey());
                tag.getValue().write(output);
            }
        }
        output.writeByte(TAG_END);
    }

    @Override
    public byte getId() {
        return TAG_COMPOUND;
    }

}
