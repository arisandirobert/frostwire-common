/*
 * Created by Angel Leon (@gubatron), Alden Torres (aldenml)
 * Copyright (c) 2011-2015, FrostWire(R). All rights reserved.
 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.frostwire.search2;

import com.frostwire.util.ArrayMap;

/**
 * @author gubatron
 * @author aldenml
 */
public final class SearchResult {

    public static final String UID = "uid";
    public static final String DISPLAY_NAME = "displayName";
    public static final String DETAILS_URL = "detailsUrl";
    public static final String THUMBNAIL_URL = "thumbnailUrl";
    public static final String CREATION_TIME = "creationTime";
    public static final String SOURCE = "source";

    private final ArrayMap<String, Value> map;

    SearchResult(ArrayMap<String, Value> map) {
        this.map = map;
    }

    public String string(String name) {
        Value v = map.get(name);
        return v != null ? v.string : null;
    }

    public boolean bool(String name) {
        Value v = map.get(name);
        return v != null ? v.bool : false;
    }

    public long integer(String name) {
        Value v = map.get(name);
        return v != null ? v.integer : 0;
    }

    public float decimal(String name) {
        Value v = map.get(name);
        return v != null ? v.decimal : 0;
    }

    public long uid() {
        return integer(UID);
    }

    public String displayName() {
        return string(DISPLAY_NAME);
    }

    public String detailsUrl() {
        return string(DETAILS_URL);
    }

    public String thumbnailUrl() {
        return string(THUMBNAIL_URL);
    }

    public long creationTime() {
        return integer(CREATION_TIME);
    }

    public String getSource() {
        return string(SOURCE);
    }

    private static final class Value {

        private Value(String string, boolean bool, long integer, float decimal) {
            this.string = string;
            this.bool = bool;
            this.integer = integer;
            this.decimal = decimal;
        }

        public final String string;
        public final boolean bool;
        public final long integer;
        public final float decimal;

        public Value of(String value) {
            return new Value(value, false, 0, 0);
        }

        public Value of(boolean value) {
            return new Value(null, value, 0, 0);
        }

        public Value of(long value) {
            return new Value(null, false, value, 0);
        }

        public Value of(float value) {
            return new Value(null, false, 0, value);
        }
    }
}
