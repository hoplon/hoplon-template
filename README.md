# hoplon

A Leiningen template for creating new Hoplon projects.

## Prerequisites

* Java 8 (not 7)
* [Boot](http://boot-clj.com)

## Usage

```bash
$ boot -d seancorfield/boot-new new -t hoplon -n my-project-name
```
## Deployment
Just do:
```bash
$ boot prod
```
and copy static files found in your project `/target` directory.

## License

Copyright © 2013 Micha Niskin and Contributors

Distributed under the Eclipse Public License, the same as Clojure.
