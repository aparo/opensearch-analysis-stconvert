STConvert Analysis for OpenSearch
=================================

STConvert is analyzer that convert Chinese characters between Traditional and Simplified.
[中文简繁體转换][简体到繁体][繁体到简体][简繁查询Expand].


## Installation

| OS    | Command |
| ----- | ------- |
| 1.1.0  | `bin/opensearch-plugin install https://github.com/aparo/opensearch-analysis-stconvert/releases/download/1.1.0/opensearch-analisys-stconvert-1.1.0.zip` |
| 1.2.0  | `bin/opensearch-plugin install https://github.com/aparo/opensearch-analysis-stconvert/releases/download/1.2.0/opensearch-analisys-stconvert-1.2.0.zip` |
| 1.2.2  | `bin/opensearch-plugin install https://github.com/aparo/opensearch-analysis-stconvert/releases/download/1.2.2/opensearch-analisys-stconvert-1.2.2.zip` |
| 1.2.3  | `bin/opensearch-plugin install https://github.com/aparo/opensearch-analysis-stconvert/releases/download/1.2.3/opensearch-analisys-stconvert-1.2.3.zip` |
| 1.2.4  | `bin/opensearch-plugin install https://github.com/aparo/opensearch-analysis-stconvert/releases/download/1.2.4/opensearch-analisys-stconvert-1.2.4.zip` |
| 1.3.0  | `bin/opensearch-plugin install https://github.com/aparo/opensearch-analysis-stconvert/releases/download/1.3.0/opensearch-analisys-stconvert-1.3.0.zip` |
| 1.3.1  | `bin/opensearch-plugin install https://github.com/aparo/opensearch-analysis-stconvert/releases/download/1.3.1/opensearch-analisys-stconvert-1.3.1.zip` |
| 1.3.2  | `bin/opensearch-plugin install https://github.com/aparo/opensearch-analysis-stconvert/releases/download/1.3.2/opensearch-analisys-stconvert-1.3.2.zip` |
| 2.0.0  | `bin/opensearch-plugin install https://github.com/aparo/opensearch-analysis-stconvert/releases/download/2.0.0/opensearch-analisys-stconvert-2.0.0.zip` |
| 2.0.1  | `bin/opensearch-plugin install https://github.com/aparo/opensearch-analysis-stconvert/releases/download/2.0.1/opensearch-analisys-stconvert-2.0.1.zip` |
| 2.6.0  | `bin/opensearch-plugin install https://github.com/aparo/opensearch-analysis-stconvert/releases/download/2.6.0/opensearch-analisys-stconvert-2.6.0.zip` |
| 2.7.0  | `bin/opensearch-plugin install https://github.com/aparo/opensearch-analysis-stconvert/releases/download/2.7.0/opensearch-analisys-stconvert.zip` |
| 2.8.0  | `bin/opensearch-plugin install https://github.com/aparo/opensearch-analysis-stconvert/releases/download/2.8.0/opensearch-analisys-stconvert.zip` |
| 2.9.0  | `bin/opensearch-plugin install https://github.com/aparo/opensearch-analysis-stconvert/releases/download/2.9.0/opensearch-analisys-stconvert.zip` |
| 2.10.0  | `bin/opensearch-plugin install https://github.com/aparo/opensearch-analysis-stconvert/releases/download/2.10.0/opensearch-analisys-stconvert.zip` |
| 2.11.0  | `bin/opensearch-plugin install https://github.com/aparo/opensearch-analysis-stconvert/releases/download/2.11.0/opensearch-analisys-stconvert.zip` |
| 2.11.1  | `bin/opensearch-plugin install https://github.com/aparo/opensearch-analysis-stconvert/releases/download/2.11.1/opensearch-analisys-stconvert.zip` |
| 2.13.0 | `bin/opensearch-plugin install https://github.com/aparo/opensearch-analysis-stconvert/releases/download/2.13.0/opensearch-analysis-stconvert.zip` |
| 2.14.0 | `bin/opensearch-plugin install https://github.com/aparo/opensearch-analysis-stconvert/releases/download/2.14.0/opensearch-analysis-stconvert.zip` |
| 2.15.0 | `bin/opensearch-plugin install https://github.com/aparo/opensearch-analysis-stconvert/releases/download/2.15.0/opensearch-analysis-stconvert.zip` |
| 2.16.0 | `bin/opensearch-plugin install https://github.com/aparo/opensearch-analysis-stconvert/releases/download/2.16.0/opensearch-analysis-stconvert.zip` |
| 2.17.0 | `bin/opensearch-plugin install https://github.com/aparo/opensearch-analysis-stconvert/releases/download/2.17.0/opensearch-analysis-stconvert.zip` |
| 2.18.0 | `bin/opensearch-plugin install https://github.com/aparo/opensearch-analysis-stconvert/releases/download/2.18.0/opensearch-analysis-stconvert.zip` |
| 2.19.0 | `bin/opensearch-plugin install https://github.com/aparo/opensearch-analysis-stconvert/releases/download/2.19.0/opensearch-analysis-stconvert.zip` |
| 2.19.1 | `bin/opensearch-plugin install https://github.com/aparo/opensearch-analysis-stconvert/releases/download/2.19.1/opensearch-analysis-stconvert.zip` |
| 2.19.2 | `bin/opensearch-plugin install https://github.com/aparo/opensearch-analysis-stconvert/releases/download/2.19.2/opensearch-analysis-stconvert.zip` |
| 3.0.0 | `bin/opensearch-plugin install https://github.com/aparo/opensearch-analysis-stconvert/releases/download/3.0.0/opensearch-analysis-stconvert.zip` |

