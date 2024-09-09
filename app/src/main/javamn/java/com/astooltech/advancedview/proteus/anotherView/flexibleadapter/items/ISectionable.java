/*
 * Copyright 2016 Davide Steduto
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
package com.astooltech.advancedview.proteus.anotherView.flexibleadapter.items;

import androidx.recyclerview.widget.RecyclerView;

/**
 * This interface represents an item in the section.
 * <p>With this interface linking the header/parent is simplified.</p>
 *
 * @author Davide Steduto
 * @see IFlexible
 * @see IExpandable
 * @see IFilterable
 * @see IHeader
 * @see IHolder
 * @since 07/02/2016 Created
 * <br>26/03/2016 setHeader returns void
 */
public interface ISectionable<VH extends RecyclerView.ViewHolder, T extends IHeader>
        extends IFlexible<VH> {

    T getHeader();

    void setHeader(T header);

}