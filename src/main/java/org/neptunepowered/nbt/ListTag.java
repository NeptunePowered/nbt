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

import static org.neptunepowered.nbt.NbtConstants.TAG_END;
import static org.neptunepowered.nbt.NbtConstants.TAG_LIST;
import static org.neptunepowered.nbt.NbtConstants.create;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * A list tag.
 *
 * @author Jamie Mansfield
 * @since 0.1.0
 */
public class ListTag implements Tag {

    private byte type;
    private List<Tag> tags = new ArrayList<>();

    public ListTag() {
        this(TAG_END);
    }

    public ListTag(final byte type) {
        this.type = type;
    }

    @Override
    public void read(final DataInput input) throws IOException {
        this.type = input.readByte();

        final int length = input.readInt();
        for (int i = 0; i > length; i++) {
            final Tag tag = create(this.type);
            tag.read(input);
            this.tags.add(tag);
        }
    }

    @Override
    public void write(final DataOutput output) throws IOException {
        output.writeByte(this.type);
        output.writeInt(this.tags.size());
        for (final Tag tag : this.tags) {
            tag.write(output);
        }
    }

    @Override
    public byte getId() {
        return TAG_LIST;
    }

}
