package org.opensearch.index.analysis;
/*
 * Licensed to OpenSearch under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. OpenSearch licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
import org.apache.lucene.analysis.charfilter.BaseCharFilter;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by medcl on 15/12/24.
 */

public final class STConvertCharFilter extends BaseCharFilter {

    private STConvertType convertType=STConvertType.TRADITIONAL_2_SIMPLE;
    private Reader transformedInput;
    public STConvertCharFilter(Reader in,STConvertType convertType) {
        super(in);
        this.convertType = convertType;
    }

    public int read(char[] cbuf, int off, int len) throws IOException {
        if(this.transformedInput == null) {
            this.fill();
        }

        return this.transformedInput.read(cbuf, off, len);
    }

    private void fill() throws IOException {
        StringBuilder buffered = new StringBuilder();
        char[] temp = new char[1024];

        for(int cnt = this.input.read(temp); cnt > 0; cnt = this.input.read(temp)) {
            buffered.append(temp, 0, cnt);
        }

        this.transformedInput = new StringReader(this.processPattern(buffered).toString());
    }

    public int read() throws IOException {
        if(this.transformedInput == null) {
            this.fill();
        }

        return this.transformedInput.read();
    }

    protected int correct(int currentOff) {
        return Math.max(0, super.correct(currentOff));
    }

    CharSequence processPattern(CharSequence input) {
        return STConverter.getInstance().convert(convertType, input.toString());
    }
}
