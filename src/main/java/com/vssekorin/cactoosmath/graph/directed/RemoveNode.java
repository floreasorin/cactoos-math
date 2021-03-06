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
package com.vssekorin.cactoosmath.graph.directed;

import com.vssekorin.cactoosmath.graph.DirectedGraph;
import com.vssekorin.cactoosmath.set.Filtered;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.cactoos.Scalar;
import org.cactoos.scalar.UncheckedScalar;

/**
 * Directed graph without node.
 *
 * @author Vseslav Sekorin (vssekorin@gmail.com)
 * @version $Id$
 * @param <T> Elements type
 * @since 0.1
 */
public final class RemoveNode<T> extends DirectedGraphEnvelope<T> {

    /**
     * Ctor.
     * @param graph Origin graph
     * @param node Scalar of node
     */
    public RemoveNode(final DirectedGraph<T> graph, final Scalar<T> node) {
        this(graph, new UncheckedScalar<>(node).value());
    }

    /**
     * Ctor.
     * @param graph Origin graph
     * @param node Node
     */
    public RemoveNode(final DirectedGraph<T> graph, final T node) {
        super(() -> () -> {
            final Map<T, Set<T>> result = new HashMap<>(graph.asMap());
            result.remove(node);
            result.replaceAll(
                (elem, set) -> new Filtered<>(set, item -> !item.equals(node))
            );
            return result;
        });
    }
}
