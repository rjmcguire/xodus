/**
 * Copyright 2010 - 2017 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package jetbrains.exodus.tree.patricia;

import jetbrains.exodus.ByteIterable;

import java.util.Iterator;

interface NodeChildren extends Iterable<ChildReference> {

    @Override
    NodeChildrenIterator iterator();
}

interface NodeChildrenIterator extends Iterator<ChildReference> {

    boolean hasPrev();

    ChildReference prev();

    boolean isMutable();

    void nextInPlace();

    void prevInPlace();

    ChildReference getNode();

    NodeBase getParentNode();

    int getIndex();

    ByteIterable getKey();
}