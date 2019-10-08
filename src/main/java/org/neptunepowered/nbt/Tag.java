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

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * A tag, used for (de)serialising binary data.
 *
 * @author Jamie Mansfield
 * @since 0.1.0
 */
public interface Tag {

    /**
     * Reads the tag, and its data, from the given {@link DataInput input}.
     *
     * @param input The input
     */
    void read(final DataInput input) throws IOException;

    /**
     * Writes the tag, and its data, to the given {@link DataOutput output}.
     *
     * @param output The output
     */
    void write(final DataOutput output) throws IOException;

    /**
     * Gets the byte identifier of this tag's type.
     *
     * @return The identifier of the type
     */
    byte getId();

}