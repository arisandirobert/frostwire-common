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

import com.frostwire.http.HttpClient;
import com.frostwire.http.Request;
import com.frostwire.http.RequestListener;
import com.frostwire.http.Response;
import com.frostwire.util.ThreadPool;

import java.io.IOException;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * @author gubatron
 * @author aldenml
 */
public final class SearchManager {

    private final ThreadPool pool;
    private final HttpClient client;

    public SearchManager(int nThreads) {
        this.pool = new ThreadPool("SearchManager", nThreads, nThreads, 1L, new PriorityBlockingQueue<Runnable>(), true);
        this.client = HttpClient.with(new HttpClient.Params(pool));
    }

    public void execute(final SearchPerformer p) {
        client.send(p.request(), new RequestListener() {
            @Override
            public void onFailure(Request request, IOException e) {
                // do something here.
            }

            @Override
            public void onResponse(Response response) throws IOException {
                p.crawl(response.bytes());
            }
        });
    }
}
