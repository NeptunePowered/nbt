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

import static org.neptunepowered.nbt.NbtConstants.TAG_STRING;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * A string tag, using UTF-8 encoding.
 *
 * @author Jamie Mansfield
 * @since 0.1.0
 */
public class StringTag implements Tag {

    private String value;

    public StringTag() {
    }

    public StringTag(final String value) {
        this.value = value;
    }

    /**
     * Gets the value of the tag.
     *
     * @return The value
     */
    public String getValue() {
        return this.value;
    }

    @Override
    public void read(final DataInput input) throws IOException {
        this.value = input.readUTF();
    }

    @Override
    public void write(final DataOutput output) throws IOException {
        output.writeUTF(this.value);
    }

    @Override
    public byte getId() {
        return TAG_STRING;
    }

}
