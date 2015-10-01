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

import java.util.Map;

/**
 * @author gubatron
 * @author aldenml
 */
public class SearchResult {

    public static final String UID = "uid";
    public static final String DISPLAY_NAME = "displayName";
    public static final String DETAILS_URL = "detailsUrl";
    public static final String THUMBNAIL_URL = "thumbnailUrl";
    public static final String CREATION_TIME = "creationTime";
    public static final String SOURCE = "source";

    private final Map<String, Object> map;

    SearchResult(Map<String, Object> map) {
        this.map = map;
    }

    public String string(String name) {
        Object obj = map.get(name);
        return obj instanceof String ? (String) obj : "";
    }

    public long integer(String name) {
        Object obj = map.get(name);
        return obj instanceof Number ? ((Number) obj).longValue() : 0;
    }

    public float decimal(String name) {
        Object obj = map.get(name);
        return obj instanceof Float || obj instanceof Double ? ((Number) obj).floatValue() : 0;
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
}
