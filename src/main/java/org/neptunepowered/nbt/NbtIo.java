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

import static org.neptunepowered.nbt.NbtConstants.TAG_COMPOUND;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.GZIPInputStream;

/**
 * IO functions for NBT.
 *
 * @author Jamie Mansfield
 * @since 0.1.0
 */
public final class NbtIo {

    /**
     * Reads a {@link CompoundTag compound tag}, compressed using GZIP, from a
     * {@link InputStream input stream}.
     *
     * @param in The input
     * @return The root tag
     * @throws IOException Should an IO error occur
     */
    public static CompoundTag readCompressedStream(final InputStream in) throws IOException {
        try (final GZIPInputStream gin = new GZIPInputStream(in)) {
            return readStream(gin);
        }
    }

    /**
     * Reads a {@link CompoundTag compound tag}, compressed using GZIP, from a
     * {@link Path path}.
     *
     * @param path The input path
     * @return The root tag
     * @throws IOException Should an IO error occur
     */
    public static CompoundTag readCompressedPath(final Path path) throws IOException {
        try (final InputStream in = Files.newInputStream(path)) {
            return readCompressedStream(in);
        }
    }

    /**
     * Reads a {@link CompoundTag compound tag} from a {@link InputStream input stream}.
     *
     * @param in The input
     * @return The root tag
     * @throws IOException Should an IO error occur
     */
    public static CompoundTag readStream(final InputStream in) throws IOException {
        try (final DataInputStream din = new DataInputStream(in)) {
            return read(din);
        }
    }

    /**
     * Reads a {@link CompoundTag compound tag} from a {@link Path path}.
     *
     * @param path The input path
     * @return The root tag
     * @throws IOException Should an IO error occur
     */
    public static CompoundTag readPath(final Path path) throws IOException {
        try (final InputStream in = Files.newInputStream(path)) {
            return readStream(in);
        }
    }

    /**
     * Reads a {@link CompoundTag compound tag} from the {@link DataInput input}.
     *
     * @param input The input
     * @return The root tag
     * @throws IOException Should an IO error occur
     */
    public static CompoundTag read(final DataInput input) throws IOException {
        if (input.readByte() != TAG_COMPOUND) {
            throw new RuntimeException("Root tag must be compound!");
        }

        // This is legacy from when tags were named
        input.readUTF();

        final CompoundTag tag = new CompoundTag();
        tag.read(input);
        return tag;
    }

    private NbtIo() {
    }

}
