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
package org.opensearch.index.analysis;

import junit.framework.Assert;
import org.apache.lucene.tests.util.LuceneTestCase;

/**
 * User: Medcl
 * Date: 12-10-28
 * Time: 上午8:44
 */
public class STConverterTests extends LuceneTestCase {
    public void testConvert() throws Exception {

        STConverter stConverter=new STConverter();
        String str= stConverter.convert(STConvertType.TRADITIONAL_2_SIMPLE,"先禮後兵");
        String str1= stConverter.convert(STConvertType.SIMPLE_2_TRADITIONAL,"非诚勿扰");
        Assert.assertEquals("先礼后兵",str);
        Assert.assertEquals("非誠勿擾",str1);
    }
}
