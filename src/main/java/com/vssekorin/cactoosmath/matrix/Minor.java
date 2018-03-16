/**
 * MIT License
 *
 * Copyright (c) 2017-2018 Vseslav Sekorin
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
package com.vssekorin.cactoosmath.matrix;

import com.vssekorin.cactoosmath.Matrix;
import org.cactoos.Scalar;
import org.cactoos.scalar.UncheckedScalar;

/**
 * Minor.
 *
 * @author Vseslav Sekorin (vssekorin@gmail.com)
 * @version $Id$
 * @param <T> Type of matrix
 * @since 0.1
 */
public final class Minor<T> extends MatrixEnvelope<T> {

    /**
     * Ctor.
     * @param src The source
     * @param row Row number
     * @param col Column number
     */
    public Minor(final Matrix<T> src, final Scalar<Number> row,
        final Scalar<Number> col) {
        this(
            src,
            new UncheckedScalar<>(row).value(),
            new UncheckedScalar<>(col).value()
        );
    }

    /**
     * Ctor.
     * @param src The source
     * @param row Row number
     * @param col Column number
     */
    public Minor(final Matrix<T> src, final Number row, final Number col) {
        super(() -> new RemoveRow<>(new RemoveColumn<>(src, col), row));
    }
}