## Usage

The plugin includes  analyzer: `stconvert`,
 tokenizer: `stconvert`,
 token-filter:  `stconvert`,
 and char-filter: `stconvert`

Supported config:

- `convert_type`: default `s2t` ,optional option:
    1. `s2t` ,convert characters from Simple Chinese to Traditional Chinese
    2. `t2s` ,convert characters from Traditional Chinese to Simple Chinese

- `keep_both`:default `false` ,

- `delimiter`:default `,`


Custom example:

```
PUT /stconvert/
{
    "settings" : {
        "analysis" : {
            "analyzer" : {
                "tsconvert" : {
                    "tokenizer" : "tsconvert"
                    }
            },
            "tokenizer" : {
                "tsconvert" : {
                    "type" : "stconvert",
                    "delimiter" : "#",
                    "keep_both" : false,
                    "convert_type" : "t2s"
                }
            },   
             "filter": {
               "tsconvert" : {
                     "type" : "stconvert",
                     "delimiter" : "#",
                     "keep_both" : false,
                     "convert_type" : "t2s"
                 }
             },
            "char_filter" : {
                "tsconvert" : {
                    "type" : "stconvert",
                    "convert_type" : "t2s"
                }
            }
        }
    }
}
```


Analyze tests

```
GET stconvert/_analyze
{
  "tokenizer" : "keyword",
  "filter" : ["lowercase"],
  "char_filter" : ["tsconvert"],
  "text" : "国际國際"
}

Output：
{
  "tokens": [
    {
      "token": "国际国际",
      "start_offset": 0,
      "end_offset": 4,
      "type": "word",
      "position": 0
    }
  ]
}
```

Normalizer usage

```
DELETE index
PUT index
{
  "settings": {
    "analysis": {
      "char_filter": {
        "tsconvert": {
          "type": "stconvert",
          "convert_type": "t2s"
        }
      },
      "normalizer": {
        "my_normalizer": {
          "type": "custom",
          "char_filter": [
            "tsconvert"
          ],
          "filter": [
            "lowercase"
          ]
        }
      }
    }
  },
  "mappings": {
    "properties": {
      "foo": {
        "type": "keyword",
        "normalizer": "my_normalizer"
      }
    }
  }
}

PUT index/_doc/1
{
  "foo": "國際"
}

PUT index/_doc/2
{
  "foo": "国际"
}

GET index/_search
{
  "query": {
    "term": {
      "foo": "国际"
    }
  }
}

GET index/_search
{
  "query": {
    "term": {
      "foo": "國際"
    }
  }
}
```
