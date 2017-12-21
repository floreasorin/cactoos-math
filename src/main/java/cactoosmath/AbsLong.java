/**
 * MIT License
 *
 * Copyright (c) 2017 Vseslav Sekorin
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included
 * in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package cactoosmath;

import org.cactoos.Scalar;

/**
 * Returns the absolute value of an int value.
 *
 * @author Vseslav Sekorin (vssekorin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public final class AbsLong implements Scalar<Long> {

    /**
     * Scalar.
     */
    private final Scalar<Long> scalar;

    /**
     * Ctor.
     * @param nmbr Number
     */
    public AbsLong(final Long nmbr) {
        this(() -> nmbr);
    }

    /**
     * Ctor.
     * @param sclr Scalar
     */
    public AbsLong(final Scalar<Long> sclr) {
        this.scalar = sclr;
    }

    @Override
    public Long value() throws Exception {
        return Math.abs(this.scalar.value());
    }
}
