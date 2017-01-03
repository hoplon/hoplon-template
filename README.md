# hoplon

A Leiningen template for creating new Hoplon projects.

## Prerequisites

* Java 8 (not 7)
* [Boot](http://boot-clj.com)

## Usage

```bash
$ boot -d seancorfield/boot-new new -t hoplon -n my-project-name
```

## Deploy the template

``` shell
boot build-jar push-release
```

## License

Copyright © Micha Niskin and Contributors

Distributed under the Eclipse Public License, the same as Clojure.
